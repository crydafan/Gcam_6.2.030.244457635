package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

public abstract class oet extends odm implements Set {
    private transient ods a;

    oet() {
    }

    static oet a(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return a(objArr[0]);
            }
            int b = b(i);
            Object[] objArr2 = new Object[b];
            int i2 = b - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object a = ohr.a(objArr[i5], i5);
                int hashCode = a.hashCode();
                int b2 = oxl.b(hashCode);
                while (true) {
                    int i6 = b2 & i2;
                    Object obj = objArr2[i6];
                    if (obj == null) {
                        objArr[i4] = a;
                        objArr2[i6] = a;
                        i3 += hashCode;
                        i4++;
                        break;
                    } else if (!obj.equals(a)) {
                        b2++;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new ohx(objArr[0], i3);
            }
            if (b(i4) >= b / 2) {
                return new ohl(a(i4, objArr.length) ? Arrays.copyOf(objArr, i4) : objArr, i3, objArr2, i2, i4);
            }
            i = i4;
        }
        return ohl.a;
    }

    public static oet a(Object obj) {
        return new ohx(obj);
    }

    public static oet a(Object obj, Object obj2) {
        return a(2, obj, obj2);
    }

    public static oet a(Object obj, Object obj2, Object obj3) {
        return a(3, obj, obj2, obj3);
    }

    public static oet a(Object obj, Object obj2, Object obj3, Object obj4) {
        return a(4, obj, obj2, obj3, obj4);
    }

    public static oet a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return null; //a(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static oet a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        ohr.a(length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[length + 6];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return a(objArr2.length, objArr2);
    }

    public static oet a(Collection<?> collection) {
        if ((collection instanceof oet) && !(collection instanceof SortedSet)) {
            oet oetVar = (oet) collection;
            if (!oetVar.x_()) {
                return oetVar;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static oet a(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? a(length, (Object[]) objArr.clone()) : a(objArr[0]) : ohl.a;
    }

    static boolean a(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    static int b(int i) {
        double d;
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            ohr.a(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
            d = highestOneBit;
            Double.isNaN(d);
        } while (d * 0.7d < max);
        return highestOneBit;
    }

    public static oeu c(int i) {
        oxl.a(i, "expectedSize");
        return new oeu(i);
    }

    public static oeu j() {
        return new oeu();
    }

    @Override
    public abstract oji iterator();

    @Override
    public ods e() {
        ods odsVar = this.a;
        if (odsVar == null) {
            ods i = i();
            this.a = i;
            return i;
        }
        return odsVar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != this) {
            if ((obj instanceof oet) && h() && ((oet) obj).h() && hashCode() != obj.hashCode()) {
                return false;
            }
            return ohr.a((Set) this, obj);
        }
        return true;
    }

    boolean h() {
        return false;
    }

    @Override
    public int hashCode() {
        return ohr.a((Set) this);
    }

    ods i() {
        return ods.b(toArray());
    }

    @Override
    Object writeReplace() {
        return new oev(toArray());
    }
}