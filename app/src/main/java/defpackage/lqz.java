package defpackage;

import java.util.concurrent.RejectedExecutionException;

public final class lqz implements Runnable {
    private final Object a;
    private final lqy b;

    public lqz(lqy lqyVar, Object obj) {
        this.b = lqyVar;
        this.a = obj;
    }

    @Override
    public final void run() {
        lqy lqyVar = this.b;
        lqyVar.c = this.a;
        for (lzb lzbVar : lqyVar.b) {
            try {
                lzbVar.a(this.a);
            } catch (RejectedExecutionException e) {
            }
        }
    }
}