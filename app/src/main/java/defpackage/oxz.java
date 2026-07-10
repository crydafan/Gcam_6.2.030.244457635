package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class oxz extends oxp implements oxy {
    @Override
    public boolean cancel(boolean b) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public final Object get(long j, TimeUnit timeUnit) {
        return super.get(j, timeUnit);
    }

    @Override
    public void a(Runnable runnable, Executor executor) {

    }
}