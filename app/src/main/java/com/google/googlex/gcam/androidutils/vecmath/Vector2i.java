package com.google.googlex.gcam.androidutils.vecmath;

public class Vector2i {
    public int x;
    public int y;

    public Vector2i() {
    }

    public Vector2i(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Vector2i(Vector2i vector2i) {
        this.x = vector2i.x;
        this.y = vector2i.y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector2i) {
            if (obj == this) {
                return true;
            }
            Vector2i vector2i = (Vector2i) obj;
            return this.x == vector2i.x && this.y == vector2i.y;
        }
        return false;
    }

    public int hashCode() {
        return (this.x * 31) + this.y;
    }

    public String toString() {
        int i = this.x;
        int i2 = this.y;
        StringBuilder sb = new StringBuilder(26);
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(")");
        return sb.toString();
    }

    public String toStringUnsigned() {
        String d = ""; //qdr.d(this.x);
        String d2 = ""; //qdr.d(this.y);
        StringBuilder sb = new StringBuilder(String.valueOf(d).length() + 4 + String.valueOf(d2).length());
        sb.append("(");
        sb.append(d);
        sb.append(", ");
        sb.append(d2);
        sb.append(")");
        return sb.toString();
    }
}
