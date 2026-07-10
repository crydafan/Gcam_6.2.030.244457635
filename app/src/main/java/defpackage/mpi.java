package defpackage;

import android.os.Build;

public final class mpi {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    private mpi(int i, String str) {
        boolean z;
        boolean z2 = false;
        this.a = i >= 21;
        this.b = i >= 23;
        this.c = i >= 24;
        this.d = i >= 26;
        if (i > 27) {
            z = true;
        } else if (i < 27) {
            z = false;
        } else {
            ohr.a(true);
            ohr.a(true);
            z = str.charAt(0) > "P".charAt(0) || str.startsWith("P") || "MASTER".equals(str);
        }
        this.e = z;
        if (this.d && !this.e) {
            z2 = true;
        }
        this.f = z2;
    }

    public static mpi a() {
        int valueOf = Build.VERSION.SDK_INT;
        String str = Build.ID;
        int intValue = valueOf > 0 ? valueOf : 1;
        if (str == null) {
            str = "AAA01";
        }
        return new mpi(intValue, str);
    }
}