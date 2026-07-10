package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class okx extends okz {
    private final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    okx() {
    }

    private final ole b(int i) {
        try {
            a(this.a.array(), i);
            return this;
        } finally {
            this.a.clear();
        }
    }

    @Override
    public final ole a(char c) {
        this.a.putChar(c);
        return b(2);
    }

    @Override
    public final ole a(int i) {
        this.a.putInt(i);
        return b(4);
    }

    protected void a(byte[] bArr, int i) {
        throw null;
    }
}