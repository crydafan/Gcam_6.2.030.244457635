package defpackage;

import android.view.Surface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class itp {
    public itp() {
    }

    public itp(byte b) {
        this();
    }

    public itp(char c) {
        this();
    }

    public static List a(List list, String str) {
        String[] split = str.split(",");
        if (split.length != 0) {
            HashSet hashSet = new HashSet(ohr.a((Object[]) split));
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                lyw lywVar = (lyw) it.next();
                if (!a(lywVar, hashSet)) {
                    arrayList.add(lywVar);
                }
            }
            return arrayList;
        }
        return list;
    }

    public static boolean a(lyw lywVar, Set set) {
        int i = lywVar.a;
        int i2 = lywVar.b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return set.contains(sb.toString());
    }

    public void a(int i) {
    }

    public void a(int i, long j) {
    }

    public void a(Surface surface, long j) {
    }

    public void a(gqp gqpVar) {
    }

    public void a(mpw mpwVar) {
    }

    public void a(mpz mpzVar) {
    }

    public void a_(mqc mqcVar) {
    }

    public void b(gqp gqpVar) {
    }
}