package defpackage;

import com.google.googlex.gcam.AeResults;
import com.google.googlex.gcam.BackgroundAeResultsCallback;

final class dgj extends BackgroundAeResultsCallback {
    private final /* synthetic */ dgg a;

    dgj(dgg dggVar) {
        this.a = dggVar;
    }

    @Override // com.google.googlex.gcam.BackgroundAeResultsCallback
    public final void Run(AeResults aeResults) {
        if (aeResults != null && aeResults.getValid()) {
            this.a.h.a(new AeResults(aeResults));
        } else if (aeResults == null) {
            pra.e(dgg.a, "AeResults from HdrPlusSession is null!");
        } else {
            pra.a(dgg.a, "AeResults from HdrPlusSession is invalid.");
        }
    }
}