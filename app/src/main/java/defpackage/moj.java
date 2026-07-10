package defpackage;

public final class moj {
    public int a;
    public int b;
    public int c;
    public long d;
    public long e;
    public float f;
    public float g;
    public float h;

    public moj() {
        this(0, 0, 0, 0L, 0L, 0.0f, 0.0f, 0.0f);
    }

    public moj(int i, int i2, int i3, long j, long j2, float f, float f2, float f3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = f;
        this.g = f2;
        this.h = f3;
    }

    public final void a(moj mojVar) {
        this.a = mojVar.a;
        this.b = mojVar.b;
        this.c = mojVar.c;
        this.d = mojVar.d;
        this.e = mojVar.e;
        this.f = mojVar.f;
        this.g = mojVar.g;
        this.h = mojVar.h;
    }

    public final /* synthetic */ Object clone() {
        return new moj(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof moj) {
                moj mojVar = (moj) obj;
                return this.a == mojVar.a && this.b == mojVar.b && this.c == mojVar.c && this.d == mojVar.d && this.e == mojVar.e && this.f == mojVar.f && this.g == mojVar.g && this.h == mojVar.h;
            }
            return false;
        }
        return false;
    }
}