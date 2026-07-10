package defpackage;

import java.util.Collection;
import java.util.Iterator;

final class lrk implements lzb {
    public final /* synthetic */ lrj a;
    private final int b;

    lrk(lrj lrjVar, int i) {
        this.a = lrjVar;
        this.b = i;
    }

    @Override // defpackage.lzb
    public final void a(Object obj) {
        this.a.a.set(this.b, obj);
        lrj lrjVar = this.a;
        if (!lrjVar.b) {
            Iterator it = lrjVar.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.a.b = true;
                    break;
                } else if (it.next() == null) {
                    break;
                }
            }
        }
        lrj lrjVar2 = this.a;
        if (lrjVar2.b) {
            this.a.d.execute(new lrl(this, ods.a((Collection) lrjVar2.a)));
        }
    }
}