package defpackage;

import java.util.Arrays;

public final class mnh {
    public final int a;
    public final lyw b;

    public mnh(int i, lyw lywVar) {
        this.a = i;
        this.b = lywVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof mnh)) {
            return false;
        }
        mnh mnhVar = (mnh) obj;
        return mnhVar.a == this.a && mnhVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b});
    }

    public final String toString() {
        return oxl.a("ImageReaderFormat").a("ImageFormat", mql.a(this.a)).a("Size", this.b).toString();
    }
}