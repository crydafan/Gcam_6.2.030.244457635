package defpackage;

import java.util.concurrent.Executor;

public final class lrc implements lrm {
    private final lrm a;

    lrc(lrm lrmVar) {
        this.a = lrmVar;
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        lpu lpuVar = new lpu();
        lpuVar.a(this.a.a(new lrd(lzbVar, executor, lpuVar), new lsh()));
        return lpuVar;
    }

    @Override // defpackage.lrm
    public final Object b_() {
        return ((lrm) this.a.b_()).b_();
    }

    public final String toString() {
        nyn a = oxl.a("DerefObs");
        a.a().b = this.a;
        return a.toString();
    }
}