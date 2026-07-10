package defpackage;

import java.util.concurrent.Executor;

public abstract class lsp implements lrm {
    public final lrm a;
    private final lrm b;

    public lsp(lrm lrmVar) {
        this.a = lrmVar;
        this.b = lrn.b(new lsq(this, lrmVar));
    }

    public abstract Object a(Object obj);

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        return this.b.a(lzbVar, executor);
    }

    @Override // defpackage.lrm
    public final Object b_() {
        return this.b.b_();
    }
}