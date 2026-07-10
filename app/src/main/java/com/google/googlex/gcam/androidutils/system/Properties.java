package com.google.googlex.gcam.androidutils.system;

import java.lang.reflect.InvocationTargetException;

public class Properties {
    public static String readSystemProperty(String str) {
        try {
            try {
                try {
                    return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (IllegalArgumentException e2) {
                    throw new AssertionError(e2);
                } catch (InvocationTargetException e3) {
                    throw new AssertionError(e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new AssertionError("SystemProperties#get may have been renamed", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new AssertionError("SystemProperties may have been renamed", e5);
        }
    }
}
