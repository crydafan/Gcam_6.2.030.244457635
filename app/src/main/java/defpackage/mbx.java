package defpackage;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public final class mbx {
    private static final Charset h = Charset.forName("US-ASCII");
    private static final int[] i;
    public final short a;
    public final short b;
    public boolean c;
    public int d;
    public int e;
    public Object f = null;
    public int g;

    static {
        int[] iArr = new int[11];
        i = iArr;
        iArr[1] = 1;
        int[] iArr2 = i;
        iArr2[2] = 1;
        iArr2[3] = 2;
        iArr2[4] = 4;
        iArr2[5] = 8;
        iArr2[7] = 1;
        iArr2[9] = 4;
        iArr2[10] = 8;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    }

    public mbx(short s, short s2, int i2, int i3, boolean z) {
        this.a = s;
        this.b = s2;
        this.d = i2;
        this.c = z;
        this.e = i3;
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    public static boolean a(short s) {
        return s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 7 || s == 9 || s == 10;
    }

    static String b(short s) {
        switch (s) {
            case 1:
                return "UNSIGNED_BYTE";
            case 2:
                return "ASCII";
            case 3:
                return "UNSIGNED_SHORT";
            case 4:
                return "UNSIGNED_LONG";
            case 5:
                return "UNSIGNED_RATIONAL";
            case 6:
            case 8:
            default:
                return "";
            case 7:
                return "UNDEFINED";
            case 9:
                return "LONG";
            case 10:
                return "RATIONAL";
        }
    }

    private final boolean d(int i2) {
        return this.c && this.d != i2;
    }

    public final int a() {
        return this.d * i[this.b];
    }

    public final boolean a(String str) {
        short s = this.b;
        if (s == 2 || s == 7) {
            byte[] bytes = str.getBytes(h);
            int length = bytes.length;
            if (length > 0) {
                if (bytes[length - 1] != 0 && this.b != 7) {
                    bytes = Arrays.copyOf(bytes, length + 1);
                }
            } else if (this.b == 2 && this.d == 1) {
                bytes = new byte[]{0};
            }
            int length2 = bytes.length;
            if (d(length2)) {
                return false;
            }
            this.d = length2;
            this.f = bytes;
            return true;
        }
        return false;
    }

    public final boolean a(byte[] bArr) {
        int length = bArr.length;
        if (!d(length)) {
            short s = this.b;
            if (s != 1 && s != 7) {
                return false;
            }
            this.f = new byte[length];
            System.arraycopy(bArr, 0, this.f, 0, length);
            this.d = length;
            return true;
        }
        return false;
    }

    public final boolean a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        if (!d(length)) {
            short s = this.b;
            if (s != 3 && s != 9 && s != 4) {
                return false;
            }
            if (s == 3) {
                for (int i3 : iArr) {
                    if (i3 > 65535 || i3 < 0) {
                        return false;
                    }
                }
            }
            if (this.b == 4) {
                for (int i4 : iArr) {
                    if (i4 < 0) {
                        return false;
                    }
                }
            }
            long[] jArr = new long[length];
            while (true) {
                int length2 = iArr.length;
                if (i2 >= length2) {
                    this.f = jArr;
                    this.d = length2;
                    return true;
                }
                jArr[i2] = iArr[i2];
                i2++;
            }
        } else {
            return false;
        }
    }

    public final boolean a(long[] jArr) {
        int length = jArr.length;
        if (d(length) || this.b != 4) {
            return false;
        }
        for (long j : jArr) {
            if (j < 0 || j > 4294967295L) {
                return false;
            }
        }
        this.f = jArr;
        this.d = length;
        return true;
    }

    /*
    public final boolean a(lyt[] lytVarArr) {
        int length = lytVarArr.length;
        if (!d(length)) {
            short s = this.b;
            if (s != 5 && s != 10) {
                return false;
            }
            if (s == 5) {
                for (lyt lytVar : lytVarArr) {
                    long j = lytVar.a;
                    if (j >= 0) {
                        long j2 = lytVar.b;
                        if (j2 >= 0 && j <= 4294967295L && j2 <= 4294967295L) {
                        }
                    }
                    return false;
                }
            }
            if (this.b == 10) {
                for (lyt lytVar2 : lytVarArr) {
                    long j3 = lytVar2.a;
                    if (j3 >= -2147483648L) {
                        long j4 = lytVar2.b;
                        if (j4 >= -2147483648L && j3 <= 2147483647L && j4 <= 2147483647L) {
                        }
                    }
                    return false;
                }
            }
            this.f = lytVarArr;
            this.d = length;
            return true;
        }
        return false;
    }
    */

    public final boolean b() {
        return this.f != null;
    }

    public final boolean b(int i2) {
        return a(new int[]{i2});
    }

    public final long c(int i2) {
        Object obj = this.f;
        if (obj instanceof long[]) {
            return ((long[]) obj)[i2];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i2];
        }
        String valueOf = String.valueOf(b(this.b));
        throw new IllegalArgumentException(valueOf.length() == 0 ? new String("Cannot get integer value from ") : "Cannot get integer value from ".concat(valueOf));
    }

    public final String c() {
        Object obj = this.f;
        if (obj != null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (!(obj instanceof byte[])) {
                return null;
            }
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            if (bArr[length] == 0) {
                bArr = Arrays.copyOf(bArr, length);
            }
            return new String(bArr, h);
        }
        return null;
    }

    public final byte[] d() {
        Object obj = this.f;
        if (!(obj instanceof byte[])) {
            return null;
        }
        return (byte[]) obj;
    }

    /*public final lyt[] e() {
        Object obj = this.f;
        if (!(obj instanceof lyt[])) {
            return null;
        }
        return (lyt[]) obj;
    }*/

    public final boolean equals(Object obj) {
        /*if (obj != null && (obj instanceof mbx)) {
            mbx mbxVar = (mbx) obj;
            if (mbxVar.a == this.a && mbxVar.d == this.d && mbxVar.b == this.b) {
                Object obj2 = this.f;
                if (obj2 != null) {
                    Object obj3 = mbxVar.f;
                    if (obj3 == null) {
                        return false;
                    }
                    if (obj2 instanceof long[]) {
                        if (!(obj3 instanceof long[])) {
                            return false;
                        }
                        return Arrays.equals((long[]) obj2, (long[]) obj3);
                    } else if (obj2 instanceof lyt[]) {
                        if (!(obj3 instanceof lyt[])) {
                            return false;
                        }
                        return Arrays.equals((lyt[]) obj2, (lyt[]) obj3);
                    } else if (!(obj2 instanceof byte[])) {
                        return obj2.equals(obj3);
                    } else {
                        if (!(obj3 instanceof byte[])) {
                            return false;
                        }
                        return Arrays.equals((byte[]) obj2, (byte[]) obj3);
                    }
                } else if (mbxVar.f == null) {
                    return true;
                }
            }
        }*/
        return false;
    }

    /*
    public final lyt f() {
        lyt lytVar = new lyt(0L, 1L);
        lyt[] e = e();
        return (e == null || e.length <= 0) ? lytVar : e[0];
    }
    */

    public final int[] g() {
        Object obj = this.f;
        int[] iArr = null;
        if (obj != null && (obj instanceof long[])) {
            long[] jArr = (long[]) obj;
            iArr = new int[jArr.length];
            for (int i2 = 0; i2 < jArr.length; i2++) {
                iArr[i2] = (int) jArr[i2];
            }
        }
        return iArr;
    }

    public final long[] h() {
        Object obj = this.f;
        if (!(obj instanceof long[])) {
            return null;
        }
        return (long[]) obj;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Short.valueOf(this.a), Short.valueOf(this.b), Boolean.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), this.f, Integer.valueOf(this.g)});
    }

    public final long i() {
        long[] h2 = h();
        if (h2 == null || h2.length <= 0) {
            return 0L;
        }
        return h2[0];
    }

    public final String toString() {
        String format = String.format("tag id: %04X\n", Short.valueOf(this.a));
        int i2 = this.e;
        String b = b(this.b);
        int i3 = this.d;
        int i4 = this.g;
        Object obj = this.f;
        String str = "";
        if (obj != null) {
            if (obj instanceof byte[]) {
                str = this.b == 2 ? new String((byte[]) obj, h) : Arrays.toString((byte[]) obj);
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                str = jArr.length == 1 ? String.valueOf(jArr[0]) : Arrays.toString(jArr);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        str = obj2.toString();
                    }
                } else {
                    str = Arrays.toString(objArr);
                }
            } else {
                str = obj.toString();
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 74 + String.valueOf(b).length() + String.valueOf(str).length());
        sb.append(format);
        sb.append("ifd id: ");
        sb.append(i2);
        sb.append("\ntype: ");
        sb.append(b);
        sb.append("\ncount: ");
        sb.append(i3);
        sb.append("\noffset: ");
        sb.append(i4);
        sb.append("\nvalue: ");
        sb.append(str);
        sb.append("\n");
        return sb.toString();
    }
}