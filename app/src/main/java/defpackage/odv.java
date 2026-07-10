package defpackage;

final class odv extends ods {
    private final transient ods a;

    odv(ods odsVar) {
        this.a = odsVar;
    }

    private final int c(int i) {
        return (size() - 1) - i;
    }

    @Override
    public final ods subList(int i, int i2) {
        ohr.a(i, i2, size());
        return this.a.subList(size() - i2, size() - i).h();
    }

    @Override
    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, size());
        return this.a.get(c(i));
    }

    @Override
    public final ods h() {
        return this.a;
    }

    @Override
    public final int indexOf(Object obj) {
        int lastIndexOf = this.a.lastIndexOf(obj);
        if (lastIndexOf < 0) {
            return -1;
        }
        return c(lastIndexOf);
    }

    @Override
    public final int lastIndexOf(Object obj) {
        int indexOf = this.a.indexOf(obj);
        if (indexOf < 0) {
            return -1;
        }
        return c(indexOf);
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    final boolean x_() {
        return this.a.x_();
    }
}