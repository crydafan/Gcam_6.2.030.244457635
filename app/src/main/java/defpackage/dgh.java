package defpackage;

import com.google.googlex.gcam.MemoryStateCallback;

final class dgh extends MemoryStateCallback {
    private final /* synthetic */ dgg a;

    dgh(dgg dggVar) {
        this.a = dggVar;
    }

    @Override // com.google.googlex.gcam.MemoryStateCallback
    public final void Run(long j, long j2) {
        String str = dgg.a;
        String sb = "MemoryStateCallback: peakMemoryBytes=" + j + " peakMemoryWithNewShotBytes=" + j2;
        pra.d(str, sb);
        this.a.f.a(j);
        this.a.g.a(j2);
    }
}