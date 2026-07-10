package defpackage;

import java.util.concurrent.Future;

public final class ozj implements Runnable {
    private final Future a;
    private final ozi b;

    public ozj(Future future, ozi oziVar) {
        this.a = future;
        this.b = oziVar;
    }

    @Override
    public final void run() {
        try {
            this.b.a(qdr.b(this.a));
        } catch (Error e) {
            this.b.a(e);
        } catch (RuntimeException e2) {
            this.b.a(e2);
        } /*catch (ExecutionException e3) {
            this.b.a(e3.getCause());
        }*/
    }

    public final String toString() {
        nyn c = oxl.c(this);
        c.a().b = this.b;
        return c.toString();
    }
}