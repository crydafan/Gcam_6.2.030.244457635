package defpackage;

public final class pam extends RuntimeException {
    public static final long serialVersionUID = 0;

    protected pam() {
    }

    public pam(Throwable th) {
        super(th);
    }
}