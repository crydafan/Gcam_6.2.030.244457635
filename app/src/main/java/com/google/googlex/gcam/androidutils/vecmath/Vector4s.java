package com.google.googlex.gcam.androidutils.vecmath;

public class Vector4s {
    public short w;
    public short x;
    public short y;
    public short z;

    public Vector4s() {
    }

    public Vector4s(Vector4s vector4s) {
        this.x = vector4s.x;
        this.y = vector4s.y;
        this.z = vector4s.z;
        this.w = vector4s.w;
    }

    public Vector4s(short s, short s2, short s3, short s4) {
        this.x = s;
        this.y = s2;
        this.z = s3;
        this.w = s4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector4s) {
            if (obj == this) {
                return true;
            }
            Vector4s vector4s = (Vector4s) obj;
            return this.x == vector4s.x && this.y == vector4s.y && this.z == vector4s.z && this.w == vector4s.w;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.z) * 31) + this.w;
    }

    public String toString() {
        short s = this.x;
        short s2 = this.y;
        short s3 = this.z;
        short s4 = this.w;
        StringBuilder sb = new StringBuilder(32);
        sb.append("(");
        sb.append((int) s);
        sb.append(", ");
        sb.append((int) s2);
        sb.append(", ");
        sb.append((int) s3);
        sb.append(", ");
        sb.append((int) s4);
        sb.append(")");
        return sb.toString();
    }

    public String toStringUnsigned() {
        short s = this.x;
        short s2 = this.y;
        short s3 = this.z;
        short s4 = this.w;
        StringBuilder sb = new StringBuilder(52);
        sb.append("(");
        sb.append((int) ((char) s));
        sb.append(", ");
        sb.append((int) ((char) s2));
        sb.append(", ");
        sb.append((int) ((char) s3));
        sb.append(", ");
        sb.append((int) ((char) s4));
        sb.append(")");
        return sb.toString();
    }
}
