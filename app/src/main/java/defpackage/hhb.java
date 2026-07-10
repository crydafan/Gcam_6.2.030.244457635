package defpackage;

public enum hhb {
    ON("on", 3),
    AUTO("auto", 2),
    OFF("off", 1);
    
    public final String d;
    public final int e;

    hhb(String str, int i) {
        this.d = str;
        this.e = i;
    }

    public static hhb a(String str, hhb hhbVar) {
        ohr.b(str);
        return AUTO.d.equals(str) ? AUTO : OFF.d.equals(str) ? OFF : ON.d.equals(str) ? ON : hhbVar;
    }
}