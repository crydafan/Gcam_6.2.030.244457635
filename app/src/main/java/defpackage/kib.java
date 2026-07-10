package defpackage;

import android.annotation.TargetApi;

import com.google.android.camera.experimental2017.ExperimentalKeys;

@TargetApi(23)
public final class kib {
    private static kib c = null;
    private static final Object d = new Object();
    public final mpj a;
    public final mpi b;

    private kib(mpj mpjVar, mpi mpiVar) {
        this.a = mpjVar;
        this.b = mpiVar;
    }

    @Deprecated
    public static kib a() {
        synchronized (d) {
            if (c == null) {
                c = new kib(mpj.a(), mpi.a());
            }
        }
        return c;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        return true;
    }

    public final int e() {
        if (!this.a.b()) {
            if (!this.b.e && ExperimentalKeys.getLibraryVersion() <= 2) {
                return 0;
            }
            return !this.b.e ? 1 : 2;
        }
        return -1;
    }

    public final boolean f() {
        return this.b.e && !this.a.b();
    }

    public final boolean g() {
        return this.a.d() || this.a.e();
    }

    public final boolean h() {
        return this.a.d() || this.a.e();
    }
}