package com.google.googlex.gcam.clientallocator;

import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.InterleavedImageU8;
import com.google.googlex.gcam.InterleavedReadViewU8;
import com.google.googlex.gcam.InterleavedU8Allocation;
import com.google.googlex.gcam.SwigHacks;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import defpackage.nyp;
import defpackage.ohr;

public class MapInterleavedU8ClientAllocator extends ClientInterleavedU8Allocator {
    public final ConcurrentMap allocatedImages = new ConcurrentHashMap();

    private long getBaseAddress(InterleavedReadViewU8 interleavedReadViewU8) {
        return SwigHacks.getNativePointer(interleavedReadViewU8.base_pointer());
    }

    @Override
    public InterleavedU8Allocation Allocate(int i, int i2, int i3) {
        InterleavedImageU8 interleavedImageU8 = new InterleavedImageU8(i, i2, i3);
        long baseAddress = getBaseAddress(interleavedImageU8);
        this.allocatedImages.put(Long.valueOf(baseAddress), interleavedImageU8);
        InterleavedU8Allocation interleavedU8Allocation = new InterleavedU8Allocation();
        interleavedU8Allocation.setId(baseAddress);
        interleavedU8Allocation.setView(interleavedImageU8);
        return interleavedU8Allocation;
    }

    @Override
    public void Release(long j) {
        ohr.b(this.allocatedImages.containsKey(Long.valueOf(j)));
    }

    public nyp findImageFromView(InterleavedReadViewU8 interleavedReadViewU8) {
        return nyp.c((InterleavedImageU8) this.allocatedImages.get(Long.valueOf(getBaseAddress(interleavedReadViewU8))));
    }
}
