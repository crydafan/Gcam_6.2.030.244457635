package defpackage;

final /* synthetic */ class dek implements Runnable {
    private final deg a;

    dek(deg degVar) {
        this.a = degVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        deg degVar = this.a;
        degVar.a(1.0f);
        synchronized (degVar.a) {
            degVar.c = null;
        }
    }
}