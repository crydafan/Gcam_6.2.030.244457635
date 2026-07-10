package defpackage;

public final class mmp {
    public final String a;
    public final int b;
    private final Integer c;

    private mmp(Integer num, String str, int i) {
        this.c = num;
        this.a = str;
        this.b = i;
    }

    private static Integer a(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static mmp a(String str, int i) {
        return new mmp(a(str), str, i);
    }

    public final boolean a() {
        return this.c != null;
    }

    public final int b() {
        Integer num = this.c;
        if (num == null) {
            String valueOf = String.valueOf(this.a);
            throw new UnsupportedOperationException(valueOf.length() == 0 ? new String("Attempted to access a camera id that is not supported on legacy camera API's: ") : "Attempted to access a camera id that is not supported on legacy camera API's: ".concat(valueOf));
        }
        return num.intValue();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return obj != null && getClass() == obj.getClass() && this.b == ((mmp) obj).b;
        }
        return true;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        int i = this.b;
        String str = this.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append("(");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }
}