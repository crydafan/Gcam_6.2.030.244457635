package com.google.googlex.gcam.image;

import com.google.googlex.gcam.InterleavedReadViewU8;
import com.google.googlex.gcam.InterleavedWriteViewU8;
import com.google.googlex.gcam.SwigHacks;
import com.google.googlex.gcam.YuvReadView;
import com.google.googlex.gcam.YuvWriteView;

import defpackage.ohr;

public final class YuvUtils {
    private YuvUtils() {
    }

    public static boolean rgbToYuv(InterleavedReadViewU8 interleavedReadViewU8, YuvWriteView yuvWriteView) {
        long nativePointer = SwigHacks.getNativePointer(interleavedReadViewU8);
        long nativePointer2 = SwigHacks.getNativePointer(yuvWriteView);
        boolean z = true;
        ohr.a(nativePointer != 0, "src view is null");
        if (nativePointer2 == 0) {
            z = false;
        }
        ohr.a(z, "dst view is null");
        return rgbToYuvImpl(nativePointer, nativePointer2);
    }

    private static native boolean rgbToYuvImpl(long j, long j2);

    public static boolean yuvToRgb(YuvReadView yuvReadView, InterleavedWriteViewU8 interleavedWriteViewU8) {
        long nativePointer = SwigHacks.getNativePointer(yuvReadView);
        long nativePointer2 = SwigHacks.getNativePointer(interleavedWriteViewU8);
        boolean z = true;
        ohr.a(nativePointer != 0, "src view is null");
        if (nativePointer2 == 0) {
            z = false;
        }
        ohr.a(z, "dst view is null");
        return yuvToRgbImpl(nativePointer, nativePointer2);
    }

    private static native boolean yuvToRgbImpl(long j, long j2);
}
