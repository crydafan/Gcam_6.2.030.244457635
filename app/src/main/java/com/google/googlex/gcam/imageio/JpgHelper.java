package com.google.googlex.gcam.imageio;

import com.google.googlex.gcam.BufferUtils;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.InterleavedReadViewU8;
import com.google.googlex.gcam.JpgEncodeOptions;
import com.google.googlex.gcam.SWIGTYPE_p_p_unsigned_char;
import com.google.googlex.gcam.SWIGTYPE_p_unsigned_char;
import com.google.googlex.gcam.YuvReadView;
import java.nio.ByteBuffer;

import defpackage.nxs;
import defpackage.nyp;

public final class JpgHelper {
    private JpgHelper() {
    }

    private static nyp copyToByteArrayAndDestroyNativeState(boolean z, SWIGTYPE_p_p_unsigned_char sWIGTYPE_p_p_unsigned_char, long[] jArr) {
        if (!z) {
            GcamModule.delete_uint8_p_p(sWIGTYPE_p_p_unsigned_char);
            return nxs.a;
        }
        int i = (int) jArr[0];
        SWIGTYPE_p_unsigned_char uint8_p_p_value = GcamModule.uint8_p_p_value(sWIGTYPE_p_p_unsigned_char);
        ByteBuffer byteBufferViewOfNativePointer = BufferUtils.byteBufferViewOfNativePointer(uint8_p_p_value, i);
        byte[] bArr = new byte[i];
        byteBufferViewOfNativePointer.get(bArr);
        GcamModule.free_uint8_p(uint8_p_p_value);
        GcamModule.delete_uint8_p_p(sWIGTYPE_p_p_unsigned_char);
        return nyp.b(bArr);
    }

    public static nyp encodeToJpegAsByteArray(InterleavedReadViewU8 interleavedReadViewU8, JpgEncodeOptions jpgEncodeOptions) {
        SWIGTYPE_p_p_unsigned_char new_uint8_p_p = GcamModule.new_uint8_p_p();
        long[] jArr = {0};
        return copyToByteArrayAndDestroyNativeState(GcamModule.WriteJpgToMemory(new_uint8_p_p, jArr, interleavedReadViewU8, jpgEncodeOptions), new_uint8_p_p, jArr);
    }

    public static nyp encodeToJpegAsByteArray(YuvReadView yuvReadView, JpgEncodeOptions jpgEncodeOptions) {
        SWIGTYPE_p_p_unsigned_char new_uint8_p_p = GcamModule.new_uint8_p_p();
        long[] jArr = {0};
        return copyToByteArrayAndDestroyNativeState(GcamModule.WriteJpgToMemory(new_uint8_p_p, jArr, yuvReadView, jpgEncodeOptions), new_uint8_p_p, jArr);
    }
}
