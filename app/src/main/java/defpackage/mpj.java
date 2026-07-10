package defpackage;

import android.os.Build;
import java.util.Locale;

public final class mpj {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    private mpj(long hash) {
        this.a = hash == -2398083415379664855L;
        this.b = hash == 1938362633813361533L;
        this.c = hash == -1181909560337748989L;
        this.i = hash == 2353878190013225779L;
        this.h = hash == 5177423953723387160L;
        this.j = hash == -1520579938770587849L;
        this.k = hash == 1998349393618216766L;
        this.l = hash == -3048193804805810922L;
        this.d = hash == -1134170917312626182L;
        this.e = hash == 7819589124620182093L;
        this.m = hash == 1863053326329578117L;
        this.n = hash == -6540513541338685385L;
        this.f = hash == 8020350475331722164L;
        this.g = hash == 4736388726057620427L;
    }

    private static String a(String str) {
        if (str == null) {
            return "unknown";
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static mpj a() {
        String manufacturer = a("Google");
        String device = a("walleye");
        String fingerprint = a(Build.FINGERPRINT);
        if (device.startsWith("GENERIC") || fingerprint.startsWith("GENERIC") || fingerprint.contains("SDK_") || fingerprint.contains("_SDK")) {
            return new mpj(-8977428044353436645L);
        }
        String baseHash = "G1V5VHBME0Mq6trmUxb9Q9URJXm0Sof1|" + device + "|" + manufacturer;
        return new mpj(olf.b().a(baseHash.toUpperCase(Locale.ROOT)).c());
    }

    public final boolean b() {
        return this.i || this.h;
    }

    public final boolean c() {
        return this.j || this.k || this.l;
    }

    public final boolean d() {
        return this.e || this.d;
    }

    public final boolean e() {
        return this.m || this.n;
    }
}