package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;

public final class kve {
    public static final CaptureRequest.Key a;
    public static final CaptureResult.Key b;
    private static final boolean c = kvd.a(1);
    private static final boolean d = kvd.a(2);
    private static final boolean e = kvd.a(3);
    private static final boolean f = true;

    static {
        if (c) {
            a = com.google.android.camera.experimental2016.ExperimentalKeys.EXPERIMENTAL_CONTROL_HYBRID_AE;
        } else if (d) {
            a = com.google.android.camera.experimental2017.ExperimentalKeys.EXPERIMENTAL_CONTROL_HYBRID_AE;
        } else if (e) {
            a = com.google.android.camera.experimental2018.ExperimentalKeys.EXPERIMENTAL_CONTROL_HYBRID_AE;
        } else {
            a = null;
        }
        if (f) {
            b = CaptureResult.CONTROL_AF_SCENE_CHANGE;
        } else if (c) {
            b = com.google.android.camera.experimental2016.ExperimentalKeys.EXPERIMENTAL_CONTROL_AF_SCENE_CHANGE;
        } else if (d) {
            b = com.google.android.camera.experimental2017.ExperimentalKeys.EXPERIMENTAL_CONTROL_AF_SCENE_CHANGE;
        } else {
            b = null;
        }
    }
}