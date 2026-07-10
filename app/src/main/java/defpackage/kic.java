package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class kic {
    private static final String a = pra.a("CameraUtil");

    public static int a() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new kid());
            if (listFiles != null) {
                return listFiles.length;
            }
            pra.b(a, "Failed to count number of cores, defaulting to 1");
            return 1;
        } catch (Exception e) {
            pra.b(a, "Failed to count number of cores, defaulting to 1", e);
            return 1;
        }
    }

    public static int a(int i, int i2, int i3) {
        return i <= i3 ? Math.max(i, i2) : i3;
    }

    public static Bitmap a(byte[] bArr) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            int length = bArr.length;
            BitmapFactory.decodeByteArray(bArr, 0, length, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                return null;
            }
            double d = options.outWidth;
            double d2 = options.outHeight;
            Double.isNaN(d);
            Double.isNaN(d2);
            int ceil = (int) Math.ceil(Math.sqrt((d * d2) / 51200.0d));
            if (ceil > 8) {
                i = ((ceil + 7) / 8) << 3;
            } else {
                while (i < ceil) {
                    i += i;
                }
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeByteArray(bArr, 0, length, options);
        } catch (OutOfMemoryError e) {
            pra.b(a, "Got oom exception ", e);
            return null;
        }
    }

    public static Point a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 % 180;
        int i7 = i6 != 0 ? i : i2;
        if (i6 != 0) {
            i = i2;
        }
        Point point = new Point();
        point.x = i4;
        point.y = i5;
        if (i == 0 || i7 == 0) {
            String str = a;
            StringBuilder sb = new StringBuilder(101);
            sb.append("zero width/height, falling back to bounds (w|h|bw|bh):");
            sb.append(i);
            sb.append("|");
            sb.append(i7);
            sb.append("|");
            sb.append(i4);
            sb.append("|");
            sb.append(i5);
            pra.e(str, sb.toString());
        } else if (i5 * i <= i4 * i7) {
            point.x = (i * point.y) / i7;
        } else {
            point.y = (i7 * point.x) / i;
        }
        return point;
    }

    public static Rect a(RectF rectF) {
        Rect rect = new Rect();
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
        return rect;
    }

    public static RectF a(Rect rect) {
        return new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static int[] a(List list) {
        if (list.size() == 0) {
            pra.b(a, "No suppoted frame rates returned!");
            return null;
        }
        Iterator it = list.iterator();
        int i = 400000;
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            int i2 = iArr[0];
            if (iArr[1] >= 30000 && i2 <= 30000 && i2 < i) {
                i = i2;
            }
        }
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int[] iArr2 = (int[]) list.get(i5);
            int i6 = iArr2[0];
            int i7 = iArr2[1];
            if (i6 == i && i4 < i7) {
                i3 = i5;
                i4 = i7;
            }
        }
        if (i3 >= 0) {
            return (int[]) list.get(i3);
        }
        pra.b(a, "Can't find an appropiate frame rate range!");
        return null;
    }
}