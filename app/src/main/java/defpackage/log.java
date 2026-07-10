package defpackage;

import android.database.ContentObserver;

final class log extends ContentObserver {
    log() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        lof.a.set(true);
    }
}