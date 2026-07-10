package com.google.googlex.gcam.androidutils;

import android.util.Log;

public class Logf {
    public static int d(String str, String str2, Throwable th, Object... objArr) {
        return Log.d(str, String.format(str2, objArr), th);
    }

    public static int d(String str, String str2, Object... objArr) {
        return Log.d(str, String.format(str2, objArr));
    }

    public static int e(String str, String str2, Throwable th, Object... objArr) {
        return Log.e(str, String.format(str2, objArr), th);
    }

    public static int e(String str, String str2, Object... objArr) {
        return Log.e(str, String.format(str2, objArr));
    }

    public static int i(String str, String str2, Throwable th, Object... objArr) {
        return Log.i(str, String.format(str2, objArr), th);
    }

    public static int i(String str, String str2, Object... objArr) {
        return Log.i(str, String.format(str2, objArr));
    }

    public static int println(int i, String str, String str2, Object... objArr) {
        return Log.println(i, str, String.format(str2, objArr));
    }

    public static int v(String str, String str2, Throwable th, Object... objArr) {
        return Log.v(str, String.format(str2, objArr), th);
    }

    public static int v(String str, String str2, Object... objArr) {
        return Log.v(str, String.format(str2, objArr));
    }

    public static int w(String str, String str2, Throwable th, Object... objArr) {
        return Log.w(str, String.format(str2, objArr), th);
    }

    public static int w(String str, String str2, Object... objArr) {
        return Log.w(str, String.format(str2, objArr));
    }

    public static int wtf(String str, String str2, Throwable th, Object... objArr) {
        return Log.wtf(str, String.format(str2, objArr), th);
    }

    public static int wtf(String str, String str2, Object... objArr) {
        return Log.wtf(str, String.format(str2, objArr));
    }
}
