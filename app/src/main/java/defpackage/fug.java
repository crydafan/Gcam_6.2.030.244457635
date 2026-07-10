package defpackage;

public final class fug {
    private static final String b = pra.a("MaxNativeMemory");
    public final long a;

    public fug(cbc cbcVar) {
        long j;
        int a = lof.a(cbcVar.a, "camera:max_allowed_native_memory_mb", -1);
        if (a > 0) {
            pra.c(b, "Max native memory overridden (gservices): " + a);
            j = a;
        } else {
            pra.c(b, "Max native memory overridden (device): 420");
            j = 420;
        }
        this.a = j * 1000 * 1000;
    }
}