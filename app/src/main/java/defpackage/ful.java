package defpackage;

import java.util.Collection;

final class ful implements lyu {
    public final fue a;
    public final lqy b;
    private final Collection<lyu> c;

    ful(fue fueVar, lqy lqyVar, Collection<lyu> collection) {
        this.a = fueVar;
        this.b = lqyVar;
        this.c = collection;
    }

    @Override // defpackage.lyu, java.lang.AutoCloseable
    public final void close() {
        for (lyu lyuVar : this.c) {
            lyuVar.close();
        }
    }
}