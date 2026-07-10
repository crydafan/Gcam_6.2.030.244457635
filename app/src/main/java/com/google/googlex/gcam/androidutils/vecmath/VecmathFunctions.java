package com.google.googlex.gcam.androidutils.vecmath;

import com.google.googlex.gcam.androidutils.MathUtils;

public final class VecmathFunctions {
    private VecmathFunctions() {
    }

    public static Matrix2f add(Matrix2f matrix2f, Matrix2f matrix2f2) {
        return new Matrix2f(matrix2f.m00 + matrix2f2.m00, matrix2f.m01 + matrix2f2.m01, matrix2f.m10 + matrix2f2.m10, matrix2f.m11 + matrix2f2.m11);
    }

    public static Matrix3f add(Matrix3f matrix3f, Matrix3f matrix3f2) {
        return new Matrix3f(matrix3f2.m00 + matrix3f.m00, matrix3f2.m01 + matrix3f.m01, matrix3f2.m02 + matrix3f.m02, matrix3f2.m10 + matrix3f.m10, matrix3f2.m11 + matrix3f.m11, matrix3f2.m12 + matrix3f.m12, matrix3f2.m20 + matrix3f.m20, matrix3f2.m21 + matrix3f.m21, matrix3f.m22 + matrix3f2.m22);
    }

    public static Matrix4f add(Matrix4f matrix4f, Matrix4f matrix4f2) {
        return new Matrix4f(matrix4f.m00 + matrix4f2.m00, matrix4f.m01 + matrix4f2.m01, matrix4f.m02 + matrix4f2.m02, matrix4f.m03 + matrix4f2.m03, matrix4f.m10 + matrix4f2.m10, matrix4f.m11 + matrix4f2.m11, matrix4f.m12 + matrix4f2.m12, matrix4f.m13 + matrix4f2.m13, matrix4f.m20 + matrix4f2.m20, matrix4f.m21 + matrix4f2.m21, matrix4f.m22 + matrix4f2.m22, matrix4f.m23 + matrix4f2.m23, matrix4f.m30 + matrix4f2.m30, matrix4f.m31 + matrix4f2.m31, matrix4f.m32 + matrix4f2.m32, matrix4f.m33 + matrix4f2.m33);
    }

    public static Vector2f add(Vector2f vector2f, Vector2f vector2f2) {
        return new Vector2f(vector2f.x + vector2f2.x, vector2f.y + vector2f2.y);
    }

    public static Vector2i add(Vector2i vector2i, Vector2i vector2i2) {
        return new Vector2i(vector2i.x + vector2i2.x, vector2i.y + vector2i2.y);
    }

    public static Vector3f add(Vector3f vector3f, Vector3f vector3f2) {
        return new Vector3f(vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
    }

    public static Vector3i add(Vector3i vector3i, Vector3i vector3i2) {
        return new Vector3i(vector3i.x + vector3i2.x, vector3i.y + vector3i2.y, vector3i.z + vector3i2.z);
    }

    public static Vector4f add(Vector4f vector4f, Vector4f vector4f2) {
        return new Vector4f(vector4f.x + vector4f2.x, vector4f.y + vector4f2.y, vector4f.z + vector4f2.z, vector4f.w + vector4f2.w);
    }

    public static Vector4i add(Vector4i vector4i, Vector4i vector4i2) {
        return new Vector4i(vector4i.x + vector4i2.x, vector4i.y + vector4i2.y, vector4i.z + vector4i2.z, vector4i.w + vector4i2.w);
    }

    public static Vector3f cross(Vector2f vector2f, Vector2f vector2f2) {
        return new Vector3f(0.0f, 0.0f, (vector2f.x * vector2f2.y) - (vector2f.y * vector2f2.x));
    }

    public static Vector3f cross(Vector3f vector3f, Vector3f vector3f2) {
        float f = vector3f.y;
        float f2 = vector3f2.z;
        float f3 = vector3f.z;
        float f4 = vector3f2.y;
        float f5 = vector3f2.x;
        float f6 = vector3f.x;
        return new Vector3f((f * f2) - (f3 * f4), (f3 * f5) - (f2 * f6), (f6 * f4) - (f * f5));
    }

    public static Vector3i cross(Vector2i vector2i, Vector2i vector2i2) {
        return new Vector3i(0, 0, (vector2i.x * vector2i2.y) - (vector2i.y * vector2i2.x));
    }

    public static Vector3i cross(Vector3i vector3i, Vector3i vector3i2) {
        int i = vector3i.y;
        int i2 = vector3i2.z;
        int i3 = vector3i.z;
        int i4 = vector3i2.y;
        int i5 = vector3i2.x;
        int i6 = vector3i.x;
        return new Vector3i((i * i2) - (i3 * i4), (i3 * i5) - (i2 * i6), (i6 * i4) - (i * i5));
    }

    private static float determinant2x2(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private static float determinant3x3(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return ((f * ((f5 * f9) - (f6 * f8))) - (f2 * ((f9 * f4) - (f6 * f7)))) + (f3 * ((f4 * f8) - (f5 * f7)));
    }

    public static float dot(Vector2f vector2f, Vector2f vector2f2) {
        return (vector2f.x * vector2f2.x) + (vector2f.y * vector2f2.y);
    }

    public static float dot(Vector3f vector3f, Vector3f vector3f2) {
        return (vector3f.x * vector3f2.x) + (vector3f.y * vector3f2.y) + (vector3f.z * vector3f2.z);
    }

    public static float dot(Vector4f vector4f, Vector4f vector4f2) {
        return (vector4f.x * vector4f2.x) + (vector4f.y * vector4f2.y) + (vector4f.z * vector4f2.z) + (vector4f.w * vector4f2.w);
    }

    public static int dot(Vector2i vector2i, Vector2i vector2i2) {
        return (vector2i.x * vector2i2.x) + (vector2i.y * vector2i2.y);
    }

    public static int dot(Vector3i vector3i, Vector3i vector3i2) {
        return (vector3i.x * vector3i2.x) + (vector3i.y * vector3i2.y) + (vector3i.z * vector3i2.z);
    }

    public static int dot(Vector4i vector4i, Vector4i vector4i2) {
        return (vector4i.x * vector4i2.x) + (vector4i.y * vector4i2.y) + (vector4i.z * vector4i2.z) + (vector4i.w * vector4i2.w);
    }

    public static Matrix4f flipUD() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = 1.0f;
        matrix4f.m11 = -1.0f;
        matrix4f.m13 = 1.0f;
        matrix4f.m22 = 1.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix4f flipUnitSquareX() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = -1.0f;
        matrix4f.m03 = 1.0f;
        matrix4f.m11 = 1.0f;
        matrix4f.m22 = 1.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix4f flipUnitSquareY() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = 1.0f;
        matrix4f.m11 = -1.0f;
        matrix4f.m13 = 1.0f;
        matrix4f.m22 = 1.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix4f glLookAt(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        Vector3f normalize = normalize(sub(vector3f, vector3f2));
        Vector3f cross = cross(vector3f3, normalize);
        Matrix4f makeZero = Matrix4f.makeZero();
        makeZero.m00 = cross.x;
        makeZero.m01 = cross.y;
        makeZero.m02 = cross.z;
        makeZero.m03 = -dot(cross, vector3f);
        makeZero.m10 = vector3f3.x;
        makeZero.m11 = vector3f3.y;
        makeZero.m12 = vector3f3.z;
        makeZero.m13 = -dot(vector3f3, vector3f);
        makeZero.m20 = normalize.x;
        makeZero.m21 = normalize.y;
        makeZero.m22 = normalize.z;
        makeZero.m23 = -dot(normalize, vector3f);
        makeZero.m33 = 1.0f;
        return makeZero;
    }

    public static Matrix4f glOrthographicProjection(float f, float f2) {
        return glOrthographicProjection(f, f2, -1.0f, 1.0f);
    }

    public static Matrix4f glOrthographicProjection(float f, float f2, float f3, float f4) {
        return glOrthographicProjection(0.0f, 0.0f, f, f2, f3, f4);
    }

    public static Matrix4f glOrthographicProjection(float f, float f2, float f3, float f4, float f5, float f6) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = 2.0f / f3;
        matrix4f.m11 = 2.0f / f4;
        matrix4f.m33 = 1.0f;
        matrix4f.m03 = (f + (f + f3)) / (-f3);
        matrix4f.m13 = (f2 + (f2 + f4)) / (-f4);
        float f7 = f5 - f6;
        matrix4f.m22 = 2.0f / f7;
        matrix4f.m23 = (f5 + f6) / f7;
        return matrix4f;
    }

    public static Matrix4f glPerspectiveProjection(float f, float f2, float f3, float f4) {
        Matrix4f makeZero = Matrix4f.makeZero();
        float tan = (float) (1.0d / Math.tan(f * 0.5f));
        makeZero.m00 = tan / f2;
        makeZero.m11 = tan;
        makeZero.m32 = -1.0f;
        float f5 = f3 - f4;
        makeZero.m22 = (f4 + f3) / f5;
        makeZero.m23 = ((f4 + f4) * f3) / f5;
        return makeZero;
    }

    public static Matrix4f glPerspectiveProjection(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 + f5;
        float f8 = f2 - f;
        Matrix4f makeZero = Matrix4f.makeZero();
        makeZero.m00 = f7 / f8;
        float f9 = f4 - f3;
        makeZero.m11 = f7 / f9;
        makeZero.m02 = (f2 + f) / f8;
        makeZero.m12 = (f4 + f3) / f9;
        makeZero.m32 = -1.0f;
        float f10 = f5 - f6;
        makeZero.m22 = (f5 + f6) / f10;
        makeZero.m23 = (f7 * f6) / f10;
        return makeZero;
    }

    public static Matrix2f hadamard(Matrix2f matrix2f, Matrix2f matrix2f2) {
        return new Matrix2f(matrix2f.m00 * matrix2f2.m00, matrix2f.m01 * matrix2f2.m01, matrix2f.m10 * matrix2f2.m10, matrix2f.m11 * matrix2f2.m11);
    }

    public static Matrix3f hadamard(Matrix3f matrix3f, Matrix3f matrix3f2) {
        return new Matrix3f(matrix3f2.m00 * matrix3f.m00, matrix3f2.m01 * matrix3f.m01, matrix3f2.m02 * matrix3f.m02, matrix3f2.m10 * matrix3f.m10, matrix3f2.m11 * matrix3f.m11, matrix3f2.m12 * matrix3f.m12, matrix3f2.m20 * matrix3f.m20, matrix3f2.m21 * matrix3f.m21, matrix3f.m22 * matrix3f2.m22);
    }

    public static Matrix4f hadamard(Matrix4f matrix4f, Matrix4f matrix4f2) {
        return new Matrix4f(matrix4f.m00 * matrix4f2.m00, matrix4f.m01 * matrix4f2.m01, matrix4f.m02 * matrix4f2.m02, matrix4f.m03 * matrix4f2.m03, matrix4f.m10 * matrix4f2.m10, matrix4f.m11 * matrix4f2.m11, matrix4f.m12 * matrix4f2.m12, matrix4f.m13 * matrix4f2.m13, matrix4f.m20 * matrix4f2.m20, matrix4f.m21 * matrix4f2.m21, matrix4f.m22 * matrix4f2.m22, matrix4f.m23 * matrix4f2.m23, matrix4f.m30 * matrix4f2.m30, matrix4f.m31 * matrix4f2.m31, matrix4f.m32 * matrix4f2.m32, matrix4f.m33 * matrix4f2.m33);
    }

    public static Vector2f homogenize(Vector2f vector2f) {
        return new Vector2f(vector2f.x / vector2f.y, 1.0f);
    }

    public static Vector3f homogenize(Vector3f vector3f) {
        float f = vector3f.x;
        float f2 = vector3f.z;
        return new Vector3f(f / f2, vector3f.y / f2, 1.0f);
    }

    public static Vector4f homogenize(Vector4f vector4f) {
        float f = vector4f.x;
        float f2 = vector4f.w;
        return new Vector4f(f / f2, vector4f.y / f2, vector4f.z / f2, 1.0f);
    }

    public static Matrix2f inverse(Matrix2f matrix2f, float f) {
        float determinant2x2 = determinant2x2(matrix2f.m00, matrix2f.m01, matrix2f.m10, matrix2f.m11);
        if (Math.abs(determinant2x2) >= f) {
            float f2 = 1.0f / determinant2x2;
            float f3 = -f2;
            return new Matrix2f(matrix2f.m11 * f2, matrix2f.m01 * f3, f3 * matrix2f.m10, f2 * matrix2f.m00);
        }
        return null;
    }

    public static Matrix3f inverse(Matrix3f matrix3f, float f) {
        float determinant2x2 = determinant2x2(matrix3f.m11, matrix3f.m12, matrix3f.m21, matrix3f.m22);
        float f2 = -determinant2x2(matrix3f.m10, matrix3f.m12, matrix3f.m20, matrix3f.m22);
        float determinant2x22 = determinant2x2(matrix3f.m10, matrix3f.m11, matrix3f.m20, matrix3f.m21);
        float f3 = -determinant2x2(matrix3f.m01, matrix3f.m02, matrix3f.m21, matrix3f.m22);
        float determinant2x23 = determinant2x2(matrix3f.m00, matrix3f.m02, matrix3f.m20, matrix3f.m22);
        float f4 = -determinant2x2(matrix3f.m00, matrix3f.m01, matrix3f.m20, matrix3f.m21);
        float determinant2x24 = determinant2x2(matrix3f.m01, matrix3f.m02, matrix3f.m11, matrix3f.m12);
        float f5 = -determinant2x2(matrix3f.m00, matrix3f.m02, matrix3f.m10, matrix3f.m12);
        float determinant2x25 = determinant2x2(matrix3f.m00, matrix3f.m01, matrix3f.m10, matrix3f.m11);
        float f6 = (matrix3f.m00 * determinant2x2) + (matrix3f.m01 * f2) + (matrix3f.m02 * determinant2x22);
        if (Math.abs(f6) >= f) {
            float f7 = 1.0f / f6;
            return new Matrix3f(determinant2x2 * f7, f3 * f7, determinant2x24 * f7, f2 * f7, determinant2x23 * f7, f5 * f7, determinant2x22 * f7, f4 * f7, determinant2x25 * f7);
        }
        return null;
    }

    public static Matrix4f inverse(Matrix4f matrix4f, float f) {
        float determinant3x3 = determinant3x3(matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m21, matrix4f.m22, matrix4f.m23, matrix4f.m31, matrix4f.m32, matrix4f.m33);
        float f2 = -determinant3x3(matrix4f.m12, matrix4f.m13, matrix4f.m10, matrix4f.m22, matrix4f.m23, matrix4f.m20, matrix4f.m32, matrix4f.m33, matrix4f.m30);
        float determinant3x32 = determinant3x3(matrix4f.m13, matrix4f.m10, matrix4f.m11, matrix4f.m23, matrix4f.m20, matrix4f.m21, matrix4f.m33, matrix4f.m30, matrix4f.m31);
        float f3 = -determinant3x3(matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m20, matrix4f.m21, matrix4f.m22, matrix4f.m30, matrix4f.m31, matrix4f.m32);
        float f4 = -determinant3x3(matrix4f.m21, matrix4f.m22, matrix4f.m23, matrix4f.m31, matrix4f.m32, matrix4f.m33, matrix4f.m01, matrix4f.m02, matrix4f.m03);
        float determinant3x33 = determinant3x3(matrix4f.m22, matrix4f.m23, matrix4f.m20, matrix4f.m32, matrix4f.m33, matrix4f.m30, matrix4f.m02, matrix4f.m03, matrix4f.m00);
        float f5 = -determinant3x3(matrix4f.m23, matrix4f.m20, matrix4f.m21, matrix4f.m33, matrix4f.m30, matrix4f.m31, matrix4f.m03, matrix4f.m00, matrix4f.m01);
        float determinant3x34 = determinant3x3(matrix4f.m20, matrix4f.m21, matrix4f.m22, matrix4f.m30, matrix4f.m31, matrix4f.m32, matrix4f.m00, matrix4f.m01, matrix4f.m02);
        float determinant3x35 = determinant3x3(matrix4f.m31, matrix4f.m32, matrix4f.m33, matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m11, matrix4f.m12, matrix4f.m13);
        float f6 = -determinant3x3(matrix4f.m32, matrix4f.m33, matrix4f.m30, matrix4f.m02, matrix4f.m03, matrix4f.m00, matrix4f.m12, matrix4f.m13, matrix4f.m10);
        float determinant3x36 = determinant3x3(matrix4f.m33, matrix4f.m30, matrix4f.m31, matrix4f.m03, matrix4f.m00, matrix4f.m01, matrix4f.m13, matrix4f.m10, matrix4f.m11);
        float f7 = -determinant3x3(matrix4f.m30, matrix4f.m31, matrix4f.m32, matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m10, matrix4f.m11, matrix4f.m12);
        float f8 = -determinant3x3(matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m21, matrix4f.m22, matrix4f.m23);
        float determinant3x37 = determinant3x3(matrix4f.m02, matrix4f.m03, matrix4f.m00, matrix4f.m12, matrix4f.m13, matrix4f.m10, matrix4f.m22, matrix4f.m23, matrix4f.m20);
        float f9 = -determinant3x3(matrix4f.m03, matrix4f.m00, matrix4f.m01, matrix4f.m13, matrix4f.m10, matrix4f.m11, matrix4f.m23, matrix4f.m20, matrix4f.m21);
        float determinant3x38 = determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m20, matrix4f.m21, matrix4f.m22);
        float f10 = (matrix4f.m00 * determinant3x3) + (matrix4f.m01 * f2) + (matrix4f.m02 * determinant3x32) + (matrix4f.m03 * f3);
        if (Math.abs(f10) >= f) {
            float f11 = 1.0f / f10;
            return new Matrix4f(determinant3x3 * f11, f4 * f11, determinant3x35 * f11, f8 * f11, f2 * f11, determinant3x33 * f11, f6 * f11, determinant3x37 * f11, determinant3x32 * f11, f5 * f11, determinant3x36 * f11, f9 * f11, f3 * f11, determinant3x34 * f11, f7 * f11, determinant3x38 * f11);
        }
        return null;
    }

    public static Vector2f lerp(Vector2f vector2f, Vector2f vector2f2, float f) {
        return add(vector2f, mul(f, sub(vector2f2, vector2f)));
    }

    public static Vector3f lerp(Vector3f vector3f, Vector3f vector3f2, float f) {
        return add(vector3f, mul(f, sub(vector3f2, vector3f)));
    }

    public static Vector4f lerp(Vector4f vector4f, Vector4f vector4f2, float f) {
        return add(vector4f, mul(f, sub(vector4f2, vector4f)));
    }

    public static Vector2f max(Vector2f vector2f, Vector2f vector2f2) {
        return new Vector2f(Math.max(vector2f.x, vector2f2.x), Math.max(vector2f.y, vector2f2.y));
    }

    public static Vector2i max(Vector2i vector2i, Vector2i vector2i2) {
        return new Vector2i(Math.max(vector2i.x, vector2i2.x), Math.max(vector2i.y, vector2i2.y));
    }

    public static Vector3f max(Vector3f vector3f, Vector3f vector3f2) {
        return new Vector3f(Math.max(vector3f.x, vector3f2.x), Math.max(vector3f.y, vector3f2.y), Math.max(vector3f.z, vector3f2.z));
    }

    public static Vector3i max(Vector3i vector3i, Vector3i vector3i2) {
        return new Vector3i(Math.max(vector3i.x, vector3i2.x), Math.max(vector3i.y, vector3i2.y), Math.max(vector3i.z, vector3i2.z));
    }

    public static Vector4f max(Vector4f vector4f, Vector4f vector4f2) {
        return new Vector4f(Math.max(vector4f.x, vector4f2.x), Math.max(vector4f.y, vector4f2.y), Math.max(vector4f.z, vector4f2.z), Math.max(vector4f.w, vector4f2.w));
    }

    public static Vector4i max(Vector4i vector4i, Vector4i vector4i2) {
        return new Vector4i(Math.max(vector4i.x, vector4i2.x), Math.max(vector4i.y, vector4i2.y), Math.max(vector4i.z, vector4i2.z), Math.max(vector4i.w, vector4i2.w));
    }

    public static Vector2f min(Vector2f vector2f, Vector2f vector2f2) {
        return new Vector2f(Math.min(vector2f.x, vector2f2.x), Math.min(vector2f.y, vector2f2.y));
    }

    public static Vector2i min(Vector2i vector2i, Vector2i vector2i2) {
        return new Vector2i(Math.min(vector2i.x, vector2i2.x), Math.min(vector2i.y, vector2i2.y));
    }

    public static Vector3f min(Vector3f vector3f, Vector3f vector3f2) {
        return new Vector3f(Math.min(vector3f.x, vector3f2.x), Math.min(vector3f.y, vector3f2.y), Math.min(vector3f.z, vector3f2.z));
    }

    public static Vector3i min(Vector3i vector3i, Vector3i vector3i2) {
        return new Vector3i(Math.min(vector3i.x, vector3i2.x), Math.min(vector3i.y, vector3i2.y), Math.min(vector3i.z, vector3i2.z));
    }

    public static Vector4f min(Vector4f vector4f, Vector4f vector4f2) {
        return new Vector4f(Math.min(vector4f.x, vector4f2.x), Math.min(vector4f.y, vector4f2.y), Math.min(vector4f.z, vector4f2.z), Math.min(vector4f.w, vector4f2.w));
    }

    public static Vector4i min(Vector4i vector4i, Vector4i vector4i2) {
        return new Vector4i(Math.min(vector4i.x, vector4i2.x), Math.min(vector4i.y, vector4i2.y), Math.min(vector4i.z, vector4i2.z), Math.min(vector4i.w, vector4i2.w));
    }

    public static Matrix2f mul(Matrix2f matrix2f, Matrix2f matrix2f2) {
        Matrix2f matrix2f3 = new Matrix2f();
        float f = matrix2f.m00;
        float f2 = matrix2f2.m00;
        float f3 = matrix2f.m01;
        float f4 = matrix2f2.m10;
        matrix2f3.m00 = (f * f2) + (f3 * f4);
        float f5 = matrix2f.m00;
        float f6 = matrix2f2.m01;
        float f7 = matrix2f2.m11;
        matrix2f3.m01 = (f5 * f6) + (f3 * f7);
        float f8 = matrix2f.m10;
        float f9 = matrix2f2.m00;
        float f10 = matrix2f.m11;
        matrix2f3.m10 = (f8 * f9) + (f4 * f10);
        matrix2f3.m11 = (matrix2f.m10 * matrix2f2.m01) + (f10 * f7);
        return matrix2f3;
    }

    public static Matrix3f mul(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3 = new Matrix3f();
        float f = matrix3f.m00;
        float f2 = matrix3f2.m00;
        float f3 = matrix3f.m01;
        float f4 = matrix3f2.m10;
        float f5 = matrix3f.m02;
        float f6 = matrix3f2.m20;
        matrix3f3.m00 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f7 = matrix3f.m00;
        float f8 = matrix3f2.m01;
        float f9 = matrix3f2.m11;
        float f10 = matrix3f2.m21;
        matrix3f3.m01 = (f8 * f7) + (f3 * f9) + (f5 * f10);
        float f11 = matrix3f2.m02;
        float f12 = matrix3f.m01;
        float f13 = matrix3f2.m12;
        float f14 = matrix3f2.m22;
        matrix3f3.m02 = (f7 * f11) + (f12 * f13) + (f5 * f14);
        float f15 = matrix3f.m10;
        float f16 = matrix3f2.m00;
        float f17 = matrix3f.m11;
        float f18 = matrix3f.m12;
        matrix3f3.m10 = (f15 * f16) + (f4 * f17) + (f18 * f6);
        float f19 = matrix3f.m10;
        float f20 = matrix3f2.m01;
        matrix3f3.m11 = (f19 * f20) + (f17 * f9) + (f18 * f10);
        float f21 = matrix3f2.m02;
        matrix3f3.m12 = (f19 * f21) + (matrix3f.m11 * f13) + (f18 * f14);
        float f22 = matrix3f.m20;
        float f23 = matrix3f.m21;
        float f24 = matrix3f2.m10;
        float f25 = matrix3f.m22;
        matrix3f3.m20 = (f22 * f16) + (f24 * f23) + (f6 * f25);
        float f26 = matrix3f.m20;
        matrix3f3.m21 = (f20 * f26) + (f23 * matrix3f2.m11) + (f10 * f25);
        matrix3f3.m22 = (f26 * f21) + (matrix3f.m21 * matrix3f2.m12) + (f25 * f14);
        return matrix3f3;
    }

    public static Matrix4f mul(Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3 = new Matrix4f();
        float f = matrix4f.m00;
        float f2 = matrix4f2.m00;
        float f3 = matrix4f.m01;
        float f4 = matrix4f2.m10;
        float f5 = matrix4f.m02;
        float f6 = matrix4f2.m20;
        float f7 = matrix4f.m03;
        float f8 = matrix4f2.m30;
        matrix4f3.m00 = (f * f2) + (f3 * f4) + (f5 * f6) + (f7 * f8);
        float f9 = matrix4f.m00;
        float f10 = matrix4f2.m01;
        float f11 = matrix4f2.m11;
        float f12 = matrix4f2.m21;
        float f13 = matrix4f2.m31;
        matrix4f3.m01 = (f10 * f9) + (f3 * f11) + (f5 * f12) + (f7 * f13);
        float f14 = matrix4f2.m02;
        float f15 = matrix4f.m01;
        float f16 = matrix4f2.m12;
        float f17 = matrix4f2.m22;
        float f18 = matrix4f2.m32;
        matrix4f3.m02 = (f14 * f9) + (f15 * f16) + (f5 * f17) + (f7 * f18);
        float f19 = matrix4f2.m03;
        float f20 = matrix4f2.m13;
        float f21 = matrix4f.m02;
        float f22 = matrix4f2.m23;
        float f23 = matrix4f2.m33;
        matrix4f3.m03 = (f9 * f19) + (f15 * f20) + (f21 * f22) + (f7 * f23);
        float f24 = matrix4f.m10;
        float f25 = matrix4f2.m00;
        float f26 = matrix4f.m11;
        float f27 = matrix4f.m12;
        float f28 = matrix4f.m13;
        matrix4f3.m10 = (f24 * f25) + (f4 * f26) + (f27 * f6) + (f28 * f8);
        float f29 = matrix4f.m10;
        float f30 = matrix4f2.m01;
        matrix4f3.m11 = (f29 * f30) + (f26 * f11) + (f27 * f12) + (f28 * f13);
        float f31 = matrix4f2.m02;
        float f32 = matrix4f.m11;
        matrix4f3.m12 = (f29 * f31) + (f16 * f32) + (f27 * f17) + (f28 * f18);
        float f33 = matrix4f2.m03;
        matrix4f3.m13 = (f29 * f33) + (f32 * f20) + (matrix4f.m12 * f22) + (f28 * f23);
        float f34 = matrix4f.m20;
        float f35 = matrix4f.m21;
        float f36 = matrix4f2.m10;
        float f37 = matrix4f.m22;
        float f38 = matrix4f.m23;
        matrix4f3.m20 = (f34 * f25) + (f35 * f36) + (f6 * f37) + (f38 * f8);
        float f39 = matrix4f.m20;
        float f40 = matrix4f2.m11;
        matrix4f3.m21 = (f39 * f30) + (f35 * f40) + (f12 * f37) + (f38 * f13);
        float f41 = matrix4f.m21;
        float f42 = matrix4f2.m12;
        matrix4f3.m22 = (f39 * f31) + (f41 * f42) + (f37 * f17) + (f38 * f18);
        float f43 = matrix4f2.m13;
        matrix4f3.m23 = (f39 * f33) + (f41 * f43) + (matrix4f.m22 * f22) + (f38 * f23);
        float f44 = matrix4f.m30;
        float f45 = matrix4f.m31;
        float f46 = matrix4f.m32;
        float f47 = matrix4f2.m20;
        float f48 = matrix4f.m33;
        matrix4f3.m30 = (f44 * f25) + (f36 * f45) + (f47 * f46) + (f8 * f48);
        float f49 = matrix4f.m30;
        matrix4f3.m31 = (f30 * f49) + (f45 * f40) + (matrix4f2.m21 * f46) + (f48 * f13);
        float f50 = matrix4f.m31;
        matrix4f3.m32 = (f31 * f49) + (f42 * f50) + (f46 * matrix4f2.m22) + (f48 * f18);
        matrix4f3.m33 = (f49 * f33) + (f50 * f43) + (matrix4f.m32 * matrix4f2.m23) + (f48 * f23);
        return matrix4f3;
    }

    public static Vector2f mul(float f, Vector2f vector2f) {
        return new Vector2f(vector2f.x * f, f * vector2f.y);
    }

    public static Vector2f mul(Matrix2f matrix2f, Vector2f vector2f) {
        Vector2f vector2f2 = new Vector2f();
        float f = matrix2f.m00;
        float f2 = vector2f.x;
        float f3 = matrix2f.m01;
        float f4 = vector2f.y;
        vector2f2.x = (f * f2) + (f3 * f4);
        vector2f2.y = (matrix2f.m10 * vector2f.x) + (matrix2f.m11 * f4);
        return vector2f2;
    }

    public static Vector2f mul(Vector2f vector2f, float f) {
        return new Vector2f(vector2f.x * f, f * vector2f.y);
    }

    public static Vector2i mul(int i, Vector2i vector2i) {
        return new Vector2i(vector2i.x * i, i * vector2i.y);
    }

    public static Vector2i mul(Vector2i vector2i, int i) {
        return new Vector2i(vector2i.x * i, i * vector2i.y);
    }

    public static Vector3f mul(float f, Vector3f vector3f) {
        return new Vector3f(vector3f.x * f, vector3f.y * f, f * vector3f.z);
    }

    public static Vector3f mul(Matrix3f matrix3f, Vector3f vector3f) {
        Vector3f vector3f2 = new Vector3f();
        float f = matrix3f.m00;
        float f2 = vector3f.x;
        float f3 = matrix3f.m01;
        float f4 = vector3f.y;
        float f5 = matrix3f.m02;
        float f6 = vector3f.z;
        vector3f2.x = (f * f2) + (f3 * f4) + (f5 * f6);
        float f7 = matrix3f.m10;
        float f8 = vector3f.x;
        vector3f2.y = (f7 * f8) + (matrix3f.m11 * f4) + (matrix3f.m12 * f6);
        vector3f2.z = (matrix3f.m20 * f8) + (matrix3f.m21 * vector3f.y) + (matrix3f.m22 * f6);
        return vector3f2;
    }

    public static Vector3f mul(Vector3f vector3f, float f) {
        return new Vector3f(vector3f.x * f, vector3f.y * f, f * vector3f.z);
    }

    public static Vector3i mul(int i, Vector3i vector3i) {
        return new Vector3i(vector3i.x * i, vector3i.y * i, i * vector3i.z);
    }

    public static Vector3i mul(Vector3i vector3i, int i) {
        return new Vector3i(vector3i.x * i, vector3i.y * i, i * vector3i.z);
    }

    public static Vector4f mul(float f, Vector4f vector4f) {
        return new Vector4f(vector4f.x * f, vector4f.y * f, vector4f.z * f, f * vector4f.w);
    }

    public static Vector4f mul(Matrix4f matrix4f, Vector4f vector4f) {
        Vector4f vector4f2 = new Vector4f();
        float f = matrix4f.m00;
        float f2 = vector4f.x;
        float f3 = matrix4f.m01;
        float f4 = vector4f.y;
        float f5 = matrix4f.m02;
        float f6 = vector4f.z;
        float f7 = matrix4f.m03;
        float f8 = vector4f.w;
        vector4f2.x = (f * f2) + (f3 * f4) + (f5 * f6) + (f7 * f8);
        float f9 = matrix4f.m10;
        float f10 = vector4f.x;
        vector4f2.y = (f9 * f10) + (matrix4f.m11 * f4) + (matrix4f.m12 * f6) + (matrix4f.m13 * f8);
        float f11 = matrix4f.m20;
        float f12 = matrix4f.m21;
        float f13 = vector4f.y;
        vector4f2.z = (f11 * f10) + (f12 * f13) + (matrix4f.m22 * f6) + (matrix4f.m23 * f8);
        vector4f2.w = (matrix4f.m30 * f10) + (matrix4f.m31 * f13) + (matrix4f.m32 * vector4f.z) + (matrix4f.m33 * f8);
        return vector4f2;
    }

    public static Vector4f mul(Vector4f vector4f, float f) {
        return new Vector4f(vector4f.x * f, vector4f.y * f, vector4f.z * f, f * vector4f.w);
    }

    public static Vector4i mul(int i, Vector4i vector4i) {
        return new Vector4i(vector4i.x * i, vector4i.y * i, vector4i.z * i, i * vector4i.w);
    }

    public static Vector4i mul(Vector4i vector4i, int i) {
        return new Vector4i(vector4i.x * i, vector4i.y * i, vector4i.z * i, i * vector4i.w);
    }

    public static float norm(Vector2f vector2f) {
        float f = vector2f.x;
        float f2 = vector2f.y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public static float norm(Vector3f vector3f) {
        float f = vector3f.x;
        float f2 = vector3f.y;
        float f3 = vector3f.z;
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public static float norm(Vector4f vector4f) {
        float f = vector4f.x;
        float f2 = vector4f.y;
        float f3 = vector4f.z;
        float f4 = vector4f.w;
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + f4 + f4);
    }

    public static float normSquared(Vector2f vector2f) {
        float f = vector2f.x;
        float f2 = vector2f.y;
        return (f * f) + (f2 * f2);
    }

    public static float normSquared(Vector3f vector3f) {
        float f = vector3f.x;
        float f2 = vector3f.y;
        float f3 = vector3f.z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public static float normSquared(Vector4f vector4f) {
        float f = vector4f.x;
        float f2 = vector4f.y;
        float f3 = vector4f.z;
        float f4 = vector4f.w;
        return (f * f) + (f2 * f2) + (f3 * f3) + f4 + f4;
    }

    public static int normSquared(Vector2i vector2i) {
        int i = vector2i.x;
        int i2 = vector2i.y;
        return (i * i) + (i2 * i2);
    }

    public static int normSquared(Vector3i vector3i) {
        int i = vector3i.x;
        int i2 = vector3i.y;
        int i3 = vector3i.z;
        return (i * i) + (i2 * i2) + (i3 * i3);
    }

    public static int normSquared(Vector4i vector4i) {
        int i = vector4i.x;
        int i2 = vector4i.y;
        int i3 = vector4i.z;
        int i4 = vector4i.w;
        return (i * i) + (i2 * i2) + (i3 * i3) + i4 + i4;
    }

    public static Vector2f normalize(Vector2f vector2f) {
        float norm = norm(vector2f);
        return new Vector2f(vector2f.x / norm, vector2f.y / norm);
    }

    public static Vector3f normalize(Vector3f vector3f) {
        float norm = norm(vector3f);
        return new Vector3f(vector3f.x / norm, vector3f.y / norm, vector3f.z / norm);
    }

    public static Vector4f normalize(Vector4f vector4f) {
        float norm = norm(vector4f);
        return new Vector4f(vector4f.x / norm, vector4f.y / norm, vector4f.z / norm, vector4f.w / norm);
    }

    public static Vector2f orthogonalVector(Vector2f vector2f) {
        return new Vector2f(-vector2f.y, vector2f.x);
    }

    public static Vector2i orthogonalVector(Vector2i vector2i) {
        return new Vector2i(-vector2i.y, vector2i.x);
    }

    public static Matrix4f rotateUnitSquareCCWNinety(int i) {
        int mod = MathUtils.mod(i, 4);
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m22 = 1.0f;
        matrix4f.m33 = 1.0f;
        if (mod == 0) {
            matrix4f.m00 = 1.0f;
            matrix4f.m11 = 1.0f;
        } else if (mod == 1) {
            matrix4f.m01 = -1.0f;
            matrix4f.m03 = 1.0f;
            matrix4f.m10 = 1.0f;
        } else if (mod == 2) {
            matrix4f.m00 = -1.0f;
            matrix4f.m03 = 1.0f;
            matrix4f.m11 = -1.0f;
            matrix4f.m13 = 1.0f;
        } else if (mod == 3) {
            matrix4f.m01 = 1.0f;
            matrix4f.m10 = -1.0f;
            matrix4f.m13 = 1.0f;
        }
        return matrix4f;
    }

    public static Matrix4f rotationBetween(Vector2f vector2f, Vector2f vector2f2) {
        float dot = dot(vector2f, vector2f2);
        float f = cross(vector2f, vector2f2).z;
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = dot;
        matrix4f.m01 = -f;
        matrix4f.m10 = f;
        matrix4f.m11 = dot;
        matrix4f.m22 = 1.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix4f scaling(float f, float f2, float f3) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = f;
        matrix4f.m11 = f2;
        matrix4f.m22 = f3;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix2f sub(Matrix2f matrix2f, Matrix2f matrix2f2) {
        return new Matrix2f(matrix2f.m00 - matrix2f2.m00, matrix2f.m01 - matrix2f2.m01, matrix2f.m10 - matrix2f2.m10, matrix2f.m11 - matrix2f2.m11);
    }

    public static Matrix3f sub(Matrix3f matrix3f, Matrix3f matrix3f2) {
        return new Matrix3f(matrix3f.m00 - matrix3f2.m00, matrix3f.m01 - matrix3f2.m01, matrix3f.m02 - matrix3f2.m02, matrix3f.m10 - matrix3f2.m10, matrix3f.m11 - matrix3f2.m11, matrix3f.m12 - matrix3f2.m12, matrix3f.m20 - matrix3f2.m20, matrix3f.m21 - matrix3f2.m21, matrix3f.m22 - matrix3f2.m22);
    }

    public static Matrix4f sub(Matrix4f matrix4f, Matrix4f matrix4f2) {
        return new Matrix4f(matrix4f.m00 - matrix4f2.m00, matrix4f.m01 - matrix4f2.m01, matrix4f.m02 - matrix4f2.m02, matrix4f.m03 - matrix4f2.m03, matrix4f.m10 - matrix4f2.m10, matrix4f.m11 - matrix4f2.m11, matrix4f.m12 - matrix4f2.m12, matrix4f.m13 - matrix4f2.m13, matrix4f.m20 - matrix4f2.m20, matrix4f.m21 - matrix4f2.m21, matrix4f.m22 - matrix4f2.m22, matrix4f.m23 - matrix4f2.m23, matrix4f.m30 - matrix4f2.m30, matrix4f.m31 - matrix4f2.m31, matrix4f.m32 - matrix4f2.m32, matrix4f.m33 - matrix4f2.m33);
    }

    public static Vector2f sub(Vector2f vector2f, Vector2f vector2f2) {
        return new Vector2f(vector2f.x - vector2f2.x, vector2f.y - vector2f2.y);
    }

    public static Vector2i sub(Vector2i vector2i, Vector2i vector2i2) {
        return new Vector2i(vector2i.x - vector2i2.x, vector2i.y - vector2i2.y);
    }

    public static Vector3f sub(Vector3f vector3f, Vector3f vector3f2) {
        return new Vector3f(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
    }

    public static Vector3i sub(Vector3i vector3i, Vector3i vector3i2) {
        return new Vector3i(vector3i.x - vector3i2.x, vector3i.y - vector3i2.y, vector3i.z - vector3i2.z);
    }

    public static Vector4f sub(Vector4f vector4f, Vector4f vector4f2) {
        return new Vector4f(vector4f.x - vector4f2.x, vector4f.y - vector4f2.y, vector4f.z - vector4f2.z, vector4f.w - vector4f2.w);
    }

    public static Vector4i sub(Vector4i vector4i, Vector4i vector4i2) {
        return new Vector4i(vector4i.x - vector4i2.x, vector4i.y - vector4i2.y, vector4i.z - vector4i2.z, vector4i.w - vector4i2.w);
    }

    public static Vector2f transformPoint(Matrix3f matrix3f, Vector2f vector2f) {
        return xy(mul(matrix3f, new Vector3f(vector2f.x, vector2f.y, 1.0f)));
    }

    public static Vector2f transformPoint(Matrix4f matrix4f, Vector2f vector2f) {
        return xy(mul(matrix4f, new Vector4f(vector2f.x, vector2f.y, 0.0f, 1.0f)));
    }

    public static Rect2f transformRect(Matrix3f matrix3f, Rect2f rect2f) {
        Vector2f min = rect2f.min();
        Vector2f max = rect2f.max();
        Vector2f transformPoint = transformPoint(matrix3f, min);
        return new Rect2f(transformPoint, sub(transformPoint(matrix3f, max), transformPoint)).standardized();
    }

    public static Rect2f transformRect(Matrix4f matrix4f, Rect2f rect2f) {
        Vector2f min = rect2f.min();
        Vector2f max = rect2f.max();
        Vector2f transformPoint = transformPoint(matrix4f, min);
        return new Rect2f(transformPoint, sub(transformPoint(matrix4f, max), transformPoint)).standardized();
    }

    public static Matrix4f translation(float f, float f2) {
        return translation(f, f2, 0.0f);
    }

    public static Matrix4f translation(float f, float f2, float f3) {
        Matrix4f makeIdentity = Matrix4f.makeIdentity();
        makeIdentity.m03 = f;
        makeIdentity.m13 = f2;
        makeIdentity.m23 = f3;
        return makeIdentity;
    }

    public static Matrix4f translation(Vector2f vector2f) {
        return translation(vector2f.x, vector2f.y, 0.0f);
    }

    public static Matrix4f translation(Vector3f vector3f) {
        return translation(vector3f.x, vector3f.y, vector3f.z);
    }

    public static Matrix2f transpose(Matrix2f matrix2f) {
        return new Matrix2f(matrix2f.m00, matrix2f.m10, matrix2f.m01, matrix2f.m11);
    }

    public static Matrix3f transpose(Matrix3f matrix3f) {
        return new Matrix3f(matrix3f.m00, matrix3f.m10, matrix3f.m20, matrix3f.m01, matrix3f.m11, matrix3f.m21, matrix3f.m02, matrix3f.m12, matrix3f.m22);
    }

    public static Matrix4f transpose(Matrix4f matrix4f) {
        return new Matrix4f(matrix4f.m00, matrix4f.m10, matrix4f.m20, matrix4f.m30, matrix4f.m01, matrix4f.m11, matrix4f.m21, matrix4f.m31, matrix4f.m02, matrix4f.m12, matrix4f.m22, matrix4f.m32, matrix4f.m03, matrix4f.m13, matrix4f.m23, matrix4f.m33);
    }

    public static Matrix4f uniformScaling(float f) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = f;
        matrix4f.m11 = f;
        matrix4f.m22 = f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Vector2f xy(Vector3f vector3f) {
        return new Vector2f(vector3f.x, vector3f.y);
    }

    public static Vector2f xy(Vector4f vector4f) {
        return new Vector2f(vector4f.x, vector4f.y);
    }

    public static Vector2i xy(Vector3i vector3i) {
        return new Vector2i(vector3i.x, vector3i.y);
    }

    public static Vector2i xy(Vector4i vector4i) {
        return new Vector2i(vector4i.x, vector4i.y);
    }

    public static Vector3f xyz(Vector4f vector4f) {
        return new Vector3f(vector4f.x, vector4f.y, vector4f.z);
    }
}
