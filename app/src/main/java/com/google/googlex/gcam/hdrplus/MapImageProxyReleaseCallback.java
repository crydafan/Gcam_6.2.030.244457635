package com.google.googlex.gcam.hdrplus;

import android.util.LongSparseArray;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.ImageReleaseCallback;

import defpackage.mqm;
import defpackage.ohr;

public class MapImageProxyReleaseCallback extends ImageReleaseCallback {
    public static final long INVALID_IMAGE_ID = GcamModule.getKInvalidImageId();
    public final Object lock = new Object();
    public long nextUniqueId = 0;
    public final LongSparseArray<mqm> imageMap = new LongSparseArray<>();

    private long getNextUniqueId() {
        long j;
        synchronized (this.lock) {
            j = this.nextUniqueId;
            this.nextUniqueId = 1 + j;
        }
        return j;
    }

    @Override
    public void Run(long j) {
        boolean z = true;
        ohr.a(j != INVALID_IMAGE_ID, "imageId was INVALID_IMAGE_ID (%s).", INVALID_IMAGE_ID);
        synchronized (this.lock) {
            mqm mqmVar = (mqm) this.imageMap.get(j);
            if (mqmVar == null) {
                z = false;
            }
            ohr.b(z, "MapImageProxyReleaseCallback does not contain the key %s.", j);
            mqmVar.close();
            this.imageMap.remove(j);
        }
    }

    public long put(mqm mqmVar) {
        long nextUniqueId;
        synchronized (this.lock) {
            ohr.b(this.imageMap.indexOfValue(mqmVar) < 0, "image has already been put in MapImageProxyReleaseCallback.");
            nextUniqueId = getNextUniqueId();
            this.imageMap.append(nextUniqueId, mqmVar);
        }
        return nextUniqueId;
    }
}
