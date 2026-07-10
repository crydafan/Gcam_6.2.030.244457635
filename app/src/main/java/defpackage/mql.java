package defpackage;

import android.graphics.ImageFormat;
import android.net.Uri;

public final class mql {
    public static long a(int i, lyw lywVar) {
        int i2 = lywVar.a;
        int i3 = lywVar.b;
        int bitsPerPixel = ImageFormat.getBitsPerPixel(i);
        if (bitsPerPixel <= 0 && i == 257) {
            bitsPerPixel = 16;
        }
        return (bitsPerPixel > 0 || i != 256) ? ((i2 * Math.max(bitsPerPixel, 0)) * i3) / 8 : (((i2 * 24) * i3) / 8) / 4;
    }

    public static long a(byte[] bArr, int i) {
        return c(bArr, i + 12) & 4294967295L;
    }

    public static String a(int i) {
        if (i != 0) {
            if (i == 34) {
                return "PRIVATE";
            }
            if (i == 257) {
                return "POINT_CLOUD";
            }
            if (i == 1144402265) {
                return "DEPTH16";
            }
            switch (i) {
                case 38:
                    return "RAW12";
                case 39:
                    return "YUV_422_888";
                case 40:
                    return "YUV_444_888";
                case 41:
                    return "FLEX_RGB_888";
                case 42:
                    return "FLEX_RGBA_8888";
                default:
                    return i != 32 ? i != 37 ? i != 35 ? i != 0 ? i != 4 ? i != 20 ? i != 256 ? i != 842094169 ? i != 16 ? i != 17 ? i != 34 ? i != 35 ? Integer.toString(i) : "YUV_420_888" : "PRIVATE" : "NV21" : "NV16" : "YV12" : "JPEG" : "YUY2" : "RGB_565" : "UNKNOWN" : "YUV_420_888" : "RAW10" : "RAW_SENSOR";
            }
        }
        return "UNKNOWN";
    }

    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static long b(byte[] bArr, int i) {
        int i2 = i + 16;
        return (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 2] & 255) << 16) + ((bArr[i2 + 3] & 255) << 24) + ((bArr[i2 + 4] & 255) << 32) + ((bArr[i2 + 5] & 255) << 40) + ((bArr[i2 + 6] & 255) << 48) + ((bArr[i2 + 7] & 255) << 56);
    }

    public static boolean b(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static int c(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(c(bArr, i));
    }
}