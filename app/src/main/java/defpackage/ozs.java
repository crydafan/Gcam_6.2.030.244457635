package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface ozs extends Future {
    void a(Runnable runnable, Executor executor);
}