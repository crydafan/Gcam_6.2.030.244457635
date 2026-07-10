package defpackage;

import java.util.Set;

public final class bat implements aww {
    private final lpu a;
    private final awq b;
    private final kmu c;
    private final kms d;

    public bat(awn awnVar, awq awqVar, axa axaVar, axf axfVar, ays aysVar, kmu kmuVar, kms kmsVar, lpx lpxVar, Set<knf> set, kne kneVar, awp awpVar, mmb mmbVar, lrm lrmVar, lrm lrmVar2, boolean z) {
        ayr ayrVar;
        this.a = new lpu();
        boolean z2 = true;
        if (!mmbVar.o() && !mmbVar.p()) {
            z2 = false;
        }
        ohr.a(z2);
        this.b = awqVar;
        this.c = kmuVar;
        this.d = kmsVar;
        awz a = axaVar.a(awpVar, lrmVar, mmbVar);
        if (mmbVar.o()) {
            ayr a2 = aysVar.a(lrmVar);
            this.a.a(a2);
            ayrVar = a2;
        } else {
            ayrVar = null;
        }
        mmt b = mmbVar.b();
        if (z) {
            kmuVar.a(new bbp(this.a, a, axfVar, b, awnVar, set, ayrVar));
        } else {
            kmuVar.a(new bbe(awnVar, a, axfVar, b, set));
        }
        kmsVar.a(kneVar);
        awqVar.a();
        this.a.a(awqVar.a(lrmVar));
        this.a.a(lrmVar2.a(new bau(axfVar), lpxVar));
    }

    public bat(awn awnVar, awq awqVar, axa axaVar, axf axfVar, ays aysVar, kmu kmuVar, kms kmsVar, lpx lpxVar, Set<knf> set, kne kneVar, awp awpVar, mmb mmbVar, lrm lrmVar, lrm lrmVar2, boolean z, byte b) {
        this(awnVar, awqVar, axaVar, axfVar, aysVar, kmuVar, kmsVar, lpxVar, set, kneVar, awpVar, mmbVar, lrmVar, lrmVar2, z);
        kmsVar.c();
    }

    @Override
    public final void close() {
        this.a.close();
        this.b.a();
        this.c.a = null;
        this.d.c();
    }
}