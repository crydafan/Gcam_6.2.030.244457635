package com.google.googlex.gcam.clientallocator;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.InterleavedU8Allocation;
import com.google.googlex.gcam.LockedBitmap;

import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class UniqueBitmapClientAllocator extends ClientInterleavedU8Allocator {
    public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static final int NUM_CHANNELS = 4;
    public nyp allocatedBitmap;
    public final DisplayMetrics displayMetrics;
    public LockedBitmap lock;
    public final long uniqueAllocationId;

    public UniqueBitmapClientAllocator(DisplayMetrics displayMetrics) {
        this(displayMetrics, 0L);
    }

    public UniqueBitmapClientAllocator(DisplayMetrics displayMetrics, long j) {
        this.allocatedBitmap = nxs.a;
        ohr.a(j != GcamModule.getKInvalidAllocationId());
        this.displayMetrics = displayMetrics;
        this.uniqueAllocationId = j;
    }

    @Override
    public InterleavedU8Allocation Allocate(int i, int i2, int i3) {
        ohr.a(i3 == 4, "Server requested an InterleavedImageU8 of %s channels, but UniqueBitmapClientAllocator only supports %s.", i3, 4);
        ohr.b(!this.allocatedBitmap.b(), "Allocate() should be called at most once.");
        InterleavedU8Allocation interleavedU8Allocation = new InterleavedU8Allocation();
        Bitmap createBitmap = Bitmap.createBitmap(this.displayMetrics, i, i2, BITMAP_CONFIG);
        this.allocatedBitmap = nyp.b(createBitmap);
        this.lock = LockedBitmap.acquire(createBitmap);
        interleavedU8Allocation.setId(this.uniqueAllocationId);
        interleavedU8Allocation.setView(this.lock.view());
        return interleavedU8Allocation;
    }

    @Override
    public void Release(long j) {
        boolean z = true;
        ohr.a(j == this.uniqueAllocationId);
        ohr.b(this.allocatedBitmap.b(), "Release() was called before Allocate().");
        if (this.lock == null) {
            z = false;
        }
        ohr.b(z, "Release() was called more than once.");
        this.lock.close();
        this.lock = null;
    }

    public nyp getBitmap() {
        return this.allocatedBitmap;
    }
}
