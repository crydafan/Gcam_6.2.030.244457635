package com.google.googlex.gcam.androidutils.camera2;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.util.Size;
import com.google.googlex.gcam.androidutils.vecmath.Vector2i;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Camera2Utilities {
    public static final String TAG = Camera2Utilities.class.getSimpleName();

    private Camera2Utilities() {
    }

    public static String dumpCaptureResultToString(CaptureResult captureResult) {
        StringBuilder sb = new StringBuilder();
        for (CaptureResult.Key<?> key : captureResult.getKeys()) {
            String str = TAG;
            String valueOf = String.valueOf(key.getName());
            Log.d(str, valueOf.length() == 0 ? new String("key = ") : "key = ".concat(valueOf));
            sb.append(key.getName());
            sb.append("\t");
            sb.append(metadataValueToString(captureResult.get(key)));
        }
        return sb.toString();
    }

    public static String getIdOfFirstCameraWithFacing(CameraManager cameraManager, int i) {
        String[] cameraIdList;
        try {
            for (String str : cameraManager.getCameraIdList()) {
                if ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) == i) {
                    return str;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List getOutputSizes(StreamConfigurationMap streamConfigurationMap, int i) {
        return sizeArrayToVector2iList(streamConfigurationMap.getOutputSizes(i));
    }

    public static List getSupportedJPEGSizes(StreamConfigurationMap streamConfigurationMap) {
        return getOutputSizes(streamConfigurationMap, 256);
    }

    public static List getSupportedOpenGLSizes(StreamConfigurationMap streamConfigurationMap) {
        if (StreamConfigurationMap.isOutputSupportedFor(SurfaceTexture.class)) {
            return sizeArrayToVector2iList(streamConfigurationMap.getOutputSizes(SurfaceTexture.class));
        }
        return null;
    }

    public static List getSupportedRaw10Sizes(StreamConfigurationMap streamConfigurationMap) {
        return getOutputSizes(streamConfigurationMap, 37);
    }

    public static List getSupportedRawSensorSizes(StreamConfigurationMap streamConfigurationMap) {
        return getOutputSizes(streamConfigurationMap, 32);
    }

    public static List getSupportedYUVSizes(StreamConfigurationMap streamConfigurationMap) {
        return getOutputSizes(streamConfigurationMap, 35);
    }

    private static String metadataValueToString(Object obj) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                sb.append(metadataValueToString(Array.get(obj, i)));
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(']');
            return sb.toString();
        }
        return "<null>";
    }

    public static int numCameras(CameraManager cameraManager) {
        try {
            return cameraManager.getCameraIdList().length;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List sizeArrayToVector2iList(Size[] sizeArr) {
        if (sizeArr != null) {
            ArrayList arrayList = new ArrayList(sizeArr.length);
            for (Size size : sizeArr) {
                arrayList.add(new Vector2i(size.getWidth(), size.getHeight()));
            }
            return arrayList;
        }
        return null;
    }
}
