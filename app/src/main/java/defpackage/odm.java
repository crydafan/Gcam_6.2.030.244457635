package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class odm extends AbstractCollection implements Serializable {
    private static final Object[] a = new Object[0];

    odm() {
    }

    int a(Object[] objArr, int i) {
        oji it = (oji) iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public abstract Iterator iterator();

    @Override
    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    Object[] b() {
        return null;
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean contains(Object obj);

    public ods e() {
        throw null;
    }

    @Override
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object[] toArray() {
        return toArray(a);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        ohr.b(objArr);
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] b = b();
            if (b != null) {
                return Arrays.copyOfRange(b, c(), w_(), objArr.getClass());
            }
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        } else if (length > size) {
            objArr[size] = null;
        }
        a(objArr, 0);
        return objArr;
    }

    int w_() {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new odw(toArray());
    }

    abstract boolean x_();
}