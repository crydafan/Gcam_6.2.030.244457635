package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class lqa implements Executor {
    private final lpx a;

    public lqa(lpx lpxVar) {
        this.a = lpxVar;
    }

    @Override
    public final void execute(final Runnable runnable) {
        if (lpx.b()) {
            runnable.run();
            return;
        }
        final pag e = pag.e();
        this.a.execute(new Runnable() {
            @Override
            public final void run() {
                pag pagVar = e;
                try {
                    runnable.run();
                    pagVar.b(true);
                } catch (Throwable th) {
                    try {
                        pagVar.a(th);
                    } finally {
                        pagVar.b(false);
                    }
                }
            }
        });
        try {
            e.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }
}