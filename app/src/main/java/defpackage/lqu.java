package defpackage;

final class lqu implements lqs {
    @Override // defpackage.lqs
    public final void a(Iterable<lyu> iterable, String str) {
        for (defpackage.lyu lyu : iterable) {
            lyu.close();
        }
    }

    @Override // defpackage.lqs
    public final void a(lyu lyuVar) {
        lyuVar.close();
    }
}