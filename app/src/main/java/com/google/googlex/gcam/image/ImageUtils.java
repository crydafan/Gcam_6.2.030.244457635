package com.google.googlex.gcam.image;

import com.google.googlex.gcam.InterleavedReadViewU8;
import com.google.googlex.gcam.InterleavedWriteViewU8;
import com.google.googlex.gcam.SwigHacks;

import defpackage.ohr;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static boolean copyContents(InterleavedReadViewU8 interleavedReadViewU8, InterleavedWriteViewU8 interleavedWriteViewU8) {
        long nativePointer = SwigHacks.getNativePointer(interleavedReadViewU8);
        long nativePointer2 = SwigHacks.getNativePointer(interleavedWriteViewU8);
        boolean z = true;
        ohr.a(nativePointer != 0, "src is null");
        if (nativePointer2 == 0) {
            z = false;
        }
        ohr.a(z, "dst is null");
        return copyContentsImpl(nativePointer, nativePointer2);
    }

    private static native boolean copyContentsImpl(long j, long j2);
}
