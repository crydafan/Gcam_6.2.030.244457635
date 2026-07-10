package defpackage;

import java.security.MessageDigest;
import java.util.Arrays;

final class oli extends okx {
    private final MessageDigest a;
    private final int b;
    private boolean c;

    oli(MessageDigest messageDigest, int i) {
        this.a = messageDigest;
        this.b = i;
    }

    private final void b() {
        ohr.b(!this.c, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override
    public final olb a() {
        b();
        this.c = true;
        return this.b == this.a.getDigestLength() ? olb.a(this.a.digest()) : olb.a(Arrays.copyOf(this.a.digest(), this.b));
    }

    @Override
    protected final void a(byte[] bArr, int i) {
        b();
        this.a.update(bArr, 0, i);
    }
}