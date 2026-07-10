package com.google.googlex.gcam.hdrplus;

import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.BlackLevelPattern;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.LensShadingMap;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OisSample;
import android.hardware.camera2.params.RggbChannelVector;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.util.SizeF;

import com.FixBSG;
import com.google.googlex.gcam.AeMetadata;
import com.google.googlex.gcam.AeShotParams;
import com.google.googlex.gcam.AfMetadata;
import com.google.googlex.gcam.AwbInfo;
import com.google.googlex.gcam.AwbMetadata;
import com.google.googlex.gcam.BayerPattern;
import com.google.googlex.gcam.DngColorCalibration;
import com.google.googlex.gcam.DngColorCalibrationVector;
import com.google.googlex.gcam.DngNoiseModel;
import com.google.googlex.gcam.FaceInfo;
import com.google.googlex.gcam.FaceInfoVector;
import com.google.googlex.gcam.FloatVector;
import com.google.googlex.gcam.FrameMetadata;
import com.google.googlex.gcam.FrameRequest;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.GyroSampleVector;
import com.google.googlex.gcam.LensFacing;
import com.google.googlex.gcam.NormalizedRect;
import com.google.googlex.gcam.OisMetadata;
import com.google.googlex.gcam.OisPosition;
import com.google.googlex.gcam.OisPositionVector;
import com.google.googlex.gcam.PixelRect;
import com.google.googlex.gcam.PixelRectVector;
import com.google.googlex.gcam.QcColorCalibration;
import com.google.googlex.gcam.QcIlluminantVector;
import com.google.googlex.gcam.SpatialGainMap;
import com.google.googlex.gcam.StaticMetadata;
import com.google.googlex.gcam.WeightedNormalizedRect;
import com.google.googlex.gcam.WeightedNormalizedRectVector;
import com.google.googlex.gcam.WeightedPixelRect;
import com.google.googlex.gcam.WeightedPixelRectVector;
import com.google.googlex.gcam.androidutils.MathUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import defpackage.kvf;
import defpackage.kvg;
import defpackage.lyb;
import defpackage.lyw;
import defpackage.lyx;
import defpackage.mcs;
import defpackage.mmb;
import defpackage.mms;
import defpackage.mmt;
import defpackage.mnh;
import defpackage.mpj;
import defpackage.mpz;
import defpackage.ohr;

public class MetadataConverter {
    public static final float ANTIBANDING_50HZ_PERIOD_MS = 10.0f;
    public static final float ANTIBANDING_60HZ_PERIOD_MS = 8.333333f;
    public static final float ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS = 0.05f;
    public static final int COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS = 9;
    public static final int COLOR_SPACE_TRANSFORM_MATRIX_RATIONAL_DENOMINATOR = 10000;
    public static final int CONTROL_POST_RAW_SENSITIVITY_BOOST_UNITY = 100;
    public static final float GCAM_CALCULATES_SHARPNESS = 0.0f;
    public static final float GCAM_METERING_REGION_FRACTION = 0.1225f;
    public static final float GCAM_METERING_REGION_WEIGHT = 45.0f;
    public static final String GCAM_SOFTWARE_TAG = "HDR+";
    public static final float OIS_RAW_2_PIXEL_X_COEFF = -0.007517f;
    public static final float OIS_RAW_2_PIXEL_Y_COEFF = -0.00733f;
    public static final String TAG = MetadataConverter.class.getSimpleName();
    public final mmb characteristics;
    public final mpj deviceProperties = mpj.a();
    public final int[] evenOddIndexMap;
    public final int faceDetectMode;
    public final int maxAnalogIso;
    public final int minIso;
    public final Rect preCorrectionActiveArraySize;
    public final int[] redBlueIndexMap;

    public static class ExtendedFaces {
        public int[] faceLandmarkCounts;
        public byte[] faceLandmarkIds;
        public float[] faceLandmarkXy;
        public Face[] faces;

        public ExtendedFaces(mpz mpzVar) {
            this.faces = mpzVar.a(CaptureResult.STATISTICS_FACES);
            if (kvg.l == null || kvg.m == null || kvg.n == null) {
                return;
            }
            this.faceLandmarkCounts = mpzVar.a(kvg.l);
            this.faceLandmarkIds = mpzVar.a(kvg.m);
            this.faceLandmarkXy = mpzVar.a(kvg.n);
        }

        public ExtendedFaces(Face[] faceArr) {
            this.faces = faceArr;
        }

        boolean extendedFacesAvailable() {
            int[] iArr;
            return facesAvailable() && (iArr = this.faceLandmarkCounts) != null && iArr.length == this.faces.length;
        }

        public boolean facesAvailable() {
            Face[] faceArr = this.faces;
            return faceArr != null && faceArr.length > 0;
        }

        int[] getFaceLandmarkCounts() {
            return this.faceLandmarkCounts;
        }

        byte[] getFaceLandmarkIds() {
            return this.faceLandmarkIds;
        }

        float[] getFaceLandmarkXy() {
            return this.faceLandmarkXy;
        }

        Face[] getFaces() {
            return this.faces;
        }
    }

    enum LandmarkIndex {
        LEFT_EYE(0),
        RIGHT_EYE(1),
        MOUTH_CENTER(45);

        public final int index;

        LandmarkIndex(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        final Point getLandmarkLocation(Face face) {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    return face.getRightEyePosition();
                }
                if (ordinal == 2) {
                    return face.getMouthPosition();
                }
                return null;
            }
            return face.getLeftEyePosition();
        }
    }

    public MetadataConverter(mmb mmbVar) {
        this.characteristics = mmbVar;
        this.minIso = mmbVar.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getLower();
        this.maxAnalogIso = mmbVar.b(CameraCharacteristics.SENSOR_MAX_ANALOG_SENSITIVITY);
        int intValue = mmbVar.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT);
        this.redBlueIndexMap = getRedBlueSourceIndicesForCfa(intValue);
        this.evenOddIndexMap = getEvenOddSourceIndicesForCfa(intValue);
        this.preCorrectionActiveArraySize = mmbVar
                .b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        if (this.deviceProperties.d() || this.deviceProperties.e()) {
            this.faceDetectMode = mms.a.e;
        } else {
            this.faceDetectMode = mmbVar.h().e;
        }
    }

    private void appendMeteringRectanglesAsGcamWeightedPixelRects(MeteringRectangle[] meteringRectangleArr,
            WeightedPixelRectVector weightedPixelRectVector) {
        if (meteringRectangleArr != null) {
            for (MeteringRectangle meteringRectangle : meteringRectangleArr) {
                if (meteringRectangle.getMeteringWeight() != 0) {
                    WeightedPixelRect weightedPixelRect = new WeightedPixelRect();
                    Rect rect = meteringRectangle.getRect();
                    PixelRect rect2 = weightedPixelRect.getRect();
                    rect2.setX0(rect.left);
                    rect2.setX1(rect.right);
                    rect2.setY0(rect.top);
                    rect2.setY1(rect.bottom);
                    weightedPixelRect.setWeight(meteringRectangle.getMeteringWeight());
                    weightedPixelRectVector.add(weightedPixelRect);
                }
            }
        }
    }

    private static int convertToBayerPattern(int cfa) {
        switch (cfa) {
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB:
                return BayerPattern.kRGGB;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG:
                return BayerPattern.kGRBG;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG:
                return BayerPattern.kGBRG;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR:
                return BayerPattern.kBGGR;
            default:
                Log.w(TAG, "convertToBayerPattern: unsupported color filter arrangement: " + cfa
                        + ", returning kInvalid.");
                return BayerPattern.kInvalid;
        }
    }

    public static ColorSpaceTransform convertToColorSpaceTransform(float[] fArr) {
        ohr.a(fArr.length == COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS, "ccm must have length %s.",
                COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS);
        Rational[] rationalArr = new Rational[9];
        for (int i = 0; i < 9; i++) {
            rationalArr[i] = new Rational((int) (fArr[i] * 10000.0f),
                    COLOR_SPACE_TRANSFORM_MATRIX_RATIONAL_DENOMINATOR);
        }
        return new ColorSpaceTransform(rationalArr);
    }

    private static float[] convertToFloatArray(ColorSpaceTransform colorSpaceTransform) {
        Rational[] rationalArr = new Rational[COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS];
        colorSpaceTransform.copyElements(rationalArr, 0);
        float[] fArr = new float[COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS];
        for (int i = 0; i < COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS; i++) {
            fArr[i] = rationalArr[i].floatValue();
        }
        return fArr;
    }

    public static StaticMetadata convertToGcamStaticMetadata(mmb mmbVar) {
        String manufacturer = "google";
        String device = "sargo";
        String model = "Pixel 3a";
        StaticMetadata staticMetadata = new StaticMetadata();
        FixBSG.GetLens(mmbVar);
        if (FixBSG.sCam == LensFacing.kFront &&
                FixBSG.sNSOn == 0 && FixBSG.GAwb == 0) {
            manufacturer = "LGE";
            device = "bullhead";
            model = "Nexus 5X";
        }
        if (FixBSG.MenuValue("pref_denoise_key") == 0) {
            manufacturer = "google";
            device = "marlin";
            model = "Pixel XL";
        }
        staticMetadata.setMake(manufacturer);
        staticMetadata.setDevice(device);
        staticMetadata.setModel(model);
        Log.e(manufacturer, device);
        String GetVersion = GcamModule.GetVersion();
        staticMetadata.setSoftware(GetVersion.length() == 0 ? GCAM_SOFTWARE_TAG : "HDR+ ".concat(GetVersion));
        staticMetadata.setDevice_os_version(Build.FINGERPRINT);
        staticMetadata.setSensor_id(getGcamSensorId(mmbVar));
        staticMetadata.setHas_flash(mmbVar.C());
        staticMetadata.setLens_facing(convertToLensFacing(mmbVar.b()));
        List<Float> i = mmbVar.i();
        ohr.a(!i.isEmpty(), "Cameras must have at least one focal length.");
        FloatVector floatVector = new FloatVector();
        for (Float f : i) {
            floatVector.add(f);
        }
        staticMetadata.setAvailable_focal_lengths_mm(floatVector);
        float[] fArr = mmbVar.b(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
        ohr.a(fArr.length > 0, "Cameras must have at least one f-number (aperture size).");
        FloatVector floatVector2 = new FloatVector();
        for (float f2 : fArr) {
            floatVector2.add(f2);
        }
        staticMetadata.setAvailable_f_numbers(floatVector2);
        staticMetadata.setWhite_level(mmbVar.a(CameraCharacteristics.SENSOR_INFO_WHITE_LEVEL));
        Rect[] rectArr = mmbVar.a(CameraCharacteristics.SENSOR_OPTICAL_BLACK_REGIONS);
        if (rectArr != null) {
            PixelRectVector pixelRectVector = new PixelRectVector();
            for (Rect rect : rectArr) {
                PixelRect pixelRect = new PixelRect();
                pixelRect.setX0(rect.left);
                pixelRect.setX1(rect.right);
                pixelRect.setY0(rect.top);
                pixelRect.setY1(rect.bottom);
                pixelRectVector.add(pixelRect);
            }
            staticMetadata.setOptically_black_regions(pixelRectVector);
        }
        staticMetadata.setBayer_pattern(
                convertToBayerPattern(mmbVar.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT)));
        int[] iArr = {
                mmbVar.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getLower(),
                mmbVar.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getUpper() };
        int intValue = mmbVar.b(CameraCharacteristics.SENSOR_MAX_ANALOG_SENSITIVITY);
        staticMetadata.setIso_range(iArr);
        staticMetadata.setMax_analog_iso(intValue);
        DngColorCalibrationVector dngColorCalibrationVector = new DngColorCalibrationVector();
        Integer num = mmbVar.a(CameraCharacteristics.SENSOR_REFERENCE_ILLUMINANT1);
        if (num != null) {
            float[] convertToFloatArray = convertToFloatArray(mmbVar.b(CameraCharacteristics.SENSOR_COLOR_TRANSFORM1));
            float[] convertToFloatArray2 = convertToFloatArray(
                    mmbVar.b(CameraCharacteristics.SENSOR_CALIBRATION_TRANSFORM1));
            DngColorCalibration dngColorCalibration = new DngColorCalibration();
            dngColorCalibration.setIlluminant(num);
            dngColorCalibration.setXyz_to_model_rgb(convertToFloatArray);
            dngColorCalibration.setModel_rgb_to_device_rgb(convertToFloatArray2);
            dngColorCalibrationVector.add(dngColorCalibration);
        }
        Byte b = mmbVar.a(CameraCharacteristics.SENSOR_REFERENCE_ILLUMINANT2);
        if (b != null) {
            float[] convertToFloatArray3 = convertToFloatArray(mmbVar.b(CameraCharacteristics.SENSOR_COLOR_TRANSFORM2));
            float[] convertToFloatArray4 = convertToFloatArray(
                    mmbVar.b(CameraCharacteristics.SENSOR_CALIBRATION_TRANSFORM2));
            DngColorCalibration dngColorCalibration2 = new DngColorCalibration();
            dngColorCalibration2.setIlluminant(b);
            dngColorCalibration2.setXyz_to_model_rgb(convertToFloatArray3);
            dngColorCalibration2.setModel_rgb_to_device_rgb(convertToFloatArray4);
            dngColorCalibrationVector.add(dngColorCalibration2);
        }
        staticMetadata.setDng_color_calibration(dngColorCalibrationVector);
        staticMetadata.setQc_color_calibration(getQcColorCalibration());
        SizeF sizeF = mmbVar.b(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        staticMetadata.setSensor_physical_width_mm(sizeF.getWidth());
        staticMetadata.setSensor_physical_height_mm(sizeF.getHeight());
        Size size = mmbVar.b(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        staticMetadata.setPixel_array_width(size.getWidth());
        staticMetadata.setPixel_array_height(size.getHeight());
        Rect rect2 = mmbVar.b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        PixelRect pixelRect2 = new PixelRect();
        pixelRect2.setX0(rect2.left);
        pixelRect2.setY0(rect2.top);
        mnh gcamRawFormat = getGcamRawFormat(mmbVar);
        int i2 = gcamRawFormat.b.a;
        staticMetadata.setFrame_raw_max_width(i2);
        pixelRect2.setX1(i2);
        int i3 = gcamRawFormat.b.b;
        staticMetadata.setFrame_raw_max_height(i3);
        pixelRect2.setY1(i3);
        staticMetadata.setActive_area(pixelRect2);
        staticMetadata.setRaw_bits_per_pixel(ImageFormat.getBitsPerPixel(gcamRawFormat.a));
        staticMetadata.setFrame_readout_time_ms(nsToMsFloat(getReadoutTimeNs(mmbVar)));
        return staticMetadata;
    }

    private static int convertToLensFacing(mmt mmtVar) {
        switch (mmtVar.ordinal()) {
            case LensFacing.kFront:
                return CameraCharacteristics.LENS_FACING_FRONT;
            case LensFacing.kBack:
                return CameraCharacteristics.LENS_FACING_BACK;
            case LensFacing.kExternal:
                return CameraCharacteristics.LENS_FACING_EXTERNAL;
            default:
                return LensFacing.kUnknown;
        }
    }

    private NormalizedRect convertToNormalizedRect(Rect rect) {
        NormalizedRect normalizedRect = new NormalizedRect();
        float width = 1.0f / this.preCorrectionActiveArraySize.width();
        float height = 1.0f / this.preCorrectionActiveArraySize.height();
        normalizedRect.setX0(rect.left * width);
        normalizedRect.setY0(rect.top * height);
        normalizedRect.setX1(rect.right * width);
        normalizedRect.setY1(rect.bottom * height);
        return normalizedRect;
    }

    private float[] getAnalogAndDigitalGain(mpz mpzVar) {
        float analog, digital;
        float sens = (float) mpzVar.a(CaptureResult.SENSOR_SENSITIVITY);
        if (sens > maxAnalogIso) {
            analog = (float) (maxAnalogIso / minIso);
            digital = Math.max(sens / maxAnalogIso, 1.0f);
        } else {
            analog = sens / minIso;
            digital = 1.0f;
        }
        return new float[] { analog, digital };
    }

    private static float[] getAwbGains(mpz mpzVar, int[] iArr) {
        float[] fArr = new float[RggbChannelVector.COUNT];
        RggbChannelVector rggbChannelVector = mpzVar.a(CaptureResult.COLOR_CORRECTION_GAINS);
        if (rggbChannelVector == null) {
            Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_GAINS.");
            Arrays.fill(fArr, 1.0f);
            return fArr;
        }
        for (int i = 0; i < RggbChannelVector.COUNT; i++) {
            fArr[i] = rggbChannelVector.getComponent(iArr[i]);
        }
        return fArr;
    }

    private static float[] getAwbGainsAlt(mpz mpzVar) {
        float[] fArr = new float[RggbChannelVector.COUNT];
        Rational[] rationalArr = mpzVar.a(CaptureResult.SENSOR_NEUTRAL_COLOR_POINT);
        if (rationalArr == null) {
            Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_GAINS.");
            Arrays.fill(fArr, 1.0f);
            return fArr;
        }
        fArr[RggbChannelVector.RED] = 1.0f / rationalArr[0].floatValue();
        fArr[RggbChannelVector.GREEN_EVEN] = 1.0f;
        fArr[RggbChannelVector.GREEN_ODD] = 1.0f;
        fArr[RggbChannelVector.BLUE] = 1.0f / rationalArr[2].floatValue();
        return fArr;
    }

    private static float[] getAwbRgb2Rgb(mpz mpzVar) {
        ColorSpaceTransform colorSpaceTransform = mpzVar.a(CaptureResult.COLOR_CORRECTION_TRANSFORM);
        if (colorSpaceTransform == null) {
            Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_TRANSFORM.");
            return new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f };
        }
        return convertToFloatArray(colorSpaceTransform);
    }

    private static int[] getEvenOddSourceIndicesForCfa(int cfa) {
        switch (cfa) {
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB:
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG:
                return new int[] {
                        RggbChannelVector.RED, RggbChannelVector.GREEN_EVEN,
                        RggbChannelVector.GREEN_ODD, RggbChannelVector.BLUE };

            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG:
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR:
                return new int[] {
                        RggbChannelVector.RED, RggbChannelVector.GREEN_ODD,
                        RggbChannelVector.GREEN_EVEN, RggbChannelVector.BLUE };
            default:
                throw new IllegalArgumentException("CameraCharacteristics: unsupported colorFilterArrangment");
        }
    }

    private static float getExposureTimeMs(mpz mpzVar) {
        return nsToMsFloat(mpzVar.a(CaptureResult.SENSOR_EXPOSURE_TIME));
    }

    public static mnh getGcamRawFormat(mmb mmbVar) {
        List<lyw> RAW10 = mmbVar.a(ImageFormat.RAW10);
        List<lyw> RAW12 = mmbVar.a(ImageFormat.RAW12);
        List<lyw> RAW_SENSOR = mmbVar.a(ImageFormat.RAW_SENSOR);
        List<lyw> YUV_420_888 = mmbVar.a(ImageFormat.YUV_420_888);
        if (!RAW10.isEmpty())
            return new mnh(ImageFormat.RAW10, lyx.a(RAW10));
        if (!RAW12.isEmpty())
            return new mnh(ImageFormat.RAW12, lyx.a(RAW12));
        if (!RAW_SENSOR.isEmpty())
            return new mnh(ImageFormat.RAW_SENSOR, lyx.a(RAW_SENSOR));
        if (!YUV_420_888.isEmpty())
            return new mnh(ImageFormat.YUV_420_888, lyx.a(YUV_420_888));
        throw new IllegalArgumentException("No HDR+ compatible raw format supported.");
    }

    public static int getGcamSensorId(mmb mmbVar) {
        int facing = convertToLensFacing(mmbVar.b());
        List<Float> focals = mmbVar.D();
        boolean hasAux = mmbVar.y() || focals.size() > 1;

        if (facing == LensFacing.kBack) {
            if (hasAux)
                return 5;
            if (focals.size() != 1 || focals.get(0) <= 5.0f)
                return 0;
            else
                return 4;
        } else if (hasAux) {
            return 3;
        } else {
            if (focals.size() == 1 && focals.get(0) < 2.1f)
                return 2;
            if (focals.size() != 1 || focals.get(0) <= 4.3f)
                return 1;
            else
                return 6;
        }
    }

    public static int getImageRotation(int i) {
        switch (i) {
            case 0:
                return 3;
            case 90:
                return 0;
            case 180:
                return 1;
            case 270:
                return 2;
            default:
                throw new IllegalArgumentException("Rotation must be one of {0, 90, 180, 270}.");
        }
    }

    private static Optional<OisMetadata> getOisMetadata(mpz mpzVar) {
        return oisMetadataFromCamera2(mpzVar);
    }

    private static OisMetadata getOisMetadataFromRawShifts(long j, long[] jArr, int[] iArr, int[] iArr2) {
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(j);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (int i = 0; i < jArr.length; i++) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(jArr[i]);
            oisPosition.setShift_pixel_x(iArr[i] * (-OIS_RAW_2_PIXEL_X_COEFF));
            oisPosition.setShift_pixel_y(iArr2[i] * (-OIS_RAW_2_PIXEL_Y_COEFF));
            ois_positions.add(oisPosition);
        }
        return oisMetadata;
    }

    private static QcColorCalibration getQcColorCalibration() {
        float[] fArr;
        float[] fArr2;
        try {
            if (FixBSG.sCam != LensFacing.kFront) {
                fArr2 = new float[] {
                        0.4789849f, 0.442842f, 0.88774407f, 0.64594114f,
                        0.58401686f, 1.1131755f, 0.55829304f, 0.64594114f,
                        0.5381625f, 0.4789849f, 0.96712637f, 0.8674805f,
                        0.4789849f, 0.4789849f, 0.64594114f, 0.64594114f };
                fArr = new float[] {
                        0.6864161f, 0.76931924f, 0.34084547f, 0.44676545f,
                        0.3976252f, 0.26975086f, 0.55698436f, 0.44676545f,
                        0.5921095f, 0.6864161f, 0.25033233f, 0.34084547f,
                        0.6864161f, 0.6864161f, 0.44676545f, 0.44676545f };
            } else {
                fArr2 = new float[] {
                        0.45419505f, 0.4423781f, 0.8008711f, 0.59523225f,
                        0.55316937f, 1.0265143f, 0.5231485f, 0.59523225f,
                        0.5231485f, 0.45419505f, 0.8008711f, 0.7823376f,
                        0.45419505f, 0.45419505f, 0.59523225f, 0.59523225f };
                fArr = new float[] {
                        0.72146124f, 0.7592262f, 0.3752295f, 0.45897773f,
                        0.44465324f, 0.28412443f, 0.5940661f, 0.45897773f,
                        0.5940661f, 0.72146124f, 0.3752295f, 0.3747195f,
                        0.72146124f, 0.72146124f, 0.45897773f, 0.45897773f };
            }
            QcIlluminantVector qcIlluminantVector = new QcIlluminantVector();
            for (int i2 = 0; i2 < 16; i2++) {
                QcColorCalibration.IlluminantData illuminantData = new QcColorCalibration.IlluminantData();
                illuminantData.setRg_ratio(fArr2[i2]);
                illuminantData.setBg_ratio(fArr[i2]);
                qcIlluminantVector.add(illuminantData);
            }
            QcColorCalibration qcColorCalibration = new QcColorCalibration();
            qcColorCalibration.setIlluminant_data(qcIlluminantVector);
            qcColorCalibration.setGrgb_ratio(FixBSG.sCam != 0 ? 1.0019569f : 1.00098f);
            Log.v(TAG, "PIXEL_TWO_AWB worked");
            return qcColorCalibration;
        } catch (Throwable unused) {
            Log.w(TAG, "PIXEL_TWO_AWB didn't work");
            return new QcColorCalibration();
        }
    }

    public static long getReadoutTimeNs(mmb mmbVar) {
        mnh gcamRawFormat = getGcamRawFormat(mmbVar);
        return mmbVar.a(gcamRawFormat.a, gcamRawFormat.b);
    }

    public static int[] getRedBlueSourceIndicesForCfa(int i) {
        return getEvenOddSourceIndicesForCfa(i);
    }

    private boolean isProbablyUsingAntibanding(float f, float f2) {
        if (f >= (-ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS) + f2) {
            float f3 = f / f2;
            return Math.abs(f3 - Math.round(f3)) * f2 < ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS;
        }
        return false;
    }

    private static long msFloatToNs(float ms) {
        return (long) (ms * 1000000.0f);
    }

    private static float nsToMsFloat(long ns) {
        return (float) ns / 1000000.0f;
    }

    private static Optional<OisMetadata> oisMetadataFromCamera2(mpz mpzVar) {
        Integer num = mpzVar.a(CaptureResult.STATISTICS_OIS_DATA_MODE);
        if (num == null || num == 0) {
            return Optional.empty();
        }
        Long l = mpzVar.a(CaptureResult.SENSOR_TIMESTAMP);
        OisSample[] oisSampleArr = mpzVar.a(CaptureResult.STATISTICS_OIS_SAMPLES);
        if (l == null || oisSampleArr == null) {
            return Optional.empty();
        }
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(l);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (OisSample oisSample : oisSampleArr) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(oisSample.getTimestamp());
            oisPosition.setShift_pixel_x(oisSample.getXshift());
            oisPosition.setShift_pixel_y(oisSample.getYshift());
            ois_positions.add(oisPosition);
        }
        return Optional.of(oisMetadata);
    }

    private static Optional<OisMetadata> oisMetadataFromExperimental(mpz mpzVar) {
        if (kvf.h == null || kvf.i == null) {
            return Optional.empty();
        }
        Long l = mpzVar.a(kvf.h);
        long[] jArr = mpzVar.a(kvf.i);
        if (l == null || jArr == null) {
            return Optional.empty();
        }
        if (kvf.l != null && kvf.m != null) {
            float[] fArr = mpzVar.a(kvf.l);
            float[] fArr2 = mpzVar.a(kvf.m);
            if (fArr != null && fArr2 != null) {
                int length = fArr.length;
                int length2 = jArr.length;
                if (length == length2 && fArr2.length == length2) {
                    return Optional.of(oisMetadataFromPixelShifts(l, jArr, fArr, fArr2));
                }
            }
        } else if (kvf.j != null && kvf.k != null) {
            int[] iArr = mpzVar.a(kvf.j);
            int[] iArr2 = mpzVar.a(kvf.k);
            if (iArr != null && iArr2 != null) {
                int length3 = iArr.length;
                int length4 = jArr.length;
                if (length3 == length4 && iArr2.length == length4) {
                    return Optional.of(getOisMetadataFromRawShifts(l, jArr, iArr, iArr2));
                }
            }
        }
        return Optional.empty();
    }

    private static OisMetadata oisMetadataFromPixelShifts(long j, long[] jArr, float[] fArr, float[] fArr2) {
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(j);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (int i = 0; i < jArr.length; i++) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(jArr[i]);
            oisPosition.setShift_pixel_x(fArr[i]);
            oisPosition.setShift_pixel_y(fArr2[i]);
            ois_positions.add(oisPosition);
        }
        return oisMetadata;
    }

    private static boolean setChoiseAwbGains() {
        return Build.DEVICE.equals("dipper") ||
                Build.DEVICE.equals("perseus") ||
                Build.DEVICE.equals("beryllium") ||
                Build.DEVICE.equals("polaris") ||
                Build.DEVICE.equals("equuleus") ||
                Build.DEVICE.equals("ursa") ||
                Build.DEVICE.equals("grus") ||
                Build.DEVICE.equals("violet") ||
                Build.DEVICE.equals("sirius");
    }

    public static void updateFaceInfo(mmb mmbVar, ExtendedFaces extendedFaces, FaceInfoVector faceInfoVector) {
        int i;
        Rect rect = mmbVar.b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        int width = rect.width();
        int height = rect.height();
        float size;
        Face[] faces = extendedFaces.getFaces();
        if (faces != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < faces.length; i3++) {
                Face face = faces[i3];
                Rect bounds = face.getBounds();
                float pointX = bounds.exactCenterX() / width;
                float pointY = bounds.exactCenterY() / height;
                float quarter = (bounds.width() + bounds.height()) / 2.0f;
                if (width > height)
                    size = quarter / width;
                else
                    size = quarter / height;
                float confidence = (face.getScore() - 1) / 99.0f;
                if (pointX >= 0.0f && pointX <= 1.0f &&
                        pointY >= 0.0f && pointY <= 1.0f &&
                        size >= 0.0f && size <= 1.0f &&
                        confidence >= 0.0f && confidence <= 1.0f) {
                    FaceInfo faceInfo = new FaceInfo();
                    faceInfo.setPos_x(pointX);
                    faceInfo.setPos_y(pointY);
                    faceInfo.setSize(size);
                    faceInfo.setConfidence(confidence);
                    if (!extendedFaces.extendedFacesAvailable()) {
                        for (LandmarkIndex landmarkIndex : LandmarkIndex.values()) {
                            updateNormalizedLandmark(face, landmarkIndex, width, height, faceInfo);
                        }
                    } else {
                        float[] faceLandmarkXy = extendedFaces.getFaceLandmarkXy();
                        byte[] faceLandmarkIds = extendedFaces.getFaceLandmarkIds();
                        int[] faceLandmarkCounts = extendedFaces.getFaceLandmarkCounts();
                        if (faceLandmarkXy != null && faceLandmarkIds != null && faceLandmarkCounts != null) {
                            int i4 = 0;
                            while (true) {
                                i = faceLandmarkCounts[i3];
                                if (i4 >= i)
                                    break;
                                FaceInfo.Landmark landmark = new FaceInfo.Landmark();
                                int i5 = i2 + i4;
                                int i6 = i5 * 2;
                                landmark.setX(faceLandmarkXy[i6] / (float) width);
                                landmark.setY(faceLandmarkXy[i6 + 1] / (float) height);
                                faceInfo.getLandmarks().set(faceLandmarkIds[i5], landmark);
                                i4++;
                            }
                            i2 += i;
                        }
                    }
                    faceInfoVector.add(faceInfo);
                }
                Log.w(TAG, String.format("Face data is bad: (%d, %d) - (%d, %d), score %d", bounds.left, bounds.top,
                        bounds.right, bounds.bottom, face.getScore()));
            }
        }
    }

    private static void updateNormalizedLandmark(Face face, LandmarkIndex landmarkIndex, int i, int i2,
            FaceInfo faceInfo) {
        Point landmarkLocation = landmarkIndex.getLandmarkLocation(face);
        if (landmarkLocation != null) {
            FaceInfo.Landmark landmark = new FaceInfo.Landmark();
            landmark.setX((float) (landmarkLocation.x / i));
            landmark.setY((float) (landmarkLocation.y / i2));
            faceInfo.getLandmarks().set(landmarkIndex.getIndex(), landmark);
        }
    }

    public void appendMeteringRectanglesAsGcamWeightedNormalizedRects(MeteringRectangle[] meteringRectangleArr,
            Rect rect, WeightedNormalizedRectVector weightedNormalizedRectVector) {
        WeightedNormalizedRect weightedNormalizedRect = new WeightedNormalizedRect();
        weightedNormalizedRect.setWeight(1.0f);
        weightedNormalizedRect.setRect(new NormalizedRect());
        weightedNormalizedRectVector.add(weightedNormalizedRect);
        if (meteringRectangleArr != null) {
            for (MeteringRectangle meteringRectangle : meteringRectangleArr) {
                if (meteringRectangle.getMeteringWeight() != 0) {
                    WeightedNormalizedRect weightedNormalizedRect2 = new WeightedNormalizedRect();
                    Rect rect2 = meteringRectangle.getRect();
                    float exactCenterX = rect2.exactCenterX();
                    float exactCenterY = rect2.exactCenterY();
                    float min = Math.min(rect.width(), rect.height()) * 0.06125f;
                    float clamp = MathUtils.clamp((exactCenterX - min) / this.preCorrectionActiveArraySize.width(),
                            0.0f, 1.0f);
                    float clamp2 = MathUtils.clamp((exactCenterY - min) / this.preCorrectionActiveArraySize.height(),
                            0.0f, 1.0f);
                    float clamp3 = MathUtils.clamp((exactCenterX + min) / this.preCorrectionActiveArraySize.width(),
                            0.0f, 1.0f);
                    float clamp4 = MathUtils.clamp((exactCenterY + min) / this.preCorrectionActiveArraySize.height(),
                            0.0f, 1.0f);
                    NormalizedRect rect3 = weightedNormalizedRect2.getRect();
                    rect3.setX0(clamp);
                    rect3.setY0(clamp2);
                    rect3.setX1(clamp3);
                    rect3.setY1(clamp4);
                    weightedNormalizedRect2.setWeight(GCAM_METERING_REGION_WEIGHT);
                    weightedNormalizedRectVector.add(weightedNormalizedRect2);
                }
            }
        }
    }

    public FrameMetadata convertToGcamFrameMetadata(mpz mpzVar) {
        return convertToGcamFrameMetadata(mpzVar, null, null);
    }

    public FrameMetadata convertToGcamFrameMetadata(mpz mpzVar, Face[] faceArr, GyroSampleVector gyroSampleVector) {
        Integer rawSensBoost;
        float rawDigitalGain = 1.0f;
        BlackLevelPattern blackLevelPattern;
        float[] fArr;
        FrameMetadata frameMetadata = new FrameMetadata();
        frameMetadata.setSensor_id(getGcamSensorId(this.characteristics));
        float exposureTimeMs = getExposureTimeMs(mpzVar);
        float[] analogAndDigitalGain = getAnalogAndDigitalGain(mpzVar);
        float analogGain = analogAndDigitalGain[0];
        float digitalGain = analogAndDigitalGain[1];
        if ((rawSensBoost = mpzVar.a(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
            rawDigitalGain = (float) (rawSensBoost / CONTROL_POST_RAW_SENSITIVITY_BOOST_UNITY);
        }
        if (FixBSG.sPhotoFrames != FixBSG.sPhotoFramesCount) {
            FixBSG.sGetActual_exposure_time_ms = exposureTimeMs;
            FixBSG.sGetActual_analog_gain = analogGain;
            FixBSG.sGetApplied_digital_gain = digitalGain;
            FixBSG.sGetPost_raw_digital_gain = rawDigitalGain;
        }
        float actualExposureTimeMs = FixBSG.sGetActual_exposure_time_ms;
        float actualAnalogGain = FixBSG.sGetActual_analog_gain;
        float appliedDigitalGain = FixBSG.sGetApplied_digital_gain;
        float postRawDigitalGain = FixBSG.sGetPost_raw_digital_gain;
        frameMetadata.setActual_exposure_time_ms(actualExposureTimeMs);
        frameMetadata.setActual_analog_gain(actualAnalogGain);
        frameMetadata.setApplied_digital_gain(appliedDigitalGain);
        frameMetadata.setPost_raw_digital_gain(postRawDigitalGain);
        Log.e(TAG, "setActual_exposure_time_ms " + actualExposureTimeMs);
        Log.e(TAG, "setActual_analog_gain " + actualAnalogGain);
        Log.e(TAG, "setApplied_digital_gain " + appliedDigitalGain);
        Log.e(TAG, "setPost_raw_digital_gain " + postRawDigitalGain);
        FixBSG.sPhotoFrames++;
        int intValue = mpzVar.a(CaptureResult.FLASH_MODE);
        if (intValue == 1 || intValue == 2) {
            frameMetadata.setFlash(1);
        } else {
            frameMetadata.setFlash(0);
        }
        frameMetadata.setSharpness(GCAM_CALCULATES_SHARPNESS);
        frameMetadata.setWb(getAwbInfoCaptured(mpzVar));
        Rational[] rationalArr = mpzVar.a(CaptureResult.SENSOR_NEUTRAL_COLOR_POINT);
        frameMetadata.setNeutral_point(
                new float[] { rationalArr[0].floatValue(), rationalArr[1].floatValue(), rationalArr[2].floatValue() });
        Boolean bool = mpzVar.a(CaptureResult.BLACK_LEVEL_LOCK);
        if (bool == null)
            bool = false;
        frameMetadata.setWas_black_level_locked(bool);
        frameMetadata.setTimestamp_ns(mpzVar.a(CaptureResult.SENSOR_TIMESTAMP));
        ExtendedFaces extendedFaces = new ExtendedFaces(mpzVar);
        if (!extendedFaces.facesAvailable())
            extendedFaces = new ExtendedFaces(faceArr);
        updateFaceInfo(this.characteristics, extendedFaces, frameMetadata.getFaces());
        frameMetadata.setSensor_temp(GcamModule.getKSensorTempUnknown());
        if (this.deviceProperties.d() || this.deviceProperties.e()) {
            float exposureTimeMs2 = getExposureTimeMs(mpzVar);
            if (isProbablyUsingAntibanding(exposureTimeMs2, ANTIBANDING_60HZ_PERIOD_MS)) {
                frameMetadata.setScene_flicker(3);
            } else if (isProbablyUsingAntibanding(exposureTimeMs2, ANTIBANDING_50HZ_PERIOD_MS)) {
                frameMetadata.setScene_flicker(2);
            } else {
                frameMetadata.setScene_flicker(1);
            }
        } else {
            Integer num2 = mpzVar.a(CaptureResult.STATISTICS_SCENE_FLICKER);
            if (num2 != null) {
                switch (num2) {
                    case CaptureResult.STATISTICS_SCENE_FLICKER_NONE:
                        frameMetadata.setScene_flicker(1);
                        break;
                    case CaptureResult.STATISTICS_SCENE_FLICKER_50HZ:
                        frameMetadata.setScene_flicker(2);
                        break;
                    case CaptureResult.STATISTICS_SCENE_FLICKER_60HZ:
                        frameMetadata.setScene_flicker(3);
                        break;
                    default:
                        Log.e(TAG, "Unexpected STATISTICS_SCENE_FLICKER type!");
                        break;
                }
            }
        }
        Pair<Double, Double>[] pairArr = mpzVar.a(CaptureResult.SENSOR_NOISE_PROFILE);

        DngNoiseModel[] dngNoiseModelArr = new DngNoiseModel[RggbChannelVector.COUNT];
        for (int i = 0; i < RggbChannelVector.COUNT; i++) {
            dngNoiseModelArr[i] = new DngNoiseModel();
            dngNoiseModelArr[i].setScale(pairArr[i].first.floatValue());
            dngNoiseModelArr[i].setOffset(pairArr[i].second.floatValue());
        }
        frameMetadata.setDng_noise_model_bayer(dngNoiseModelArr);
        if (!setChoiseAwbGains() || (fArr = mpzVar.a(CaptureResult.SENSOR_DYNAMIC_BLACK_LEVEL)) == null) {
            if ((blackLevelPattern = characteristics.a(CameraCharacteristics.SENSOR_BLACK_LEVEL_PATTERN)) != null) {
                float[] fArr2 = new float[RggbChannelVector.COUNT];
                for (int i2 = 0; i2 < RggbChannelVector.COUNT; i2++) {
                    fArr2[i2] = blackLevelPattern.getOffsetForIndex(i2 % 2, i2 / 2);
                }
                frameMetadata.setBlack_levels_bayer(fArr2);
            }
        } else {
            frameMetadata.setBlack_levels_bayer(fArr);
        }
        Float f8 = mpzVar.a(CaptureResult.LENS_FOCUS_DISTANCE);
        Integer num3 = this.characteristics.a(CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION);
        if (f8 != null && num3 != null && (num3 == 2 || num3 == 1)) {
            frameMetadata.setFocus_distance_diopters(f8);
        }
        Float f9 = mpzVar.a(CaptureResult.LENS_FOCAL_LENGTH);
        if (f9 != null) {
            frameMetadata.setFocal_length_mm(f9);
        }
        Float f10 = mpzVar.a(CaptureResult.LENS_APERTURE);
        if (f10 != null) {
            frameMetadata.setF_number(f10);
        }
        frameMetadata.setControl_mode(mpzVar.a(CaptureResult.CONTROL_MODE));
        AeMetadata aeMetadata = new AeMetadata();
        aeMetadata.setMode(mpzVar.a(CaptureResult.CONTROL_AE_MODE));
        aeMetadata.setLock(mpzVar.a(CaptureResult.CONTROL_AE_LOCK));
        aeMetadata.setState(mpzVar.a(CaptureResult.CONTROL_AE_STATE));
        Integer num4 = mpzVar.a(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        if (num4 != null) {
            aeMetadata.setPrecapture_trigger(num4);
        }
        aeMetadata.setExposure_compensation(
                getExposureCompensationStops(mpzVar.a(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION) + 1));
        appendMeteringRectanglesAsGcamWeightedPixelRects(mpzVar.a(CaptureResult.CONTROL_AE_REGIONS),
                aeMetadata.getMetering_rectangles());
        frameMetadata.setAe(aeMetadata);
        AwbMetadata awbMetadata = new AwbMetadata();
        awbMetadata.setMode(mpzVar.a(CaptureResult.CONTROL_AWB_MODE));
        awbMetadata.setLock(mpzVar.a(CaptureResult.CONTROL_AWB_LOCK));
        awbMetadata.setState(mpzVar.a(CaptureResult.CONTROL_AWB_STATE));
        appendMeteringRectanglesAsGcamWeightedPixelRects(mpzVar.a(CaptureResult.CONTROL_AWB_REGIONS),
                awbMetadata.getMetering_rectangles());
        frameMetadata.setAwb(awbMetadata);
        AfMetadata afMetadata = new AfMetadata();
        afMetadata.setMode(mpzVar.a(CaptureResult.CONTROL_AF_MODE));
        afMetadata.setState(mpzVar.a(CaptureResult.CONTROL_AF_STATE));
        afMetadata.setTrigger(mpzVar.a(CaptureResult.CONTROL_AF_TRIGGER));
        appendMeteringRectanglesAsGcamWeightedPixelRects(mpzVar.a(CaptureResult.CONTROL_AF_REGIONS),
                afMetadata.getMetering_rectangles());
        frameMetadata.setAf(afMetadata);
        Integer num5 = mpzVar.a(CaptureResult.LENS_STATE);
        if (num5 != null) {
            frameMetadata.setLens_state(num5);
        }
        Optional<OisMetadata> oisMetadata = getOisMetadata(mpzVar);
        frameMetadata.getClass();
        oisMetadata.ifPresent(frameMetadata::setOis_metadata);
        if (kvf.n != null) {
            frameMetadata.setExposure_time_boost(mpzVar.a(kvf.n));
        }
        if (gyroSampleVector != null) {
            frameMetadata.setGyro_samples(gyroSampleVector);
        }
        return frameMetadata;
    }

    public SpatialGainMap convertToSpatialGainMap(mpz mpzVar) {
        LensShadingMap lensShadingMap = mpzVar.a(CaptureResult.STATISTICS_LENS_SHADING_CORRECTION_MAP);
        if (lensShadingMap == null) {
            Log.w(TAG, "android.statistics.lensShadingMap was null, returning the empty SpatialGainMap()");
            return new SpatialGainMap();
        }
        int columnCount = lensShadingMap.getColumnCount();
        int rowCount = lensShadingMap.getRowCount();
        SpatialGainMap spatialGainMap = new SpatialGainMap(columnCount, rowCount, true, false);
        int[] evenOddSourceIndicesForCfa = getEvenOddSourceIndicesForCfa(
                characteristics.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT));
        for (int i = 0; i < RggbChannelVector.COUNT; i++) {
            int i2 = evenOddSourceIndicesForCfa[i];
            for (int i3 = 0; i3 < rowCount; i3++) {
                for (int i4 = 0; i4 < columnCount; i4++) {
                    spatialGainMap.WriteRggb(i4, i3, i, lensShadingMap.getGainFactor(i2, i4, i3));
                }
            }
        }
        return spatialGainMap;
    }

    public AwbInfo getAwbInfoCaptured(mpz mpzVar) {
        AwbInfo awbInfo = new AwbInfo();
        if (!setChoiseAwbGains())
            awbInfo.setGains(getAwbGains(mpzVar, evenOddIndexMap));
        else
            awbInfo.setGains(getAwbGainsAlt(mpzVar));
        awbInfo.setRgb2rgb(getAwbRgb2Rgb(mpzVar));
        return awbInfo;
    }

    public float getExposureCompensationStops(int i) {
        Rational rational = characteristics.b(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        return new Rational(i * rational.getNumerator(), rational.getDenominator()).floatValue();
    }

    public float getTotalExposureTime(mpz mpzVar) {
        return nsToMsFloat(mpzVar.a(CaptureResult.SENSOR_EXPOSURE_TIME))
                * (float) (mpzVar.a(CaptureResult.SENSOR_SENSITIVITY) / this.minIso);
    }

    public void updateAeShotParams(AeShotParams aeShotParams, Rect rect, MeteringRectangle[] meteringRectangleArr,
            lyw lywVar) {
        Rect a = lyb.a(lywVar).a(rect);
        aeShotParams.setCrop(convertToNormalizedRect(a));
        appendMeteringRectanglesAsGcamWeightedNormalizedRects(meteringRectangleArr, a,
                aeShotParams.getWeighted_metering_areas());
    }

    public void updateFromFrameRequest(FrameRequest frameRequest, mcs mcsVar) {
        float desired_exposure_time_ms = frameRequest.getDesired_exposure_time_ms();
        float desired_analog_gain = frameRequest.getDesired_analog_gain();
        float desired_digital_gain = frameRequest.getDesired_digital_gain();
        mcsVar.a(CaptureRequest.CONTROL_MODE, 1);
        mcsVar.a(CaptureRequest.CONTROL_AE_MODE, 0);
        mcsVar.a(CaptureRequest.SENSOR_EXPOSURE_TIME, msFloatToNs(desired_exposure_time_ms));
        mcsVar.a(CaptureRequest.SENSOR_FRAME_DURATION, 0L);
        mcsVar.a(CaptureRequest.SENSOR_SENSITIVITY, (int) (desired_digital_gain * desired_analog_gain * this.minIso));
        mcsVar.a(CaptureRequest.BLACK_LEVEL_LOCK, frameRequest.getTry_to_lock_black_level());
        mcsVar.a(CaptureRequest.CONTROL_AWB_MODE, 0);
        mcsVar.a(CaptureRequest.COLOR_CORRECTION_MODE, 0);
        AwbInfo awb = frameRequest.getAwb();
        if (!awb.Check())
            Log.w(TAG, "updateFromFrameRequest - invalid AwbInfo");
        float[] gains = awb.getGains();
        int[] iArr = this.redBlueIndexMap;
        mcsVar.a(CaptureRequest.COLOR_CORRECTION_GAINS,
                new RggbChannelVector(gains[iArr[0]], gains[iArr[1]], gains[iArr[2]], gains[iArr[3]]));
        mcsVar.a(CaptureRequest.COLOR_CORRECTION_TRANSFORM, convertToColorSpaceTransform(awb.getRgb2rgb()));
        mcsVar.a(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 1);
        mcsVar.a(CaptureRequest.STATISTICS_OIS_DATA_MODE, 1);
        mcsVar.a(CaptureRequest.STATISTICS_FACE_DETECT_MODE, this.faceDetectMode);
        mcsVar.a(CaptureRequest.EDGE_MODE, 0);
        mcsVar.a(CaptureRequest.NOISE_REDUCTION_MODE, 0);
    }
}
