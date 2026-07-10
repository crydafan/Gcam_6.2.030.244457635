package defpackage;

import java.util.concurrent.Executor;

final class hny implements mpe {
    public final /* synthetic */ lzb a;
    private final /* synthetic */ Executor b;

    hny(Executor executor, lzb lzbVar) {
        this.b = executor;
        this.a = lzbVar;
    }

    @Override // defpackage.mpe
    public final void a(lys lysVar) {
        this.b.execute(new hnz(this, lysVar));
    }
}