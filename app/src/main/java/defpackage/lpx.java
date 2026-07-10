package defpackage;

import android.os.Handler;
import android.os.Looper;

public final class lpx extends lpr {
    private static final ThreadLocal a = new lpy();

    public lpx() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static void a() {
        ohr.b(b(), "Not main thread.");
    }

    public static boolean b() {
        Boolean bool = (Boolean) a.get();
        return bool != null && bool;
    }

    public final void a(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            execute(runnable);
        }
    }
}