package com.google.googlex.gcam.androidutils;

import com.google.googlex.gcam.androidutils.vecmath.Vector2f;
import com.google.googlex.gcam.androidutils.vecmath.Vector2i;
import com.google.googlex.gcam.androidutils.vecmath.Vector3f;
import com.google.googlex.gcam.androidutils.vecmath.Vector3i;
import com.google.googlex.gcam.androidutils.vecmath.Vector4f;
import com.google.googlex.gcam.androidutils.vecmath.Vector4i;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.List;

public class BufferUtilities {
    public static void copy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.position() == 0 && byteBuffer2.position() == 0 && byteBuffer.limit() == byteBuffer.capacity() && byteBuffer2.limit() == byteBuffer2.capacity() && byteBuffer.capacity() == byteBuffer2.capacity()) {
            byteBuffer2.duplicate().put(byteBuffer.duplicate());
            return;
        }
        throw new IllegalArgumentException("Cannot copy buffers that do not have default position and capacity.");
    }

    public static void fill(ByteBuffer byteBuffer, byte b) {
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put(i, b);
        }
    }

    public static void put(FloatBuffer floatBuffer, Vector2f vector2f) {
        floatBuffer.put(vector2f.x);
        floatBuffer.put(vector2f.y);
    }

    public static void put(FloatBuffer floatBuffer, Vector3f vector3f) {
        floatBuffer.put(vector3f.x);
        floatBuffer.put(vector3f.y);
        floatBuffer.put(vector3f.z);
    }

    public static void put(FloatBuffer floatBuffer, Vector4f vector4f) {
        floatBuffer.put(vector4f.x);
        floatBuffer.put(vector4f.y);
        floatBuffer.put(vector4f.z);
        floatBuffer.put(vector4f.w);
    }

    public static void put(IntBuffer intBuffer, Vector2i vector2i) {
        intBuffer.put(vector2i.x);
        intBuffer.put(vector2i.y);
    }

    public static void put(IntBuffer intBuffer, Vector3i vector3i) {
        intBuffer.put(vector3i.x);
        intBuffer.put(vector3i.y);
        intBuffer.put(vector3i.z);
    }

    public static void put(IntBuffer intBuffer, Vector4i vector4i) {
        intBuffer.put(vector4i.x);
        intBuffer.put(vector4i.y);
        intBuffer.put(vector4i.z);
        intBuffer.put(vector4i.w);
    }

    public static void putVertices2D(FloatBuffer floatBuffer, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            put(floatBuffer, (Vector2f) it.next());
        }
    }

    public static void putVertices2D(FloatBuffer floatBuffer, List list, float f) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Vector2f vector2f = (Vector2f) it.next();
            floatBuffer.put(vector2f.x);
            floatBuffer.put(vector2f.y);
            floatBuffer.put(f);
        }
    }

    public static void putVertices2D(FloatBuffer floatBuffer, List list, float f, float f2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Vector2f vector2f = (Vector2f) it.next();
            floatBuffer.put(vector2f.x);
            floatBuffer.put(vector2f.y);
            floatBuffer.put(f);
            floatBuffer.put(f2);
        }
    }

    public static void putVertices3D(FloatBuffer floatBuffer, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            put(floatBuffer, (Vector3f) it.next());
        }
    }

    public static void putVertices3D(FloatBuffer floatBuffer, List list, float f) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Vector3f vector3f = (Vector3f) it.next();
            floatBuffer.put(vector3f.x);
            floatBuffer.put(vector3f.y);
            floatBuffer.put(vector3f.z);
            floatBuffer.put(f);
        }
    }

    public static void putVertices4D(FloatBuffer floatBuffer, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            put(floatBuffer, (Vector4f) it.next());
        }
    }

    public static FloatBuffer toFloatBuffer2D(List list) {
        int size = list.size();
        FloatBuffer allocate = FloatBuffer.allocate(size + size);
        putVertices2D(allocate, list);
        return allocate;
    }

    public static FloatBuffer toFloatBuffer2D(List list, float f) {
        FloatBuffer allocate = FloatBuffer.allocate(list.size() * 3);
        putVertices2D(allocate, list, f);
        return allocate;
    }

    public static FloatBuffer toFloatBuffer2D(List list, float f, float f2) {
        FloatBuffer allocate = FloatBuffer.allocate(list.size() << 2);
        putVertices2D(allocate, list, f, f2);
        return allocate;
    }

    public static FloatBuffer toFloatBuffer3D(List list) {
        FloatBuffer allocate = FloatBuffer.allocate(list.size() * 3);
        putVertices3D(allocate, list);
        return allocate;
    }

    public static FloatBuffer toFloatBuffer3D(List list, float f) {
        FloatBuffer allocate = FloatBuffer.allocate(list.size() << 2);
        putVertices3D(allocate, list, f);
        return allocate;
    }

    public static FloatBuffer toFloatBuffer4D(List list) {
        FloatBuffer allocate = FloatBuffer.allocate(list.size() << 2);
        putVertices4D(allocate, list);
        return allocate;
    }
}
