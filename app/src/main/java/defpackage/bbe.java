package defpackage;

import android.graphics.PointF;
import java.util.Set;

public final class bbe extends knf {
    public final axf a;
    private final awn d;
    private final awz e;
    private final mmt f;
    private final Set<knf> g;
    public khq b = null;
    public khq c = null;
    private final lpn h = new bbj(this);

    public bbe(awn awnVar, awz awzVar, axf axfVar, mmt mmtVar, Set<knf> set) {
        this.d = awnVar;
        this.e = awzVar;
        this.a = axfVar;
        this.f = mmtVar;
        this.g = set;
    }

    @Override
    public final boolean a(PointF pointF) {
        khq khqVar = this.b;
        if (khqVar != null) {
            khqVar.b();
        }
        khq khqVar2 = this.c;
        if (khqVar2 != null) {
            khqVar2.b();
        }
        for (knf knfVar : this.g) {
            knfVar.a(pointF);
        }
        aye a = this.d.a();
        this.b = this.a.a(pointF);
        this.b.a(new bbf(this));
        azp a2 = this.e.a(this.f, pointF, a);
        lpg.a(this.b.a(), a2.a(), this.h, lpz.a());
        ozs a3 = a.a();
        lpg.a(a3, new bbg(a2));
        lpg.a(a2.b(), new bbh(a3, a2), oyx.INSTANCE);
        lpg.a(a.b(), new bbi(a2), oyx.INSTANCE);
        return true;
    }
}