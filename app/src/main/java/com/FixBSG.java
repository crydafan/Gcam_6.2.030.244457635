package com;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Size;

import com.google.googlex.gcam.DebugParams;
import com.google.googlex.gcam.Gcam;
import com.google.googlex.gcam.InitParams;
import com.google.googlex.gcam.StaticMetadataVector;
import com.google.googlex.gcam.Tuning;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import java.lang.reflect.InvocationTargetException;

import defpackage.gvk;
import defpackage.ltm;
import defpackage.lto;
import defpackage.mmb;
import defpackage.mpz;

public class FixBSG {
    public static int CameraSwitch;
    public static int GAwb;
    public static CaptureResult.Key<Integer> fixAFSceneResKey;
    public static CameraCharacteristics.Key<float[]> fixDistCCKey;
    public static CaptureResult.Key<float[]> fixDistCRKey;
    public static CaptureRequest.Key<Integer> fixOISReqKey;
    public static CaptureResult.Key<Integer> fixOISResKey;
    public static int sAutoHDRP;
    public static mmb sBack;
    public static int sCam;
    public static DebugParams sDebugParams;
    public static int sFlash;
    public static int sFrames;
    public static mmb sFront;
    public static Gcam sGcam;
    public static float sGetActual_analog_gain;
    public static float sGetActual_exposure_time_ms;
    public static float sGetApplied_digital_gain;
    public static float sGetDesired_analog_gain;
    public static float sGetDesired_digital_gain;
    public static float sGetDesired_exposure_time_ms;
    public static String sGetDevice;
    public static String sGetMake;
    public static float sGetMaxISO;
    public static float sGetPost_raw_digital_gain;
    public static String sInExifModel;
    public static String sInputStyleDev;
    public static String sInputStyleMan;
    public static int sJPGQuality;
    public static int sLensBlurMPB;
    public static int sLensBlurMPF;
    public static gvk sLgvk;
    public static float sMotion_score;
    public static int sNSOn;
    public static int sPhotoFrames;
    public static int sPhotoFramesCount;
    public static int sRAWImageAvailable;
    public static int sReInit;

    public FixBSG() {
        getInputStyle();
        fixKey();
        CameraSwitch = -1;
    }

    public static int CalcFrames(mmb mmbVar, mpz mipVar) {
        int intValue = mmbVar.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getLower();
        int quality = getQuality();
        if (quality != 0) {
            quality = getQuality()
                    - ((mipVar.a(CaptureResult.SENSOR_SENSITIVITY) / intValue) / (32 / quality));
        }
        sFrames = quality + 8;
        return sFrames;
    }

    public static lto FixSlowMo(ltm ltmVar, lto ltoVar) {
        if (ltm.FPS_30 != ltmVar) {
            if (ltm.FPS_AUTO == ltmVar || ltm.FPS_60 == ltmVar) {
                return lto.RES_1080P;
            }
            if (ltm.FPS_120_HFR_4X == ltmVar) {
                return lto.RES_1080P;
            }
            if (ltm.FPS_240_HFR_8X == ltmVar) {
                return lto.RES_720P;
            }
        }
        return ltoVar;
    }

    public static void GetLens(mmb mmbVar) {
        sGetMaxISO = mmbVar.b(CameraCharacteristics.SENSOR_MAX_ANALOG_SENSITIVITY)
                / mmbVar.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE).getLower();
        sCam = mmbVar.a(CameraCharacteristics.LENS_FACING);
        Size size = mmbVar.b(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        int height = (int) ((size.getHeight() * size.getWidth()) / 1000000.0f);
        if (sCam != 0) {
            sLensBlurMPB = height;
        } else {
            sLensBlurMPF = height;
        }
    }

    @SuppressLint("PrivateApi")
    private static Context getApplicationContext() {
        try {
            Class<?> appGlobals = Class.forName("android.app.AppGlobals");
            Application initialApplication = (Application) (appGlobals.getMethod("getInitialApplication").invoke(null));
            assert initialApplication != null;
            return initialApplication
                    .createPackageContext(initialApplication.getPackageName(), Context.CONTEXT_INCLUDE_CODE)
                    .getApplicationContext();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException
                | PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int MenuValue(String str) {
        Context applicationContext = getApplicationContext();
        boolean contains = PreferenceManager.getDefaultSharedPreferences(applicationContext).contains(str);
        return contains
                ? Integer.parseInt(
                        PreferenceManager.getDefaultSharedPreferences(applicationContext).getString(str, null))
                : 0;
    }

    public static int MenuValueIMG() {
        if (!Build.DEVICE.equals("aura")) {
            Context applicationContext = getApplicationContext();
            if (PreferenceManager.getDefaultSharedPreferences(applicationContext).contains("img_key")) {
                return Integer.parseInt(
                        PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("img_key", null));
            }
        }
        return 256;
    }

    public static int MenuValueRAW() {
        if (!Build.DEVICE.equals("aura")) {
            Context applicationContext = getApplicationContext();
            if (PreferenceManager.getDefaultSharedPreferences(applicationContext).contains("raw_key")) {
                return Integer.parseInt(
                        PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("raw_key", null));
            }
        }
        return 37;
    }

    public static void MinISOParamDesired() {
        int MenuValue;
        if (sNSOn == 0) {
            MenuValue = MenuValue("quality_key");
        } else {
            MenuValue = MenuValue("quality_ns_key");
        }
        if (MenuValue == 0) {
            return;
        }
        float exposureTimeMs = sGetDesired_exposure_time_ms;
        float iso = sGetDesired_analog_gain * sGetDesired_digital_gain;
        float tet = iso * exposureTimeMs;
        float f4 = MenuValue / 10.0f;
        float f5 = iso / f4;
        float f6 = exposureTimeMs * f4;
        if (f5 <= 1.0f) {
            sGetDesired_exposure_time_ms = tet;
            sGetDesired_analog_gain = 1.0f;
            sGetDesired_digital_gain = 1.0f;
            return;
        }
        float f7 = sGetMaxISO;
        if (f5 > f7) {
            sGetDesired_exposure_time_ms = f6;
            sGetDesired_analog_gain = f7;
            sGetDesired_digital_gain = f5 / f7;
            return;
        }
        sGetDesired_exposure_time_ms = f6;
        sGetDesired_analog_gain = f5;
        sGetDesired_digital_gain = 1.0f;
    }

    public static Gcam UpdateCameras(Gcam gcam) {
        if (gcam != null && sDebugParams != null) {
            InitParams GetInitParams = gcam.GetInitParams();
            StaticMetadataVector staticMetadataVector = new StaticMetadataVector();
            staticMetadataVector.add(MetadataConverter.convertToGcamStaticMetadata(sBack));
            staticMetadataVector.add(MetadataConverter.convertToGcamStaticMetadata(sFront));
            if (!staticMetadataVector.isEmpty()) {
                return Gcam.Create(GetInitParams, staticMetadataVector, sDebugParams);
            }
        }
        return gcam;
    }

    public static void UpdateParam() {
        getJPGQuality();
    }

    public static void fixKey() {
        if (Build.VERSION.SDK_INT >= 28) {
            fixDistCCKey = CameraCharacteristics.LENS_DISTORTION;
            fixDistCRKey = CaptureResult.LENS_DISTORTION;
            fixOISReqKey = CaptureRequest.STATISTICS_OIS_DATA_MODE;
            fixOISResKey = CaptureResult.STATISTICS_OIS_DATA_MODE;
            fixAFSceneResKey = CaptureResult.CONTROL_AF_SCENE_CHANGE;
            return;
        }
        fixDistCCKey = CameraCharacteristics.LENS_RADIAL_DISTORTION;
        fixDistCRKey = CaptureResult.LENS_RADIAL_DISTORTION;
        fixOISReqKey = CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE;
        fixOISResKey = CaptureResult.LENS_OPTICAL_STABILIZATION_MODE;
        fixAFSceneResKey = CaptureResult.CONTROL_SCENE_MODE;
    }

    public static void getInputModel(mmb mmbVar) {
        GetLens(mmbVar);
        int MenuValue = sCam != 0 ? MenuValue("model_b_key") : MenuValue("model_f_key");
        if (MenuValue != 0) {
            if (MenuValue == 1) {
                sGetMake = "LGE";
                sGetDevice = "bullhead";
                sInExifModel = " (GCam - Nexus 5X ";
                return;
            } else if (MenuValue == 2) {
                sGetMake = "Huawei";
                sGetDevice = "Angler";
                sInExifModel = " (GCam - Nexus 6P ";
                return;
            } else if (MenuValue == 3) {
                sGetMake = "google";
                sGetDevice = "marlin";
                sInExifModel = " (GCam - Pixel XL ";
                return;
            } else if (MenuValue != 4) {
                if (MenuValue == 5) {
                    sGetMake = "google";
                    sGetDevice = "taimen";
                    sInExifModel = " (GCam - Pixel II XL ";
                    return;
                } else if (MenuValue == 6) {
                    sGetMake = "google";
                    sGetDevice = "blueline";
                    sInExifModel = " (GCam - Pixel III ";
                    return;
                } else if (MenuValue == 7) {
                    sGetMake = "google";
                    sGetDevice = "crosshatch";
                    sInExifModel = " (GCam - Pixel III XL ";
                    return;
                } else if (MenuValue == 8) {
                    sGetMake = "google";
                    sGetDevice = "sargo";
                    sInExifModel = " (GCam - Pixel III+ ";
                    return;
                } else if (MenuValue != 9) {
                    sGetMake = Build.MANUFACTURER;
                    sGetDevice = Build.DEVICE;
                    sInExifModel = " (GCam - None ";
                    return;
                } else {
                    sGetMake = "google";
                    sGetDevice = "bonito";
                    sInExifModel = " (GCam - Pixel III+ XL ";
                    return;
                }
            }
        }
        sGetMake = "google";
        sGetDevice = "walleye";
        sInExifModel = " (GCam - Pixel II ";
    }

    public static void getInputStyle() {
        if (Build.DEVICE.equals("aura")) {
            sInputStyleMan = "google";
            sInputStyleDev = "taimen";
        }
        int MenuValue = MenuValue("style_key");
        if (MenuValue != 0) {
            if (MenuValue == 1) {
                sInputStyleMan = "google";
                sInputStyleDev = "marlin";
                return;
            }
            if (MenuValue != 2) {
                sInputStyleMan = Build.MANUFACTURER;
                sInputStyleDev = Build.DEVICE;
                return;
            }
            sInputStyleMan = "google";
            sInputStyleDev = "crosshatch";
            return;
        }
        sInputStyleMan = "google";
        sInputStyleDev = "taimen";
    }

    public static void getJPGQuality() {
        int MenuValue = MenuValue("pref_qjpg_key");
        if (MenuValue == 0 || MenuValue == 101) {
            MenuValue = 95;
        }
        sJPGQuality = MenuValue;
    }

    public static int getQuality() {
        int MenuValue = MenuValue("quality_key");
        if (MenuValue != 0) {
            return (1 == MenuValue || 2 != MenuValue) ? 0 : 8;
        }
        return 4;
    }

    public static void setSAT(Tuning tuning, int i) {
        int sat;
        float val = 1.0f;
        if (i != 0)
            sat = MenuValue("sat_f_key");
        else
            sat = MenuValue("sat_b_key");

        if (!(sat == 0 || sat > 15))
            val = sat / 10.0f;

        tuning.GetColorSatAdj().setHighlight_saturation(val);
    }
}