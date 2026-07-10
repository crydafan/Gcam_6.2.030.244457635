package com.google.googlex.gcam;

public class JniUtilsJniLoader {
    static {
        GcamSwigLoader.initialize();
        System.loadLibrary("JniUtilsJni");
    }

    public static void initialize() {
    }
}
