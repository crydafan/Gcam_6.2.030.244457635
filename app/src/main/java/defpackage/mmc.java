package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class mmc implements mmq {
    private final CameraCharacteristics a;
    private final nzv<Set<CaptureRequest.Key<?>>> b;
    private final nzv<Set<String>> c;
    private final nzv<Set<CaptureRequest.Key<?>>> d;

    public mmc(final CameraCharacteristics cameraCharacteristics, mpi apiProperties) {
        this.a = cameraCharacteristics;
        b(a::getKeys);
        this.b = b(a::getAvailableCaptureRequestKeys);
        b(a::getAvailableCaptureResultKeys);
        this.c = a(a::getPhysicalCameraIds, apiProperties);
        a(a::getAvailablePhysicalCameraRequestKeys, apiProperties);
        this.d = a(a::getAvailableSessionKeys, apiProperties);
    }

    static <T> Set<T> a(nzv<Collection<T>> nzvVar) {
        try {
            Collection<T> collection = nzvVar.a();
            if (collection == null) {
                return null;
            } else {
                return oet.a(collection);
            }
        } catch (Throwable th) {
            Log.w("CameraDeviceMetadata", "Failed to get some keys", th);
            return ohl.a;
        }
    }

    private static <T> nzv<Set<T>> a(nzv<Collection<T>> nzvVar, mpi mpiVar) {
        if (mpiVar.e)
            return () -> a(nzvVar);
        return () -> ohl.a;
    }

    private static <T> nzv<Set<T>> b(nzv<List<T>> nzvVar) {
        return () -> oet.a(nzvVar.a());
    }

    @Override
    public final <T> T a(CameraCharacteristics.Key<T> key) {
        return this.a.get(key);
    }

    @Override
    public final <T> T a(CameraCharacteristics.Key<T> key, T obj) {
        final T keyVal = this.a.get(key);
        if (keyVal != null)
            return keyVal;
        return obj;
    }

    @Override
    public final Set<CaptureRequest.Key<?>> a() {
        return (Set<CaptureRequest.Key<?>>) this.b.a();
    }

    @Override
    public final <T> T b(CameraCharacteristics.Key<T> key) {
        return ohr.b(this.a.get(key));
    }

    @Override
    public final Set<CaptureRequest.Key<?>> b() {
        return (Set<CaptureRequest.Key<?>>) this.d.a();
    }

    @Override
    public final Set<String> c() {
        return (Set<String>) this.c.a();
    }
}