package defpackage;

import android.annotation.TargetApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(23)
public final class lrn {
    public static final lyu a = new lyr();

    static final /* synthetic */ Boolean a(Comparable comparable, Comparable comparable2) {
        return Boolean.valueOf(comparable2.compareTo(comparable) >= 0);
    }

    static final /* synthetic */ Integer a(List list) {
        Integer num = (Integer) list.get(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            num = Integer.valueOf(Math.min(num.intValue(), ((Integer) it.next()).intValue()));
        }
        return num;
    }

    public static lrm a(Object obj) {
        return new lry(obj);
    }

    public static lrm a(Object obj, ozs ozsVar) {
        lqy lqyVar = new lqy(a(obj));
        qdr.a(ozsVar, new lsb(lqyVar), oyx.INSTANCE);
        lrc lrcVar = new lrc(lqyVar);
        return null; //!(lrcVar instanceof lre) ? new lre(lrcVar) : lrcVar;
    }

    public static lrm a(Collection collection) {
        return a(e(collection), lro.a);
    }

    public static lrm a(lrm lrmVar) {
        lrc lrcVar = new lrc(lrmVar);
        return null; //!(lrcVar instanceof lre) ? new lre(lrcVar) : lrcVar;
    }

    public static lrm a(lrm lrmVar, Comparable comparable) {
        return a(lrmVar, new lrs(comparable));
    }

    public static lrm a(lrm lrmVar, lrm lrmVar2) {
        return a(c(lrmVar, lrmVar2), lru.a);
    }

    public static lrm a(lrm lrmVar, nyi nyiVar) {
        lrx lrxVar = new lrx(lrmVar, nyiVar, lrmVar);
        return null; //!(lrxVar instanceof lre) ? new lre(lrxVar) : lrxVar;
    }

    public static lrm a(ozs ozsVar) {
        lqy lqyVar = new lqy((Object) false);
        qdr.a(ozsVar, new lsa(lqyVar), oyx.INSTANCE);
        return lqyVar;
    }

    @SafeVarargs
    public static lrm a(lrm... lrmVarArr) {
        return a((Collection) Arrays.asList(lrmVarArr));
    }

    public static lyu a(lrm lrmVar, Runnable runnable, Executor executor) {
        ohr.b(lrmVar);
        ohr.b(runnable);
        ohr.b(executor);
        return lrmVar.a(new lrr(runnable), executor);
    }

    public static lyu a(lrm lrmVar, lzb lzbVar) {
        return lrmVar.a(lzbVar, null /*qdr.a()*/);
    }

    public static ozs a(lrm lrmVar, lpu lpuVar) {
        pag e = pag.e();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        lpu c = lpuVar.c();
        c.a(lrmVar.a(new lrw(atomicBoolean, c), oyx.INSTANCE));
        c.a(new lrq(e, atomicBoolean));
        return e;
    }

    static final /* synthetic */ void a(Runnable runnable) {
        runnable.run();
    }

    static final /* synthetic */ void a(AtomicBoolean atomicBoolean, lpu lpuVar, Boolean bool) {
        if (bool.booleanValue()) {
            atomicBoolean.set(true);
            lpuVar.close();
        }
    }

    static final /* synthetic */ void a(pag pagVar, AtomicBoolean atomicBoolean) {
        pagVar.b(Boolean.valueOf(atomicBoolean.get()));
    }

    static final /* synthetic */ Long b(List list) {
        return Long.valueOf(((Long) list.get(0)).longValue() - ((Long) list.get(1)).longValue());
    }

    public static lrm b(Collection collection) {
        ohr.a(!collection.isEmpty());
        return a(e(collection), lrp.a);
    }

    public static lrm b(lrm lrmVar) {
        return !(lrmVar instanceof lre) ? new lre(lrmVar) : lrmVar;
    }

    @SafeVarargs
    public static lrm b(lrm... lrmVarArr) {
        return b((Collection) Arrays.asList(lrmVarArr));
    }

    static final /* synthetic */ Integer c(List list) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Integer) it.next()).intValue();
        }
        return Integer.valueOf(i);
    }

    public static lrm c(Collection collection) {
        return a(e(collection), lrt.a);
    }

    @SafeVarargs
    public static lrm c(lrm... lrmVarArr) {
        ArrayList arrayList = new ArrayList();
        for (lrm lrmVar : lrmVarArr) {
            arrayList.add(lrmVar);
        }
        return e((Collection) arrayList);
    }

    static final /* synthetic */ Boolean d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((Boolean) it.next()) {
                return true;
            }
        }
        return false;
    }

    public static lrm d(Collection collection) {
        ohr.a(!collection.isEmpty());
        return a(e(collection), lrv.a);
    }

    static final /* synthetic */ Boolean e(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!(Boolean) it.next()) {
                return false;
            }
        }
        return true;
    }

    public static lrm e(Collection collection) {
        return new lrh(collection);
    }

    public static List f(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((lrm) it.next()).b_());
        }
        return arrayList;
    }
}