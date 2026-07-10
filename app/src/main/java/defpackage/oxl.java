package defpackage;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class oxl {
    public static float a(float... fArr) {
        ohr.a(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = Math.min(f, fArr[i]);
        }
        return f;
    }

    public static int a(int i) {
        if (i != 0) {
            if (i == 1) {
                return 2;
            }
            return i != 2 ? 0 : 3;
        }
        return 1;
    }

    public static int a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= highestOneBit || (highestOneBit = highestOneBit + highestOneBit) > 0) {
            return highestOneBit;
        }
        return 1073741824;
    }

    public static int a(int i, int i2, RoundingMode roundingMode) {
        ohr.b(roundingMode);
        if (i2 != 0) {
            int i3 = i / i2;
            int i4 = i - (i2 * i3);
            if (i4 == 0) {
                return i3;
            }
            boolean z = true;
            int i5 = 1;
            int i6 = ((i ^ i2) >> 31) | 1;
            switch (owx.a[roundingMode.ordinal()]) {
                case 1:
                    if (i4 != 0) {
                        z = false;
                    }
                    a(z);
                    return i3;
                case 2:
                    return i3;
                case 3:
                    break;
                case 4:
                    return i3 + i6;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i4);
                    int abs2 = abs - (Math.abs(i2) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode != RoundingMode.HALF_EVEN) {
                                i5 = 0;
                            }
                            break;
                        }
                        return i3 + i6;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("/ by zero");
        }
        return 0; //
    }

    public static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int a(int i, RoundingMode roundingMode) {
        if (i <= 0) {
            StringBuilder sb = new StringBuilder(String.valueOf("x").length() + 26);
            sb.append("x (");
            sb.append(i);
            sb.append(") must be > 0");
            throw new IllegalArgumentException(sb.toString());
        }
        switch (owx.a[roundingMode.ordinal()]) {
            case 1:
                boolean z = true;
                boolean z2 = i > 0;
                if (((i - 1) & i) != 0) {
                    z = false;
                }
                a(z & z2);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + ((((((-1257966797) >>> numberOfLeadingZeros) - i) ^ (-1)) ^ (-1)) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int a(long j) {
        if (j <= 2147483647L) {
            return j < -2147483648L ? Integer.MIN_VALUE: (int) j;
        }
        return Integer.MAX_VALUE;
    }

    public static int a(Object obj) {
        return b(obj != null ? obj.hashCode() : 0);
    }

    public static Object a(Object obj, String str, Object... objArr) {
        a(obj != null, str, objArr);
        return obj;
    }

    public static String a(byte b) {
        ohr.a(true, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", 10);
        return Integer.toString(b & 255, 10);
    }

    public static Collection a(Collection collection, nyi nyiVar) {
        return new obo(collection, nyiVar);
    }

    public static Collection a(Collection collection, nyu nyuVar) {
        if (collection instanceof obn) {
            obn obnVar = (obn) collection;
            return new obn(obnVar.a, new nyv(Arrays.asList((nyu) ohr.b(obnVar.b), (nyu) ohr.b(nyuVar))));
        }
        return new obn((Collection) ohr.b((Object) collection), (nyu) ohr.b(nyuVar));
    }

    public static nyn a(String str) {
        return new nyn(str);
    }

    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("null key in entry: null=");
            sb.append(valueOf);
            throw new NullPointerException(sb.toString());
        } else if (obj2 != null) {
        } else {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 26);
            sb2.append("null value in entry: ");
            sb2.append(valueOf2);
            sb2.append("=null");
            throw new NullPointerException(sb2.toString());
        }
    }

    static void a(boolean z) {
        if (z) {
            return;
        }
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    public static void a(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        throw new oac(ohr.a(str, obj, obj2));
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (z) {
            return;
        }
        throw new oac(ohr.a(str, objArr));
    }

    public static boolean a(double d) {
        return Math.getExponent(d) <= 1023;
    }

    public static boolean a(Collection collection, Object obj) {
        ohr.b((Object) collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    public static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static long[] a(Collection collection) {
        if (!(collection instanceof oxk)) {
            Object[] array = collection.toArray();
            int length = array.length;
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = ((Number) ohr.b(array[i])).longValue();
            }
            return jArr;
        }
        throw new NoSuchMethodError();
    }

    public static float b(float... fArr) {
        ohr.a(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = Math.max(f, fArr[i]);
        }
        return f;
    }

    public static int b(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static Object b(Object obj) {
        return a(obj, "expected a non-null reference", new Object[0]);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                throw new NullPointerException("Both parameters are null");
            }
            return obj2;
        }
        return obj;
    }

    public static void b(boolean z) {
        if (z) {
            return;
        }
        throw new oac();
    }

    public static List c(float... fArr) {
        return fArr.length == 0 ? Collections.emptyList() : new oxh(fArr);
    }

    public static nyn c(Object obj) {
        return new nyn(obj.getClass().getSimpleName());
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}