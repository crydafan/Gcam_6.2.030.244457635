package defpackage;

import java.io.Serializable;
import java.util.Map;

class oed implements Serializable {
    public static final long serialVersionUID = 0;
    private final Object[] a;
    private final Object[] b;

    oed(ody odyVar) {
        this.a = new Object[odyVar.size()];
        this.b = new Object[odyVar.size()];
        oji it = odyVar.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            this.a[i] = entry.getKey();
            this.b[i] = entry.getValue();
            i++;
        }
    }

    final Object a(oea oeaVar) {
        int i = 0;
        while (true) {
            Object[] objArr = this.a;
            if (i < objArr.length) {
                oeaVar.a(objArr[i], this.b[i]);
                i++;
            } else {
                return oeaVar.a();
            }
        }
    }

    Object readResolve() {
        return a(new oea(this.a.length));
    }
}