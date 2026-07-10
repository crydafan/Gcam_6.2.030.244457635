package defpackage;

import java.io.Serializable;
import java.util.List;

public final class nyv implements Serializable, nyu {
    public static final long serialVersionUID = 0;
    private final List a;

    public nyv(List list) {
        this.a = list;
    }

    @Override
    public final boolean a(Object obj) {
        for (int i = 0; i < this.a.size(); i++) {
            if (!((nyu) this.a.get(i)).a(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof nyv) {
            return this.a.equals(((nyv) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 306654252;
    }

    public final String toString() {
        List list = this.a;
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and(");
        boolean z = true;
        for (Object obj : list) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}