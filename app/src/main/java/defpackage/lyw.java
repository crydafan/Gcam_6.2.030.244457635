package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import java.util.Arrays;

public final class lyw {
    public final int a;
    public final int b;
    private volatile lyw c;

    public lyw(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = null;
    }

    private lyw(int i, int i2, lyw lywVar) {
        this.a = i;
        this.b = i2;
        this.c = lywVar;
    }

    public static lyw a(int i, int i2) {
        return new lyw(i, i2);
    }

    public static lyw a(Point point) {
        return new lyw(point.x, point.y);
    }

    public static lyw a(Rect rect) {
        return new lyw(rect.width(), rect.height());
    }

    public final lyw a() {
        lyw lywVar = this.c;
        if (lywVar == null) {
            lyw lywVar2 = new lyw(this.b, this.a, this);
            this.c = lywVar2;
            return lywVar2;
        }
        return lywVar;
    }

    public final lyw a(lys lysVar) {
        int ordinal = lysVar.ordinal();
        return (ordinal == 1 || ordinal == 3) ? a() : this;
    }

    public final long b() {
        return this.a * this.b;
    }

    public final float c() {
        return this.a / this.b;
    }

    public final lyw d() {
        return this.a < this.b ? a() : this;
    }

    public final lyw e() {
        return this.b < this.a ? a() : this;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && getClass() == obj.getClass()) {
                lyw lywVar = (lyw) obj;
                if (this.a == lywVar.a && this.b == lywVar.b) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final Size f() {
        return new Size(this.a, this.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}