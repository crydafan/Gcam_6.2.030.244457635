package defpackage;

import com.google.googlex.gcam.SimpleCallback;

import java.util.Locale;

final class dgi extends SimpleCallback {
    private final /* synthetic */ dgg a;

    dgi(dgg dggVar) {
        this.a = dggVar;
    }

    @Override // com.google.googlex.gcam.SimpleCallback
    public final void Run() {
        if (!this.a.d.isEmpty()) {
            pra.b(dgg.a, String.format((Locale) null, "HDR+ is idle, but we have %d shots in flight", this.a.d.size()));
        }
    }
}