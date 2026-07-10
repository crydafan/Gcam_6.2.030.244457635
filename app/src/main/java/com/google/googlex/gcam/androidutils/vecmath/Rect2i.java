package com.google.googlex.gcam.androidutils.vecmath;

public class Rect2i {
    public final Vector2i origin;
    public final Vector2i size;

    public Rect2i() {
        this.origin = new Vector2i();
        this.size = new Vector2i();
    }

    public Rect2i(int i, int i2) {
        this.origin = new Vector2i();
        this.size = new Vector2i(i, i2);
    }

    public Rect2i(int i, int i2, int i3, int i4) {
        this.origin = new Vector2i(i, i2);
        this.size = new Vector2i(i3, i4);
    }

    public Rect2i(Rect2i rect2i) {
        this.origin = new Vector2i(rect2i.origin());
        this.size = new Vector2i(rect2i.size());
    }

    public Rect2i(Vector2i vector2i, Vector2i vector2i2) {
        this.origin = new Vector2i(vector2i);
        this.size = new Vector2i(vector2i2);
    }

    public static Rect2i flipUD(Rect2i rect2i, int i) {
        Rect2i standardized = rect2i.standardized();
        standardized.origin().y = i - standardized.max().y;
        return standardized.standardized();
    }

    public static Rect2i fromPoints(Vector2i vector2i, Vector2i vector2i2) {
        int i = vector2i.x;
        int i2 = vector2i.y;
        return new Rect2i(i, i2, vector2i2.x - i, vector2i2.y - i2).standardized();
    }

    public Vector4i asOriginAndSize() {
        Vector2i vector2i = this.origin;
        int i = vector2i.x;
        int i2 = vector2i.y;
        Vector2i vector2i2 = this.size;
        return new Vector4i(i, i2, vector2i2.x, vector2i2.y);
    }

    public int height() {
        return this.size.y;
    }

    public Vector2i max() {
        Vector2i vector2i = this.origin;
        return VecmathFunctions.max(vector2i, VecmathFunctions.add(vector2i, this.size));
    }

    public Vector2i min() {
        Vector2i vector2i = this.origin;
        return VecmathFunctions.min(vector2i, VecmathFunctions.add(vector2i, this.size));
    }

    public Vector2i origin() {
        return this.origin;
    }

    public Vector2i size() {
        return this.size;
    }

    public Rect2i standardized() {
        int i;
        int i2;
        Vector2i vector2i = this.size;
        int i3 = vector2i.x;
        if (i3 > 0) {
            i = this.origin.x;
        } else {
            i = this.origin.x + i3;
            i3 = -i3;
        }
        int i4 = vector2i.y;
        if (i4 > 0) {
            i2 = this.origin.y;
        } else {
            i2 = this.origin.y + i4;
            i4 = -i4;
        }
        return new Rect2i(i, i2, i3, i4);
    }

    public String toString() {
        return String.format("Rect2f: origin = (%d, %d), size = (%d, %d)", Integer.valueOf(this.origin.x), Integer.valueOf(this.origin.y), Integer.valueOf(this.size.x), Integer.valueOf(this.size.y));
    }

    public int width() {
        return this.size.x;
    }
}
