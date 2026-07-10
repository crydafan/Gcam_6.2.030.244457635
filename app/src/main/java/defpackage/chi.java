package defpackage;

import android.widget.Toast;

final class chi implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ int b;
    private final /* synthetic */ chh c;

    chi(chh chhVar, String str, int i) {
        this.c = chhVar;
        this.a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.c.a, this.a, this.b).show();
    }
}