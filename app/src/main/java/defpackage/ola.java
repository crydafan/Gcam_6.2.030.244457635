package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class ola extends okz {
    private final ByteBuffer a;
    private final int b;

    protected ola() {
        this((byte) 0);
    }

    private ola(byte b) {
        ohr.a(true);
        this.a = ByteBuffer.allocate(23).order(ByteOrder.LITTLE_ENDIAN);
        this.b = 16;
    }

    private final void c() {
        if (this.a.remaining() < 8) {
            d();
        }
    }

    private final void d() {
        this.a.flip();
        while (this.a.remaining() >= this.b) {
            a(this.a);
        }
        this.a.compact();
    }

    @Override
    public final olb a() {
        d();
        this.a.flip();
        if (this.a.remaining() > 0) {
            b(this.a);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return b();
    }

    @Override
    public final ole a(char c) {
        this.a.putChar(c);
        c();
        return this;
    }

    @Override
    public final ole a(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    protected abstract void a(ByteBuffer byteBuffer);

    protected abstract olb b();

    protected void b(ByteBuffer byteBuffer) {
        throw null;
    }
}