package defpackage;

import com.google.googlex.gcam.Gcam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class deg {
    private static final String d = pra.a("HdrPCpuPriority");
    public Future c;
    private final Gcam e;
    private final ScheduledExecutorService f;
    public final Object a = new Object();
    public final List<del> b = new ArrayList<>();
    private float g = 1.0f;

    public deg(Gcam gcam, ScheduledExecutorService scheduledExecutorService) {
        this.e = gcam;
        this.f = scheduledExecutorService;
    }

    public final lyu a(int i) {
        String sb = "Registering shot " + i;
        pra.d(d, sb);
        del delVar = new del(i);
        synchronized (this.a) {
            this.b.add(delVar);
        }
        return new deh(this, delVar);
    }

    public final void a() {
        pra.c(d, "Setting HDR+ high processing priority");
        synchronized (this.a) {
            Future future = this.c;
            if (future != null) {
                future.cancel(false);
            }
        }
        this.f.execute(new dei(this));
    }

    final void a(float f) {
        synchronized (this.a) {
            if (f == this.g) {
                return;
            }
            this.g = f;
            for (del delVar : this.b) {
                int i = delVar.a;
                String sb = "Setting HDR+ CPU usage to " + f + " for shot " + i;
                pra.c(d, sb);
                this.e.LimitShotCpuUsage(delVar.a, f);
            }
        }
    }

    public final void b() {
        pra.c(d, "Setting HDR+ low processing priority");
        this.f.execute(new dej(this));
        synchronized (this.a) {
            this.c = this.f.schedule(new dek(this), 2000L, TimeUnit.MILLISECONDS);
        }
    }
}