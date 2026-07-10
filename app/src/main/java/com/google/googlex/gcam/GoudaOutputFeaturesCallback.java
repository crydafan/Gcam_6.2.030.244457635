package com.google.googlex.gcam;

public class GoudaOutputFeaturesCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected GoudaOutputFeaturesCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaOutputFeaturesCallback goudaOutputFeaturesCallback) {
        if (goudaOutputFeaturesCallback == null) {
            return 0L;
        }
        return goudaOutputFeaturesCallback.swigCPtr;
    }

    public void AddFeature(long j, String str, double d) {
        GcamModuleJNI.GoudaOutputFeaturesCallback_AddFeature(this.swigCPtr, this, j, str, d);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaOutputFeaturesCallback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }
}
