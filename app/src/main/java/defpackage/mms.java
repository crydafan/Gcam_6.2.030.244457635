package defpackage;

public enum mms {
    a(128),
    b(2),
    c(1),
    d(0);
    
    public final int e;

    mms(int i) {
        this.e = i;
    }

    public static mms a(int i) {
        return i != 1 ? i != 2 ? i != 128 ? d : a : b : c;
    }
}