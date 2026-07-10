package defpackage;

import java.io.Serializable;

public abstract class nyp implements Serializable {
    public static final long serialVersionUID = 0;

    nyp() {
    }

    public static nyp b(Object obj) {
        return new nzf(ohr.b(obj));
    }

    public static nyp c(Object obj) {
        return obj != null ? new nzf(obj) : nxs.a;
    }

    public abstract Object a(Object obj);

    public abstract nyp a(nyi nyiVar);

    public abstract boolean b();

    public abstract Object c();

    public abstract Object d();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();
}