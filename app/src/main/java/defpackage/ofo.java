package defpackage;

import java.util.Iterator;

final class ofo extends oad {
    private final Iterator b;
    private final nyu c;

    ofo(Iterator it, nyu nyuVar) {
        this.b = it;
        this.c = nyuVar;
    }

    @Override
    protected final Object a() {
        while (this.b.hasNext()) {
            Object next = this.b.next();
            if (this.c.a(next)) {
                return next;
            }
        }
        this.a = 3;
        return null;
    }
}