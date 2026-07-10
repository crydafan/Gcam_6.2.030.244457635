package defpackage;

public final class awn {
    private final cnu a;
    private final gjs b;
    private final qdx c;
    private ayf d = null;

    public awn(cnu cnuVar, gjs gjsVar, qdx qdxVar) {
        this.a = cnuVar;
        this.b = gjsVar;
        this.c = qdxVar;
    }

    public final aye a() {
        ayf ayfVar = this.d;
        if (ayfVar != null) {
            ayfVar.close();
            this.d = null;
        }
        this.b.f();
        this.a.a();
        this.a.a(false);
        this.d = (ayf) this.c.get();
        return this.d;
    }
}