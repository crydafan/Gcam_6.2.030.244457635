package defpackage;

public final class cgm {
    public static final cvi A;
    public static final cvy B;
    public static final cvj C;
    public static final cvy D;
    public static final cvi E;
    public static final cvy F;
    public static final cvi G;
    public static final cvi H;
    public static final cvi I;
    public static final cvi J;
    public static final cvi K;
    public static final cvj L;
    public static final cvj M;
    public static final cvj N;
    public static final cvj O;
    public static final cvj P;
    public static final cvy Q;
    public static final cvj R;
    public static final cvy S;
    public static final cvr T;
    private static final cvy V;
    private static final cwc W;
    public static final cvi c = new cvi("camera.onscreen_log");
    public static final cvi d = new cvi("camera.onscreen_logcat");
    public static final cvi e = new cvi("camera.syshealth_info");
    public static final cvi f = new cvi("camera.faceboxes");
    public static final cvy g = new cvy("camera.use_local_logger", false);
    public static final cvy h = new cvy("camera.use_perf_logger", false);
    public static final cvi i = new cvi("camera.af.debug.show");
    public static final cvi j;
    public static final cvi k;
    public static final cvy l;
    public static final cvj m;
    public static final cvj n;
    public static final cvj o;
    public static final cvi p;
    public static final cvi q;
    public static final cvi r;
    public static final cvi s;
    public static final cvi t;
    public static final cvi u;
    public static final cvj v;
    public static final cvj w;
    public static final cvj x;
    public static final cvi y;
    public static final cvi z;
    private final czy X;
    private final cbc Y;
    public final cvv a;
    public final kib b;
    public final cvy U = new cvy("camera.enable_micro", i());
    private final cvy Z = new cvy("camera.raw_mode", true);

    static {
        new cvi("camera.af.ring.hide");
        j = new cvi("camera.op.nes");
        new cvj("camera.flash.ind");
        k = new cvi("camera.hwhdr_inapp");
        l = new cvy("camera.hwhdr_intent", true);
        new cvi("camera.elmyra_assist");
        new cvi("camera.elmyra_lens");
        m = new cvj("camera.enable_pd");
        n = new cvj("camera.enable_pd_blur");
        o = new cvj("cameraprogress_overlay");
        p = new cvi("camera.enable_micro_he");
        q = new cvi("camera.mv_verbose");
        r = new cvi("camera.micro_datacoll");
        s = new cvi("camera.micro_audio");
        t = new cvi("camera.diet_mv");
        u = new cvi("camera.micro_trimtoast");
        v = new cvj("camera.micro_motion");
        w = new cvj("camera.micro_tooltip");
        x = new cvj("camera.micro_tone_map");
        y = new cvi("camera.micro_profile");
        z = new cvi("camera.micro_no_gyro");
        A = new cvi("camera.micro_cam_pose");
        B = new cvy("camera.mts_4k", true);
        new cvs("camera.mts_4k_fishfood", true);
        C = new cvj("camera.mts_postview");
        D = new cvy("camera.mts_fast_hdr", true);
        E = new cvi("camera.mts_f_fast_hdr");
        F = new cvy("camera.mts_alt_w_main", true);
        G = new cvi("camera.mts_f_alt_w_main");
        H = new cvi("camera.mts_gpu");
        I = new cvi("camera.mts_scoring_dbg");
        J = new cvi("camera.micro_longpress");
        K = new cvi("camera.mts_simple");
        new cvi("camera.optbar.hdr");
        L = new cvj("camera.enable_lkcnry");
        M = new cvj("camera.use_photos");
        N = new cvj("camera.iris.enable_iris");
        O = new cvj("camera.use_smarts_api");
        new cvj("camera.iris_ocr");
        P = new cvj("camera.iris_use_pb");
        new cvr("camera.iris_throw_ex", true);
        new cvy("camera.hdr_easel", true);
        new cvi("camera.use_custom_tabs");
        new cvj("camera.hdr_hvx");
        V = new cvy("camera.enable_pbooth", true);
        new cvi("camera.enable_stereo");
        W = new cwc("camera.fake_therm_state");
        new cvi("camera.ignore_temp");
        Q = new cvy("camera.auto_fps_default", true);
        R = new cvj("camera.seamless_mode");
        S = new cvy("camera.enable_jpgcheck", false);
        new cvi("camera.frameserver_img");
        new cvr("camera.vid_meta_fatal", false);
        T = new cvr("camera.enable_hound", true);
    }

    public cgm(cvv cvvVar, kib kibVar, czy czyVar, cbc cbcVar) {
        this.a = cvvVar;
        this.b = kibVar;
        this.X = czyVar;
        this.Y = cbcVar;
        new cvk("camera.chk_anim_trnstns");
    }

    public final boolean A() {
        this.a.a();
        return this.b.a.d();
    }

    public final boolean B() {
        if (A()) {
            this.a.a();
            return true;
        }
        return false;
    }

    public final boolean C() {
        return this.a.a(V);
    }

    public final boolean D() {
        return this.a.b();
    }

    public final nyp E() {
        return this.a.a(W);
    }

    public final boolean F() {
        return this.a.a();
    }

    public final boolean a() {
        return this.a.b();
    }

    public final boolean b() {
        return this.a.b();
    }

    public final boolean c() {
        this.a.a();
        cbc cbcVar = this.Y;
        return (!cbcVar.b.a.b() || lof.a(cbcVar.a, "camera:google_photos_gallery_pixel_2016", false)) && this.X.a();
    }

    public final boolean d() {
        return this.a.a();
    }

    public final boolean e() {
        return this.a.b();
    }

    public final boolean f() {
        return this.a.b();
    }

    public final boolean g() {
        return this.a.b();
    }

    public final boolean h() {
        return (!i() || this.a.a(this.U)) ? false : false;
    }

    public final boolean i() {
        return !this.b.a.b();
    }

    public final boolean j() {
        return this.a.b();
    }

    public final boolean k() {
        return this.a.b();
    }

    public final boolean l() {
        return this.a.a();
    }

    public final boolean m() {
        return this.a.b();
    }

    public final boolean n() {
        return this.a.b();
    }

    public final boolean o() {
        this.a.b();
        this.a.b();
        return false;
    }

    public final boolean p() {
        this.a.d();
        if (this.a.a(B)) {
            return (this.b.a.d() || this.b.a.e()) && h();
        }
        return false;
    }

    public final boolean q() {
        this.a.b();
        return this.a.a(D) && this.b.a.e();
    }

    public final boolean r() {
        return this.a.b();
    }

    public final boolean s() {
        return this.a.b();
    }

    public final boolean t() {
        return this.a.a();
    }

    public final boolean u() {
        return this.a.b();
    }

    public final boolean v() {
        return this.a.a(l);
    }

    public final boolean w() {
        return this.a.b();
    }

    public final boolean x() {
        return this.a.b();
    }

    public final boolean y() {
        return this.a.a(this.Z);
    }

    public final boolean z() {
        if (d()) {
            this.a.a();
            return true;
        }
        return false;
    }
}