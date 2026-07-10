package defpackage;

import java.io.Serializable;

final class olk extends oky implements Serializable {
    public static final long serialVersionUID = 0;
    private final int a;

    static {
        new olk(0);
        new olk(olf.a);
    }

    olk(int i) {
        this.a = i;
    }

    @Override
    public final ole a() {
        return new oll(this.a);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof olk) && this.a == ((olk) obj).a;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ this.a;
    }

    public final String toString() {
        int i = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }
}