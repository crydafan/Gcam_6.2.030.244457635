package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class kvd {
    public static final int[] a = a();
    private static final SparseArray<String> b;

    static {
        b = new SparseArray<>();
        b.append(0, "com.google.android.camera.experimental2015.ExperimentalKeys");
        b.append(1, "com.google.android.camera.experimental2016.ExperimentalKeys");
        b.append(2, "com.google.android.camera.experimental2017.ExperimentalKeys");
        b.append(3, "com.google.android.camera.experimental2018.ExperimentalKeys");
    }

    public static OutputConfiguration a(Size size, Class cls) {
        return new OutputConfiguration(size, cls);
    }

    public static void a(CameraCaptureSession cameraCaptureSession, List list) {
        try {
            cameraCaptureSession.finalizeOutputConfigurations(list);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public static void a(OutputConfiguration outputConfiguration, Surface surface) {
        outputConfiguration.addSurface(surface);
    }

    public static void a(ImageReader imageReader) {
        imageReader.discardFreeBuffers();
    }

    public static void a(MediaRecorder mediaRecorder, int i, int i2) {
        mediaRecorder.setVideoEncodingProfileLevel(i, i2);
    }

    public static boolean a(int i) {
        return Arrays.binarySearch(a, i) >= 0;
    }

    public static boolean a(int[] iArr) {
        return Arrays.binarySearch(iArr, 3) >= 0;
    }

    private static int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < b.size(); i2++) {
            try {
                Class.forName((String) b.valueAt(i2));
                arrayList.add(Integer.valueOf(b.keyAt(i2)));
            } catch (ClassNotFoundException e) {
            } catch (NoClassDefFoundError e2) {
            }
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i3 = 0;
        while (i < size) {
            iArr[i3] = ((Integer) arrayList.get(i)).intValue();
            i++;
            i3++;
        }
        Arrays.sort(iArr);
        return iArr;
    }
}