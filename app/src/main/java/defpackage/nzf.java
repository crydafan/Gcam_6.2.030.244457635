package defpackage;

final class nzf extends nyp {
    public static final long serialVersionUID = 0;
    private final Object a;

    nzf(Object obj) {
        this.a = obj;
    }

    @Override
    public final Object a(Object obj) {
        ohr.b(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.a;
    }

    @Override
    public final nyp a(nyi nyiVar) {
        return new nzf(ohr.b(nyiVar.a(this.a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override
    public final boolean b() {
        return true;
    }

    @Override
    public final Object c() {
        return this.a;
    }

    @Override
    public final Object d() {
        return this.a;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof nzf) {
            return this.a.equals(((nzf) obj).a);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.a + ")";
    }
}