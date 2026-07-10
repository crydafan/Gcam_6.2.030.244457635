package defpackage;

final class hob implements Runnable {
    private final /* synthetic */ lys a;
    private final /* synthetic */ hoa b;

    hob(hoa hoaVar, lys lysVar) {
        this.b = hoaVar;
        this.a = lysVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.a(this.a);
    }
}