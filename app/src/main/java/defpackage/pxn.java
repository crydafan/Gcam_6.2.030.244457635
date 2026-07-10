package defpackage;

import android.content.Context;

public final class pxn {
    public static cgv a;
    public static Context b;

    public static char a(char c) {
        return (c < 'a' || c > 'z') ? c : (char) (c - ' ');
    }

    public static int a(String str, byte[] bArr, int i, int i2) {
        int length = str.length();
        int i3 = i;
        byte b2 = 1;
        while (b2 != 0) {
            b2 = bArr[i2];
            i2++;
            if (b2 == 0) {
                break;
            } else if (i3 == length || str.charAt(i3) != (b2 & 255)) {
                return -1;
            } else {
                i3++;
            }
        }
        return i3;
    }

    public static int a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = 1;
            while (b2 != 0) {
                b2 = bArr[i];
                i++;
            }
        }
        return i;
    }

    public static String a(String str) {
        char charAt;
        int i = 0;
        while (i < str.length() && ((charAt = str.charAt(i)) < 'A' || charAt > 'Z')) {
            i++;
        }
        if (i != str.length()) {
            StringBuilder sb = new StringBuilder(str.substring(0, i));
            while (i < str.length()) {
                sb.append(b(str.charAt(i)));
                i++;
            }
            return sb.toString();
        }
        return str;
    }

    public static boolean a(String str, String str2) {
        if (!pxm.a(str, str2)) {
            int length = str.length();
            if (length != str2.length()) {
                return false;
            }
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2 && b(charAt) != b(charAt2)) {
                    break;
                }
                i++;
            }
            return i == length;
        }
        return true;
    }

    public static char b(char c) {
        return (c < 'A' || c > 'Z') ? c : (char) (c + ' ');
    }

    public static int b(String str, String str2) {
        if (!pxm.a(str, str2)) {
            return a(str).compareTo(a(str2));
        }
        return 0;
    }

    public static String b(String str) {
        char charAt;
        int i = 0;
        while (i < str.length() && ((charAt = str.charAt(i)) < 'a' || charAt > 'z')) {
            i++;
        }
        if (i != str.length()) {
            StringBuilder sb = new StringBuilder(str.substring(0, i));
            while (i < str.length()) {
                sb.append(a(str.charAt(i)));
                i++;
            }
            return sb.toString();
        }
        return str;
    }

    public static String c(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i = 1;
            if (charAt < 'a' || charAt > 'z') {
                while (i < str.length() && (charAt < 'A' || charAt > 'Z')) {
                    i++;
                }
            } else {
                i = 0;
            }
            if (i == str.length()) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.substring(0, i));
            if (i == 0) {
                sb.append(a(str.charAt(i)));
                i++;
            }
            while (i < str.length()) {
                sb.append(b(str.charAt(i)));
                i++;
            }
            return sb.toString();
        }
        return str;
    }

    public static boolean c(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return c >= 'a' && c <= 'z';
    }

    public static boolean d(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!c(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(char c) {
        return c(c) || d(c);
    }

    public static boolean e(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!e(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}