package defpackage;

import android.util.Range;
import java.util.Collection;
import java.util.LinkedList;

public enum ltm {
    FPS_AUTO(30, 30, 60),
    FPS_30(30, 30, 30),
    FPS_60(60, 60, 60),
    FPS_60_HFR_2X(60, 30, 60),
    FPS_120_HFR_4X(120, 30, 120),
    FPS_240_HFR_8X(240, 30, 240);
    
    public final int f;
    public final int g;
    public final int h;

    ltm(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    public static Collection a() {
        ltm[] values;
        LinkedList linkedList = new LinkedList();
        for (ltm ltmVar : values()) {
            if (ltmVar.d()) {
                linkedList.add(ltmVar);
            }
        }
        return linkedList;
    }

    public static ltm a(int i, int i2) {
        if (i == 60) {
            if (i2 == 60) {
                return FPS_60;
            }
            if (i2 == 30) {
                return FPS_60_HFR_2X;
            }
        } else if (i2 == 30) {
            if (i == 30) {
                return FPS_30;
            }
            if (i == 120) {
                return FPS_120_HFR_4X;
            }
            if (i == 240) {
                return FPS_240_HFR_8X;
            }
        }
        StringBuilder sb = new StringBuilder(79);
        sb.append("unsupported capture frame rate =");
        sb.append(i);
        sb.append(" and encoding frame rate=");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final Range b() {
        return new Range(Integer.valueOf(this.f), Integer.valueOf(this.f));
    }

    public final boolean c() {
        return this.f == this.g;
    }

    public final boolean d() {
        return this.f > this.g;
    }

    public final int e() {
        return this.f / this.g;
    }
}