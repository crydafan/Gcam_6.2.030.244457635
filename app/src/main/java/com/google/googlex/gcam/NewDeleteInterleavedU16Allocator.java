package com.google.googlex.gcam;

public class NewDeleteInterleavedU16Allocator extends ClientInterleavedU16Allocator {
    public long swigCPtr;

    public NewDeleteInterleavedU16Allocator() {
        this(GcamModuleJNI.new_NewDeleteInterleavedU16Allocator(), true);
    }

    protected NewDeleteInterleavedU16Allocator(long j, boolean z) {
        super(GcamModuleJNI.NewDeleteInterleavedU16Allocator_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(NewDeleteInterleavedU16Allocator newDeleteInterleavedU16Allocator) {
        if (newDeleteInterleavedU16Allocator == null) {
            return 0L;
        }
        return newDeleteInterleavedU16Allocator.swigCPtr;
    }

    @Override
    public InterleavedU16Allocation Allocate(int i, int i2, int i3) {
        return new InterleavedU16Allocation(GcamModuleJNI.NewDeleteInterleavedU16Allocator_Allocate(this.swigCPtr, this, i, i2, i3), true);
    }

    @Override
    public void Release(long j) {
        GcamModuleJNI.NewDeleteInterleavedU16Allocator_Release(this.swigCPtr, this, j);
    }

    @Override
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_NewDeleteInterleavedU16Allocator(j);
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
