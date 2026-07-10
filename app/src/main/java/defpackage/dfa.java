package defpackage;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.RggbChannelVector;

import com.FixBSG;
import com.google.googlex.gcam.AeShotParams;
import com.google.googlex.gcam.AwbInfo;
import com.google.googlex.gcam.FrameMetadata;
import com.google.googlex.gcam.FrameRequest;
import com.google.googlex.gcam.GeometricCalibration;
import com.google.googlex.gcam.GeometricCalibrationVector;
import com.google.googlex.gcam.GyroSampleVector;
import com.google.googlex.gcam.SpatialGainMap;
import com.google.googlex.gcam.StaticMetadata;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import java.util.Iterator;
import java.util.List;

public final class dfa {
    private static final String b = pra.a("HdrPMdataConv");
    private static final boolean c = gpp.a().a("persist.gcam.sm.log", false)
            || !gpp.a().a("persist.gcam.sm.enabled", true);
    public final MetadataConverter a;
    private final mmb d;
    private final int e;
    private final mmm f;
    private final kib g;

    public dfa(mmb mmbVar, mmm mmmVar, kib kibVar) {
        this.d = mmbVar;
        FixBSG.GetLens(mmbVar);
        if (kibVar.a.d() || kibVar.a.e()) {
            this.e = mms.a.e;
        } else {
            this.e = mmbVar.h().e;
        }
        this.f = mmmVar;
        this.g = kibVar;
        this.a = new MetadataConverter(mmbVar);
    }

    public static int a(hha hhaVar) {
        switch (hhaVar) {
            case a:
                return 0;
            case c:
                return 1;
            case b:
                return 2;
            default:
                return -1;
        }
    }

    public static int a(mmb mmbVar) {
        return MetadataConverter.getGcamSensorId(mmbVar);
    }

    static StaticMetadata b(mmb mmbVar) {
        return MetadataConverter.convertToGcamStaticMetadata(mmbVar);
    }

    public final float a(int i) {
        return this.a.getExposureCompensationStops(i);
    }

    public final FrameMetadata a(mpz mpzVar, Face[] faceArr, GyroSampleVector gyroSampleVector) {
        mmb mmbVar;
        FrameMetadata convertToGcamFrameMetadata = this.a.convertToGcamFrameMetadata(mpzVar, faceArr, gyroSampleVector);
        if (!this.d.y()) {
            mmbVar = this.d;
        } else if (this.g.a.d()) {
            Float f = mpzVar.a(CaptureResult.LENS_FOCAL_LENGTH);
            ohr.b(f, "Could not retrieve focal length.");
            Iterator<mmp> it = this.d.B().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ohr.a(false, (Object) "Physical camera with matching focal length not found.");
                    mmbVar = this.d;
                    break;
                }
                mmb b2 = this.f.b((mmp) it.next());
                List<Float> i = b2.i();
                ohr.a(i.size() == 1, "Physical cameras must be single focal length.");
                float floatValue = i.get(0);
                if (f != null && f == floatValue) {
                    mmbVar = b2;
                    break;
                }
            }
        } else {
            ohr.a(false, (Object) "Logical camera, but mapping to physical camera is unknown.");
            mmbVar = this.d;
        }
        ohr.a(!mmbVar.y(), "Logical cameras not supported.");
        GeometricCalibrationVector geometricCalibrationVector = new GeometricCalibrationVector();
        float[] fArr = (float[]) mpzVar.a(CaptureResult.LENS_DISTORTION);
        float[] fArr2 = (float[]) mpzVar.a(CaptureResult.LENS_INTRINSIC_CALIBRATION);
        if (fArr == null) {
            fArr = (float[]) mmbVar.a(CameraCharacteristics.LENS_DISTORTION);
        }
        if (fArr2 == null) {
            fArr2 = (float[]) mmbVar.a(CameraCharacteristics.LENS_INTRINSIC_CALIBRATION);
        }
        if (fArr != null && fArr2 != null) {
            GeometricCalibration geometricCalibration = new GeometricCalibration();
            geometricCalibration.setQuality(0);
            geometricCalibration.setLens_distortion(fArr);
            geometricCalibration.setLens_intrinsic_calibration(fArr2);
            geometricCalibrationVector.add(geometricCalibration);
        }
        if (kvg.b != null && kvg.c != null && kvg.d != null && kvg.e != null && kvg.f != null) {
            float[] fArr3 = (float[]) mmbVar.a(kvg.b);
            float[] fArr4 = (float[]) mmbVar.a(kvg.c);
            float[] fArr5 = (float[]) mmbVar.a(kvg.d);
            int[] iArr = (int[]) mmbVar.a(kvg.e);
            int[] iArr2 = (int[]) mmbVar.a(kvg.f);
            if (fArr3 != null && fArr4 != null && fArr5 != null && iArr != null && iArr2 != null) {
                GeometricCalibration geometricCalibration2 = new GeometricCalibration();
                geometricCalibration2.setQuality(1);
                float[] lens_distortion = geometricCalibration2.getLens_distortion();
                lens_distortion[0] = fArr3[0];
                lens_distortion[1] = fArr3[1];
                lens_distortion[2] = fArr3[2];
                lens_distortion[3] = fArr3[6];
                lens_distortion[4] = fArr3[7];
                geometricCalibration2.setLens_distortion(lens_distortion);
                float[] lens_distortion_extended = geometricCalibration2.getLens_distortion_extended();
                lens_distortion_extended[0] = fArr3[3];
                lens_distortion_extended[1] = fArr3[4];
                lens_distortion_extended[2] = fArr3[5];
                lens_distortion_extended[3] = fArr3[8];
                lens_distortion_extended[4] = fArr3[9];
                lens_distortion_extended[5] = fArr3[10];
                lens_distortion_extended[6] = fArr3[11];
                geometricCalibration2.setLens_distortion_extended(lens_distortion_extended);
                float[] lens_intrinsic_calibration = geometricCalibration2.getLens_intrinsic_calibration();
                lens_intrinsic_calibration[0] = fArr5[0];
                lens_intrinsic_calibration[1] = fArr5[1];
                lens_intrinsic_calibration[2] = fArr4[0];
                lens_intrinsic_calibration[3] = fArr4[1];
                lens_intrinsic_calibration[4] = 0.0f;
                geometricCalibration2.setLens_intrinsic_calibration(lens_intrinsic_calibration);
                geometricCalibration2.setActive_rectangle(iArr);
                geometricCalibration2.setValid_rectangle(iArr2);
                geometricCalibrationVector.add(geometricCalibration2);
            }
        }
        convertToGcamFrameMetadata.setGeometric_calibration(geometricCalibrationVector);
        return convertToGcamFrameMetadata;
    }

    public final SpatialGainMap a(mpz mpzVar) {
        return this.a.convertToSpatialGainMap(mpzVar);
    }

    public final void a(AeShotParams aeShotParams, Rect rect, MeteringRectangle[] meteringRectangleArr, lyw lywVar) {
        this.a.updateAeShotParams(aeShotParams, rect, meteringRectangleArr, lywVar);
    }

    public final void a(FrameRequest frameRequest, grj builder) {
        float desired_exposure_time_ms = frameRequest.getDesired_exposure_time_ms();
        float desired_analog_gain = frameRequest.getDesired_analog_gain();
        float desired_digital_gain = frameRequest.getDesired_digital_gain();

        FixBSG.sGetDesired_exposure_time_ms = desired_exposure_time_ms;
        FixBSG.sGetDesired_analog_gain = desired_analog_gain;
        FixBSG.sGetDesired_digital_gain = desired_digital_gain;
        FixBSG.MinISOParamDesired();
        float dExposureTimeMs = FixBSG.sGetDesired_exposure_time_ms;
        float dAnalogGain = FixBSG.sGetDesired_analog_gain;
        float dDigitalGain = FixBSG.sGetDesired_digital_gain;

        builder.a(CaptureRequest.CONTROL_MODE, CaptureRequest.CONTROL_MODE_AUTO);
        builder.a(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_OFF);
        long exposure = (long) (dExposureTimeMs * 1000000.0f);
        builder.a(CaptureRequest.SENSOR_EXPOSURE_TIME, exposure);
        if (c)
            pra.d(b, "updateFromFrameRequest - Exposure (ns) = " + exposure);

        int minIso = this.d.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getLower();
        int sensitivity = (int) (dDigitalGain * dAnalogGain * minIso);
        builder.a(CaptureRequest.SENSOR_SENSITIVITY, sensitivity);
        if (c)
            pra.d(b, "updateFromFrameRequest - Gain (iso) = " + sensitivity +
                    " (analog = " + dAnalogGain + ", digital = " + dDigitalGain + ", minIsoGain = " + minIso + ")");

        builder.a(CaptureRequest.BLACK_LEVEL_LOCK, frameRequest.getTry_to_lock_black_level());
        if (c)
            pra.d(b, "updateFromFrameRequest - using manual white balance values");

        AwbInfo awb = frameRequest.getAwb();
        if (!awb.Check())
            pra.e(b, "updateFromFrameRequest - expected FrameRequest to have valid AwbInfo");

        builder.a(CaptureRequest.CONTROL_AWB_MODE, CaptureRequest.CONTROL_AWB_MODE_OFF);
        builder.a(CaptureRequest.COLOR_CORRECTION_MODE, CaptureRequest.COLOR_CORRECTION_MODE_TRANSFORM_MATRIX);
        float[] gains = awb.getGains();
        int[] indicesForCfa = this.a.redBlueIndexMap;
        builder.a(CaptureRequest.COLOR_CORRECTION_GAINS,
                new RggbChannelVector(gains[indicesForCfa[0]], gains[indicesForCfa[1]], gains[indicesForCfa[2]],
                        gains[indicesForCfa[3]]));
        builder.a(CaptureRequest.COLOR_CORRECTION_TRANSFORM,
                MetadataConverter.convertToColorSpaceTransform(awb.getRgb2rgb()));

        builder.a(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE_ON);
        builder.a(CaptureRequest.STATISTICS_OIS_DATA_MODE, CaptureRequest.STATISTICS_OIS_DATA_MODE_ON);
        builder.a(CaptureRequest.STATISTICS_FACE_DETECT_MODE, this.e);
        builder.a(CaptureRequest.EDGE_MODE, CaptureRequest.EDGE_MODE_OFF);
        builder.a(CaptureRequest.NOISE_REDUCTION_MODE, CaptureRequest.NOISE_REDUCTION_MODE_OFF);
        builder.a(CaptureRequest.SENSOR_FRAME_DURATION, 0L);
    }
}