package defpackage;

import java.util.concurrent.Executor;

final class lrf implements lzb {
    private Object a = null;
    private final /* synthetic */ Executor b;
    private final /* synthetic */ lzb c;

    lrf(Executor executor, lzb lzbVar) {
        this.b = executor;
        this.c = lzbVar;
    }

    @Override // defpackage.lzb
    public final void a(Object obj) {
        if (!oxl.c(this.a, obj)) {
            this.a = obj;
            this.b.execute(new lrg(this.c, obj));
        }
    }
}