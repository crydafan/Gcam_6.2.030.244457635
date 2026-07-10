package defpackage;

import java.io.Serializable;

final class odw implements Serializable {
    public static final long serialVersionUID = 0;
    private final Object[] a;

    odw(Object[] objArr) {
        this.a = objArr;
    }

    final Object readResolve() {
        return ods.a(this.a);
    }
}