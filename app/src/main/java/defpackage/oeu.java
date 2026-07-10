package defpackage;

import java.util.Arrays;

public class oeu extends odn {
    private Object[] d;
    private int e;

    public oeu() {
        super(4);
    }

    oeu(int i) {
        super(i);
        this.d = new Object[oet.b(i)];
    }

    public oet a() {
        oet oetVar;
        int i = this.b;
        if (i != 0) {
            if (i == 1) {
                return oet.a(this.a[0]);
            }
            if (this.d == null || oet.b(i) != this.d.length) {
                oetVar = oet.a(this.b, this.a);
                this.b = oetVar.size();
            } else {
                Object[] copyOf = oet.a(this.b, this.a.length) ? Arrays.copyOf(this.a, this.b) : this.a;
                int i2 = this.e;
                Object[] objArr = this.d;
                oetVar = new ohl(copyOf, i2, objArr, objArr.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return oetVar;
        }
        return ohl.a;
    }

    public final oeu a(Object... objArr) {
        if (this.d != null) {
            for (Object obj : objArr) {
                b(obj);
            }
        } else {
            int length = objArr.length;
            ohr.a(objArr, length);
            super.a(this.b + length);
            System.arraycopy(objArr, 0, this.a, this.b, length);
            this.b += length;
        }
        return this;
    }

    public oeu b(Iterable iterable) {
        ohr.b((Object) iterable);
        if (this.d != null) {
            for (Object obj : iterable) {
                b(obj);
            }
        } else {
            super.a(iterable);
        }
        return this;
    }

    public oeu b(Object obj) {
        ohr.b(obj);
        if (this.d != null) {
            int b = oet.b(this.b);
            int length = this.d.length;
            if (b <= length) {
                int i = length - 1;
                int hashCode = obj.hashCode();
                int b2 = oxl.b(hashCode);
                while (true) {
                    int i2 = b2 & i;
                    Object[] objArr = this.d;
                    Object obj2 = objArr[i2];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        b2 = i2 + 1;
                    } else {
                        objArr[i2] = obj;
                        this.e += hashCode;
                        super.a(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.d = null;
        super.a(obj);
        return this;
    }
}