package com.google.googlex.gcam.hdrplus;

import android.hardware.HardwareBuffer;
import android.util.LongSparseArray;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.ImageReleaseCallback;
import java.util.Objects;

import defpackage.mqm;
import defpackage.ohr;

public class ImageProxyAndHardwareBufferReleaseCallback extends ImageReleaseCallback {
    public static final long INVALID_BUFFER_ID = GcamModule.getKInvalidImageId();
    public final Object lock = new Object();
    public long nextUniqueId = 0;
    public final LongSparseArray<Entry> entries = new LongSparseArray<>();

    class Entry {
        public final HardwareBuffer hardwareBuffer;
        public final mqm image;
        public int refCount;

        public Entry(mqm mqmVar) {
            this.refCount = 1;
            this.image = mqmVar;
            this.hardwareBuffer = null;
        }

        private Entry(mqm mqmVar, HardwareBuffer hardwareBuffer) {
            this.refCount = 2;
            this.image = mqmVar;
            this.hardwareBuffer = hardwareBuffer;
        }

        public void release() {
            ohr.b(this.refCount > 0, "Tried to release an entry that has already been released.");
            this.refCount--;
            if (this.refCount == 0) {
                HardwareBuffer hardwareBuffer = this.hardwareBuffer;
                if (hardwareBuffer != null) {
                    hardwareBuffer.close();
                }
                this.image.close();
            }
        }
    }

    public class Key {
        public final long hardwareBufferId;
        public final long imageId;

        private Key(long j) {
            this.imageId = j;
            this.hardwareBufferId = ImageProxyAndHardwareBufferReleaseCallback.INVALID_BUFFER_ID;
        }

        private Key(long j, long j2) {
            this.imageId = j;
            this.hardwareBufferId = j2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.imageId == key.imageId && this.hardwareBufferId == key.hardwareBufferId) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.imageId), Long.valueOf(this.hardwareBufferId));
        }
    }

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
        ohr.a(j != INVALID_BUFFER_ID, "id was INVALID_BUFFER_ID (%s).", INVALID_BUFFER_ID);
        synchronized (this.lock) {
            Entry entry = (Entry) this.entries.get(j);
            if (entry == null) {
                z = false;
            }
            ohr.b(z, "ImageProxyAndHardwareBufferReleaseCallback does not contain the id %s.", j);
            entry.release();
            this.entries.remove(j);
        }
    }

    public Key register(mqm mqmVar) {
        Key key;
        synchronized (this.lock) {
            Entry entry = new Entry(mqmVar);
            key = new Key(getNextUniqueId());
            this.entries.append(key.imageId, entry);
        }
        return key;
    }

    public Key register(mqm mqmVar, HardwareBuffer hardwareBuffer) {
        Key key;
        synchronized (this.lock) {
            Entry entry = new Entry(mqmVar, hardwareBuffer);
            key = new Key(getNextUniqueId(), getNextUniqueId());
            this.entries.append(key.imageId, entry);
            this.entries.append(key.hardwareBufferId, entry);
        }
        return key;
    }
}
