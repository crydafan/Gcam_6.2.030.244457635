package defpackage;

import java.util.concurrent.Executor;

public final class hnx implements lrm {
    public final mpd a;
    private final lpx b = new lpx();

    public hnx(mpd mpdVar) {
        this.a = mpdVar;
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        hny hnyVar = new hny(executor, lzbVar);
        this.a.a(hnyVar);
        this.b.execute(new hoa(this, executor, lzbVar));
        return new hoc(this, hnyVar);
    }

    @Override // defpackage.lrm
    public final /* synthetic */ Object b_() {
        return this.a.a();
    }
}