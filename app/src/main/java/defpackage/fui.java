package defpackage;

import java.util.EnumMap;
import java.util.concurrent.Executor;

public final class fui {
    private static final String a = pra.a("MemoryManager");
    private final Executor c;
    private final long d;
    private final EnumMap<fud, ful> e = new EnumMap<>(fud.class);
    private final Object b = new Object();

    public fui(fug fugVar, Executor executor) {
        this.d = fugVar.a;
        pra.c(a, "Max native memory: " + this.d + " bytes. (" + this.d / 1000000 + "MB).");
        this.c = executor;
    }

    private final long b() {
        long j;
        synchronized (this.b) {
            long j2 = 0;
            for (fud fudVar : this.e.keySet()) {
                j2 += (Long) ((ful) this.e.get(fudVar)).a.b().b_();
            }
            j = this.d - j2;
        }
        return j;
    }

    private final boolean b(fud fudVar) {
        synchronized (this.b) {
            long b = b();
            long longValue = (Long) ((ful) this.e.get(fudVar)).a.c().b_();
            boolean z = false;
            if (longValue < 0) {
                String name = fudVar.name();
                String sb = "Feature (" +
                        name +
                        ") reports negative shot memory: " +
                        longValue +
                        ". Disabling.";
                pra.e(a, sb);
                return false;
            }
            if (longValue <= b) {
                z = true;
            }
            String name2 = fudVar.name();
            String sb2 = "Feature available: " +
                    name2 +
                    ": " +
                    z +
                    " (Additional memory: " +
                    longValue +
                    ")";
            pra.a(a, sb2);
            return z;
        }
    }

    public final lrm a(fud fudVar) {
        lqy lqyVar;
        synchronized (this.b) {
            if (!this.e.containsKey(fudVar)) {
                String valueOf = String.valueOf(fudVar);
                String sb = "Feature not registered: " +
                        valueOf;
                throw new IllegalStateException(sb);
            }
            lqyVar = ((ful) this.e.get(fudVar)).b;
        }
        return lqyVar;
    }

    final void a() {
        synchronized (this.b) {
            long b = b();
            for (fud fudVar : this.e.keySet()) {
                ((ful) this.e.get(fudVar)).b.a(b(fudVar));
            }
            String sb = "State updated. Free Memory: " +
                    b;
            pra.c(a, sb);
        }
    }

    public final boolean a(fue fueVar) {
        synchronized (this.b) {
            if (this.e.containsKey(fueVar.a())) {
                String valueOf = fueVar.a().name();
                pra.c(a, valueOf.length() != 0 ? "Feature already registered: ".concat(valueOf) : "Feature already registered: ");
                return false;
            }
            String valueOf2 = fueVar.a().name();
            pra.c(a, valueOf2.length() != 0 ? "Registering feature: ".concat(valueOf2) : "Registering feature: ");
            //this.e.put((EnumMap) fueVar.a(), (fud) new ful(fueVar, new lqy((Object) false), ods.a(fueVar.b().a(new fuj(this), this.c), fueVar.c().a(new fuk(this), this.c))));
            a();
            return true;
        }
    }
}