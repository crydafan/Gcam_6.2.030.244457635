package defpackage;

final /* synthetic */ class deh implements lyu {
    private final deg a;
    private final del b;

    deh(deg degVar, del delVar) {
        this.a = degVar;
        this.b = delVar;
    }

    @Override // defpackage.lyu, java.lang.AutoCloseable
    public final void close() {
        deg degVar = this.a;
        synchronized (degVar.a) {
            degVar.b.remove(this.b);
        }
    }
}