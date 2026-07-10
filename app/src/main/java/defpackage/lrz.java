package defpackage;

final /* synthetic */ class lrz implements Runnable {
    private final lzb a;
    private final Object b;

    lrz(lzb lzbVar, Object obj) {
        this.a = lzbVar;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}