package defpackage;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;

public final class nys {
    private static final nyr a = new nyt();

    static {
        Logger.getLogger(nys.class.getName());
    }

    private nys() {
    }

    static long a() {
        return System.nanoTime();
    }

    static String a(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    static nyp a(Class cls, String str) {
        WeakReference weakReference = (WeakReference) nyh.a(cls).get(str);
        return weakReference != null ? nyp.b((Enum) cls.cast(weakReference.get())) : nxs.a;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static nyg c(String str) {
        ohr.b(str);
        return a.a(str);
    }
}