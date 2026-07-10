package defpackage;

import android.annotation.SuppressLint;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class mpn {
    private final Method a;
    private final Method b;
    private final Method c;

    mpn() {
        Method get = null;
        Method set = null;
        Method getNum = null;

        try {
            @SuppressLint("PrivateApi")
            Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            get = systemProperties.getMethod("get", String.class, String.class);
            set = systemProperties.getMethod("set", String.class, String.class);
            try {
                getNum = systemProperties.getMethod("getInt", String.class, Integer.TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getNum = systemProperties.getMethod("getLong", String.class, Long.TYPE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new IllegalStateException("Unable to reflect SystemProperties.", e);
        } finally {
            this.a = get;
            this.b = set;
            this.c = getNum;
        }
    }

    public final int a(String key, int defValue) {
        ohr.b(key, "Key cannot be null!");
        Method getNum = this.c;
        Integer value;
        try {
            if (getNum == null || (value = (Integer) getNum.invoke(null, key, defValue)) == null) {
                return defValue;
            } else {
                return value;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e("CAM_SystemProperties", "get error", e);
            return defValue;
        }
    }

    public final String a(String key) {
        ohr.b(key, "Key cannot be null!");
        Method get = this.a;
        String value = null;
        try {
            if (get == null) {
                return null;
            }
            value = (String) get.invoke(null, key, null);
            if (value == null || value.equals("")) {
                return null;
            }
            return value;
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e("CAM_SystemProperties", "get error", e);
            return null;
        }
    }

    public final boolean a(String key, String value) {
        ohr.b(key, "Key cannot be null!");
        Method set = this.b;
        try {
            if (set != null) {
                set.invoke(null, key, value);
                return true;
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e("CAM_SystemProperties", "Could not set SystemProperty key: " + key + " to value: " + value, e);
            return false;
        }
    }
}