package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;

import java.util.Set;

public final class mmz implements mmq {
    private final mmq a;
    private final lzp b;

    public mmz(mmq mmqVar, lzp lzpVar) {
        this.a = mmqVar;
        this.b = lzpVar;
    }

    @Override
    public final <T> T a(CameraCharacteristics.Key<T> key) {
        return this.a.a(key);
    }

    @Override
    public final <T> T a(CameraCharacteristics.Key<T> key, T obj) {
        return this.a.a(key, obj);
    }

    @Override
    public final Set<CaptureRequest.Key<?>> a() {
        this.b.a("CM.availableCaptureRequestKeys");
        Set<CaptureRequest.Key<?>> a = this.a.a();
        this.b.a();
        return a;
    }

    @Override
    public final <T> T b(CameraCharacteristics.Key<T> key) {
        return this.a.b(key);
    }

    @Override
    public final Set<CaptureRequest.Key<?>> b() {
        this.b.a("CM.availableSessionKeys");
        Set<CaptureRequest.Key<?>> b = this.a.b();
        this.b.a();
        return b;
    }

    @Override
    public final Set<String> c() {
        this.b.a("CM.physicalCameraIds");
        Set<String> c = this.a.c();
        this.b.a();
        return c;
    }
}