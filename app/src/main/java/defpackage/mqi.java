package defpackage;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import java.util.Arrays;
import java.util.List;

public class mqi implements mqm {
    private final mqm a;

    public mqi(mqm mqmVar) {
        this.a = mqmVar;
    }

    @Override
    public final Rect a() {
        return this.a.a();
    }

    @Override
    public final void a(Rect rect) {
        this.a.a(rect);
    }

    @Override
    public final int b() {
        return this.a.b();
    }

    @Override
    public final int c() {
        return this.a.c();
    }

    @Override
    public void close() {
        this.a.close();
    }

    @Override
    public final int d() {
        return this.a.d();
    }

    @Override
    public final List e() {
        return this.a.e();
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof mqm)) {
            mqm mqmVar = (mqm) obj;
            if (mqmVar.b() == b() && mqmVar.c() == c() && mqmVar.d() == d() && mqmVar.f() == f()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final long f() {
        return this.a.f();
    }

    @Override
    public final HardwareBuffer g() {
        return this.a.g();
    }

    @Override
    public final mlp h() {
        return this.a.h();
    }

    public final int hashCode() {
        return Arrays.hashCode(
                new Object[] { Integer.valueOf(b()), Integer.valueOf(c()), Integer.valueOf(d()), Long.valueOf(f()) });
    }

    public String toString() {
        return this.a.toString();
    }
}