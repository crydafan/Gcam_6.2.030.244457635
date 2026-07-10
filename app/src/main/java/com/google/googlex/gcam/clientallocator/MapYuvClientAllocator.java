package com.google.googlex.gcam.clientallocator;

import com.google.googlex.gcam.ClientYuvAllocator;
import com.google.googlex.gcam.SwigHacks;
import com.google.googlex.gcam.YuvAllocation;
import com.google.googlex.gcam.YuvImage;
import com.google.googlex.gcam.YuvReadView;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import defpackage.nyp;
import defpackage.ohr;

public class MapYuvClientAllocator extends ClientYuvAllocator {
    public final ConcurrentMap allocatedImages = new ConcurrentHashMap();

    private long getBaseAddress(YuvReadView yuvReadView) {
        return SwigHacks.getNativePointer(yuvReadView.luma_read_view().base_pointer());
    }

    @Override
    public YuvAllocation Allocate(int i, int i2, int i3) {
        YuvImage yuvImage = new YuvImage(i, i2, i3);
        long baseAddress = getBaseAddress(yuvImage);
        this.allocatedImages.put(Long.valueOf(baseAddress), yuvImage);
        YuvAllocation yuvAllocation = new YuvAllocation();
        yuvAllocation.setId(baseAddress);
        yuvAllocation.setView(yuvImage);
        return yuvAllocation;
    }

    @Override
    public void Release(long j) {
        ohr.b(this.allocatedImages.containsKey(Long.valueOf(j)));
    }

    public nyp findImageFromView(YuvReadView yuvReadView) {
        return nyp.c((YuvImage) this.allocatedImages.get(Long.valueOf(getBaseAddress(yuvReadView))));
    }
}
