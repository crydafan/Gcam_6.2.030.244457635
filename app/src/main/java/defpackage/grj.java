package defpackage;

import android.hardware.camera2.CaptureRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class grj {
    public int a;
    private final Map<CaptureRequest.Key<?>, Object> b;
    private final Set<itp> c;
    private final Set<gqy> d;
    private final nyp e;

    public grj() {
        this.a = 1;
        this.c = new HashSet<>();
        this.b = new HashMap<>();
        this.d = new HashSet<>();
        this.e = nxs.a;
    }

    public grj(grh grhVar) {
        this.a = grhVar.a;
        this.d = new HashSet<>(grhVar.d);
        this.c = new HashSet<>();
        this.c.addAll(grhVar.c);
        this.b = new HashMap<>();
        for (gri griVar : grhVar.b) {
            a(griVar);
        }
        this.e = grhVar.e;
    }

    public grj(grj grjVar) {
        this(grjVar.c());
    }

    public final grj a() {
        return new grj(c());
    }

    public final grj a(int i) {
        grj grjVar = new grj(this);
        grjVar.a = i;
        return grjVar;
    }

    public final grj a(CaptureRequest.Key<?> key, Object obj) {
        this.b.put(key, new gri(key, obj));
        return this;
    }

    public final grj a(gqx gqxVar) {
        a(gqxVar.o_());
        return this;
    }

    public final grj a(gqy gqyVar) {
        this.d.add(gqyVar);
        return this;
    }

    public final grj a(gri griVar) {
        a(griVar.a, griVar.b);
        return this;
    }

    public final grj a(itp itpVar) {
        this.c.add(itpVar);
        return this;
    }

    public final grj b() {
        this.d.clear();
        return this;
    }

    public final grh c() {
        return new grh(this.a, oet.a(this.b.values()), this.c, this.d, this.e);
    }
}