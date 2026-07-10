package defpackage;

final /* synthetic */ class dfy implements lyu {
    private final dfx a;
    private final int b;

    dfy(dfx dfxVar, int i) {
        this.a = dfxVar;
        this.b = i;
    }

    @Override // defpackage.lyu, java.lang.AutoCloseable
    public final void close() {
        this.a.b.d.remove(this.b);
    }
}