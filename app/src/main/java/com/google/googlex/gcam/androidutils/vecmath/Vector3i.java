package com.google.googlex.gcam.androidutils.vecmath;

public class Vector3i {
    public int x;
    public int y;
    public int z;

    public Vector3i() {
    }

    public Vector3i(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
    }

    public Vector3i(Vector3i vector3i) {
        this.x = vector3i.x;
        this.y = vector3i.y;
        this.z = vector3i.z;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector3i) {
            if (obj == this) {
                return true;
            }
            Vector3i vector3i = (Vector3i) obj;
            return this.x == vector3i.x && this.y == vector3i.y && this.z == vector3i.z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.x * 31) + this.y) * 31) + this.z;
    }

    public String toString() {
        int i = this.x;
        int i2 = this.y;
        int i3 = this.z;
        StringBuilder sb = new StringBuilder(39);
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(")");
        return sb.toString();
    }

    public String toStringUnsigned() {
        String d = "";//qdr.d(this.x);
        String d2 = "";//qdr.d(this.y);
        String d3 = "";//qdr.d(this.z);
        int length = String.valueOf(d).length();
        StringBuilder sb = new StringBuilder(length + 6 + String.valueOf(d2).length() + String.valueOf(d3).length());
        sb.append("(");
        sb.append(d);
        sb.append(", ");
        sb.append(d2);
        sb.append(", ");
        sb.append(d3);
        sb.append(")");
        return sb.toString();
    }
}
