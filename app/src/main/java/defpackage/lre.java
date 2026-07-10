package defpackage;

import java.util.concurrent.Executor;

final class lre implements lrm {
    private final lrm a;

    lre(lrm lrmVar) {
        this.a = lrmVar;
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        return this.a.a(new lrf(executor, lzbVar), new lsh());
    }

    @Override // defpackage.lrm
    public final Object b_() {
        return this.a.b_();
    }

    public final String toString() {
        nyn a = oxl.a("filtered");
        a.a().b = this.a;
        return a.toString();
    }
}