package defpackage;

import java.util.Arrays;

public final class gtv {
    private final String a;

    gtv(String str) {
        ohr.b(str);
        this.a = str;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof gtv) && this.a.equals(((gtv) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.a });
    }

    public final String toString() {
        return oxl.c(this).a("name", this.a).toString();
    }
}