package defpackage;

import java.util.Map;

final class ohh extends oet {
    public final transient Object[] a;
    public final transient int b;
    public final transient int c;
    private final transient ody d;

    ohh(ody odyVar, Object[] objArr, int i, int i2) {
        this.d = odyVar;
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override
    final int a(Object[] objArr, int i) {
        return e().a(objArr, i);
    }

    @Override
    public final oji iterator() {
        return e().listIterator(0);
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override
    final ods i() {
        return new ohi(this);
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    final boolean x_() {
        return true;
    }
}