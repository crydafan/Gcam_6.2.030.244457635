package com.google.googlex.gcam.androidutils.vecmath;

public class Vector4i {
    public int w;
    public int x;
    public int y;
    public int z;

    public Vector4i() {
    }

    public Vector4i(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.w = i4;
    }

    public Vector4i(Vector4i vector4i) {
        this.x = vector4i.x;
        this.y = vector4i.y;
        this.z = vector4i.z;
        this.w = vector4i.w;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector4i) {
            if (obj == this) {
                return true;
            }
            Vector4i vector4i = (Vector4i) obj;
            return this.x == vector4i.x && this.y == vector4i.y && this.z == vector4i.z && this.w == vector4i.w;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.z) * 31) + this.w;
    }

    public String toString() {
        int i = this.x;
        int i2 = this.y;
        int i3 = this.z;
        int i4 = this.w;
        StringBuilder sb = new StringBuilder(52);
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(")");
        return sb.toString();
    }

    public String toStringUnsigned() {
        String d = ""; //qdr.d(this.x);
        String d2 = ""; //qdr.d(this.y);
        String d3 = ""; //qdr.d(this.z);
        String d4 = ""; //qdr.d(this.w);
        int length = String.valueOf(d).length();
        int length2 = String.valueOf(d2).length();
        StringBuilder sb = new StringBuilder(length + 8 + length2 + String.valueOf(d3).length() + String.valueOf(d4).length());
        sb.append("(");
        sb.append(d);
        sb.append(", ");
        sb.append(d2);
        sb.append(", ");
        sb.append(d3);
        sb.append(", ");
        sb.append(d4);
        sb.append(")");
        return sb.toString();
    }
}
