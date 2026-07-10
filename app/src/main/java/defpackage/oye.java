package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class oye extends ozc implements Runnable {
    private ozs e;
    private Object f;

    oye(ozs ozsVar, Object obj) {
        this.e = ohr.b(ozsVar);
        this.f = ohr.b(obj);
    }

    public static ozs a(ozs ozsVar, nyi nyiVar, Executor executor) {
        ohr.b(nyiVar);
        oyg oygVar = new oyg(ozsVar, nyiVar);
        ozsVar.a(oygVar, qdr.a(executor, oygVar));
        return oygVar;
    }

    public static ozs a(ozs ozsVar, oyp oypVar, Executor executor) {
        ohr.b(executor);
        oyf oyfVar = new oyf(ozsVar, oypVar);
        ozsVar.a(oyfVar, qdr.a(executor, oyfVar));
        return oyfVar;
    }

    abstract Object a(Object obj, Object obj2);

    @Override
    protected final String a() {
        String str;
        ozs ozsVar = this.e;
        Object obj = this.f;
        String a = super.a();
        if (ozsVar != null) {
            String valueOf = String.valueOf(ozsVar);
            str = "inputFuture=[" +
                    valueOf +
                    "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (a == null) {
                return null;
            }
            return a.length() == 0 ? str : str.concat(a);
        }
        String valueOf4 = String.valueOf(obj);
        return str +
                "function=[" +
                valueOf4 +
                "]";
    }

    abstract void a(Object obj);

    @Override
    protected final void b() {
        a(this.e);
        this.e = null;
        this.f = null;
    }

    @Override
    public final void run() {
        ozs ozsVar = this.e;
        Object obj = this.f;
        boolean z = true;
        boolean isCancelled = isCancelled() | (ozsVar == null);
        if (obj != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.e = null;
            if (ozsVar.isCancelled()) {
                a(ozsVar);
                return;
            }
            try {
                try {
                    Object a = a(obj, qdr.b(ozsVar));
                    this.f = null;
                    a(a);
                } catch (Throwable th) {
                    try {
                        a(th);
                    } finally {
                        this.f = null;
                    }
                }
            } catch (CancellationException e2) {
                cancel(false);
            } catch (Error | RuntimeException e) {
                a(e);
            } /*catch (ExecutionException e4) {
                a(e4.getCause());
            }*/
        }
    }
}