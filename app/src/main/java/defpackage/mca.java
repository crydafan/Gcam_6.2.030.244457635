package defpackage;

import com.google.android.libraries.camera.exif.ExifInterface;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public final class mca {
    public static final int[] c = {0, 1, 2, 3, 4};
    public final int a;
    private final Map d = new TreeMap();
    public int b = 0;

    public mca(int i) {
        this.a = i;
    }

    public final mbx a(mbx mbxVar) {
        mbxVar.e = this.a;
        return (mbx) this.d.put(Short.valueOf(mbxVar.a), mbxVar);
    }

    public final mbx a(short s) {
        return (mbx) this.d.get(Short.valueOf(s));
    }

    protected final mbx[] a() {
        return (mbx[]) this.d.values().toArray(new mbx[this.d.size()]);
    }

    protected final int b() {
        return this.d.size();
    }

    protected final void b(short s) {
        this.d.remove(Short.valueOf(s));
    }

    public final boolean equals(Object obj) {
        mbx[] a;
        if (this != obj) {
            if (obj != null && (obj instanceof mca)) {
                mca mcaVar = (mca) obj;
                if (mcaVar.a == this.a && mcaVar.b() == b()) {
                    for (mbx mbxVar : mcaVar.a()) {
                        if (mbxVar != null && !ExifInterface.a(mbxVar.a) && !mbxVar.equals((mbx) this.d.get(Short.valueOf(mbxVar.a)))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), this.d});
    }
}