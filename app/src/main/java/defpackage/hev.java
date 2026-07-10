package defpackage;

import com.google.android.libraries.camera.exif.ExifInterface;

public final class hev {
    public final byte[] a;
    public final lyw b;
    public final int c;
    public final ExifInterface d;

    public hev(byte[] bArr, lyw lywVar, int i, ExifInterface exifInterface, kiw kiwVar) {
        this.a = bArr;
        this.b = lywVar;
        this.c = i;
        if (kiwVar != null) {
            kiwVar.a(exifInterface);
        }
        this.d = exifInterface;
    }
}