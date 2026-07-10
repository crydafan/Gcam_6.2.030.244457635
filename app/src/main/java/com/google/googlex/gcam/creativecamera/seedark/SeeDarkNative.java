package com.google.googlex.gcam.creativecamera.seedark;

import android.hardware.HardwareBuffer;
import android.view.Surface;

public interface SeeDarkNative {
    void abortCapture(long j);

    long create(long j, String str, String str2);

    void delete(long j);

    void finishCapture(long j);

    void notifySurfaceChanged(long j, Surface surface);

    void processAndCloseFrame(long j, long j2, Runnable runnable, long j3, HardwareBuffer hardwareBuffer, Runnable runnable2, long j4, long j5, int i);

    void startCapture(long j, long j2, String str, Runnable runnable, Runnable runnable2, Runnable runnable3);
}
