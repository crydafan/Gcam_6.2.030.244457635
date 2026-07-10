package defpackage;

import java.util.Arrays;

public class oea {
    public Object[] a;
    public int b;

    public oea() {
        this(4);
    }

    oea(int i) {
        this.a = new Object[i + i];
        this.b = 0;
    }

    public ody a() {
        return ohg.a(this.b, this.a);
    }

    public oea a(Object obj, Object obj2) {
        a(this.b + 1);
        oxl.a(obj, obj2);
        Object[] objArr = this.a;
        int i = this.b;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.b = i + 1;
        return this;
    }

    final void a(int i) {
        int i2 = i + i;
        Object[] objArr = this.a;
        int length = objArr.length;
        if (i2 > length) {
            this.a = Arrays.copyOf(objArr, odo.a(length, i2));
        }
    }
}