package com.google.googlex.gcam.clientallocator;

import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.InterleavedImageU8;
import com.google.googlex.gcam.InterleavedU8Allocation;

import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class UniqueInterleavedU8ClientAllocator extends ClientInterleavedU8Allocator {
    public nyp allocatedImage;
    public final long uniqueAllocationId;

    public UniqueInterleavedU8ClientAllocator() {
        this(0L);
    }

    public UniqueInterleavedU8ClientAllocator(long j) {
        this.allocatedImage = nxs.a;
        ohr.a(j != GcamModule.getKInvalidAllocationId());
        this.uniqueAllocationId = j;
    }

    @Override
    public InterleavedU8Allocation Allocate(int i, int i2, int i3) {
        ohr.b(!this.allocatedImage.b(), "Allocate() should be called at most once.");
        InterleavedU8Allocation interleavedU8Allocation = new InterleavedU8Allocation();
        InterleavedImageU8 interleavedImageU8 = new InterleavedImageU8(i, i2, i3);
        this.allocatedImage = nyp.b(interleavedImageU8);
        interleavedU8Allocation.setId(this.uniqueAllocationId);
        interleavedU8Allocation.setView(interleavedImageU8);
        return interleavedU8Allocation;
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
