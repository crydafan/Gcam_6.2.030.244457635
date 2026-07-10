package defpackage;

import android.graphics.PointF;

public final class kmu implements kng {
    public kng a = null;

    @Override
    public final void a() {
        kng kngVar = this.a;
        if (kngVar != null) {
            kngVar.a();
        }
    }

    public final void a(kng kngVar) {
        this.a = ohr.b(kngVar);
    }

    @Override
    public final boolean a(PointF pointF) {
        kng kngVar = this.a;
        if (kngVar == null) {
            return false;
        }
        return kngVar.a(pointF);
    }

    @Override
    public final boolean b(PointF pointF) {
        kng kngVar = this.a;
        if (kngVar == null) {
            return false;
        }
        return kngVar.b(pointF);
    }
}