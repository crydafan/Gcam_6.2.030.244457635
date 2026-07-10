package com.google.googlex.gcam.androidutils.gles20;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;
import com.google.googlex.gcam.androidutils.Array2D;

public class GLUtilities {
    public static final String TAG = "GLUtilities";

    public static String getErrorString() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            if (glGetError == 1285) {
                return "GL_OUT_OF_MEMORY";
            }
            if (glGetError == 1286) {
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
            }
            switch (glGetError) {
                case 1280:
                    return "GL_INVALID_ENUM";
                case 1281:
                    return "GL_INVALID_VALUE";
                case 1282:
                    return "GL_INVALID_OPERATION";
                default:
                    return String.format("Error code 0x%x not recognized", Integer.valueOf(glGetError));
            }
        }
        return "GL_NO_ERROR";
    }

    public static int glGetInteger(int i) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(i, iArr, 0);
        return iArr[0];
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            String valueOf = String.valueOf(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.d("GLUtilities", valueOf.length() == 0 ? new String("shader info log: ") : "shader info log: ".concat(valueOf));
            throw new RuntimeException("shader compilation failed!");
        }
        return glCreateShader;
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

    public static Array2D.F32x4 readPixels_f32x4(int i, int i2) {
        return readPixels_f32x4(0, 0, i, i2);
    }

    public static Array2D.F32x4 readPixels_f32x4(int i, int i2, int i3, int i4) {
        Array2D.F32x4 f32x4 = new Array2D.F32x4(i3, i4);
        readPixels_f32x4(i, i2, f32x4);
        return f32x4;
    }

    public static void readPixels_f32x4(int i, int i2, Array2D.F32x4 f32x4) {
        GLES20.glReadPixels(i, i2, f32x4.width(), f32x4.height(), 6408, 5126, f32x4.buffer());
    }

    public static Array2D.U8x4 readPixels_u8x4(int i, int i2) {
        return readPixels_u8x4(0, 0, i, i2);
    }

    public static Array2D.U8x4 readPixels_u8x4(int i, int i2, int i3, int i4) {
        Array2D.U8x4 u8x4 = new Array2D.U8x4(i3, i4);
        readPixels_u8x4(i, i2, u8x4);
        return u8x4;
    }

    public static void readPixels_u8x4(int i, int i2, Array2D.U8x4 u8x4) {
        if (i >= 0 && i2 >= 0) {
            GLES30.glReadPixels(i, i2, u8x4.width(), u8x4.height(), 6408, 5121, u8x4.buffer());
            return;
        }
        StringBuilder sb = new StringBuilder(89);
        sb.append("readPixels_u8x4 requires a non-negative origin, received: x = ");
        sb.append(i);
        sb.append(" y = ");
        sb.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    public static void setViewport(int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }
}
