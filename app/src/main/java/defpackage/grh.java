package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class grh {
    public final int a;
    public final Set<gri> b;
    public final Set<itp> c;
    public final Set<gqy> d;
    public final nyp e;

    public grh(int i, Set<gri> set, Set<itp> set2, Set<gqy> set3, nyp nypVar) {
        this.a = i;
        this.b = oet.a((Collection) set);
        this.c = oet.a((Collection) set2);
        this.d = oet.a((Collection) set3);
        this.e = nypVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof grh)) {
            return false;
        }
        grh grhVar = (grh) obj;
        return oxl.c(this.a, grhVar.a) && oxl.c(this.b, grhVar.b) && oxl.c(this.d, grhVar.d) && oxl.c(this.c, grhVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, this.c});
    }
}