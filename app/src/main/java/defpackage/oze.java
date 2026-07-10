package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class oze extends ozb {
    private final ozs e;

    oze(ozs ozsVar) {
        this.e = ohr.b(ozsVar);
    }

    @Override
    public final void a(Runnable runnable, Executor executor) {
        this.e.a(runnable, executor);
    }

    @Override
    public final boolean cancel(boolean z) {
        return this.e.cancel(z);
    }

    @Override
    public final Object get() {
        try {
            return this.e.get();
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public final Object get(long j, TimeUnit timeUnit) {
        try {
            return this.e.get(j, timeUnit);
        } catch (ExecutionException | InterruptedException | TimeoutException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public final boolean isCancelled() {
        return this.e.isCancelled();
    }

    @Override
    public final boolean isDone() {
        return this.e.isDone();
    }
}