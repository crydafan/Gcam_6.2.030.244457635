package defpackage;

import com.google.googlex.gcam.GyroSample;
import com.google.googlex.gcam.GyroSampleVector;
import java.util.Iterator;
import java.util.List;

public final class ddv implements moh {
    public static final ddv a = new ddv();

    private ddv() {
    }

    @Override // defpackage.moh
    public final /* synthetic */ Object a(List list) {
        GyroSampleVector gyroSampleVector = new GyroSampleVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            moj mojVar = (moj) it.next();
            GyroSample gyroSample = new GyroSample();
            gyroSample.setTimestamp_ns(mojVar.e);
            gyroSample.setX(mojVar.f);
            gyroSample.setY(mojVar.g);
            gyroSample.setZ(mojVar.h);
            gyroSampleVector.add(gyroSample);
        }
        return gyroSampleVector;
    }
}