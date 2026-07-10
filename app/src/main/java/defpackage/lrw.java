package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

final /* synthetic */ class lrw implements lzb {
    private final AtomicBoolean a;
    private final lpu b;

    lrw(AtomicBoolean atomicBoolean, lpu lpuVar) {
        this.a = atomicBoolean;
        this.b = lpuVar;
    }

    @Override // defpackage.lzb
    public final void a(Object obj) {
        lrn.a(this.a, this.b, (Boolean) obj);
    }
}