package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class qdr {
    public static Object a(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException e) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                try {
                    throw th;
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static Object b(Future future) {
        if (future.isDone()) {
            return a(future);
        }
        throw new IllegalStateException(ohr.a("Future was expected to be done: %s", future));
    }

    public static ozs b(Object obj) {
        return obj != null ? new ozp(obj) : ozp.a;
    }

    public static ozs a(Throwable th) {
        ohr.b(th);
        return new ozo(th);
    }

    public static Object c(Future future) {
        ohr.b(future);
        try {
            return a(future);
        } catch (/*Execution*/Exception e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof Error)) {
                throw new pam(cause);
            }
            throw new oyy((Error) cause);
        }
    }

    public static void a(ozs ozsVar, ozi oziVar, Executor executor) {
        ohr.b(oziVar);
        ozsVar.a(new ozj(ozsVar, oziVar), executor);
    }

    public static ozs a(Iterable iterable) {
        return new oyh(ods.a(iterable), true);
    }

    public static Executor a(Executor executor, oxp oxpVar) {
        ohr.b(executor);
        ohr.b(oxpVar);
        return executor != oyx.INSTANCE ? new ozx(executor, oxpVar) : executor;
    }
}
