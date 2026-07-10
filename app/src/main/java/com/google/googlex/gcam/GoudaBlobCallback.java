package com.google.googlex.gcam;

public class GoudaBlobCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected GoudaBlobCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaBlobCallback goudaBlobCallback) {
        if (goudaBlobCallback == null) {
            return 0L;
        }
        return goudaBlobCallback.swigCPtr;
    }

    public void BlobReady(long j, String str, String str2, String str3) {
        GcamModuleJNI.GoudaBlobCallback_BlobReady(this.swigCPtr, this, j, str, str2, str3);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaBlobCallback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }
}
