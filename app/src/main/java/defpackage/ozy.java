package defpackage;

final class ozy implements Runnable {
    private final Runnable a;
    private final ozx b;

    ozy(ozx ozxVar, Runnable runnable) {
        this.b = ozxVar;
        this.a = runnable;
    }

    @Override
    public final void run() {
        this.b.a = false;
        this.a.run();
    }
}