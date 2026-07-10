package defpackage;

import java.util.NoSuchElementException;

final class ofr extends oji {
    private boolean a;
    private final Object b;

    ofr(Object obj) {
        this.b = obj;
    }

    @Override
    public final boolean hasNext() {
        return !this.a;
    }

    @Override
    public final Object next() {
        if (!this.a) {
            this.a = true;
            return this.b;
        }
        throw new NoSuchElementException();
    }
}