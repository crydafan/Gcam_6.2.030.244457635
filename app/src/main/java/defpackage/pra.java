package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreUtils;

public final class pra {
    public static int a;
    public static pqw b;
    public static volatile Boolean c;
    private static Context d;

    public static Context a(Context context) {
        if (d == null) {
            int vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(context);
            if (vrCoreClientApiVersion < 9) {
                try {
                    throw new ppa(4);
                } catch (ppa e) {
                    e.printStackTrace();
                }
            }
            try {
                d = context.createPackageContext("com.google.vr.vrcore", 3);
                a = vrCoreClientApiVersion;
            } catch (PackageManager.NameNotFoundException e) {
                try {
                    throw new ppa(1);
                } catch (ppa ex) {
                    ex.printStackTrace();
                }
            }
        }
        return d;
    }

    public static IBinder a(ClassLoader classLoader, String str) {
        try {
            return (IBinder) classLoader.loadClass(str).newInstance();
        } catch (ClassNotFoundException e) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() == 0 ? "Unable to find dynamic class " : "Unable to find dynamic class ".concat(valueOf));
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(str);
            throw new IllegalStateException(valueOf2.length() == 0 ? "Unable to call the default constructor of " : "Unable to call the default constructor of ".concat(valueOf2));
        } catch (InstantiationException e3) {
            String valueOf3 = String.valueOf(str);
            throw new IllegalStateException(valueOf3.length() == 0 ? "Unable to instantiate the remote class " : "Unable to instantiate the remote class ".concat(valueOf3));
        }
    }

    public static String a(String str) {
        int length = str.length() - 19;
        if (length > 0) {
            e("CAM_Log", "Tag " + str + " is " + length + " chars longer than limit.");
        }
        String valueOf = "CAM_";
        if (length > 0) {
            str = str.substring(0, 19);
        }
        String valueOf2 = str;
        return valueOf2.length() == 0 ? valueOf : valueOf.concat(valueOf2);
    }

    public static void a(String str, String str2) {
        if (a(str, 3)) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public static boolean a(String str, int i) {
        try {
            return cff.a == 0 ? i != 2 ? "userdebug".equals(Build.TYPE) || "eng".equals(Build.TYPE) || b(str, i) : b(str, i) : cff.a <= i;
        } catch (IllegalArgumentException e) {
            String valueOf = String.valueOf(str);
            b("CAM_Log", valueOf.length() == 0 ? "String too long:" : "String too long:".concat(valueOf));
            return false;
        }
    }

    public static void b(String str, String str2) {
        if (a(str, 6)) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public static synchronized boolean b(Context context) {
        boolean booleanValue;
        synchronized (pra.class) {
            if (c == null) {
                try {
                    c = poz.a(context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES), poz.c, poz.d, poz.b);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("Unable to find self package info", e);
                }
            }
            booleanValue = c;
        }
        return booleanValue;
    }

    private static boolean b(String str, int i) {
        return Log.isLoggable("CAM_", i) || Log.isLoggable(str, i);
    }

    public static void c(String str, String str2) {
        if (a(str, 4)) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (a(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (a(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }
}