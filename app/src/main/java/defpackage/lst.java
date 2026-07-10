package defpackage;

final /* synthetic */ class lst implements nyi {
    private final lss a;

    lst(lss lssVar) {
        this.a = lssVar;
    }

    @Override // defpackage.nyi
    public final Object a(Object obj) {
        lss lssVar = this.a;
        ohr.b(obj);
        Object c = lssVar.c(obj);
        if (c != null) {
            return c;
        }
        String valueOf = String.valueOf(obj);
        String name = lssVar.getClass().getName();
        String sb = "Transforming input value: " + valueOf + " resulted in a null output value for: " + name;
        throw new NullPointerException(sb);
    }
}