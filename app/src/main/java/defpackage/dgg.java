package defpackage;

import com.google.googlex.gcam.AeResults;
import com.google.googlex.gcam.BackgroundAeResultsCallback;
import com.google.googlex.gcam.InitParams;
import com.google.googlex.gcam.MemoryStateCallback;
import com.google.googlex.gcam.SimpleCallback;
import com.google.googlex.gcam.hdrplus.ImageConverter;
import com.google.googlex.gcam.hdrplus.ImageProxyAndHardwareBufferReleaseCallback;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class dgg {
    public static final String a = pra.a("HdrPlusState");
    public final InitParams b;
    public final ImageConverter c;
    public final ConcurrentMap<Integer, dhm> d = new ConcurrentHashMap<>();
    public final ImageProxyAndHardwareBufferReleaseCallback e = new ImageProxyAndHardwareBufferReleaseCallback();
    public final lqy f = new lqy((Object) 0L);
    public final lqy g = new lqy((Object) 0L);
    private final MemoryStateCallback i = new dgh(this);
    private final SimpleCallback j = new dgi(this);
    public final lqy h = new lqy(new AeResults());
    private final BackgroundAeResultsCallback k = new dgj(this);

    dgg(cbc cbcVar, fui fuiVar, ded dedVar, cba cbaVar, ImageConverter imageConverter) {
        int a2 = lof.a(cbcVar.a, "camera:gcam_thread_count", kic.a());
        boolean z = true;
        ohr.b(a2 > 0, "threadCount %d is not a valid value.");
        InitParams initParams = new InitParams();
        initParams.setThread_count(a2);
        if (cbaVar == cba.ENG) {
        }
        initParams.setAllow_unknown_devices(true);
        initParams.setMin_payload_frames(1);
        initParams.setMax_payload_frames(dedVar.m);
        initParams.setExecute_finish_on(0);
        dedVar.j.a.a();
        if (new File("/dev/adsprpc-smd").canRead()) {
            pra.c(a, "Using Hexagon");
            initParams.setExecute_finish_on(1);
        }
        initParams.setSimultaneous_merge_and_finish(initParams.getExecute_finish_on() != 0);
        initParams.setMemory_callback(this.i);
        initParams.setFinish_queue_empty_callback(this.j);
        initParams.setBackground_ae_results_callback(this.k);
        initParams.setImage_release_callback(this.e);
        this.b = initParams;
        this.c = imageConverter;
        fuiVar.a(new fuf(fud.HDR_PLUS, this.f, this.g));
    }
}