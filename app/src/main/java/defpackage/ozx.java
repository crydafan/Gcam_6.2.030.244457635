package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ozx implements Executor {
    public boolean a = true;
    private final Executor b;
    private final oxp c;

    public ozx(Executor executor, oxp oxpVar) {
        this.b = executor;
        this.c = oxpVar;
    }

    @Override
    public final void execute(Runnable runnable) {
        try {
            this.b.execute(new ozy(this, runnable));
        } catch (RejectedExecutionException e) {
            if (!this.a) {
                return;
            }
            this.c.a((Throwable) e);
        }
    }
}