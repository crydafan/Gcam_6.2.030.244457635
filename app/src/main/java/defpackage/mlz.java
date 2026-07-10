package defpackage;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Rational;
import android.util.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

final class mlz implements mmb {
    private final mmq f;
    private final mmp g;
    private final oet h;
    private final mpi i;
    private final lzp j;
    private final lzj k;
    private StreamConfigurationMap l = null;
    private final Object e = new Object();

    mlz(mmp mmpVar, mmq mmqVar, Set<mmp> set, mpi mpiVar, lzp lzpVar, lzj lzjVar) {
        this.g = mmpVar;
        this.f = mmqVar;
        this.h = oet.a((Collection) set);
        this.i = mpiVar;
        this.j = lzpVar;
        this.k = lzjVar.a("Characteristics");
    }

    private StreamConfigurationMap F() {
        StreamConfigurationMap streamConfigurationMap;
        synchronized (this.e) {
            if (this.l == null) {
                try {
                    String str = this.g.a;
                    String sb = "StreamConfigurationMap(" +
                            str +
                            ")#create";
                    this.j.a(sb);
                    this.l = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    this.j.a();
                } catch (Exception e) {
                    String valueOf = String.valueOf(this.g.a);
                    this.k.b(valueOf.length() != 0 ? "Unable to obtain StreamConfigurationMap for camera ".concat(valueOf) :
                            "Unable to obtain StreamConfigurationMap for camera ", e);
                    this.j.a();
                    return null;
                }
            }
            streamConfigurationMap = this.l;
        }
        return streamConfigurationMap;
    }

    @Override
    public Set A() {
        return this.f.b();
    }

    @Override
    public Set<mmp> B() {
        return this.h;
    }

    @Override
    public boolean C() {
        return f() || b() == mmt.FRONT;
    }

    @Override
    public List<Float> D() {
        float[] fArr = (float[]) this.f.a(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        ohr.b(fArr);
        Arrays.sort(fArr);
        ArrayList<Float> c = ohr.c();
        for (float f : fArr) {
            c.add(f);
        }
        return c;
    }

    @Override
    public int E() {
        int intValue = (Integer) b(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (intValue != 0) {
            int i = 1;
            if (intValue != 1) {
                i = 3;
                if (intValue != 2) {
                    if (intValue == 3) {
                        return 4;
                    }
                    if (intValue == 4) {
                        return 5;
                    }
                    String sb = "Invalid or Unknown INFO_SUPPORTED_HARDWARE_LEVEL: " +
                            intValue;
                    throw new IllegalStateException(sb);
                }
            }
            return i;
        }
        return 2;
    }

    @Override
    public long a(int i, lyw lywVar) {
        StreamConfigurationMap F = F();
        if (F != null) {
            return F.getOutputMinFrameDuration(i, lyx.b(lywVar));
        }
        return 0L;
    }

    @Override
    public <T> T a(CameraCharacteristics.Key<T> key) {
        return this.f.a(key);
    }

    @Override
    public <T> T a(CameraCharacteristics.Key<T> key, T obj) {
        return this.f.a(key, obj);
    }

    @Override
    public List a(int i) {
        StreamConfigurationMap F = F();
        return F == null ? Collections.emptyList() : lyx.a(F.getOutputSizes(i));
    }

    @Override
    public mmp a() {
        return this.g;
    }

    @Override
    public List a_(lyw lywVar) {
        Range<Integer>[] highSpeedVideoFpsRangesFor;
        StreamConfigurationMap F = F();
        if (F != null && (highSpeedVideoFpsRangesFor = F.getHighSpeedVideoFpsRangesFor(lyx.b(lywVar))) != null) {
            return Arrays.asList(highSpeedVideoFpsRangesFor);
        }
        return Collections.emptyList();
    }

    @Override
    public <T> T b(CameraCharacteristics.Key<T> key) {
        return this.f.b(key);
    }

    @Override
    public mmt b() {
        int intValue = (Integer) b(CameraCharacteristics.LENS_FACING);
        return intValue == 1 ? mmt.BACK : intValue == 0 ? mmt.FRONT : mmt.EXTERNAL;
    }

    @Override
    public List c() {
        StreamConfigurationMap F = F();
        return F != null ? lyx.a(F.getOutputSizes(SurfaceTexture.class)) : Collections.emptyList();
    }

    @Override
    public int d() {
        return (Integer) b(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    @Override
    public Rect e() {
        return (Rect) b(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    @Override
    public boolean f() {
        return a(CameraCharacteristics.FLASH_INFO_AVAILABLE, false);
    }

    @Override
    public boolean g() {
        for (int i : (int[]) a(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES, a)) {
            if (i == 18) {
                return true;
            }
        }
        return false;
    }

    @Override
    public mms h() {
        int[] iArr = (int[]) a(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES, a);
        ArrayList<mms> arrayList = new ArrayList<>(iArr.length);
        for (int i : iArr) {
            arrayList.add(mms.a(i));
        }
        return arrayList.contains(mms.b) ? mms.b : arrayList.contains(mms.c) ? mms.c : mms.d;
    }

    @Override
    public List<Float> i() {
        return oxl.c((float[]) a(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS, b));
    }

    @Override
    public boolean j() {
        Range<Integer> range = a(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        if (range != null) {
            if (range.getLower() != null && (Integer) range.getLower() != 0) {
                return true;
            }
            return range.getUpper() != null && (Integer) range.getUpper() != 0;
        }
        return false;
    }

    @Override
    public int k() {
        if (j()) {
            return (Integer) ((Range) b(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getLower();
        }
        return -1;
    }

    @Override
    public int l() {
        if (j()) {
            return (Integer) ((Range) b(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getUpper();
        }
        return -1;
    }

    @Override
    public float m() {
        if (j()) {
            return a(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, Rational.ZERO).floatValue();
        }
        return -1.0f;
    }

    @Override
    public float n() {
        return a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, 1.0f);
    }

    @Override
    public boolean o() {
        Integer num = (Integer) a(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Float f = (Float) a(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        return num != null && num > 0 && f != null && f > 0.0f;
    }

    @Override
    public boolean p() {
        Integer num = (Integer) a(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        return num != null && num > 0;
    }

    @Override
    public boolean q() {
        for (int i : (int[]) a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES, a)) {
            if (i == 9) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean r() {
        for (int i : (int[]) a(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES, a)) {
            if (i == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<lyw> s() {
        Size[] highSpeedVideoSizes;
        StreamConfigurationMap F = F();
        if (F != null && (highSpeedVideoSizes = F.getHighSpeedVideoSizes()) != null) {
            List<lyw> a = lyx.a(highSpeedVideoSizes);
            return Arrays.asList((lyw[]) a.toArray(new lyw[0]));
        }
        return Collections.emptyList();
    }

    @Override
    public List<lyw> t() {
        return lyx.a((Size[]) a(CameraCharacteristics.JPEG_AVAILABLE_THUMBNAIL_SIZES, c));
    }

    @Override
    public List<Range<Integer>> u() {
        return Arrays.asList(b(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    @Override
    public boolean v() {
        for (int i : (int[]) a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, a)) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public byte[] w() {
        return kvf.a != null ? (byte[]) a(kvf.a, d) : d;
    }

    @Override
    public boolean x() {
        if (this.i.d) {
            try {
                return z().contains(CaptureRequest.CONTROL_ENABLE_ZSL);
            } catch (NoSuchFieldError ignored) {
            }
        }
        return false;
    }

    @Override
    public boolean y() {
        for (int i : (int[]) a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES, a)) {
            if (i == 11) {
                return this.h.size() > 1;
            }
        }
        return false;
    }

    @Override
    public Set<CaptureRequest.Key<?>> z() {
        return this.f.a();
    }
}