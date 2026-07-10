package defpackage;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public final class mbn {
    public byte[] b;
    public final ByteOrder d;
    public final mca[] a = new mca[5];
    public final ArrayList c = new ArrayList();

    public mbn(ByteOrder byteOrder) {
        this.d = byteOrder;
    }

    public final mbx a(mbx mbxVar) {
        if (mbxVar != null) {
            int i = mbxVar.e;
            if (mbxVar != null && mbx.a(i)) {
                mca mcaVar = this.a[i];
                if (mcaVar == null) {
                    mcaVar = new mca(i);
                    this.a[i] = mcaVar;
                }
                return mcaVar.a(mbxVar);
            }
        }
        return null;
    }

    public final void a(mca mcaVar) {
        this.a[mcaVar.a] = mcaVar;
    }

    public final void a(short s, int i) {
        mca mcaVar = this.a[i];
        if (mcaVar != null) {
            mcaVar.b(s);
        }
    }

    protected final boolean a() {
        return this.b != null;
    }

    protected final byte[] a(int i) {
        return (byte[]) this.c.get(i);
    }

    public final mca b(int i) {
        if (mbx.a(i)) {
            return this.a[i];
        }
        return null;
    }

    protected final boolean b() {
        return this.c.size() != 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && (obj instanceof mbn)) {
                mbn mbnVar = (mbn) obj;
                if (mbnVar.d == this.d && mbnVar.c.size() == this.c.size() && Arrays.equals(mbnVar.b, this.b)) {
                    for (int i = 0; i < this.c.size(); i++) {
                        if (!Arrays.equals((byte[]) mbnVar.c.get(i), (byte[]) this.c.get(i))) {
                            return false;
                        }
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        mca b = mbnVar.b(i2);
                        mca b2 = b(i2);
                        if (b != null && !b.equals(b2)) {
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
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.a)), Integer.valueOf(Arrays.hashCode(this.b)), this.c, this.d});
    }
}