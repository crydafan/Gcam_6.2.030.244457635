package defpackage;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class olh extends oky implements Serializable {
    private final MessageDigest a;
    private final int b;
    private final boolean c;
    private final String d;

    olh(String str, int i, String str2) {
        this.d = (String) ohr.b(str2);
        this.a = a(str);
        int digestLength = this.a.getDigestLength();
        boolean z = false;
        if (i >= 4 && i <= digestLength) {
            z = true;
        }
        ohr.a(z, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.b = i;
        this.c = a(this.a);
    }

    olh(String str, String str2) {
        this.a = a(str);
        this.b = this.a.getDigestLength();
        this.d = (String) ohr.b(str2);
        this.c = a(this.a);
    }

    private static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean a(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException e) {
            return false;
        }
    }

    @Override
    public final ole a() {
        if (this.c) {
            try {
                return new oli((MessageDigest) this.a.clone(), this.b);
            } catch (CloneNotSupportedException e) {
            }
        }
        return new oli(a(this.a.getAlgorithm()), this.b);
    }

    public final String toString() {
        return this.d;
    }

    final Object writeReplace() {
        return new olj(this.a.getAlgorithm(), this.b, this.d);
    }
}