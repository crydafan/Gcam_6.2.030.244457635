package com.google.googlex.gcam;

public class GoudaCompleteCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaCompleteCallback() {
        this(GcamModuleJNI.new_GoudaCompleteCallback(), true);
        GcamModuleJNI.GoudaCompleteCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected GoudaCompleteCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaCompleteCallback goudaCompleteCallback) {
        if (goudaCompleteCallback == null) {
            return 0L;
        }
        return goudaCompleteCallback.swigCPtr;
    }

    public void Run(long j) {
        GcamModuleJNI.GoudaCompleteCallback_Run(this.swigCPtr, this, j);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaCompleteCallback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GcamModuleJNI.GoudaCompleteCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.GoudaCompleteCallback_change_ownership(this, this.swigCPtr, true);
    }
}
