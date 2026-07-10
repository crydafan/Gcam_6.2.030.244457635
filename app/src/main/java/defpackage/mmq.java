package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;

import java.util.Set;

public interface mmq {
    <T> T a(CameraCharacteristics.Key<T> key);

    <T> T a(CameraCharacteristics.Key<T> key, T obj);

    Set<CaptureRequest.Key<?>> a();

    <T> T b(CameraCharacteristics.Key<T> key);

    Set<CaptureRequest.Key<?>> b();

    Set<String> c();
}