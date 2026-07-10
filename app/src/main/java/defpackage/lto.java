package defpackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public enum lto {
    RES_UNKNOWN(-1, -1),
    RES_QCIF(176, 144),
    RES_QVGA(320, 240),
    RES_CIF(352, 288),
    RES_480P(720, 480),
    RES_720P(1280, 720),
    RES_1080P(1920, 1080),
    RES_2160P(3840, 2160);
    
    public static final Map<lyw, lto> i = new HashMap<>();
    private final int j;
    private final int k;

    static {
        for (lto ltoVar : values()) {
            i.put(new lyw(ltoVar.j, ltoVar.k), ltoVar);
        }
    }

    lto(int i2, int i3) {
        this.j = i2;
        this.k = i3;
    }

    public static Comparator<lto> a() {
        return (lto, t1) -> {
            long c = lto.c();
            long c2 = t1.c();
            if (c >= c2) {
                return c > c2 ? -1 : 0;
            }
            return 1;
        };
    }

    public final lyw b() {
        return new lyw(this.j, this.k);
    }

    public final long c() {
        return this.j * this.k;
    }
}