package com.google.googlex.gcam.imageproc;

import com.google.googlex.gcam.InterleavedReadViewU8;
import com.google.googlex.gcam.InterleavedWriteViewU8;
import com.google.googlex.gcam.SwigHacks;
import com.google.googlex.gcam.YuvReadView;
import com.google.googlex.gcam.YuvWriteView;

import defpackage.ohr;

public final class Resample {
    private Resample() {
    }

    public static boolean downsample(YuvReadView yuvReadView, int i, YuvWriteView yuvWriteView) {
        long nativePointer = SwigHacks.getNativePointer(yuvReadView);
        long nativePointer2 = SwigHacks.getNativePointer(yuvWriteView);
        boolean z = true;
        ohr.a(nativePointer != 0, "src is null");
        if (nativePointer2 == 0) {
            z = false;
        }
        ohr.a(z, "dst is null");
        return downsampleImpl(nativePointer, i, nativePointer2);
    }

    private static native boolean downsampleImpl(long j, int i, long j2);

    public static boolean resampleLanczos(InterleavedReadViewU8 interleavedReadViewU8, float f, InterleavedWriteViewU8 interleavedWriteViewU8) {
        long nativePointer = SwigHacks.getNativePointer(interleavedReadViewU8);
        long nativePointer2 = SwigHacks.getNativePointer(interleavedWriteViewU8);
        boolean z = true;
        ohr.a(nativePointer != 0, "src is null");
        if (nativePointer2 == 0) {
            z = false;
        }
        ohr.a(z, "dst is null");
        return resampleLanczosImpl(nativePointer, f, nativePointer2);
    }

    private static native boolean resampleLanczosImpl(long j, float f, long j2);
}
