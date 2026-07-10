package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lpu implements lox, lyu {
    private final lpu a;
    private final lqs b;
    private final Object c;
    private final Set<lyu> d;
    private boolean e;

    public lpu() {
        this(lqt.a);
    }

    private lpu(lpu lpuVar, lqs lqsVar) {
        this.b = lqsVar;
        this.c = new Object();
        this.d = new HashSet<>();
        this.a = lpuVar;
        this.e = false;
    }

    public lpu(lqs lqsVar) {
        this.b = lqsVar;
        this.c = new Object();
        this.d = new HashSet<>();
        this.a = null;
        this.e = false;
    }

    @Override
    public final lyu a(lyu lyuVar) {
        boolean z;
        ohr.b(lyuVar);
        synchronized (this.c) {
            if (!this.e) {
                this.d.add(lyuVar);
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.b.a(lyuVar);
        }
        return lyuVar;
    }

    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = this.e;
        }
        return z;
    }

    @Override
    public final lpu c() {
        return (lpu) a(new lpu(this, this.b));
    }

    public void close() {
        ArrayList<lyu> arrayList = new ArrayList<>();
        synchronized (this.c) {
            if (this.e) {
                return;
            }
            this.e = true;
            lpu lpuVar = this.a;
            if (lpuVar != null) {
                synchronized (lpuVar.c) {
                    lpuVar.d.remove(this);
                }
            }
            arrayList.addAll(this.d);
            this.d.clear();
            this.b.a(arrayList, "Lifetime#close");
        }
    }
}