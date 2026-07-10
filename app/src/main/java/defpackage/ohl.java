package defpackage;

public final class ohl extends oet {
    public static final ohl a = new ohl(new Object[0], 0, null, 0, 0);
    private final transient Object[] b;
    private final transient Object[] c;
    private final transient int d;
    private final transient int e;
    private final transient int f;

    ohl(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.b = objArr;
        this.c = objArr2;
        this.d = i2;
        this.e = i;
        this.f = i3;
    }

    @Override
    final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.f);
        return i + this.f;
    }

    @Override
    public final oji iterator() {
        return e().listIterator(0);
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
    public final boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj != null && objArr != null) {
            int a2 = oxl.a(obj);
            while (true) {
                int i = a2 & this.d;
                Object obj2 = objArr[i];
                if (obj2 == null) {
                    break;
                } else if (obj2.equals(obj)) {
                    return true;
                } else {
                    a2 = i + 1;
                }
            }
        }
        return false;
    }

    @Override
    final boolean h() {
        return true;
    }

    @Override
    public final int hashCode() {
        return this.e;
    }

    @Override
    final ods i() {
        return ods.b(this.b, this.f);
    }

    @Override
    public final int size() {
        return this.f;
    }

    @Override
    final int w_() {
        return this.f;
    }

    @Override
    final boolean x_() {
        return false;
    }
}