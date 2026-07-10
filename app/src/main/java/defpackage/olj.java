package defpackage;

import java.io.Serializable;

final class olj implements Serializable {
    public static final long serialVersionUID = 0;
    private final String a;
    private final int b;
    private final String c;

    olj(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    private final Object readResolve() {
        return new olh(this.a, this.b, this.c);
    }
}