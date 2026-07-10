package com.google.googlex.gcam.androidutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.google.googlex.gcam.androidutils.Array2D;
import com.google.googlex.gcam.androidutils.vecmath.Matrix4f;
import com.google.googlex.gcam.androidutils.vecmath.VecmathFunctions;
import com.google.googlex.gcam.androidutils.vecmath.Vector2i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class AndroidUtilities {
    public static final String TAG = AndroidUtilities.class.getSimpleName();

    private AndroidUtilities() {
    }

    public static Vector2i biggestSizeLEq(List list, Vector2i vector2i) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Vector2i vector2i2 = (Vector2i) it.next();
            if (vector2i2.x <= vector2i.x && vector2i2.y <= vector2i.y) {
                arrayList.add(vector2i2);
            }
        }
        return getLargestSizeByPixelCount(arrayList);
    }

    public static void copyImage(Image image, ByteBuffer[] byteBufferArr) {
        Image.Plane[] planes = image.getPlanes();
        for (int i = 0; i < planes.length; i++) {
            BufferUtilities.copy(planes[i].getBuffer(), byteBufferArr[i]);
        }
    }

    public static void copyImage(Array2D.U8x4 u8x4, Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            if (u8x4.width() != bitmap.getWidth() || u8x4.height() != bitmap.getHeight()) {
                throw new IndexOutOfBoundsException("copyImage requires that thesrcArray and dstBitmap have the same dimensions.");
            }
            if (u8x4.rowStrideBytes() != bitmap.getRowBytes()) {
                throw new IndexOutOfBoundsException("copyImage requires that thesrcArray and dstBitmap have the same row strides.");
            }
            bitmap.copyPixelsFromBuffer(u8x4.buffer());
            return;
        }
        throw new RuntimeException("dstBitmap must be of config ARGB_8888");
    }

    public static String floatArrayToString(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int i = 0;
        while (true) {
            int length = fArr.length - 1;
            if (i >= length) {
                sb.append(fArr[length]);
                sb.append(" ]");
                return sb.toString();
            }
            sb.append(fArr[i]);
            sb.append(", ");
            i++;
        }
    }

    public static int getDeviceRotation(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
    }

    public static Vector2i getLargestSizeByPixelCount(List<Vector2i> list) {
        return Collections.max(list, (vector2i, vector2i2) -> {
            int i = vector2i.x * vector2i.y;
            int i2 = vector2i2.x * vector2i2.y;
            if (i < i2) {
                return -1;
            }
            return i > i2 ? 1 : 0;
        });
    }

    public static final String getMd5HashAsHex(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    String valueOf = String.valueOf(hexString);
                    hexString = valueOf.length() != 0 ? "0".concat(valueOf) : new String("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.w(TAG, "MD5 not installed.");
            return null;
        }
    }

    public static float getSeekBarValue(SeekBar seekBar, float f, float f2) {
        return MathUtils.linearRescaleRanges(seekBar.getProgress(), 0.0f, seekBar.getMax(), f, f2);
    }

    public static int maxIndex(List list) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        int i = 0;
        int intValue = ((Integer) list.get(0)).intValue();
        int i2 = 1;
        while (i2 < list.size()) {
            int intValue2 = ((Integer) list.get(i2)).intValue();
            int i3 = intValue2 > intValue ? intValue2 : intValue;
            if (intValue2 > intValue) {
                i = i2;
            }
            i2++;
            intValue = i3;
        }
        return i;
    }

    public static BufferedInputStream openBinaryFileForReading(File file, int i) {
        try {
            return new BufferedInputStream(new FileInputStream(file), i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedInputStream openBinaryFileForReading(String str, int i) {
        return openBinaryFileForReading(new File(str), i);
    }

    public static BufferedOutputStream openBinaryFileForWriting(File file, int i) {
        try {
            return new BufferedOutputStream(new FileOutputStream(file), i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedOutputStream openBinaryFileForWriting(String str, int i) {
        return openBinaryFileForWriting(new File(str), i);
    }

    public static BufferedReader openTextFileForReading(File file, int i) {
        try {
            return new BufferedReader(new FileReader(file), i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedReader openTextFileForReading(String str, int i) {
        return openTextFileForReading(new File(str), i);
    }

    public static String readRawResource(Resources resources, int i) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resources.openRawResource(i)));
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (IOException e) {
            //pao.a.b(e);
        }
        return sb.toString();
    }

    public static void setSeekBarToValue(SeekBar seekBar, float f, float f2, float f3) {
        seekBar.setProgress(MathUtils.linearRescaleRangesAndRound(f, f2, f3, 0.0f, seekBar.getMax()));
    }

    public static Matrix4f textureMatrixForRotatedSensorAndDisplay(int i, int i2, int i3) {
        Matrix4f rotateUnitSquareCCWNinety = VecmathFunctions.rotateUnitSquareCCWNinety(i - i2);
        return i3 != 0 ? VecmathFunctions.mul(VecmathFunctions.flipUnitSquareY(), rotateUnitSquareCCWNinety) : rotateUnitSquareCCWNinety;
    }
}
