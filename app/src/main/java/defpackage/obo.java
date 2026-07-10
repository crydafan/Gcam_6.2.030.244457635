package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public final class obo extends AbstractCollection {
    private final Collection a;
    private final nyi b;

    public obo(Collection collection, nyi nyiVar) {
        this.a = (Collection) ohr.b((Object) collection);
        this.b = (nyi) ohr.b(nyiVar);
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return ohr.b(this.a.iterator(), this.b);
    }

    @Override
    public final int size() {
        return this.a.size();
    }
}