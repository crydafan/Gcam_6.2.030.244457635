package defpackage;

import android.view.View;

public final class ayf implements aye, lyu {
    public final cnu a;
    public final gjs b;
    private final lyu f;
    private boolean g;
    public final pag c = pag.e();
    public final pag d = pag.e();
    public final View.OnClickListener e = new View.OnClickListener() {
        @Override
        public final void onClick(View view) {
            ayf ayfVar = ayf.this;
            //ayfVar.d.b((Object) true);
            ayfVar.a.a(false);
            ayfVar.a.c();
            ayfVar.b.f();
            ayfVar.a.a(null);
        }
    };
    private final View.OnClickListener h = new View.OnClickListener() {
        @Override
        public final void onClick(View view) {
            ayf ayfVar = ayf.this;
            //ayfVar.c.b((Object) true);
            ayfVar.a.a(true);
            ayfVar.b.e();
            ayfVar.a.a(ayfVar.e);
        }
    };

    public ayf(cnu cnuVar, cnt cntVar, gjs gjsVar) {
        this.a = cnuVar;
        this.b = gjsVar;
        cnuVar.a(this.h);
        //this.f = cntVar.b.a(new ayi(this), oyx.INSTANCE);
        this.f = null;
    }

    @Override
    public final ozs a() {
        return this.c;
    }

    @Override
    public final ozs b() {
        return this.d;
    }

    @Override
    public final void close() {
        if (!this.g) {
            this.g = true;
            this.f.close();
            this.a.a(null);
            if (!this.c.isDone()) {
                //this.c.b((Object) false);
            }
            if (this.d.isDone()) {
                return;
            }
            //this.d.b((Object) false);
        }
    }
}