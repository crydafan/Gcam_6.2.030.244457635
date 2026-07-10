package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.google.android.camera.experimental2018.ExperimentalKeys;

public final class kvg {
    public static final CaptureResult.Key<Boolean> a;
    public static final CameraCharacteristics.Key<float[]> b;
    public static final CameraCharacteristics.Key<float[]> c;
    public static final CameraCharacteristics.Key<float[]> d;
    public static final CameraCharacteristics.Key<int[]> e;
    public static final CameraCharacteristics.Key<int[]> f;
    public static final CaptureRequest.Key<Integer> g;
    public static final CaptureResult.Key<byte[]> h;
    public static final CaptureResult.Key<byte[]> i;
    public static final CaptureResult.Key<byte[]> j;
    public static final CaptureResult.Key<Boolean> k;
    public static final CaptureResult.Key<int[]> l;
    public static final CaptureResult.Key<byte[]> m;
    public static final CaptureResult.Key<float[]> n;
    public static final CaptureResult.Key<float[]> o;
    public static final CaptureResult.Key<float[]> p;
    private static final boolean q = kvd.a(3);

    static {
        a = a(2) ? ExperimentalKeys.EXPERIMENTAL_FOCUS_OBJ_TOO_CLOSE : null;
        b = a(6) ? ExperimentalKeys.EXPERIMENTAL_LENS_DISTORTION_COEFFICIENTS_HIGH_QUALITY : null;
        c = a(6) ? ExperimentalKeys.EXPERIMENTAL_LENS_DISTORTION_OPTICAL_CENTER_HIGH_QUALITY : null;
        d = a(6) ? ExperimentalKeys.EXPERIMENTAL_LENS_DISTORTION_NORMALIZATION_HIGH_QUALITY : null;
        e = a(6) ? ExperimentalKeys.EXPERIMENTAL_LENS_DISTORTION_ACTIVE_RECTANGLE_HIGH_QUALITY : null;
        f = a(6) ? ExperimentalKeys.EXPERIMENTAL_LENS_DISTORTION_VALID_RECTANGLE_HIGH_QUALITY : null;
        g = a(9) ? ExperimentalKeys.EXPERIMENTAL_3A_METADATA_ENABLED : null;
        h = a(9) ? ExperimentalKeys.EXPERIMENTAL_3A_METADATA_AEC : null;
        i = a(9) ? ExperimentalKeys.EXPERIMENTAL_3A_METADATA_AF : null;
        j = a(9) ? ExperimentalKeys.EXPERIMENTAL_3A_METADATA_AWB : null;
        k = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_SKIPFRAME : null;
        l = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_LANDMARK_COUNT : null;
        m = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_LANDMARK_IDS : null;
        n = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_LANDMARK_XY : null;
        o = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_LANDMARK_DEPTH : null;
        p = a(12) ? ExperimentalKeys.EXPERIMENTAL_FACE_ORIENTATION : null;
    }

    private static boolean a(int i2) {
        if (q) {
            try {
                return i2 <= ExperimentalKeys.getLibraryVersion();
            } catch (NoSuchFieldError | NoSuchMethodError e2) {
                return false;
            }
        }
        return false;
    }
}