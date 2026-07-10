package defpackage;

public final class ozp extends ozn {
    public static final ozp a = new ozp(null);
    private final Object b;

    public ozp(Object obj) {
        this.b = obj;
    }

    @Override
    public final Object get() {
        return this.b;
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.b);
        return obj + "[status=SUCCESS, result=[" + valueOf + "]]";
    }
}