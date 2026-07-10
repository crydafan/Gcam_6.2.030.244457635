package defpackage;

import java.util.Arrays;

public final class nyn {
    private final String a;
    private final nyo b = new nyo();
    private nyo c = this.b;

    public nyn(String str) {
        this.a = (String) ohr.b(str);
    }

    public final nyn a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    public final nyn a(String str, long j) {
        return a(str, String.valueOf(j));
    }

    public final nyn a(String str, Object obj) {
        nyo a = a();
        a.b = obj;
        a.a = (String) ohr.b(str);
        return this;
    }

    public final nyo a() {
        nyo nyoVar = new nyo();
        this.c.c = nyoVar;
        this.c = nyoVar;
        return nyoVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        nyo nyoVar = this.b.c;
        String str = "";
        while (nyoVar != null) {
            Object obj = nyoVar.b;
            sb.append(str);
            String str2 = nyoVar.a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            nyoVar = nyoVar.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}