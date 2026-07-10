package defpackage;

final class ohk extends ods {
    private final transient Object[] a;
    private final transient int b;
    private final transient int c;

    ohk(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, this.c);
        return this.a[i + i + this.b];
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    final boolean x_() {
        return true;
    }
}