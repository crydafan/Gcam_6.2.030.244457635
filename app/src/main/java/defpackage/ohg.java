package defpackage;

import java.util.Arrays;

public final class ohg extends ody {
    public static final ody a = new ohg(null, new Object[0], 0);
    public static final long serialVersionUID = 0;
    private final transient int[] b;
    private final transient Object[] c;
    private final transient int d;

    private ohg(int[] iArr, Object[] objArr, int i) {
        this.b = iArr;
        this.c = objArr;
        this.d = i;
    }

    static Object a(int[] iArr, Object[] objArr, int i, int i2, Object obj) {
        if (obj != null) {
            if (i == 1) {
                if (!objArr[i2].equals(obj)) {
                    return null;
                }
                return objArr[i2 ^ 1];
            } else if (iArr != null) {
                int length = iArr.length - 1;
                int b = oxl.b(obj.hashCode());
                while (true) {
                    int i3 = b & length;
                    int i4 = iArr[i3];
                    if (i4 == -1) {
                        break;
                    } else if (objArr[i4].equals(obj)) {
                        return objArr[i4 ^ 1];
                    } else {
                        b = i3 + 1;
                    }
                }
            }
        }
        return null;
    }

    public static ohg a(int i, Object[] objArr) {
        if (i == 0) {
            return (ohg) a;
        }
        if (i == 1) {
            oxl.a(objArr[0], objArr[1]);
            return new ohg(null, objArr, 1);
        }
        ohr.b(i, objArr.length >> 1);
        return new ohg(a(objArr, i, oet.b(i), 0), objArr, i);
    }

    static int[] a(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            oxl.a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i5 = 0;
        while (i5 < i) {
            int i6 = i5 + i5;
            int i7 = i6 + i3;
            Object obj = objArr[i7];
            Object obj2 = objArr[i6 + (i3 ^ 1)];
            oxl.a(obj, obj2);
            int b = oxl.b(obj.hashCode());
            while (true) {
                int i8 = b & i4;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    break;
                } else if (objArr[i9].equals(obj)) {
                    String valueOf = String.valueOf(obj);
                    String valueOf2 = String.valueOf(obj2);
                    String valueOf3 = String.valueOf(objArr[i9]);
                    String valueOf4 = String.valueOf(objArr[1 ^ i9]);
                    int length = String.valueOf(valueOf).length();
                    StringBuilder sb = new StringBuilder(length + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
                    sb.append("Multiple entries with same key: ");
                    sb.append(valueOf);
                    sb.append("=");
                    sb.append(valueOf2);
                    sb.append(" and ");
                    sb.append(valueOf3);
                    sb.append("=");
                    sb.append(valueOf4);
                    throw new IllegalArgumentException(sb.toString());
                } else {
                    b = i8 + 1;
                }
            }
        }
        return iArr;
    }

    @Override
    final odm c() {
        return new ohk(this.c, 1, this.d);
    }

    @Override
    final boolean e() {
        return false;
    }

    @Override
    public final Object get(Object obj) {
        return a(this.b, this.c, this.d, 0, obj);
    }

    @Override
    final oet h() {
        return new ohh(this, this.c, 0, this.d);
    }

    @Override
    final oet j() {
        return new ohj(this, new ohk(this.c, 0, this.d));
    }

    @Override
    public final int size() {
        return this.d;
    }
}