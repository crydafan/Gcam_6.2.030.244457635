package defpackage;

final class lqv implements lqw, lyu {
    private final lyu a;
    private final String b;

    public lqv(lyu lyuVar, String str) {
        this.a = lyuVar;
        this.b = str;
    }

    @Override
    public final String c() {
        return this.b;
    }

    @Override
    public final void close() {
        this.a.close();
    }
}