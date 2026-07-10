package defpackage;

public final class nxs extends nyp {
    public static nxs a = new nxs();
    public static long serialVersionUID = 0;

    private nxs() {
    }

    public static nyp a() {
        return a;
    }

    private Object readResolve() {
        return a;
    }

    @Override
    public Object a(Object obj) {
        return ohr.b(obj, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override
    public nyp a(nyi nyiVar) {
        ohr.b(nyiVar);
        return a;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public Object c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override
    public Object d() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}