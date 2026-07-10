package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class oll extends ola {
    private long a;
    private long b;
    private int c = 0;

    oll(int i) {
        long j = i;
        this.a = j;
        this.b = j;
    }

    private static long a(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private static long b(long j) {
        return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
    }

    private static long c(long j) {
        return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
    }

    @Override
    protected final void a(ByteBuffer byteBuffer) {
        long j = byteBuffer.getLong();
        long j2 = byteBuffer.getLong();
        this.a = b(j) ^ this.a;
        this.a = Long.rotateLeft(this.a, 27);
        long j3 = this.a;
        long j4 = this.b;
        this.a = j3 + j4;
        this.a = (this.a * 5) + 1390208809;
        this.b = c(j2) ^ j4;
        this.b = Long.rotateLeft(this.b, 31);
        this.b += this.a;
        this.b = (this.b * 5) + 944331445;
        this.c += 16;
    }

    @Override
    public final olb b() {
        long j = this.a;
        long j2 = this.c;
        this.a = j ^ j2;
        this.b ^= j2;
        long j3 = this.a;
        long j4 = this.b;
        this.a = j3 + j4;
        long j5 = this.a;
        this.b = j4 + j5;
        this.a = a(j5);
        this.b = a(this.b);
        long j6 = this.a;
        long j7 = this.b;
        this.a = j6 + j7;
        this.b = j7 + this.a;
        return olb.a(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.a).putLong(this.b).array());
    }

    @Override
    protected final void b(ByteBuffer byteBuffer) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        this.c += byteBuffer.remaining();
        long j8 = 0;
        switch (byteBuffer.remaining()) {
            case 1:
                j2 = 0;
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 2:
                j3 = 0;
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 3:
                j4 = 0;
                j3 = j4 ^ ((byteBuffer.get(2) & 255) << 16);
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 4:
                j5 = 0;
                j4 = j5 ^ ((byteBuffer.get(3) & 255) << 24);
                j3 = j4 ^ ((byteBuffer.get(2) & 255) << 16);
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 5:
                j6 = 0;
                j5 = j6 ^ ((byteBuffer.get(4) & 255) << 32);
                j4 = j5 ^ ((byteBuffer.get(3) & 255) << 24);
                j3 = j4 ^ ((byteBuffer.get(2) & 255) << 16);
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 6:
                j7 = 0;
                j6 = ((byteBuffer.get(5) & 255) << 40) ^ j7;
                j5 = j6 ^ ((byteBuffer.get(4) & 255) << 32);
                j4 = j5 ^ ((byteBuffer.get(3) & 255) << 24);
                j3 = j4 ^ ((byteBuffer.get(2) & 255) << 16);
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 7:
                j7 = (byteBuffer.get(6) & 255) << 48;
                j6 = ((byteBuffer.get(5) & 255) << 40) ^ j7;
                j5 = j6 ^ ((byteBuffer.get(4) & 255) << 32);
                j4 = j5 ^ ((byteBuffer.get(3) & 255) << 24);
                j3 = j4 ^ ((byteBuffer.get(2) & 255) << 16);
                j2 = j3 ^ ((byteBuffer.get(1) & 255) << 8);
                j = j2 ^ (byteBuffer.get(0) & 255);
                break;
            case 8:
                j = byteBuffer.getLong();
                break;
            case 9:
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 10:
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 11:
                j8 ^= (byteBuffer.get(10) & 255) << 16;
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 12:
                j8 ^= (byteBuffer.get(11) & 255) << 24;
                j8 ^= (byteBuffer.get(10) & 255) << 16;
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 13:
                j8 ^= (byteBuffer.get(12) & 255) << 32;
                j8 ^= (byteBuffer.get(11) & 255) << 24;
                j8 ^= (byteBuffer.get(10) & 255) << 16;
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 14:
                j8 ^= (byteBuffer.get(13) & 255) << 40;
                j8 ^= (byteBuffer.get(12) & 255) << 32;
                j8 ^= (byteBuffer.get(11) & 255) << 24;
                j8 ^= (byteBuffer.get(10) & 255) << 16;
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            case 15:
                j8 = (byteBuffer.get(14) & 255) << 48;
                j8 ^= (byteBuffer.get(13) & 255) << 40;
                j8 ^= (byteBuffer.get(12) & 255) << 32;
                j8 ^= (byteBuffer.get(11) & 255) << 24;
                j8 ^= (byteBuffer.get(10) & 255) << 16;
                j8 ^= (byteBuffer.get(9) & 255) << 8;
                j8 ^= byteBuffer.get(8) & 255;
                j = byteBuffer.getLong();
                break;
            default:
                throw new AssertionError("Should never get here.");
        }
        this.a = b(j) ^ this.a;
        this.b ^= c(j8);
    }
}