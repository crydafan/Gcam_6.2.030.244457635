package defpackage;

import java.util.concurrent.Executor;

final class hoa implements Runnable {
    public final /* synthetic */ lzb a;
    private final /* synthetic */ Executor b;
    private final /* synthetic */ hnx c;

    hoa(hnx hnxVar, Executor executor, lzb lzbVar) {
        this.c = hnxVar;
        this.b = executor;
        this.a = lzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.execute(new hob(this, this.c.a.a()));
    }
}