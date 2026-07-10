package defpackage;

import java.util.AbstractMap;

final class ohi extends ods {
    private final ohh a;

    ohi(ohh ohhVar) {
        this.a = ohhVar;
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, this.a.c);
        ohh ohhVar = this.a;
        Object[] objArr = ohhVar.a;
        int i2 = i + i;
        int i3 = ohhVar.b;
        return new AbstractMap.SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
    }

    @Override
    public final int size() {
        return this.a.c;
    }

    @Override
    public final boolean x_() {
        return true;
    }
}