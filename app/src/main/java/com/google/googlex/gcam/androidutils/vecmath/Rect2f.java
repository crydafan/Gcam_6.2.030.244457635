package com.google.googlex.gcam.androidutils.vecmath;

import android.graphics.Rect;

public class Rect2f {
    public final Vector2f origin;
    public final Vector2f size;

    public Rect2f() {
        this.origin = new Vector2f();
        this.size = new Vector2f();
    }

    public Rect2f(float f, float f2) {
        this.origin = new Vector2f();
        this.size = new Vector2f(f, f2);
    }

    public Rect2f(float f, float f2, float f3, float f4) {
        this.origin = new Vector2f(f, f2);
        this.size = new Vector2f(f3, f4);
    }

    public Rect2f(Rect2f rect2f) {
        this.origin = new Vector2f(rect2f.origin());
        this.size = new Vector2f(rect2f.size());
    }

    public Rect2f(Vector2f vector2f, Vector2f vector2f2) {
        this.origin = new Vector2f(vector2f);
        this.size = new Vector2f(vector2f2);
    }

    public static Rect2f flipUD(Rect2f rect2f, float f) {
        Rect2f standardized = rect2f.standardized();
        standardized.origin().y = f - standardized.max().y;
        return standardized.standardized();
    }

    public static Rect2f fromPoints(Vector2f vector2f, Vector2f vector2f2) {
        float f = vector2f.x;
        float f2 = vector2f.y;
        return new Rect2f(f, f2, vector2f2.x - f, vector2f2.y - f2).standardized();
    }

    public static Rect2f fromRect(Rect rect) {
        return new Rect2f(rect.left, rect.top, rect.width(), rect.height());
    }

    public Vector4f asOriginAndSize() {
        Vector2f vector2f = this.origin;
        float f = vector2f.x;
        float f2 = vector2f.y;
        Vector2f vector2f2 = this.size;
        return new Vector4f(f, f2, vector2f2.x, vector2f2.y);
    }

    public float height() {
        return this.size.y;
    }

    public Vector2f max() {
        Vector2f vector2f = this.origin;
        return VecmathFunctions.max(vector2f, VecmathFunctions.add(vector2f, this.size));
    }

    public Vector2f min() {
        Vector2f vector2f = this.origin;
        return VecmathFunctions.min(vector2f, VecmathFunctions.add(vector2f, this.size));
    }

    public Vector2f origin() {
        return this.origin;
    }

    public Vector2f size() {
        return this.size;
    }

    public Rect2f standardized() {
        float f;
        float f2;
        Vector2f vector2f = this.size;
        float f3 = vector2f.x;
        if (f3 > 0.0f) {
            f = this.origin.x;
        } else {
            f = this.origin.x + f3;
            f3 = -f3;
        }
        float f4 = vector2f.y;
        if (f4 > 0.0f) {
            f2 = this.origin.y;
        } else {
            f2 = this.origin.y + f4;
            f4 = -f4;
        }
        return new Rect2f(f, f2, f3, f4);
    }

    public String toString() {
        return String.format("Rect2f: origin = (%f, %f), size = (%f, %f)", Float.valueOf(this.origin.x), Float.valueOf(this.origin.y), Float.valueOf(this.size.x), Float.valueOf(this.size.y));
    }

    public float width() {
        return this.size.x;
    }
}
