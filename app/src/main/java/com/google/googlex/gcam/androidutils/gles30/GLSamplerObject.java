package com.google.googlex.gcam.androidutils.gles30;

import android.opengl.GLES30;
import java.io.Closeable;

public class GLSamplerObject implements Closeable {
    public final int id;

    public final class CompareFunctions {
        public static final int ALWAYS = 519;
        public static final int EQUAL = 514;
        public static final int GEQUAL = 518;
        public static final int GREATER = 516;
        public static final int LEQUAL = 515;
        public static final int LESS = 513;
        public static final int NEVER = 512;
        public static final int NOTEQUAL = 517;

        private CompareFunctions() {
        }
    }

    public final class CompareModes {
        public static final int COMPARE_REF_TO_TEXTURE = 34894;
        public static final int NONE = 0;

        private CompareModes() {
        }
    }

    public final class FilterModes {
        public static final int LINEAR = 9729;
        public static final int LINEAR_MIPMAP_LINEAR = 9987;
        public static final int NEAREST = 9728;
        public static final int NEAREST_MIPMAP_LINEAR = 9986;
        public static final int NEAREST_MIPMAP_NEAREST = 9984;

        private FilterModes() {
        }
    }

    public final class WrapAxes {
        public static final int R = 32882;
        public static final int S = 10242;
        public static final int T = 10243;

        private WrapAxes() {
        }
    }

    public final class WrapModes {
        public static final int CLAMP_TO_EDGE = 33071;
        public static final int MIRRORED_REPEAT = 33648;
        public static final int REPEAT = 10497;

        private WrapModes() {
        }
    }

    public GLSamplerObject() {
        int[] iArr = new int[1];
        GLES30.glGenSamplers(1, iArr, 0);
        this.id = iArr[0];
    }

    public static void unbind(int i) {
        GLES30.glBindSampler(i, 0);
    }

    public void bind(int i) {
        GLES30.glBindSampler(i, this.id);
    }

    @Override
    public void close() {
        GLES30.glDeleteSamplers(1, new int[]{this.id}, 0);
    }

    public int id() {
        return this.id;
    }

    public void setAllWrapModes(int i) {
        setWrapMode(WrapAxes.S, i);
        setWrapMode(WrapAxes.T, i);
        setWrapMode(WrapAxes.R, i);
    }

    public void setCompareFunction(int i) {
        GLES30.glSamplerParameteri(this.id, 34893, i);
    }

    public void setCompareMode(int i) {
        GLES30.glSamplerParameteri(this.id, 34892, i);
    }

    public void setMagFilter(int i) {
        GLES30.glSamplerParameteri(this.id, 10240, i);
    }

    public void setMaxLod(float f) {
        GLES30.glSamplerParameterf(this.id, 33083, f);
    }

    public void setMinFilter(int i) {
        GLES30.glSamplerParameteri(this.id, 10241, i);
    }

    public void setMinLod(float f) {
        GLES30.glSamplerParameterf(this.id, 33082, f);
    }

    public void setMinMagFilters(int i) {
        setMinFilter(i);
        setMagFilter(i);
    }

    public void setMinMagFilters(int i, int i2) {
        setMinFilter(i);
        setMagFilter(i2);
    }

    public void setWrapMode(int i, int i2) {
        GLES30.glSamplerParameteri(this.id, i, i2);
    }

    public void setWrapMode(int i, int i2, int i3) {
        setWrapMode(WrapAxes.S, i);
        setWrapMode(WrapAxes.T, i2);
        setWrapMode(WrapAxes.R, i3);
    }
}
