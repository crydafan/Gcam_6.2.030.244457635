package defpackage;

import android.os.Looper;

final class lpy extends ThreadLocal {
    @Override
    protected final Object initialValue() {
        return Looper.getMainLooper().isCurrentThread();
    }
}