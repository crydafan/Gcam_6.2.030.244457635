package defpackage;

public final class ded {
    public final cgm j;
    public final kib k;
    public final int l = 3;
    public final int m;
    public final int n;
    public final int o;
    public boolean p;
    public final cbc t;
    public static final cvi a = new cvi("camera.extburst.RESTART");
    public static final cvi b = new cvi("camera.sabre_force");
    public static final cvj c = new cvj("camera.p3_available");
    public static final cvi d = new cvi("camera.p3_force");
    public static final cvi e = new cvi("camera.slowraw.RESTART");
    public static final cvi f = new cvi("camera.gcam_awb");
    private static final cvy q = new cvy("camera.disable_easel", false);
    private static final cvy r = new cvy("camera.use_fine_finish", false);
    private static final cvy s = new cvy("camera.random_use_easel", false);
    public static final cvj g = new cvj("camera.cuttle.motion_ef");
    public static final cvi h = new cvi("camera.cuttle.extended");
    public static final cvi i = new cvi("camera.cuttle.average");

    ded(cbc cbcVar, cgm cgmVar, kib kibVar, mpn mpnVar, cvv cvvVar) {
        this.p = false;
        this.j = cgmVar;
        this.k = kibVar;
        this.t = cbcVar;
        this.m = Math.max(this.l, mpnVar.a("persist.gcam.max_burst_size", cbcVar.d()));
        int a2 = lof.a(cbcVar.a, "camera:hdr_plus_zsl_buffer_count", cbcVar.d() + 2);
        a2 = !kibVar.a.b() ? Math.max(a2, 10) : a2;
        cvvVar.b();
        int max = Math.max(this.l, mpnVar.a("persist.gcam.zsl_buffer_size", a2));
        int i4 = 15;
        int i5 = !kibVar.a.b() ? 15 : max;
        if (!a(kibVar)) {
            cvvVar.b();
            i4 = max;
        }
        this.n = Math.max((!cgmVar.p() ? 0 : 4) + max, Math.max(i5, i4));
        this.o = cgmVar.p() ? this.n - max : 0;
        ohr.b(this.l <= this.m);
        ohr.b(this.m <= this.n);
        if (cvvVar.a(q)) {
            this.p = true;
        } else if (cvvVar.a(s)) {
            this.p = System.currentTimeMillis() % 2000 < 1000;
        }
        cvvVar.a(r);
    }

    public static boolean a(cvv cvvVar) {
        return cvvVar.a();
    }

    public static boolean a(kib kibVar) {
        return kibVar.a.d() || kibVar.a.e();
    }

    public static boolean b(cvv cvvVar) {
        return cvvVar.b();
    }

    public static boolean b(kib kibVar) {
        return !kibVar.a.b();
    }

    public static boolean c(cvv cvvVar) {
        return cvvVar.b();
    }
}