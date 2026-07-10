package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class obn extends AbstractCollection {
    public final Collection a;
    public final nyu b;

    public obn(Collection collection, nyu nyuVar) {
        this.a = collection;
        this.b = nyuVar;
    }

    @Override
    public final boolean add(Object obj) {
        ohr.a(this.b.a(obj));
        return this.a.add(obj);
    }

    @Override
    public final boolean addAll(Collection collection) {
        for (Object obj : collection) {
            ohr.a(this.b.a(obj));
        }
        return this.a.addAll(collection);
    }

    @Override
    public final void clear() {
        Collection collection = this.a;
        nyu nyuVar = this.b;
        if ((collection instanceof RandomAccess) && (collection instanceof List)) {
            ohr.a((List) collection, (nyu) ohr.b(nyuVar));
            return;
        }
        Iterator it = collection.iterator();
        ohr.b(nyuVar);
        while (it.hasNext()) {
            if (nyuVar.a(it.next())) {
                it.remove();
            }
        }
    }

    @Override
    public final boolean contains(Object obj) {
        if (oxl.a(this.a, obj)) {
            return this.b.a(obj);
        }
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return !ohr.a((Iterable) this.a, this.b);
    }

    @Override
    public final Iterator iterator() {
        return ohr.a(this.a.iterator(), this.b);
    }

    @Override
    public final boolean remove(Object obj) {
        return contains(obj) && this.a.remove(obj);
    }

    @Override
    public final boolean removeAll(Collection collection) {
        Iterator it = this.a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.b.a(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        Iterator it = this.a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.b.a(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override
    public final int size() {
        int i = 0;
        for (Object obj : this.a) {
            if (this.b.a(obj)) {
                i++;
            }
        }
        return i;
    }

    @Override
    public final Object[] toArray() {
        return ohr.b(iterator()).toArray();
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        return ohr.b(iterator()).toArray(objArr);
    }
}