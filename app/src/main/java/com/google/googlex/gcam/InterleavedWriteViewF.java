package com.google.googlex.gcam;

public class InterleavedWriteViewF extends InterleavedReadViewF {
    public long swigCPtr;

    public InterleavedWriteViewF() {
        this(GcamModuleJNI.new_InterleavedWriteViewF__SWIG_3(), true);
    }

    public InterleavedWriteViewF(int i, int i2, int i3, SWIGTYPE_p_float sWIGTYPE_p_float, long j) {
        this(GcamModuleJNI.new_InterleavedWriteViewF__SWIG_4(i, i2, i3, SWIGTYPE_p_float.getCPtr(sWIGTYPE_p_float), j), true);
    }

    protected InterleavedWriteViewF(long j, boolean z) {
        super(GcamModuleJNI.InterleavedWriteViewF_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public InterleavedWriteViewF(InterleavedWriteViewF interleavedWriteViewF) {
        this(GcamModuleJNI.new_InterleavedWriteViewF__SWIG_0(getCPtr(interleavedWriteViewF), interleavedWriteViewF), true);
    }

    public InterleavedWriteViewF(InterleavedWriteViewF interleavedWriteViewF, int i, int i2, int i3, int i4) {
        this(GcamModuleJNI.new_InterleavedWriteViewF__SWIG_2(getCPtr(interleavedWriteViewF), interleavedWriteViewF, i, i2, i3, i4), true);
    }

    public InterleavedWriteViewF(InterleavedWriteViewF interleavedWriteViewF, int i, int i2, int i3, int i4, int i5, int i6) {
        this(GcamModuleJNI.new_InterleavedWriteViewF__SWIG_1(getCPtr(interleavedWriteViewF), interleavedWriteViewF, i, i2, i3, i4, i5, i6), true);
    }

    protected static long getCPtr(InterleavedWriteViewF interleavedWriteViewF) {
        if (interleavedWriteViewF == null) {
            return 0L;
        }
        return interleavedWriteViewF.swigCPtr;
    }

    @Override
    public void FastCrop(int i, int i2, int i3, int i4) {
        GcamModuleJNI.InterleavedWriteViewF_FastCrop_SWIG_0_1(this.swigCPtr, this, i, i2, i3, i4);
    }

    @Override
    public void FastCrop(int i, int i2, int i3, int i4, int i5, int i6) {
        GcamModuleJNI.InterleavedWriteViewF_FastCrop_SWIG_0_0(this.swigCPtr, this, i, i2, i3, i4, i5, i6);
    }

    public void Fill(float f) {
        GcamModuleJNI.InterleavedWriteViewF_Fill__SWIG_1(this.swigCPtr, this, f);
    }

    public void Fill(float f, int i, int i2, int i3, int i4) {
        GcamModuleJNI.InterleavedWriteViewF_Fill__SWIG_0(this.swigCPtr, this, f, i, i2, i3, i4);
    }

    @Override
    public boolean SamplesAreCompact() {
        return GcamModuleJNI.InterleavedWriteViewF_SamplesAreCompact(this.swigCPtr, this);
    }

    public SWIGTYPE_p_float at_InterleavedWriteViewF(int i, int i2, int i3) {
        return new SWIGTYPE_p_float(GcamModuleJNI.InterleavedWriteViewF_at_InterleavedWriteViewF(this.swigCPtr, this, i, i2, i3), false);
    }

    @Override
    public SWIGTYPE_p_float base_pointer() {
        long InterleavedWriteViewF_base_pointer = GcamModuleJNI.InterleavedWriteViewF_base_pointer(this.swigCPtr, this);
        if (InterleavedWriteViewF_base_pointer != 0) {
            return new SWIGTYPE_p_float(InterleavedWriteViewF_base_pointer, false);
        }
        return null;
    }

    @Override
    public long c_stride() {
        return GcamModuleJNI.InterleavedWriteViewF_c_stride(this.swigCPtr, this);
    }

    @Override
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_InterleavedWriteViewF(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    protected void finalize() {
        delete();
    }

    @Override
    public int height() {
        return GcamModuleJNI.InterleavedWriteViewF_height(this.swigCPtr, this);
    }

    @Override
    public int num_channels() {
        return GcamModuleJNI.InterleavedWriteViewF_num_channels(this.swigCPtr, this);
    }

    @Override
    public int row_padding() {
        return GcamModuleJNI.InterleavedWriteViewF_row_padding(this.swigCPtr, this);
    }

    @Override
    public long sample_array_size() {
        return GcamModuleJNI.InterleavedWriteViewF_sample_array_size(this.swigCPtr, this);
    }

    public SWIGTYPE_p_gcam__TImageSampleIteratorT_float_gcam__kPixelContiguous_t sample_iterator_InterleavedWriteViewF() {
        return new SWIGTYPE_p_gcam__TImageSampleIteratorT_float_gcam__kPixelContiguous_t(GcamModuleJNI.InterleavedWriteViewF_sample_iterator_InterleavedWriteViewF__SWIG_0(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_gcam__TImageSampleIteratorT_float_gcam__kPixelContiguous_t sample_iterator_InterleavedWriteViewF(int i) {
        return new SWIGTYPE_p_gcam__TImageSampleIteratorT_float_gcam__kPixelContiguous_t(GcamModuleJNI.InterleavedWriteViewF_sample_iterator_InterleavedWriteViewF__SWIG_1(this.swigCPtr, this, i), true);
    }

    @Override
    public long sizeof_sample_type() {
        return GcamModuleJNI.InterleavedWriteViewF_sizeof_sample_type(this.swigCPtr, this);
    }

    @Override
    public int width() {
        return GcamModuleJNI.InterleavedWriteViewF_width(this.swigCPtr, this);
    }

    @Override
    public long x_stride() {
        return GcamModuleJNI.InterleavedWriteViewF_x_stride(this.swigCPtr, this);
    }

    @Override
    public long y_stride() {
        return GcamModuleJNI.InterleavedWriteViewF_y_stride(this.swigCPtr, this);
    }
}
