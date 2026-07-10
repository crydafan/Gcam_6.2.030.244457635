package defpackage;

import android.hardware.camera2.CaptureRequest;
import java.util.Arrays;

public final class gri {
    public final CaptureRequest.Key a;
    public final Object b;

    public gri(CaptureRequest.Key key, Object obj) {
        this.a = (CaptureRequest.Key) ohr.b(key, "Parameter keys cannot be null.");
        this.b = ohr.b(obj, "Parameter values cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && (obj instanceof gri)) {
                gri griVar = (gri) obj;
                return oxl.c(this.a, griVar.a) && oxl.c(this.b, griVar.b);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }
}