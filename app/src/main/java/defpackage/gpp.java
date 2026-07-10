package defpackage;

public final class gpp {
    private static gpp a = null;
    private static final Object b = new Object();
    private final mpn c;

    static {
        pra.a("OneCamDbgHpr");
    }

    private gpp(mpn mpnVar) {
        this.c = mpnVar;
    }

    @Deprecated
    public static gpp a() {
        synchronized (b) {
            if (a == null) {
                a = new gpp(mpo.a);
            }
        }
        return a;
    }

    public static boolean b() {
        return false;
    }

    public static boolean c() {
        return false;
    }

    public final int a(String str) {
        ohr.b(str);
        String a2 = this.c.a(str);
        if (a2 != null && !a2.isEmpty()) {
            try {
                return Integer.parseInt(a2);
            } catch (NumberFormatException e) {
            }
        }
        return 6;
    }

    public final boolean a(String str, String str2) {
        ohr.b(str);
        String a2 = this.c.a(str);
        if (a2 == null || a2.isEmpty() || str2.isEmpty()) {
            return false;
        }
        return str2.equals(a2);
    }

    public final boolean a(String str, boolean z) {
        ohr.b(str);
        String a2 = this.c.a(str);
        if (a2 == null || a2.isEmpty()) {
            return z;
        }
        if ("0".equals(a2)) {
            return false;
        }
        if (!"1".equals(a2)) {
            return z;
        }
        return true;
    }
}