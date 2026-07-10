package defpackage;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class ojj extends oji implements ListIterator {
    private final int a;
    private int b;

    protected ojj(int i, int i2) {
        ohr.b(i2, i);
        this.a = i;
        this.b = i2;
    }

    protected abstract Object a(int i);

    @Override
    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override
    public final Object next() {
        if (hasNext()) {
            int i = this.b;
            this.b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return this.b;
    }

    @Override
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.b - 1;
            this.b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override
    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}