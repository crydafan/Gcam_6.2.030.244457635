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

    public static Object a(ozs ozsVar) {
        try {
            return ozsVar.get();
        } catch (ExecutionException | InterruptedException e) {
            try {
                throw new mbl(e);
            } catch (mbl ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}