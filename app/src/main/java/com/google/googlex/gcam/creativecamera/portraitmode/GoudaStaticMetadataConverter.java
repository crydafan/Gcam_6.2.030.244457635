package com.google.googlex.gcam.creativecamera.portraitmode;

import com.google.googlex.gcam.GoudaStaticMetadata;
import com.google.googlex.gcam.InterleavedImageF;
import com.google.googlex.gcam.PdCalibrationData;
import com.google.googlex.gcam.PdCalibrationDataVector;
import com.google.googlex.gcam.SwigHacks;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import defpackage.ohr;

public class GoudaStaticMetadataConverter {
    public static final int MAX_VALID_VERSION = 2;
    public static final int MIN_VALID_VERSION = 2;

    private static InterleavedImageF copyImage(int i, int i2, byte[] bArr, int i3) {
        InterleavedImageF interleavedImageF = new InterleavedImageF(i, i2, 1);
        copyImageImpl(bArr, i3, ((long) i * i2) << 2, SwigHacks.getNativePointer(interleavedImageF.base_pointer()));
        return interleavedImageF;
    }

    private static native void copyImageImpl(byte[] bArr, long j, long j2, long j3);

    public static GoudaStaticMetadata unpack(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        GoudaStaticMetadata goudaStaticMetadata = new GoudaStaticMetadata();
        goudaStaticMetadata.setCalibration_landscape_right(unpack(bArr));
        goudaStaticMetadata.setCalibration_landscape_left(unpack(bArr2));
        goudaStaticMetadata.setCalibration_portrait(unpack(bArr3));
        return goudaStaticMetadata;
    }

    private static PdCalibrationDataVector unpack(byte[] bArr) {
        PdCalibrationDataVector pdCalibrationDataVector = new PdCalibrationDataVector();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int i = wrap.getInt();
        ohr.a(i == 2, "Invalid PD calibration version (%s).", i);
        int i2 = wrap.getInt();
        int i3 = wrap.getInt();
        int i4 = wrap.getInt();
        int i5 = (i2 * i3) << 2;
        int i6 = (i5 + i5 + 16) * i4;
        ohr.a(i6 == wrap.remaining(), "Calibration data size (%s) does not match expected size (%s).", wrap.remaining(), i6);
        for (int i7 = 0; i7 < i4; i7++) {
            PdCalibrationData pdCalibrationData = new PdCalibrationData();
            pdCalibrationData.setReported_focus_distance_diopters(wrap.getFloat());
            pdCalibrationData.setEstimated_focus_distance_diopters(wrap.getFloat());
            pdCalibrationData.setDepth_to_disparity_scale(wrap.getFloat());
            pdCalibrationData.setDepth_to_disparity_offset(wrap.getFloat());
            pdCalibrationDataVector.add(pdCalibrationData);
        }
        for (int i8 = 0; i8 < i4; i8++) {
            PdCalibrationData pdCalibrationData2 = pdCalibrationDataVector.get(i8);
            pdCalibrationData2.setPd_scale(copyImage(i2, i3, bArr, wrap.position()));
            wrap.position(wrap.position() + i5);
            pdCalibrationData2.setPd_offset(copyImage(i2, i3, bArr, wrap.position()));
            wrap.position(wrap.position() + i5);
        }
        return pdCalibrationDataVector;
    }
}
