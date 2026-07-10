package defpackage;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class lpg {
    public static Object a(ozs ozsVar) {
        Object obj;
        if (!ozsVar.isDone() || ozsVar.isCancelled()) {
            return null;
        }
        boolean z = false;
        while (true) {
            try {
                obj = ozsVar.get();
                break;
            } catch (InterruptedException e) {
                z = true;
            } catch (ExecutionException e2) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                return null;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static ozs a(ozs ozsVar, ozs ozsVar2, lpn lpnVar) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(ozsVar);
        arrayList.add(ozsVar2);
        return oye.a(qdr.a(arrayList), new lph(lpnVar), oyx.INSTANCE);
    }

    public static ozs a(ozs ozsVar, ozs ozsVar2, lpn lpnVar, Executor executor) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(ozsVar);
        arrayList.add(ozsVar2);
        return oye.a(qdr.a(arrayList), new lpi(lpnVar), executor);
    }

    public static ozs a(ozs ozsVar, ozs ozsVar2, lyl lylVar) {
        return a(ozsVar, ozsVar2, new lpq(lylVar));
    }

    public static void a(ozs ozsVar, lyd lydVar) {
        a(ozsVar, lydVar, oyx.INSTANCE);
    }

    public static void a(ozs ozsVar, lyd lydVar, Executor executor) {
        qdr.a(ozsVar, new lpm(lydVar), executor);
    }
}