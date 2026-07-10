package defpackage;

public enum hha {
    a("AUTO", 0, "auto", 2),
    b("OFF", 1, "off", 1),
    c("ON", 2, "on", 3);

    public final String d;
    public final int e;

    hha(String str, int i, String str2, int i2) {
        d = str2;
        e = i2;
    }

    public static hha a(String str, hha hhaVar) {
        ohr.b(str);
        if (a.d.equals(str))
            return a;
        if (b.d.equals(str))
            return b;
        if (c.d.equals(str))
            return c;
        return hhaVar;
    }
}
