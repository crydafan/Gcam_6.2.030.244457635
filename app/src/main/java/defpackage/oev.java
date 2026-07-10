package defpackage;

import java.io.Serializable;

final class oev implements Serializable {
    public static final long serialVersionUID = 0;
    private final Object[] a;

    oev(Object[] objArr) {
        this.a = objArr;
    }

    final Object readResolve() {
        return oet.a(this.a);
    }
}