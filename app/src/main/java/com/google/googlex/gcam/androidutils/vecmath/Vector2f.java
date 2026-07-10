package com.google.googlex.gcam.androidutils.vecmath;

public class Vector2f {
    public float x;
    public float y;

    public Vector2f() {
    }

    public Vector2f(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Vector2f(Vector2f vector2f) {
        this.x = vector2f.x;
        this.y = vector2f.y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector2f) {
            if (obj == this) {
                return true;
            }
            Vector2f vector2f = (Vector2f) obj;
            return this.x == vector2f.x && this.y == vector2f.y;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    public String toString() {
        float f = this.x;
        float f2 = this.y;
        StringBuilder sb = new StringBuilder(34);
        sb.append("(");
        sb.append(f);
        sb.append(", ");
        sb.append(f2);
        sb.append(")");
        return sb.toString();
    }
}
