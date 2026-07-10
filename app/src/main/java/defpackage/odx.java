package defpackage;

final class odx extends ods {
    private final transient int a;
    private final transient int b;
    private final ods c;

    odx(ods odsVar, int i, int i2) {
        this.c = odsVar;
        this.a = i;
        this.b = i2;
    }

    @Override
    public final ods subList(int i, int i2) {
        ohr.a(i, i2, this.b);
        ods odsVar = this.c;
        int i3 = this.a;
        return odsVar.subList(i + i3, i2 + i3);
    }

    @Override
    final Object[] b() {
        return this.c.b();
    }

    @Override
    final int c() {
        return this.c.c() + this.a;
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, this.b);
        return this.c.get(i + this.a);
    }

    @Override
    public final int size() {
        return this.b;
    }

    @Override
    final int w_() {
        return this.c.c() + this.a + this.b;
    }

    @Override
    final boolean x_() {
        return true;
    }
}