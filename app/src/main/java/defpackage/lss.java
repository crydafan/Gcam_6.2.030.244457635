package defpackage;

import java.util.concurrent.Executor;

public abstract class lss implements lsg {
    private final lsg a;
    private final lrm b;

    public lss(lsg lsgVar) {
        this.a = lsgVar;
        this.b = lrn.a(lsgVar, new lst(this));
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        return this.b.a(lzbVar, executor);
    }

    @Override // defpackage.lzb
    public final void a(Object obj) {
        ohr.b(obj);
        Object b = b(obj);
        if (b != null) {
            this.a.a(b);
            return;
        }
        String valueOf = String.valueOf(obj);
        String name = getClass().getName();
        String sb = "Transforming output value: " + valueOf + " resulted in a null input value for: " + name;
        throw new NullPointerException(sb);
    }

    public abstract Object b(Object obj);

    @Override // defpackage.lrm
    public Object b_() {
        return this.b.b_();
    }

    public abstract Object c(Object obj);
}