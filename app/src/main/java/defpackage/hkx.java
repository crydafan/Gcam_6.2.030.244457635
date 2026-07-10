package defpackage;

import android.graphics.Rect;
import java.util.Arrays;
import java.util.List;

public final class hkx {
    public final mnh a;
    public final mnh b;
    public final lyw c;
    public final Rect d;

    private hkx(mnh mnhVar, mnh mnhVar2, lyw lywVar, Rect rect) {
        this.a = mnhVar;
        this.b = mnhVar2;
        this.c = lywVar;
        this.d = rect;
    }

    public static hkx a(mmb mmbVar, lyw lywVar, int i) {
        hky hkyVar = new hky(mmbVar, lywVar, i);
        List<lyw> a = hkyVar.a.a(hkyVar.c);
        if (a.isEmpty()) {
            int i2 = hkyVar.c;
            StringBuilder sb = new StringBuilder(50);
            sb.append("No picture sizes supported for format: ");
            sb.append(i2);
            try {
                throw new hkw(sb.toString());
            } catch (hkw e) {
                e.printStackTrace();
            }
        }
        lyw lywVar2 = hkyVar.b;
        ohr.b(!a.isEmpty());
        lyw lywVar3 = null;
        long j = Long.MAX_VALUE;
        for (lyw lywVar4 : a) {
            long b = lywVar4.b();
            if (lywVar4.a >= lywVar2.a && lywVar4.b >= lywVar2.b && b < j) {
                lywVar3 = lywVar4;
                j = b;
            }
        }
        if (lywVar3 == null) {
            lywVar3 = lyx.a(a);
        }
        return new hkx(new mnh(hkyVar.c, lywVar3), new mnh(hkyVar.c, lyx.a(a)), hkyVar.b, lyb.a(hkyVar.b).a(new Rect(0, 0, lywVar3.a, lywVar3.b)));
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof hkx) {
                hkx hkxVar = (hkx) obj;
                if (this.c.equals(hkxVar.c) && this.b.equals(hkxVar.b) && this.a.equals(hkxVar.a) && this.d.equals(hkxVar.d)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b, this.a, this.d});
    }

    public final String toString() {
        return oxl.a("PictureSizeCalculator.Configuration").a("desired size", this.c).a("large image reader", this.a).a("full-size image reader", this.b).a("crop", this.d).toString();
    }
}