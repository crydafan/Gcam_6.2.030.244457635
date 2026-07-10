package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public abstract class ody implements Serializable, Map {
    private transient oet a;
    private transient oet b;
    private transient odm c;

    ody() {
    }

    public static ody a(Object obj, Object obj2) {
        oxl.a(obj, obj2);
        return ohg.a(1, new Object[]{obj, obj2});
    }

    public static ody a(Map map) {
        if ((map instanceof ody) && !(map instanceof SortedMap)) {
            ody odyVar = (ody) map;
            if (!odyVar.e()) {
                return odyVar;
            }
        }
        Set<Map.Entry> entrySet = map.entrySet();
        boolean z = entrySet instanceof Collection;
        oea oeaVar = new oea(z ? entrySet.size() : 4);
        if (z) {
            oeaVar.a(oeaVar.b + entrySet.size());
        }
        for (Map.Entry entry : entrySet) {
            oeaVar.a(entry.getKey(), entry.getValue());
        }
        return oeaVar.a();
    }

    public static oea a(int i) {
        oxl.a(i, "expectedSize");
        return new oea(i);
    }

    public static ody b(Object obj, Object obj2, Object obj3, Object obj4) {
        oxl.a(obj, obj2);
        oxl.a(obj3, obj4);
        return ohg.a(2, new Object[]{obj, obj2, obj3, obj4});
    }

    public static ody b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        oxl.a(obj, obj2);
        oxl.a(obj3, obj4);
        oxl.a(obj5, obj6);
        return ohg.a(3, new Object[]{obj, obj2, obj3, obj4, obj5, obj6});
    }

    public static ody b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        oxl.a(obj, obj2);
        oxl.a(obj3, obj4);
        oxl.a(obj5, obj6);
        oxl.a(obj7, obj8);
        return ohg.a(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static oea f() {
        return new oea();
    }

    abstract odm c();

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public odm values() {
        odm odmVar = this.c;
        if (odmVar == null) {
            odm c = c();
            this.c = c;
            return c;
        }
        return odmVar;
    }

    abstract boolean e();

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Map)) {
                return false;
            }
            return entrySet().equals(((Map) obj).entrySet());
        }
        return true;
    }

    public final oet entrySet() {
        oet oetVar = this.a;
        if (oetVar == null) {
            oet h = h();
            this.a = h;
            return h;
        }
        return oetVar;
    }

    public abstract Object get(Object obj);

    @Override
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    abstract oet h();

    @Override
    public final int hashCode() {
        return ohr.a((Set) entrySet());
    }

    public oet keySet() {
        oet oetVar = this.b;
        if (oetVar == null) {
            oet j = j();
            this.b = j;
            return j;
        }
        return oetVar;
    }

    @Override
    public final boolean isEmpty() {
        return size() == 0;
    }

    abstract oet j();

    @Override
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        oxl.a(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb.append('{');
        boolean z = true;
        /*for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }*/
        sb.append('}');
        return sb.toString();
    }

    oji v_() {
        return new odz(entrySet().iterator());
    }

    Object writeReplace() {
        return new oed(this);
    }
}