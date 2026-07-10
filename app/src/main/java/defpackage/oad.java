package defpackage;

import java.util.NoSuchElementException;

public abstract class oad extends oji {
    public int a = 2;
    private Object b;

    protected oad() {
    }

    protected abstract Object a();

    @Override
    public final boolean hasNext() {
        ohr.b(this.a != 4);
        int i = this.a;
        int i2 = i - 1;
        if (i != 0) {
            if (i2 == 0) {
                return true;
            }
            if (i2 != 2) {
                this.a = 4;
                this.b = a();
                if (this.a != 3) {
                    this.a = 1;
                    return true;
                }
            }
            return false;
        }
        throw null;
    }

    @Override
    public final Object next() {
        if (hasNext()) {
            this.a = 2;
            Object obj = this.b;
            this.b = null;
            return obj;
        }
        throw new NoSuchElementException();
    }
}