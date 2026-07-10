package com.google.googlex.gcam.androidutils.vecmath;

public class Vector3f {
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public Vector3f(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Vector3f(Vector3f vector3f) {
        this.x = vector3f.x;
        this.y = vector3f.y;
        this.z = vector3f.z;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector3f) {
            if (obj == this) {
                return true;
            }
            Vector3f vector3f = (Vector3f) obj;
            return this.x == vector3f.x && this.y == vector3f.y && this.z == vector3f.z;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    public String toString() {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.z;
        StringBuilder sb = new StringBuilder(51);
        sb.append("(");
        sb.append(f);
        sb.append(", ");
        sb.append(f2);
        sb.append(", ");
        sb.append(f3);
        sb.append(")");
        return sb.toString();
    }
}
