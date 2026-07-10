package defpackage;

import java.util.concurrent.Executor;

final class lrd implements lzb {
    private final lzb a;
    private final Executor b;
    private final lpu c;
    private lpu d;

    lrd(lzb lzbVar, Executor executor, lpu lpuVar) {
        this.a = lzbVar;
        this.b = executor;
        this.c = lpuVar;
        this.d = this.c.c();
    }

    @Override // defpackage.lzb
    public final /* synthetic */ void a(Object obj) {
        lpu lpuVar = this.d;
        this.d = this.c.c();
        this.d.a(((lrm) obj).a(this.a, this.b));
        lpuVar.close();
    }
}