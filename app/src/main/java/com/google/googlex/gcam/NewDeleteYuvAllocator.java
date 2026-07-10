package com.google.googlex.gcam;

public class NewDeleteYuvAllocator extends ClientYuvAllocator {
    public long swigCPtr;

    public NewDeleteYuvAllocator() {
        this(GcamModuleJNI.new_NewDeleteYuvAllocator(), true);
    }

    protected NewDeleteYuvAllocator(long j, boolean z) {
        super(GcamModuleJNI.NewDeleteYuvAllocator_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(NewDeleteYuvAllocator newDeleteYuvAllocator) {
        if (newDeleteYuvAllocator == null) {
            return 0L;
        }
        return newDeleteYuvAllocator.swigCPtr;
    }

    @Override
    public YuvAllocation Allocate(int i, int i2, int i3) {
        return new YuvAllocation(GcamModuleJNI.NewDeleteYuvAllocator_Allocate(this.swigCPtr, this, i, i2, i3), true);
    }

    @Override
    public void Release(long j) {
        GcamModuleJNI.NewDeleteYuvAllocator_Release(this.swigCPtr, this, j);
    }

    @Override
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_NewDeleteYuvAllocator(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    protected void finalize() {
        delete();
    }
}
