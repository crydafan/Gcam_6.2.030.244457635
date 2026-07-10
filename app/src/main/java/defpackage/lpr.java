package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

public class lpr implements Executor {
    private final Handler a;

    public lpr(Handler handler) {
        this.a = handler;
    }

    @Override
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}