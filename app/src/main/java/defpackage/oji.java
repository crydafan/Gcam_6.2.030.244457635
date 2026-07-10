package defpackage;

import java.util.Iterator;

public abstract class oji implements Iterator {
    protected oji() {
    }

    @Override
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}