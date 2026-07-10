package defpackage;

final class lrx extends lsp {
    private final /* synthetic */ nyi b;
    private final /* synthetic */ lrm c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    lrx(lrm lrmVar, nyi nyiVar, lrm lrmVar2) {
        super(lrmVar);
        this.b = nyiVar;
        this.c = lrmVar2;
    }

    @Override // defpackage.lsp
    public final Object a(Object obj) {
        return this.b.a(obj);
    }

    public final String toString() {
        return oxl.a("TransformedObs").a("input", this.c).a("func", this.b).toString();
    }
}