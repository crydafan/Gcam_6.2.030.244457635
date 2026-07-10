package com.google.googlex.gcam.androidutils.vecmath;

public class Vector4b {
    public byte w;
    public byte x;
    public byte y;
    public byte z;

    public Vector4b() {
    }

    public Vector4b(byte b, byte b2, byte b3, byte b4) {
        this.x = b;
        this.y = b2;
        this.z = b3;
        this.w = b4;
    }

    public Vector4b(int i, int i2, int i3, int i4) {
        this.x = (byte) i;
        this.y = (byte) i2;
        this.z = (byte) i3;
        this.w = (byte) i4;
    }

    public Vector4b(Vector4b vector4b) {
        this.x = vector4b.x;
        this.y = vector4b.y;
        this.z = vector4b.z;
        this.w = vector4b.w;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector4b) {
            if (obj == this) {
                return true;
            }
            Vector4b vector4b = (Vector4b) obj;
            return this.x == vector4b.x && this.y == vector4b.y && this.z == vector4b.z && this.w == vector4b.w;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.z) * 31) + this.w;
    }

    public String toString() {
        byte b = this.x;
        byte b2 = this.y;
        byte b3 = this.z;
        byte b4 = this.w;
        StringBuilder sb = new StringBuilder(24);
        sb.append("(");
        sb.append((int) b);
        sb.append(", ");
        sb.append((int) b2);
        sb.append(", ");
        sb.append((int) b3);
        sb.append(", ");
        sb.append((int) b4);
        sb.append(")");
        return sb.toString();
    }

    public String toStringUnsigned() {
        String a = "";//oxl.a(this.x);
        String a2 = "";//oxl.a(this.y);
        String a3 = "";//oxl.a(this.z);
        String a4 = "";//oxl.a(this.w);
        int length = String.valueOf(a).length();
        int length2 = String.valueOf(a2).length();
        StringBuilder sb = new StringBuilder(length + 8 + length2 + String.valueOf(a3).length() + String.valueOf(a4).length());
        sb.append("(");
        sb.append(a);
        sb.append(", ");
        sb.append(a2);
        sb.append(", ");
        sb.append(a3);
        sb.append(", ");
        sb.append(a4);
        sb.append(")");
        return sb.toString();
    }
}
