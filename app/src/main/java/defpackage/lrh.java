package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

final class lrh implements lrm {
    public final List<lrm> a;

    lrh(Collection collection) {
        this.a = ods.a(collection);
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        if (this.a.isEmpty()) {
            executor.execute(new lri(lzbVar));
            return new lyr();
        }
        lrj lrjVar = new lrj(this, lzbVar, executor);
        lpu lpuVar = new lpu();
        lsh lshVar = new lsh();
        for (int i = 0; i < this.a.size(); i++) {
            lpuVar.a(((lrm) this.a.get(i)).a(new lrk(lrjVar, i), lshVar));
        }
        return lpuVar;
    }

    @Override // defpackage.lrm
    public final /* synthetic */ Object b_() {
        ArrayList arrayList = new ArrayList();
        for (lrm lrmVar : this.a) {
            arrayList.add(lrmVar.b_());
        }
        return arrayList;
    }
}