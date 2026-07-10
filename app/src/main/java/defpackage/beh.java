package defpackage;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCharacteristics;

@TargetApi(21)
public final class beh {
    public final int a;
    public final boolean b;
    private final mpd c;

    public beh(mpd mpdVar, int i, boolean z) {
        this.a = i;
        this.b = z;
        this.c = mpdVar;
    }

    public beh(mpd mpdVar, mmb mmbVar) {
        this(mpdVar, mmbVar.d(), mmbVar.b() == mmt.FRONT);
    }

    public static int a(int i, int i2, boolean z) {
        if (z) {
            i2 = (360 - i2) % 360;
        }
        return (i + i2) % 360;
    }

    public static int a(int i, mmb mmbVar) {
        boolean z = false;
        if (i != -1) {
            Integer num = (Integer) mmbVar.a(CameraCharacteristics.LENS_FACING);
            Integer num2 = (Integer) mmbVar.a(CameraCharacteristics.SENSOR_ORIENTATION);
            if (num != null && num2 != null) {
                if (num == 0) {
                    z = true;
                }
                return a(num2, i, z);
            }
        }
        return 0;
    }

    public final lys a() {
        return lys.a(a(this.a, this.c.a().e, this.b));
    }

    public final lrm b() {
        return lrn.a(new hnx(this.c), new bei(this));
    }
}