package defpackage;

import java.util.concurrent.Executor;

final class lry implements lrm {
    private final /* synthetic */ Object a;

    lry(Object obj) {
        this.a = obj;
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        executor.execute(new lrz(lzbVar, this.a));
        return lrn.a;
    }

    @Override // defpackage.lrm
    public final Object b_() {
        return this.a;
    }

    public final String toString() {
        nyn a = oxl.a("Obs.of");
        a.a().b = this.a;
        return a.toString();
    }
}