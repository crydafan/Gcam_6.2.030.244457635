package defpackage;

final class bbw implements Runnable {
    private final bbp a;

    bbw(bbp bbpVar) {
        this.a = bbpVar;
    }

    @Override
    public final void run() {
        this.a.c();
    }
}