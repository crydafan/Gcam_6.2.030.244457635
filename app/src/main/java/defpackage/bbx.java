package defpackage;

import android.graphics.PointF;

final class bbx implements lzb {
    private final bbp a;

    bbx(bbp bbpVar) {
        this.a = bbpVar;
    }

    @Override
    public final void a(Object obj) {
        bbp bbpVar = this.a;
        PointF pointF = (PointF) obj;
        if (pointF.x < 0.0f || pointF.y < 0.0f) {
            return;
        }
        if (bbpVar.b == mmt.FRONT) {
            pointF.x = 1.0f - pointF.x;
        }
        bbpVar.a.c(pointF);
    }
}