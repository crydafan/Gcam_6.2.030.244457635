package defpackage;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public class lqy implements bxs, lsg {
    private final Executor a;
    public final Set<lzb> b;
    public volatile Object c;

    public lqy(Object obj) {
        this.b = new CopyOnWriteArraySet<>();
        this.c = obj;
        this.a = null; //new lsh();
    }

    public lqy(ltm ltmVar) {
        this((Object) ltmVar);
    }

    @Override
    public final lyu a(lzb lzbVar, Executor executor) {
        /*lpe lpeVar = new lpe(lzbVar, executor);
        this.b.add(lpeVar);
        this.a.execute(new lra(this, lpeVar));
        return new lrb(this, lpeVar);*/
        return null;
    }

    @Override
    public final void a(Object obj) {
        this.a.execute(new lqz(this, obj));
    }

    @Override
    public final Object b_() {
        return this.c;
    }
}