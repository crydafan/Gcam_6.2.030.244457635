package defpackage;

import android.graphics.PointF;
import java.util.Set;

public final class bbp implements kng, lyu {
    public final axf a;
    public final mmt b;
    public azp c;
    private final awn g;
    private final awz h;
    private final Set<knf> i;
    private final ayr j;
    private boolean k = false;
    public khq d = null;
    public khq e = null;
    public lyu f = null;
    private final lpn l = new bby(this);

    public bbp(lpu lpuVar, awz awzVar, axf axfVar, mmt mmtVar, awn awnVar, Set<knf> set, ayr ayrVar) {
        this.a = axfVar;
        this.b = mmtVar;
        this.g = awnVar;
        this.h = awzVar;
        this.i = set;
        this.j = ayrVar;
        lpuVar.a(this);
    }

    @Override
    public final void a() {
        azp azpVar = this.c;
        if (azpVar != null) {
            azpVar.d();
        }
    }

    @Override
    public final boolean a(PointF pointF) {
        return true;
    }

    final void b() {
        khq khqVar = this.e;
        if (khqVar != null) {
            khqVar.a().a(new bbw(this), oyx.INSTANCE);
        } else {
            c();
        }
    }

    @Override
    public final synchronized boolean b(PointF pointF) {
        if (!this.k) {
            azp azpVar = this.c;
            if (azpVar != null && !azpVar.a().isDone() && this.a.d(pointF)) {
                this.c.d();
                return true;
            }
            ayr ayrVar = this.j;
            if (ayrVar != null) {
                ayrVar.b();
            }
            khq khqVar = this.d;
            if (khqVar != null) {
                khqVar.b();
            }
            khq khqVar2 = this.e;
            if (khqVar2 != null) {
                khqVar2.b();
            }
            lyu lyuVar = this.f;
            if (lyuVar != null) {
                lyuVar.close();
            }
            for (knf knfVar : this.i) {
                knfVar.a(pointF);
            }
            this.g.a();
            this.d = this.a.b(pointF);
            this.d.a(new bbq(this));
            aye a = this.g.a();
            this.c = this.h.a(this.b, pointF, a);
            khq khqVar3 = this.d;
            lpg.a(khqVar3 == null ? qdr.b(true) : khqVar3.a(), this.c.a(), this.l, lpz.a());
            lpg.a(this.c.e(), new bbr(this), lpz.a());
            ozs a2 = a.a();
            lpg.a(a2, new bbs(this), lpz.a());
            lpg.a(a.b(), new bbt(this), lpz.a());
            lpg.a(this.c.b(), new bbu(this, a2), oyx.INSTANCE);
            lpg.a(this.c.b(), new bbv(this, a2), lpz.a());
            return true;
        }
        return false;
    }

    final void c() {
        this.a.a();
        this.a.e();
        ayr ayrVar = this.j;
        if (ayrVar != null) {
            ayrVar.a();
        }
    }

    @Override
    public final synchronized void close() {
        this.k = true;
        lyu lyuVar = this.f;
        if (lyuVar != null) {
            lyuVar.close();
        }
    }
}