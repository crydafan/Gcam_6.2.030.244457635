package defpackage;

public abstract class olb {
    private static final char[] a = "0123456789abcdef".toCharArray();

    olb() {
    }

    static olb a(byte[] bArr) {
        return new olc(bArr);
    }

    public abstract int a();

    abstract boolean a(olb olbVar);

    public abstract int b();

    public abstract long c();

    byte[] d() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof olb) {
            olb olbVar = (olb) obj;
            if (a() == olbVar.a() && a(olbVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (a() >= 32) {
            return b();
        }
        byte[] d = d();
        int i = d[0] & 255;
        for (int i2 = 1; i2 < d.length; i2++) {
            i |= (d[i2] & 255) << (i2 << 3);
        }
        return i;
    }

    public final String toString() {
        byte[] d = d();
        int length = d.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : d) {
            sb.append(a[(b >> 4) & 15]);
            sb.append(a[b & 15]);
        }
        return sb.toString();
    }
}