package defpackage;

import java.util.Arrays;
import java.util.Collection;

class odn extends odo {
    public Object[] a;
    public int b = 0;
    public boolean c;

    odn(int i) {
        oxl.a(i, "initialCapacity");
        this.a = new Object[i];
    }

    public final odn a(Object obj) {
        ohr.b(obj);
        a(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
        return this;
    }

    @Override
    public final odo a(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            a(this.b + collection.size());
            if (collection instanceof odm) {
                this.b = ((odm) collection).a(this.a, this.b);
                return this;
            }
        }
        super.a(iterable);
        return this;
    }

    final void a(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        if (length < i) {
            this.a = Arrays.copyOf(objArr, a(length, i));
            this.c = false;
        } else if (!this.c) {
        } else {
            this.a = (Object[]) objArr.clone();
            this.c = false;
        }
    }

    @Override
    public odo b(Object obj) {
        throw null;
    }
}