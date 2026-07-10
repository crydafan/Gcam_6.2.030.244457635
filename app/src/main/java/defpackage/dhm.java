package defpackage;

import android.util.DisplayMetrics;
import com.google.googlex.gcam.BaseFrameCallback;
import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.EncodedBlobCallback;
import com.google.googlex.gcam.FinalImageCallback;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.PdImageCallback;
import com.google.googlex.gcam.PostviewCallback;
import com.google.googlex.gcam.ProgressCallback;
import com.google.googlex.gcam.ShotStatusCallback;
import com.google.googlex.gcam.clientallocator.UniqueBitmapClientAllocator;
import com.google.googlex.gcam.clientallocator.UniqueHardwareBufferInterleavedU8ClientAllocator;
import com.google.googlex.gcam.clientallocator.UniqueInterleavedU16ClientAllocator;
import com.google.googlex.gcam.clientallocator.UniqueInterleavedU8ClientAllocator;
import com.google.googlex.gcam.clientallocator.UniqueYuvClientAllocator;
import java.util.ArrayList;
import java.util.List;

public final class dhm {
    public static final String a = pra.a("HdrPShotParams");
    public final het c;
    public final ProgressCallback f;
    public final ShotStatusCallback g;
    public final BaseFrameCallback h;
    public final PostviewCallback i;
    public final PdImageCallback j;
    public final EncodedBlobCallback k;
    public final FinalImageCallback l;
    public final EncodedBlobCallback m;
    public final ClientInterleavedU8Allocator n;
    public final UniqueYuvClientAllocator o;
    public final ClientInterleavedU8Allocator p;
    public final boolean s;
    public final dhv t;
    public lyu u;
    private int v = 1;
    public int b = GcamModule.getKInvalidShotId();
    public final UniqueYuvClientAllocator q = new UniqueYuvClientAllocator();
    public final UniqueInterleavedU16ClientAllocator r = new UniqueInterleavedU16ClientAllocator();
    public final List<mqc> d = new ArrayList<>();
    public final List<Long> e = new ArrayList<>();

    public dhm(dhv dhvVar, DisplayMetrics displayMetrics, het hetVar, int i, jab jabVar, cba cbaVar, chh chhVar) {
        this.t = dhvVar;
        this.c = hetVar;
        boolean z = false;
        if ((dhvVar.c().b() || dhvVar.d().b() || dhvVar.e().b()) && !dhvVar.f().b() && !dhvVar.g().b() && !dhvVar.h().b() && !dhvVar.i().b() && !dhvVar.j().b() && !dhvVar.k().b()) {
            z = true;
        }
        this.s = z;
        this.f = null; //new dhn(dhvVar);
        this.g = null; //new dho(this, cbaVar, chhVar, i, jabVar, dhvVar, hetVar);
        this.h = null; //new dhp(this, dhvVar);
        if (dhvVar.c().b()) {
            this.n = new UniqueBitmapClientAllocator(displayMetrics);
            this.o = null;
        } else if (dhvVar.d().b()) {
            this.n = null;
            this.o = new UniqueYuvClientAllocator();
        } else if (dhvVar.e().b()) {
            this.n = new UniqueHardwareBufferInterleavedU8ClientAllocator(288L, 32L);
            this.o = null;
        } else {
            this.n = null;
            this.o = null;
        }
        if (dhvVar.i().b()) {
            this.p = new UniqueInterleavedU8ClientAllocator();
        } else if (dhvVar.j().b()) {
            this.p = new UniqueHardwareBufferInterleavedU8ClientAllocator(290L, 34L);
        } else {
            this.p = null;
        }
        this.i = null; //new dhq(this, dhvVar);
        this.j = null; //new dhr(this, dhvVar);
        this.k = null; //new dhs(this, dhvVar);
        this.l = null; //new dht(this, dhvVar);
        this.m = null; //new dhu(this, dhvVar);
    }

    static /* synthetic */ int a(dhm dhmVar) {
        return dhmVar.v;
    }

    static /* synthetic */ int a(dhm dhmVar, int i) {
        dhmVar.v = i;
        return i;
    }

    public final int a() {
        ohr.b(this.b != GcamModule.getKInvalidShotId(), "setShotId() has not been called on this Shot.");
        return this.b;
    }

    public final void b() {
        if (this.t.g().b()) {
            //new dia(String.format(null, "MergePD failed (notified by command)", new Object[0]));
            //((dic) this.t.g().c()).a();
        }
    }
}