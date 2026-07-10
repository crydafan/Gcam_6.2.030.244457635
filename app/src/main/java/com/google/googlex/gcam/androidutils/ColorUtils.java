package com.google.googlex.gcam.androidutils;

import com.google.googlex.gcam.androidutils.vecmath.Vector3f;
import com.google.googlex.gcam.androidutils.vecmath.Vector4f;

public class ColorUtils {
    public static Vector3f colorMapHSV(float f) {
        return hsv2rgb(new Vector3f(f, 1.0f, 1.0f));
    }

    public static Vector4f colorMapHSVA(float f, float f2) {
        Vector3f hsv2rgb = hsv2rgb(new Vector3f(f, 1.0f, 1.0f));
        return new Vector4f(hsv2rgb.x, hsv2rgb.y, hsv2rgb.z, f2);
    }

    public static int convertYUVtoARGB(int i, int i2, int i3) {
        float f = i2;
        int i4 = ((int) (1.402f * f)) + i;
        float f2 = i3;
        int i5 = i - ((int) ((0.344f * f2) + (f * 0.714f)));
        int i6 = i + ((int) (f2 * 1.772f));
        if (i4 > 255) {
            i4 = 255;
        } else if (i4 < 0) {
            i4 = 0;
        }
        if (i5 > 255) {
            i5 = 255;
        } else if (i5 < 0) {
            i5 = 0;
        }
        if (i6 > 255) {
            i6 = 255;
        } else if (i6 < 0) {
            i6 = 0;
        }
        return i6 | (i5 << 8) | (i4 << 16) | (-16777216);
    }

    public static byte floatToByte(float f) {
        return (byte) (f * 255.0f);
    }

    public static Vector3f hsv2rgb(Vector3f vector3f) {
        float f = 0;
        float f2 = vector3f.x;
        float f3 = vector3f.y;
        float f4 = vector3f.z;
        float f5 = f2 * 360.0f;
        if (f3 == 0.0f) {
            return new Vector3f(f4, f4, f4);
        }
        float f6 = f5 / 60.0f;
        int i = (int) f6;
        float f7 = f6 - i;
        float f8 = (1.0f - f3) * f4;
        float f9 = (1.0f - (f3 * f7)) * f4;
        float f10 = f4 * (1.0f - (f3 * (1.0f - f7)));
        if (i == 0) {
            f8 = f10;
            f10 = f8;
        } else if (i != 1) {
            if (i == 2) {
                f = f8;
                f8 = f4;
            } else if (i == 3) {
                f10 = f4;
                f4 = f8;
                f8 = f9;
            } else if (i != 4) {
                f10 = f9;
            } else {
                f = f10;
                f10 = f4;
            }
            f4 = f;
        } else {
            f10 = f8;
            f8 = f4;
            f4 = f9;
        }
        return new Vector3f(f4, f8, f10);
    }

    public static float intToFloat(int i) {
        return i / 255.0f;
    }

    public static Vector4f intToFloat(int i, int i2, int i3, int i4) {
        return new Vector4f(intToFloat(i), intToFloat(i2), intToFloat(i3), intToFloat(i4));
    }

    public static byte intToUByte(int i) {
        return (byte) i;
    }

    public static Vector4f randomColorForInteger(long j) {
        if (j < 4294967291L) {
            long j2 = (j * j) % 4294967291L;
            j = j > 2147483645 ? 4294967291L - j2 : j2;
        }
        return intToFloat((int) (j & 255), (int) ((j >> 8) & 255), (int) ((j >> 16) & 255), (int) ((j >> 24) & 255));
    }

    public static float saturate(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                return f;
            }
            return 1.0f;
        }
        return 0.0f;
    }
}
