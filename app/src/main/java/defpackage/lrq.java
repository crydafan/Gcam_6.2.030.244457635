package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

final /* synthetic */ class lrq implements lyu {
    private final pag a;
    private final AtomicBoolean b;

    lrq(pag pagVar, AtomicBoolean atomicBoolean) {
        this.a = pagVar;
        this.b = atomicBoolean;
    }

    @Override // defpackage.lyu, java.lang.AutoCloseable
    public final void close() {
        lrn.a(this.a, this.b);
    }
}