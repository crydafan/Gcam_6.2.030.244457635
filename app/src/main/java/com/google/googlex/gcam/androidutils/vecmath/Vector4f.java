package com.google.googlex.gcam.androidutils.vecmath;

public class Vector4f {
    public float w;
    public float x;
    public float y;
    public float z;

    public Vector4f() {
    }

    public Vector4f(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public Vector4f(Vector4f vector4f) {
        this.x = vector4f.x;
        this.y = vector4f.y;
        this.z = vector4f.z;
        this.w = vector4f.w;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector4f) {
            if (obj == this) {
                return true;
            }
            Vector4f vector4f = (Vector4f) obj;
            return this.x == vector4f.x && this.y == vector4f.y && this.z == vector4f.z && this.w == vector4f.w;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z)) * 31) + Float.floatToIntBits(this.w);
    }

    public String toString() {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.z;
        float f4 = this.w;
        StringBuilder sb = new StringBuilder(68);
        sb.append("(");
        sb.append(f);
        sb.append(", ");
        sb.append(f2);
        sb.append(", ");
        sb.append(f3);
        sb.append(", ");
        sb.append(f4);
        sb.append(")");
        return sb.toString();
    }
}
