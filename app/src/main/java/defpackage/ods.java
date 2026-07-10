package defpackage;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class ods extends odm implements List, RandomAccess {
    private static final ojj a = new odu(ohf.a, 0);

    ods() {
    }

    public static ods a(Iterable iterable) {
        ohr.b((Object) iterable);
        if (iterable instanceof Collection) {
            return a((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return ohf.a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a(next);
        }
        odt c = new odt().c(next);
        while (it.hasNext()) {
            c.b(it.next());
        }
        return c.a();
    }

    public static ods a(Object obj) {
        Object[] a2 = ohr.a(new Object[]{obj}, 1);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2}, 2);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3}, 3);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3, obj4}, 4);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3, obj4, obj5}, 5);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3, obj4, obj5, obj6}, 6);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9}, 9);
        return b(a2, a2.length);
    }

    public static ods a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Object[] a2 = ohr.a(new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10}, 10);
        return b(a2, a2.length);
    }

    @SafeVarargs
    public static ods a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        ohr.a(length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        Object[] a2 = ohr.a(objArr2, objArr2.length);
        return b(a2, a2.length);
    }

    public static ods a(Collection collection) {
        if (!(collection instanceof odm)) {
            Object[] array = collection.toArray();
            Object[] a2 = ohr.a(array, array.length);
            return b(a2, a2.length);
        }
        ods e = ((odm) collection).e();
        if (!e.x_()) {
            return e;
        }
        Object[] array2 = e.toArray();
        return b(array2, array2.length);
    }

    public static ods a(Object[] objArr) {
        if (objArr.length != 0) {
            Object[] objArr2 = (Object[]) objArr.clone();
            Object[] a2 = ohr.a(objArr2, objArr2.length);
            return b(a2, a2.length);
        }
        return ohf.a;
    }

    static ods b(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static ods b(Object[] objArr, int i) {
        return i != 0 ? new ohf(objArr, i) : ohf.a;
    }

    public static odt b(int i) {
        oxl.a(i, "expectedSize");
        return new odt(i);
    }

    public static ods g() {
        return ohf.a;
    }

    public static odt i() {
        return new odt();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            throw new InvalidObjectException("Use SerializedForm");
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    @Override
    int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ods subList(int i, int i2) {
        ohr.a(i, i2, size());
        int i3 = i2 - i;
        return i3 != size() ? i3 != 0 ? new odx(this, i, i3) : ohf.a : this;
    }

    //public final oji a() {
    //    return listIterator(0);
    //}

    public final ojj listIterator(int i) {
        ohr.b(i, size());
        return isEmpty() ? a : new odu(this, i);
    }

    @Override
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public final ods e() {
        return this;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj != ohr.b((Object) this)) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                        for (int i = 0; i < size; i++) {
                            if (!oxl.c(get(i), list.get(i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    Iterator it = list.iterator();
                    for (Object obj2 : this) {
                        if (!it.hasNext() || !oxl.c(obj2, it.next())) {
                            return false;
                        }
                    }
                    return !it.hasNext();
                }
            }
            return false;
        }
        return true;
    }

    public ods h() {
        return size() > 1 ? new odv(this) : this;
    }

    @Override
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ (-1)) ^ (-1);
        }
        return i;
    }

    @Override
    public int indexOf(Object obj) {
        if (obj != null) {
            if (!(this instanceof RandomAccess)) {
                ListIterator listIterator = listIterator();
                while (listIterator.hasNext()) {
                    if (oxl.c(obj, listIterator.next())) {
                        return listIterator.previousIndex();
                    }
                }
                return -1;
            }
            int size = size();
            int i = 0;
            if (obj != null) {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            while (i < size) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override
    public int lastIndexOf(Object obj) {
        if (obj != null) {
            if (!(this instanceof RandomAccess)) {
                ListIterator listIterator = listIterator(size());
                while (listIterator.hasPrevious()) {
                    if (oxl.c(obj, listIterator.previous())) {
                        return listIterator.nextIndex();
                    }
                }
                return -1;
            } else if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
                return -1;
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    Object writeReplace() {
        return new odw(toArray());
    }
}