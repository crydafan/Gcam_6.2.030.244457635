package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;

//
// Left as it is because I couldn't find
// a real experimental2017 jar file.
// Once I find it, the code will be
// updated and the comments will be removed.
//
public final class kvf {
    public static /*final*/ Integer A;
    public static /*final*/ CaptureResult.Key B;
    private static final boolean C = kvd.a(2);
    private static final boolean D = kvd.a(3);
    public static /*final*/ CameraCharacteristics.Key a;
    public static /*final*/ CaptureRequest.Key b;
    public static /*final*/ CaptureRequest.Key c;
    public static /*final*/ Byte d;
    public static /*final*/ Byte e;
    public static /*final*/ Byte f;
    public static /*final*/ CaptureResult.Key g;
    public static /*final*/ CaptureResult.Key<Long> h;
    public static /*final*/ CaptureResult.Key<long[]> i;
    @Deprecated
    public static /*final*/ CaptureResult.Key<int[]> j;
    @Deprecated
    public static /*final*/ CaptureResult.Key<int[]> k;
    public static /*final*/ CaptureResult.Key<float[]> l;
    public static /*final*/ CaptureResult.Key<float[]> m;
    public static /*final*/ CaptureResult.Key<Float> n;
    public static /*final*/ CaptureResult.Key o;
    public static /*final*/ CaptureRequest.Key p;
    public static /*final*/ Integer q;
    public static /*final*/ CaptureResult.Key r;
    public static /*final*/ CaptureResult.Key s;
    public static /*final*/ CaptureRequest.Key t;
    public static /*final*/ CaptureRequest.Key u;
    public static /*final*/ CameraCharacteristics.Key v;
    public static /*final*/ CameraCharacteristics.Key w;
    public static /*final*/ CameraCharacteristics.Key x;
    public static /*final*/ CameraCharacteristics.Key y;
    public static /*final*/ CaptureRequest.Key z;
/*
    static {
        CaptureResult.Key key = null;
        a = C ? ExperimentalKeys.EXPERIMENTAL_SENSOR_EEPROM_INFORMATION : null;
        if (C) {
            e();
        }
        b = (!C || !e()) ? null : ExperimentalKeys.EXPERIMENTAL_SENSOR_PD_ENABLE;
        c = C ? ExperimentalKeys.EXPERIMENTAL_CONTROL_TRACKING_AF_TRIGGER : null;
        d = (byte) 0;
        e = (byte) 1;
        f = (byte) 2;
        g = C ? ExperimentalKeys.EXPERIMENTAL_CONTROL_AF_REGIONS_CONFIDENCE : null;
        h = C ? ExperimentalKeys.EXPERIMENTAL_STATS_OIS_FRAME_TIMESTAMP_BOOTTIME : null;
        i = C ? ExperimentalKeys.EXPERIMENTAL_STATS_OIS_TIMESTAMPS_BOOTTIME : null;
        j = C ? ExperimentalKeys.EXPERIMENTAL_STATS_OIS_SHIFT_X : null;
        k = C ? ExperimentalKeys.EXPERIMENTAL_STATS_OIS_SHIFT_Y : null;
        l = (!C || !c()) ? null : ExperimentalKeys.EXPERIMENTAL_STATS_OIS_SHIFT_PIXEL_X;
        m = (!C || !c()) ? null : ExperimentalKeys.EXPERIMENTAL_STATS_OIS_SHIFT_PIXEL_Y;
        n = (!C || !d()) ? null : ExperimentalKeys.EXPERIMENTAL_CONTROL_EXP_TIME_BOOST;
        o = f() ? ExperimentalKeys.EXPERIMENTAL_REQUEST_NEXT_STILL_INTENT_REQUEST_READY : null;
        p = f() ? ExperimentalKeys.EXPERIMENTAL_REQUEST_POSTVIEW : null;
        q = 1;
        r = f() ? ExperimentalKeys.EXPERIMENTAL_REQUEST_POSTVIEW_CONFIG : null;
        s = f() ? ExperimentalKeys.EXPERIMENTAL_REQUEST_POSTVIEW_DATA : null;
        t = f() ? ExperimentalKeys.EXPERIMENTAL_CONTINUOUS_ZSL_CAPTURE : null;
        u = (!C || !g()) ? (!D || !g()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.EXPERIMENTAL_DISABLE_HDRPLUS : ExperimentalKeys.EXPERIMENTAL_DISABLE_HDRPLUS;
        h();
        if (C) {
            a();
        }
        if (C) {
            a();
        }
        if (C) {
            a();
        }
        v = (!C || !b()) ? (!D || !b()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.NEXUS_EXPERIMENTAL_EEPROM_WB_CALIB_NUM_LIGHTS : ExperimentalKeys.NEXUS_EXPERIMENTAL_2017_EEPROM_WB_CALIB_NUM_LIGHTS;
        w = (!C || !b()) ? (!D || !b()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.NEXUS_EXPERIMENTAL_EEPROM_WB_CALIB_R_OVER_G_RATIOS : ExperimentalKeys.NEXUS_EXPERIMENTAL_2017_EEPROM_WB_CALIB_R_OVER_G_RATIOS;
        x = (!C || !b()) ? (!D || !b()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.NEXUS_EXPERIMENTAL_EEPROM_WB_CALIB_B_OVER_G_RATIOS : ExperimentalKeys.NEXUS_EXPERIMENTAL_2017_EEPROM_WB_CALIB_B_OVER_G_RATIOS;
        y = (!C || !b()) ? (!D || !b()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.NEXUS_EXPERIMENTAL_EEPROM_WB_CALIB_GR_OVER_GB_RATIO : ExperimentalKeys.NEXUS_EXPERIMENTAL_2017_EEPROM_WB_CALIB_GR_OVER_GB_RATIO;
        z = (!C || !i()) ? (!D || !i()) ? null : com.google.android.camera.experimental2018.ExperimentalKeys.EXPERIMENTAL_STATS_MOTION_DETECTION_ENABLE : ExperimentalKeys.EXPERIMENTAL_STATS_MOTION_DETECTION_ENABLE;
        A = 1;
        if ((!C || !i()) && D) {
            i();
        }
        if ((!C || !i()) && D) {
            i();
        }
        if (C && i()) {
            key = ExperimentalKeys.EXPERIMENTAL_STATS_SUBJECT_MOTION;
        } else if (D && i()) {
            key = com.google.android.camera.experimental2018.ExperimentalKeys.EXPERIMENTAL_STATS_SUBJECT_MOTION;
        }
        B = key;
    }

    private static boolean a() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() >= 7;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean b() {
        try {
            if (C) {
                if (ExperimentalKeys.getLibraryVersion() >= 10) {
                    return true;
                }
            } else if (!D) {
                return false;
            } else {
                if (com.google.android.camera.experimental2018.ExperimentalKeys.getLibraryVersion() > 0) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchFieldError e2) {
            return false;
        } catch (NoSuchMethodError e3) {
            return false;
        }
    }

    private static boolean c() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() >= 3;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean d() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() >= 2;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean e() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() > 0;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean f() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() >= 4;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean g() {
        try {
            if (C) {
                if (ExperimentalKeys.getLibraryVersion() >= 5) {
                    return true;
                }
            } else if (!D) {
                return false;
            } else {
                if (com.google.android.camera.experimental2018.ExperimentalKeys.getLibraryVersion() >= 3) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchFieldError e2) {
            return false;
        } catch (NoSuchMethodError e3) {
            return false;
        }
    }

    private static boolean h() {
        if (C) {
            try {
                return ExperimentalKeys.getLibraryVersion() >= 6;
            } catch (NoSuchFieldError e2) {
                return false;
            } catch (NoSuchMethodError e3) {
                return false;
            }
        }
        return false;
    }

    private static boolean i() {
        try {
            if (C) {
                if (ExperimentalKeys.getLibraryVersion() >= 9) {
                    return true;
                }
            } else if (!D) {
                return false;
            } else {
                if (com.google.android.camera.experimental2018.ExperimentalKeys.getLibraryVersion() >= 4) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchFieldError e2) {
            return false;
        } catch (NoSuchMethodError e3) {
            return false;
        }
    }
 */
}