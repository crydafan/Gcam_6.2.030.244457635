package defpackage;

final class ohf extends ods {
    public static final ods a = new ohf(new Object[0], 0);
    private final transient Object[] b;
    private final transient int c;

    ohf(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    @Override
    final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.c);
        return i + this.c;
    }

    @Override
    final Object[] b() {
        return this.b;
    }

    @Override
    final int c() {
        return 0;
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, this.c);
        return this.b[i];
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    final int w_() {
        return this.c;
    }

    @Override
    final boolean x_() {
        return false;
    }
}