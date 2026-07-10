package defpackage;

import android.os.Handler;

public final class mil {
    public final mcw a;
    public final lzw b;
    public final miq c;
    public final mjz d;
    public final lpu e;
    public final lzp f;
    public final lzj g;
    public final mje h;
    public final Handler i;
    public mio j;

    mil(mcw mcwVar, lzw lzwVar, miq miqVar, mjz mjzVar, Handler handler, mje mjeVar, lpu lpuVar, lzp lzpVar,
            lzj lzjVar) {
        this.a = mcwVar;
        this.b = lzwVar;
        this.c = miqVar;
        this.d = mjzVar;
        this.i = handler;
        this.h = mjeVar;
        this.e = lpuVar;
        this.f = lzpVar;
        this.g = lzjVar.a("CameraOpener");
    }

    public final mir a(mje mjeVar, lpu lpuVar, Handler handler) {
        mir mirVar = new mir(mjeVar, this.d, lpuVar, handler, this.f, this.g);
        lpuVar.a(mirVar);
        return mirVar;
    }
}