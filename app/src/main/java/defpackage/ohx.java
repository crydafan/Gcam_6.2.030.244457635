package defpackage;

final class ohx extends oet {
    private final transient Object a;
    private transient int b;

    ohx(Object obj) {
        this.a = ohr.b(obj);
    }

    ohx(Object obj, int i) {
        this.a = obj;
        this.b = i;
    }

    @Override
    final int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    @Override
    public final oji iterator() {
        return new ofr(this.a);
    }

    @Override
    public final boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    @Override
    final boolean h() {
        return this.b != 0;
    }

    @Override
    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = this.a.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override
    final ods i() {
        return ods.a(this.a);
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final String toString() {
        String obj = this.a.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override
    final boolean x_() {
        return false;
    }
}