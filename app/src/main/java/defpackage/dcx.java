package defpackage;

final class dcx extends dhv {
    private final nyp a;
    private final nyp b;
    private final nyp c;
    private final nyp d;
    private final nyp e;
    private final nyp f;
    private final nyp g;
    private final nyp h;
    private final nyp i;
    private final nyp j;
    private final nyp k;
    private final nyp l;

    dcx(nyp nypVar, nyp nypVar2, nyp nypVar3, nyp nypVar4, nyp nypVar5, nyp nypVar6, nyp nypVar7, nyp nypVar8, nyp nypVar9, nyp nypVar10, nyp nypVar11, nyp nypVar12) {
        this.a = nypVar;
        this.b = nypVar2;
        this.c = nypVar3;
        this.d = nypVar4;
        this.e = nypVar5;
        this.f = nypVar6;
        this.g = nypVar7;
        this.h = nypVar8;
        this.i = nypVar9;
        this.j = nypVar10;
        this.k = nypVar11;
        this.l = nypVar12;
    }

    @Override // defpackage.dhv
    public final nyp a() {
        return this.a;
    }

    @Override // defpackage.dhv
    public final nyp b() {
        return this.b;
    }

    @Override // defpackage.dhv
    public final nyp c() {
        return this.c;
    }

    @Override // defpackage.dhv
    public final nyp d() {
        return this.d;
    }

    @Override // defpackage.dhv
    public final nyp e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof dhv) {
                dhv dhvVar = (dhv) obj;
                return this.a.equals(dhvVar.a()) && this.b.equals(dhvVar.b()) && this.c.equals(dhvVar.c()) && this.d.equals(dhvVar.d()) && this.e.equals(dhvVar.e()) && this.f.equals(dhvVar.f()) && this.g.equals(dhvVar.g()) && this.h.equals(dhvVar.h()) && this.i.equals(dhvVar.i()) && this.j.equals(dhvVar.j()) && this.k.equals(dhvVar.k()) && this.l.equals(dhvVar.l());
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.dhv
    public final nyp f() {
        return this.f;
    }

    @Override // defpackage.dhv
    public final nyp g() {
        return this.g;
    }

    @Override // defpackage.dhv
    public final nyp h() {
        return this.h;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode();
    }

    @Override // defpackage.dhv
    public final nyp i() {
        return this.i;
    }

    @Override // defpackage.dhv
    public final nyp j() {
        return this.j;
    }

    @Override // defpackage.dhv
    public final nyp k() {
        return this.k;
    }

    @Override // defpackage.dhv
    public final nyp l() {
        return this.l;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        String valueOf3 = String.valueOf(this.c);
        String valueOf4 = String.valueOf(this.d);
        String valueOf5 = String.valueOf(this.e);
        String valueOf6 = String.valueOf(this.f);
        String valueOf7 = String.valueOf(this.g);
        String valueOf8 = String.valueOf(this.h);
        String valueOf9 = String.valueOf(this.i);
        String valueOf10 = String.valueOf(this.j);
        String valueOf11 = String.valueOf(this.k);
        String valueOf12 = String.valueOf(this.l);
        return "ShotConfig{progressCallback=" +
                valueOf +
                ", baseFrameCallback=" +
                valueOf2 +
                ", postviewRgbCallback=" +
                valueOf3 +
                ", postviewYuvCallback=" +
                valueOf4 +
                ", postviewHardwareBufferCallback=" +
                valueOf5 +
                ", dngCallback=" +
                valueOf6 +
                ", pdCallback=" +
                valueOf7 +
                ", yuvCallback=" +
                valueOf8 +
                ", rgbCallback=" +
                valueOf9 +
                ", rgbHardwareBufferCallback=" +
                valueOf10 +
                ", jpegCallback=" +
                valueOf11 +
                ", shotStatusCallback=" +
                valueOf12 +
                "}";
    }
}