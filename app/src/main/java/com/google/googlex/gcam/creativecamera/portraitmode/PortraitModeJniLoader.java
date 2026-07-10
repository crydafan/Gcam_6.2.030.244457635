package com.google.googlex.gcam.creativecamera.portraitmode;

import com.google.googlex.gcam.JniUtilsJniLoader;

public class PortraitModeJniLoader {
    static {
        JniUtilsJniLoader.initialize();
        System.loadLibrary("PortraitModeJni");
    }

    private PortraitModeJniLoader() {
    }

    public static void initialize() {
    }
}
