package defpackage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public final class lsh implements Executor {
    private final Object a = new Object();
    private boolean b = false;
    private final Queue<Runnable> c = new LinkedList<>();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Runnable runnable2;
        synchronized (this.a) {
            if (this.b) {
                this.c.add(runnable);
                return;
            }
            this.b = true;
            while (runnable != null) {
                runnable.run();
                synchronized (this.a) {
                    runnable2 = (Runnable) this.c.poll();
                    if (runnable2 == null) {
                        this.b = false;
                    }
                }
                runnable = runnable2;
            }
        }
    }
}