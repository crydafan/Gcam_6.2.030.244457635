package com.google.googlex.gcam.clientallocator;

import android.hardware.HardwareBuffer;
import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.InterleavedU8Allocation;
import com.google.googlex.gcam.InterleavedWriteViewU8;
import com.google.googlex.gcam.LockedHardwareBuffer;

import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class UniqueHardwareBufferInterleavedU8ClientAllocator extends ClientInterleavedU8Allocator {
    public static final int FORMAT = 1;
    public static final int NUM_CHANNELS = 4;
    public final long allocateUsage;
    public nyp allocatedBuffer;
    public LockedHardwareBuffer lock;
    public final long lockUsage;
    public final long uniqueAllocationId;

    public UniqueHardwareBufferInterleavedU8ClientAllocator(long j, long j2) {
        this(0L, j, j2);
    }

    public UniqueHardwareBufferInterleavedU8ClientAllocator(long j, long j2, long j3) {
        this.allocatedBuffer = nxs.a;
        boolean z = true;
        ohr.a(j != GcamModule.getKInvalidAllocationId());
        ohr.a((j2 & 32) != 0, "allocateUsage must contain USAGE_CPU_WRITE_RARELY.");
        ohr.a((32 & j3) == 0 ? false : z, "lockUsage must contain USAGE_CPU_WRITE_RARELY.");
        this.uniqueAllocationId = j;
        this.allocateUsage = j2;
        this.lockUsage = j3;
    }

    @Override
    public InterleavedU8Allocation Allocate(int i, int i2, int i3) {
        ohr.a(i3 == 4, "Server requested an InterleavedImageU8 of %s channels, but UniqueHardwareBufferInterleavedU8ClientAllocator only supports %s.", i3, 4);
        ohr.b(!this.allocatedBuffer.b(), "Allocate() should be called at most once.");
        InterleavedU8Allocation interleavedU8Allocation = new InterleavedU8Allocation();
        HardwareBuffer create = HardwareBuffer.create(i, i2, HardwareBuffer.RGBA_8888, 1, this.allocateUsage);
        this.lock = LockedHardwareBuffer.acquire(create, this.lockUsage);
        if (this.lock != null) {
            this.allocatedBuffer = nyp.b(create);
            interleavedU8Allocation.setId(this.uniqueAllocationId);
            interleavedU8Allocation.setView(this.lock.getInterleavedWriteViewU8());
        } else {
            create.close();
            interleavedU8Allocation.setId(GcamModule.getKInvalidAllocationId());
            interleavedU8Allocation.setView(new InterleavedWriteViewU8());
        }
        return interleavedU8Allocation;
    }

    @Override
    public void Release(long j) {
        boolean z = true;
        ohr.a(j == this.uniqueAllocationId);
        ohr.b(this.allocatedBuffer.b(), "Release() was called before Allocate().");
        if (this.lock == null) {
            z = false;
        }
        ohr.b(z, "Release() was called more than once.");
        if (((HardwareBuffer) this.allocatedBuffer.c()).isClosed()) {
            this.lock.invalidateHardwareBuffer();
        }
        this.lock.close();
        this.lock = null;
    }

    public nyp getHardwareBuffer() {
        return this.allocatedBuffer;
    }
}
