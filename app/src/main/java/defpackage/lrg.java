package defpackage;

final /* synthetic */ class lrg implements Runnable {
    private final lzb a;
    private final Object b;

    lrg(lzb lzbVar, Object obj) {
        this.a = lzbVar;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}