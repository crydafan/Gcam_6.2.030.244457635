package defpackage;

import java.util.Arrays;

public final class gqp implements Comparable {
    public final long a;
    public final long b;
    public final long c;

    public gqp(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    @Override
    public final int compareTo(Object obj) {
        return (this.b > ((gqp) obj).b ? 1 : (this.b == ((gqp) obj).b ? 0 : -1));
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && (obj instanceof gqp)) {
                gqp gqpVar = (gqp) obj;
                if (this.b == gqpVar.b && this.a == gqpVar.a && this.c == gqpVar.c) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c)});
    }

    public final String toString() {
        return oxl.c(this).a("timestamp", this.a).a("onStartedId", this.b).a("frameNumber", this.c).toString();
    }
}