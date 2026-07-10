package defpackage;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.libraries.camera.exif.ExifInterface;
import com.google.googlex.gcam.BufferUtils;
import com.google.googlex.gcam.ExifMetadata;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.PostviewParams;
import com.google.googlex.gcam.SWIGTYPE_p_p_unsigned_char;
import com.google.googlex.gcam.SWIGTYPE_p_unsigned_char;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class dds {
    private static final String c = pra.a("GcamUtils");
    public final gpp a;
    private final Application b;

    public dds(Application application, gpp gppVar) {
        this.b = application;
        this.a = gppVar;
    }

    public static int a(int i) {
        return MetadataConverter.getImageRotation(i);
    }

    public static ExifInterface a(int i, int i2, ExifMetadata exifMetadata) {
        SWIGTYPE_p_p_unsigned_char new_uint8_p_p = GcamModule.new_uint8_p_p();
        long[] jArr = {0};
        GcamModule.EncodeGcamExif(i, i2, exifMetadata, new_uint8_p_p, jArr);
        int i3 = (int) jArr[0];
        SWIGTYPE_p_unsigned_char uint8_p_p_value = GcamModule.uint8_p_p_value(new_uint8_p_p);
        ByteBuffer byteBufferViewOfNativePointer = BufferUtils.byteBufferViewOfNativePointer(uint8_p_p_value, i3);
        byte[] bArr = new byte[i3 + 4];
        int i4 = i3 + 2;
        bArr[0] = -1;
        bArr[1] = -31;
        bArr[2] = (byte) (i4 >> 8);
        bArr[3] = (byte) i4;
        byteBufferViewOfNativePointer.get(bArr, 4, i3);
        GcamModule.delete_uint8_p(uint8_p_p_value);
        GcamModule.delete_uint8_p_p(new_uint8_p_p);
        ExifInterface exifInterface = new ExifInterface();
        try {
            exifInterface.a(bArr);
        } catch (/*IO*/Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            pra.e(c, valueOf.length() == 0 ? "Unable to parse EXIF: " : "Unable to parse EXIF: ".concat(valueOf));
        }
        if (exifMetadata.getIcc_profile() == 1 || exifMetadata.getIcc_profile() == 0 || exifMetadata.getIcc_profile() == 3) {
            exifInterface.P = 1;
        } else {
            exifInterface.P = 2;
        }
        exifMetadata.getXmp_metadata_main();
        exifInterface.Q = exifMetadata.getXmp_metadata_extended();
        return exifInterface;
    }

    public static PostviewParams a(mmb mmbVar, hkx hkxVar) {
        int i;
        int round;
        PostviewParams postviewParams = new PostviewParams();
        lyw lywVar = MetadataConverter.getGcamRawFormat(mmbVar).b;
        postviewParams.setPixel_format(5);
        float a = ((lyb) ohr.b(lyb.a(hkxVar.c))).a();
        int i2 = lywVar.a;
        int i3 = lywVar.b;
        if (i2 > i3) {
            round = Math.round(i2 / 6.0f);
            i = Math.round((round / a) * 1.05f);
        } else {
            int round2 = Math.round(i3 / 6.0f);
            i = round2;
            round = Math.round(round2 * a * 1.05f);
        }
        lyw lywVar2 = new lyw((round + 1) & (-2), (i + 1) & (-2));
        int i4 = lywVar2.a;
        if (i4 > lywVar2.b) {
            postviewParams.setTarget_width(i4);
            postviewParams.setTarget_height(0);
        } else {
            postviewParams.setTarget_width(0);
            postviewParams.setTarget_height(lywVar2.b);
        }
        return postviewParams;
    }

    public final String a(long j) {
        String str = null;
        if (this.b.checkSelfPermission("android.permission.READ_PHONE_STATE") == PackageManager.PERMISSION_GRANTED) {
            try {
                str = Build.getSerial();
            } catch (SecurityException e) {
                pra.a(c, "Failed to getSerial() ", e);
            }
        }
        if (str != null) {
            int length = str.length();
            if (length > 4) {
                str = str.substring(length - 4, length);
            }
        } else {
            str = "XXXX";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return String.format("%s_%s", str, simpleDateFormat.format(j));
    }
}