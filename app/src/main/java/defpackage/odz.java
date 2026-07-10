package defpackage;

import java.util.Map;

final class odz extends oji {
    private final oji a;

    odz(oji ojiVar) {
        this.a = ojiVar;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final Object next() {
        return ((Map.Entry) this.a.next()).getKey();
    }
}