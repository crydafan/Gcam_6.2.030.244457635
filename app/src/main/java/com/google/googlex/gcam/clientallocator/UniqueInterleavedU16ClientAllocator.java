package com.google.googlex.gcam.clientallocator;

import com.google.googlex.gcam.ClientInterleavedU16Allocator;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.InterleavedImageU16;
import com.google.googlex.gcam.InterleavedU16Allocation;

import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class UniqueInterleavedU16ClientAllocator extends ClientInterleavedU16Allocator {
    public nyp allocatedImage;
    public final long uniqueAllocationId;

    public UniqueInterleavedU16ClientAllocator() {
        this(0L);
    }

    public UniqueInterleavedU16ClientAllocator(long j) {
        this.allocatedImage = nxs.a;
        ohr.a(j != GcamModule.getKInvalidAllocationId());
        this.uniqueAllocationId = j;
    }

    @Override
    public InterleavedU16Allocation Allocate(int i, int i2, int i3) {
        ohr.b(!this.allocatedImage.b(), "Allocate() should be called at most once.");
        InterleavedU16Allocation interleavedU16Allocation = new InterleavedU16Allocation();
        InterleavedImageU16 interleavedImageU16 = new InterleavedImageU16(i, i2, i3);
        this.allocatedImage = nyp.b(interleavedImageU16);
        interleavedU16Allocation.setId(this.uniqueAllocationId);
        interleavedU16Allocation.setView(interleavedImageU16);
        return interleavedU16Allocation;
    }

    @Override
    public void Release(long j) {
        ohr.a(j == this.uniqueAllocationId);
        ohr.b(this.allocatedImage.b(), "Release() was called before Allocate().");
    }

    public nyp getImage() {
        return this.allocatedImage;
    }
}
