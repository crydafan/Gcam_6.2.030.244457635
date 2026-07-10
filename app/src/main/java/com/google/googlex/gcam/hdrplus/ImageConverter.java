package com.google.googlex.gcam.hdrplus;

import android.util.Log;

import com.google.googlex.gcam.BufferUtils;
import com.google.googlex.gcam.InterleavedWriteViewU16;
import com.google.googlex.gcam.RawWriteView;
import com.google.googlex.gcam.SWIGTYPE_p_unsigned_char;
import com.google.googlex.gcam.SwigHacks;
import com.google.googlex.gcam.YuvWriteView;

import java.nio.ByteBuffer;
import java.util.List;

import defpackage.mqm;
import defpackage.mqn;
import defpackage.nxs;
import defpackage.nyp;
import defpackage.ohr;

public class ImageConverter {
    public static final int GCAM_YUV_PIXEL_DISTANCE_UV = 1;
    public static final int GCAM_YUV_PIXEL_STRIDE_U = 2;
    public static final int GCAM_YUV_PIXEL_STRIDE_V = 2;
    public static final int IMAGE_FORMAT_RAW_DEPTH = 4098;
    public static final int PD_DEPTH_POINT_CLOUD_HEIGHT1 = 756;
    public static final int PD_DEPTH_POINT_CLOUD_HEIGHT2 = 758;
    public static final int PD_DEPTH_POINT_CLOUD_ROW_PADDING = 0;
    public static final int PD_DEPTH_POINT_CLOUD_WIDTH = 2016;
    public static final int PD_NUM_CHANNELS = 2;
    public static final int PD_PLANE = 0;
    public static final int PD_PLANE_COUNT = 1;
    public static final int RAW10_PIXEL_STRIDE = 0;
    public static final int RAW12_PIXEL_STRIDE = 0;
    public static final int RAW_PLANE = 0;
    public static final int RAW_PLANE_COUNT = 1;
    public static final int RAW_SENSOR_PIXEL_STRIDE = 2;
    public static final int SIZE_OF_UINT16 = 2;
    public static final String TAG = ImageConverter.class.getSimpleName();
    public static final int YUV_420_888_CHROMA_SUBSAMPLE = 2;
    public static final int YUV_420_888_LUMA_SUBSAMPLE = 1;
    public static final int YUV_420_888_PIXEL_STRIDE_Y = 1;
    public static final int YUV_420_888_PLANE_COUNT = 3;
    public static final int YUV_420_888_PLANE_U = 1;
    public static final int YUV_420_888_PLANE_V = 2;
    public static final int YUV_420_888_PLANE_Y = 0;

    private static int validateAndConvertToGcamYuvFormat(mqm mqmVar) {
        int c = mqmVar.c();
        int d = mqmVar.d();
        boolean z = false;
        ohr.a(c % 2 == 0, "A YUV image must have even width.");
        ohr.a(d % 2 == 0, "A YUV image must have even height.");
        ohr.a(mqmVar.b() == 35, "Format is not YUV_420_888");
        List<mqn> e = mqmVar.e();
        ohr.a(e.size() == 3, "A YUV image must have %s planes.", 3);
        mqn mqnVar = e.get(0);
        mqn mqnVar2 = e.get(1);
        mqn mqnVar3 = e.get(2);
        long directBufferAddress = BufferUtils.getDirectBufferAddress(mqnVar.getBuffer());
        long directBufferAddress2 = BufferUtils.getDirectBufferAddress(mqnVar2.getBuffer());
        long directBufferAddress3 = BufferUtils.getDirectBufferAddress(mqnVar3.getBuffer());
        ohr.a(mqnVar.getPixelStride() == 1, "Y plane's pixel stride is not 1");
        ohr.a(mqnVar.getRowStride() >= mqmVar.c(), "Y plane's row stride smaller than image width");
        ohr.a(mqnVar2.getRowStride() >= mqmVar.c(), "U plane's row stride smaller than image width");
        ohr.a(mqnVar2.getRowStride() == mqnVar3.getRowStride(), "U and V planes have different row strides");
        ohr.a(directBufferAddress != 0, "luma plane address cannot be 0 (NULL).");
        ohr.a(directBufferAddress2 != 0, "chroma U plane address cannot be 0 (NULL).");
        ohr.a(directBufferAddress3 != 0, "chroma V plane address cannot be 0 (NULL).");
        if (mqnVar2.getPixelStride() == 2 && mqnVar3.getPixelStride() == 2 && Math.abs(directBufferAddress2 - directBufferAddress3) == 1) {
            z = true;
        }
        ohr.a(z, "UV planes not tightly interleaved");
        return directBufferAddress2 < directBufferAddress3 ? 1 : 2;
    }

    public boolean isCompatiblePdFormat(int i) {
        return i == 257 || i == 4098;
    }

    public boolean isCompatibleRawFormat(int i) {
        return i == 37 || i == 38 || i == 32;
    }

    public nyp wrapPdWriteView(mqm mqmVar) {
        int i;
        int i2;
        int b = mqmVar.b();
        List<mqn> e = mqmVar.e();
        boolean z = true;
        int i3 = 0;
        boolean z2 = e.size() == 1;
        int size = e.size();
        String sb = "Should have a single PD plane, has: " +
                size;
        ohr.a(z2, sb);
        boolean isCompatiblePdFormat = isCompatiblePdFormat(b);
        String sb2 = "Unsupported PD format: " +
                b;
        ohr.a(isCompatiblePdFormat, sb2);
        ByteBuffer buffer = ((mqn) e.get(0)).getBuffer();
        int remaining = buffer.remaining();
        if (b != 257) {
            ohr.a(mqmVar.c() % 2 == 0, "Image width should be divisible by the number of channels.");
            int pixelStride = ((mqn) e.get(0)).getPixelStride();
            ohr.a(pixelStride == 2, "Pixel stride should be two bytes.");
            int c = mqmVar.c() / 2;
            int d = mqmVar.d();
            int rowStride = ((mqn) e.get(0)).getRowStride();
            int i4 = (c + c) * pixelStride;
            boolean z3 = rowStride >= i4;
            String sb3 = "The row stride (" +
                    rowStride +
                    " bytes) should be greater than or equal to the width (" +
                    i4 +
                    " bytes)";
            ohr.a(z3, sb3);
            int i5 = rowStride - i4;
            if (remaining != rowStride * d) {
                z = false;
            }
            String sb4 = "The buffer capacity (" +
                    remaining +
                    ") should be equal to the row stride in bytes (" +
                    rowStride +
                    ") multiplied by the height (" +
                    d +
                    ").";
            ohr.a(z, sb4);
            i3 = i5;
            i = d;
            i2 = c;
        } else if (remaining % 8064 != 0) {
            String sb5 = "The row stride in bytes (8064) should evenly divide the PD buffer capacity (" +
                    remaining +
                    ").";
            Log.e(TAG, sb5);
            return nxs.a;
        } else {
            int i6 = remaining / 8064;
            if (i6 == 756) {
                i = i6;
                i2 = PD_DEPTH_POINT_CLOUD_WIDTH;
            } else if (i6 != 758) {
                String sb6 = "The inferred PD data height for DEPTH_POINT_CLOUD formatted Images should be one of 756 or 758, but is " +
                        i6;
                Log.e(TAG, sb6);
                return nxs.a;
            } else {
                i = i6;
                i2 = PD_DEPTH_POINT_CLOUD_WIDTH;
            }
        }
        return nyp.b(new InterleavedWriteViewU16(i2, i, 2, SwigHacks.wrapNativePointerWithSwigUnsignedShort(BufferUtils.getDirectBufferAddress(buffer)), i3));
    }

    public RawWriteView wrapRawWriteView(mqm mqmVar) {
        int i;
        int i2;
        int c = mqmVar.c();
        int d = mqmVar.d();
        int b = mqmVar.b();
        List<mqn> e = mqmVar.e();
        int pixelStride = ((mqn) e.get(0)).getPixelStride();
        int rowStride = ((mqn) e.get(0)).getRowStride();
        ohr.a(isCompatibleRawFormat(b), "Should must be a compatible image format.");
        boolean z = c % 2 == 0 && d % 2 == 0;
        String sb = "Should have even dimensions, but was: " +
                c +
                "x" +
                d;
        ohr.a(z, sb);
        boolean z2 = e.size() == 1;
        int size = e.size();
        String sb2 = "Should have a single RAW_SENSOR plane, has: " +
                size;
        ohr.a(z2, sb2);
        boolean z3 = b == 32 || b == 37 || b == 38;
        String sb3 = "Unsupported raw format: " +
                b;
        ohr.a(z3, sb3);
        if (b == 32) {
            boolean z4 = pixelStride == 2;
            String sb4 = "Unexpected RAW_SENSOR pixel stride: " +
                    pixelStride;
            ohr.a(z4, sb4);
        } else if (b == 37) {
            boolean z5 = c % 4 == 0;
            String sb5 = "RAW10 image width should be divisible by 4, but was: " +
                    c +
                    "x" +
                    d;
            ohr.a(z5, sb5);
            boolean z6 = pixelStride == 0;
            String sb6 = "Unexpected RAW10 pixel stride: " +
                    pixelStride;
            ohr.a(z6, sb6);
            int i3 = (c * 5) / 4;
            boolean z7 = rowStride >= i3;
            String sb7 = "RAW10 row stride " +
                    rowStride +
                    "should be at least " +
                    i3;
            ohr.a(z7, sb7);
        } else if (b == 38) {
            boolean z8 = c % 4 == 0;
            String sb8 = "RAW12 image width should be divisible by 4, but was: " +
                    c +
                    "x" +
                    d;
            ohr.a(z8, sb8);
            boolean z9 = pixelStride == 0;
            String sb9 = "Unexpected RAW12 pixel stride: " +
                    pixelStride;
            ohr.a(z9, sb9);
            int i4 = (c * 3) / 2;
            boolean z10 = rowStride >= i4;
            String sb10 = "RAW12 row stride " +
                    rowStride +
                    "should be at least " +
                    i4;
            ohr.a(z10, sb10);
        }
        SWIGTYPE_p_unsigned_char wrapNativePointerWithSwigUnsignedChar = SwigHacks.wrapNativePointerWithSwigUnsignedChar(BufferUtils.getDirectBufferAddress(((mqn) e.get(0)).getBuffer()));
        if (b == 37) {
            i = rowStride - ((c * 5) / 4);
            i2 = 0;
        } else if (mqmVar.b() == 38) {
            i = rowStride - ((c * 3) / 2);
            i2 = 1;
        } else {
            i = (rowStride / 2) - c;
            i2 = 2;
        }
        return new RawWriteView(c, d, i, i2, wrapNativePointerWithSwigUnsignedChar);
    }

    public YuvWriteView wrapYuvWriteView(mqm mqmVar) {
        int c = mqmVar.c();
        int d = mqmVar.d();
        int validateAndConvertToGcamYuvFormat = validateAndConvertToGcamYuvFormat(mqmVar);
        List<mqn> e = mqmVar.e();
        SWIGTYPE_p_unsigned_char wrapNativePointerWithSwigUnsignedChar = SwigHacks.wrapNativePointerWithSwigUnsignedChar(BufferUtils.getDirectBufferAddress(((mqn) e.get(0)).getBuffer()));
        int i = 1;
        if (validateAndConvertToGcamYuvFormat != 1) {
            i = 2;
        }
        return new YuvWriteView(c, d, ((mqn) e.get(0)).getRowStride(), wrapNativePointerWithSwigUnsignedChar, c / 2, d / 2, ((mqn) e.get(i)).getRowStride(), SwigHacks.wrapNativePointerWithSwigUnsignedChar(BufferUtils.getDirectBufferAddress(((mqn) e.get(i)).getBuffer())), validateAndConvertToGcamYuvFormat);
    }
}
