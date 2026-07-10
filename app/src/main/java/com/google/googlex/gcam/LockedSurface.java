package com.google.googlex.gcam;

import android.annotation.TargetApi;
import android.view.Surface;

import defpackage.ohr;

@TargetApi(19)
public class LockedSurface implements AutoCloseable {
    public long nativePointer;

    private LockedSurface(Surface surface) {
        ohr.b(surface);
        this.nativePointer = AndroidJniUtils.lockSurface(surface);
        if (this.nativePointer != 0) {
            return;
        }
        throw new IllegalArgumentException("Failed to lock Surface.");
    }

    public static LockedSurface acquire(Surface surface) {
        return new LockedSurface(surface);
    }

    @Override
    public void close() {
        long j = this.nativePointer;
        if (j != 0) {
            AndroidJniUtils.unlockSurface(j);
            this.nativePointer = 0L;
        }
    }

    public long nativePointer() {
        return this.nativePointer;
    }
}
