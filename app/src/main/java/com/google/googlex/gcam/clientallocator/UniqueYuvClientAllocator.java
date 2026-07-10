package com.google.googlex.gcam.clientallocator;

import com.google.googlex.gcam.ClientYuvAllocator;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.YuvAllocation;
import com.google.googlex.gcam.YuvImage;

import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class UniqueYuvClientAllocator extends ClientYuvAllocator {
    public nyp allocatedImage;
    public final long uniqueAllocationId;

    public UniqueYuvClientAllocator() {
        this(0L);
    }

    public UniqueYuvClientAllocator(long j) {
        this.allocatedImage = nxs.a;
        ohr.a(j != GcamModule.getKInvalidAllocationId());
        this.uniqueAllocationId = j;
    }

    @Override
    public YuvAllocation Allocate(int i, int i2, int i3) {
        ohr.b(!this.allocatedImage.b(), "Allocate() should be called at most once.");
        YuvAllocation yuvAllocation = new YuvAllocation();
        YuvImage yuvImage = new YuvImage(i, i2, i3);
        this.allocatedImage = nyp.b(yuvImage);
        yuvAllocation.setId(this.uniqueAllocationId);
        yuvAllocation.setView(yuvImage);
        return yuvAllocation;
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
