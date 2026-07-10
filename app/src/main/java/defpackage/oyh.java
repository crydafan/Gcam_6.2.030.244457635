package defpackage;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class oyh extends oxz {
    public static final Logger e = Logger.getLogger(oyh.class.getName());
    //public oyi f;

    oyh() {
    }

    private oyh(byte b) {
        this();
    }

    public oyh(odm odmVar, boolean z) {
        this((byte) 0);
        //a((oyi) new oys(this, odmVar, z, (byte) 0));
    }

    oyh(odm odmVar, boolean z, Executor executor, Callable callable) {
        this();
        //a((oyi) new oyw(this, odmVar, z, new oyu(this, callable, executor)));
    }

    /*public oyh(odm odmVar, boolean z, Executor executor, oyo oyoVar) {
        this();
        a((oyi) new oyw(this, odmVar, z, new oyt(this, oyoVar, executor)));
    }*/

    /*private final void a(oyi oyiVar) {
        this.f = oyiVar;
        if (oyiVar.a.isEmpty()) {
            oyiVar.c();
        } else if (!oyiVar.b) {
            oji a = oyiVar.a.a();
            while (a.hasNext()) {
                ((ozs) a.next()).a(oyiVar, oyx.INSTANCE);
            }
        } else {
            oji a2 = oyiVar.a.a();
            int i = 0;
            while (a2.hasNext()) {
                ozs ozsVar = (ozs) a2.next();
                ozsVar.a(new oyj(oyiVar, i, ozsVar), oyx.INSTANCE);
                i++;
            }
        }
    }

    static boolean a(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override
    protected final String a() {
        odm odmVar;
        oyi oyiVar = this.f;
        if (oyiVar == null || (odmVar = oyiVar.a) == null) {
            return null;
        }
        String valueOf = String.valueOf(odmVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 10);
        sb.append("futures=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override
    protected final void b() {
        super.b();
        oyi oyiVar = this.f;
        if (oyiVar != null) {
            this.f = null;
            odm odmVar = oyiVar.a;
            boolean c = c();
            if (c) {
                oyiVar.d();
            }
            if (!isCancelled() || !(odmVar != null)) {
                return;
            }
            oji a = odmVar.a();
            while (a.hasNext()) {
                ((ozs) a.next()).cancel(c);
            }
        }
    }*/
}