package com.google.android.libraries.camera.exif;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.HashSet;

import defpackage.mbn;

public class ExifInterface {
    private static HashSet bv;
    private static HashSet bw;
    private static final ByteOrder by = ByteOrder.BIG_ENDIAN;
    public static final int c = 270;
    public int P = 0;
    public String Q = "";
    public mbn S = new mbn(by);

    public final void a(InputStream inputStream) {
        // Dummy
    }


    public static boolean a(short s2) {
        return bv.contains(s2);
    }

    public final void a(byte[] bArr) {
        a(new ByteArrayInputStream(bArr));
    }

    public static short c(int i2) {
        return (short) i2;
    }
}
