package defpackage;

public abstract class odo {
    odo() {
    }

    static int a(int i, int i2) {
        if (i2 >= 0) {
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 >= 0) {
                return i3;
            }
            return Integer.MAX_VALUE;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }

    public odo a(Iterable iterable) {
        for (Object obj : iterable) {
            b(obj);
        }
        return this;
    }

    public abstract odo b(Object obj);
}