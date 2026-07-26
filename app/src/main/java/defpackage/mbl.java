package defpackage;

import java.util.concurrent.ExecutionException;

public class mbl extends Exception {
    public mbl() {
    }

    public mbl(String str) {
        super(str);
    }

    public mbl(Throwable th) {
        super(th);
    }

    public static Object a(ozs ozsVar) throws InterruptedException, mbl {
        try {
            return ozsVar.get();
        } catch (ExecutionException e) {
            throw new mbl(e);
        }
    }
}