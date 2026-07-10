package com.google.googlex.gcam.creativecamera.seedark;

import android.hardware.HardwareBuffer;
import android.view.Surface;

final class SeeDarkNativeImpl implements SeeDarkNative {
    static {
        System.loadLibrary("SeeDarkJni");
    }

    SeeDarkNativeImpl() {
    }

    @Override
    public final native void abortCapture(long j);

    @Override
    public final native long create(long j, String str, String str2);

    @Override
    public final native void delete(long j);

    @Override
    public final native void finishCapture(long j);

    @Override
    public final native void notifySurfaceChanged(long j, Surface surface);

    @Override
    public final native void processAndCloseFrame(long j, long j2, Runnable runnable, long j3, HardwareBuffer hardwareBuffer, Runnable runnable2, long j4, long j5, int i);

    @Override
    public final native void startCapture(long j, long j2, String str, Runnable runnable, Runnable runnable2, Runnable runnable3);
}
