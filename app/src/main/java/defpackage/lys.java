package defpackage;

import android.view.Display;

public enum lys {
    CLOCKWISE_0(0),
    CLOCKWISE_90(90),
    CLOCKWISE_180(180),
    CLOCKWISE_270(270);
    
    public final int e;

    lys(int i) {
        this.e = i;
    }

    public static lys a(int i) {
        if (i != -1 && i != 0) {
            if (i == 90) {
                return CLOCKWISE_90;
            }
            if (i == 180) {
                return CLOCKWISE_180;
            }
            if (i == 270) {
                return CLOCKWISE_270;
            }
            int abs = (((Math.abs(i / 360) * 360) + 360) + i) % 360;
            return (abs > 315 || abs <= 45) ? CLOCKWISE_0 : (abs > 45 && abs <= 135) ? CLOCKWISE_90 : (abs <= 135 || abs > 225) ? CLOCKWISE_270 : CLOCKWISE_180;
        }
        return CLOCKWISE_0;
    }

    public static lys a(Display display) {
        return b(display.getRotation());
    }

    public static lys b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? CLOCKWISE_0 : c(270) : c(180) : c(90) : c(0);
    }

    public static lys c(int i) {
        return a((360 - i) % 360);
    }

    public final int a() {
        return (360 - this.e) % 360;
    }
}