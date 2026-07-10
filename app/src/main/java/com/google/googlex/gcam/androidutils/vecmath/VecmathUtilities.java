package com.google.googlex.gcam.androidutils.vecmath;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;

public final class VecmathUtilities {
    private VecmathUtilities() {
    }

    public static String matrix2x2ToString(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append("[ ");
            for (int i2 = 0; i2 < 2; i2++) {
                sb.append(fArr[i2 + i2 + i]);
                sb.append("\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static String matrix3x3ToString(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("[ ");
            for (int i2 = 0; i2 < 3; i2++) {
                sb.append(fArr[(i2 * 3) + i]);
                sb.append("\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static float[] matrix4fListToFloatArray(List list) {
        float[] fArr = new float[list.size() << 4];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Matrix4f matrix4f = (Matrix4f) it.next();
            int i2 = i << 4;
            fArr[i2] = matrix4f.m00;
            fArr[i2 + 1] = matrix4f.m10;
            fArr[i2 + 2] = matrix4f.m20;
            fArr[i2 + 3] = matrix4f.m30;
            fArr[i2 + 4] = matrix4f.m01;
            fArr[i2 + 5] = matrix4f.m11;
            fArr[i2 + 6] = matrix4f.m21;
            fArr[i2 + 7] = matrix4f.m31;
            fArr[i2 + 8] = matrix4f.m02;
            fArr[i2 + 9] = matrix4f.m12;
            fArr[i2 + 10] = matrix4f.m22;
            fArr[i2 + 11] = matrix4f.m32;
            fArr[i2 + 12] = matrix4f.m03;
            fArr[i2 + 13] = matrix4f.m13;
            fArr[i2 + 14] = matrix4f.m23;
            fArr[i2 + 15] = matrix4f.m33;
            i++;
        }
        return fArr;
    }

    public static String matrix4x4ToString(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append("[ ");
            for (int i2 = 0; i2 < 4; i2++) {
                sb.append(fArr[(i2 << 2) + i]);
                sb.append("\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static Rect2i toRect2i(Rect rect) {
        return new Rect2i(rect.left, rect.top, rect.width(), rect.height());
    }

    public static Vector2f toVector2f(Point point) {
        return new Vector2f(point.x, point.y);
    }

    public static Vector3f toVector3f(Point point) {
        return new Vector3f(point.x, point.y, 0.0f);
    }

    public static Vector4f toVector4f(Point point) {
        return new Vector4f(point.x, point.y, 0.0f, 1.0f);
    }

    public static float[] vector4fListToFloatArray(List list) {
        float[] fArr = new float[list.size() << 2];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Vector4f vector4f = (Vector4f) it.next();
            int i2 = i << 2;
            fArr[i2] = vector4f.x;
            fArr[i2 + 1] = vector4f.y;
            fArr[i2 + 2] = vector4f.z;
            fArr[i2 + 3] = vector4f.w;
            i++;
        }
        return fArr;
    }
}
