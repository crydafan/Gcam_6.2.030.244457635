package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

final class oxh extends AbstractList implements Serializable, RandomAccess {
    public static final long serialVersionUID = 0;
    private final float[] a;
    private final int b;
    private final int c;

    oxh(float[] fArr) {
        this(fArr, 0, fArr.length);
    }

    private oxh(float[] fArr, int i, int i2) {
        this.a = fArr;
        this.b = i;
        this.c = i2;
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.a;
            float floatValue = ((Float) obj).floatValue();
            int i = this.b;
            int i2 = this.c;
            while (i < i2) {
                if (fArr[i] == floatValue) {
                    return i != -1;
                }
                i++;
            }
            return false;
        }
        return false;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof oxh)) {
                return super.equals(obj);
            }
            oxh oxhVar = (oxh) obj;
            int size = size();
            if (oxhVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.b + i] != oxhVar.a[oxhVar.b + i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public final Object get(int i) {
        ohr.a(i, size());
        return Float.valueOf(this.a[this.b + i]);
    }

    @Override
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.b; i2 < this.c; i2++) {
            i = (i * 31) + Float.valueOf(this.a[i2]).hashCode();
        }
        return i;
    }

    @Override
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.a;
            float floatValue = ((Float) obj).floatValue();
            int i = this.b;
            int i2 = this.c;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (fArr[i] == floatValue) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                return i - this.b;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.a;
            float floatValue = ((Float) obj).floatValue();
            int i = this.b;
            int i2 = this.c - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                } else if (fArr[i2] == floatValue) {
                    break;
                } else {
                    i2--;
                }
            }
            if (i2 >= 0) {
                return i2 - this.b;
            }
        }
        return -1;
    }

    @Override
    public final Object set(int i, Object obj) {
        ohr.a(i, size());
        float[] fArr = this.a;
        int i2 = this.b + i;
        float f = fArr[i2];
        fArr[i2] = ((Float) ohr.b((Float) obj)).floatValue();
        return Float.valueOf(f);
    }

    @Override
    public final int size() {
        return this.c - this.b;
    }

    @Override
    public final List subList(int i, int i2) {
        ohr.a(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        float[] fArr = this.a;
        int i3 = this.b;
        return new oxh(fArr, i + i3, i3 + i2);
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 12);
        sb.append('[');
        sb.append(this.a[this.b]);
        int i = this.b;
        while (true) {
            i++;
            if (i >= this.c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.a[i]);
        }
    }
}