package defpackage;

import android.hardware.camera2.CaptureResult;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Locale;

final class bea implements beb {
    private final /* synthetic */ mpz a;
    private final /* synthetic */ String b;

    bea(mpz mpzVar, String str) {
        this.a = mpzVar;
        this.b = str;
    }

    @Override // defpackage.beb
    public final void a(Writer writer) {
        List<CaptureResult.Key<?>> a = this.a.a();
        String format = this.b;
        StringBuilder sb = new StringBuilder(format.length() + 1);
        sb.append(format);
        sb.append('\n');
        try {
            writer.write(sb.toString());
            for (CaptureResult.Key<?> key : a) {
                writer.write(String.format((Locale) null, "    %s\n", key.getName()));
                writer.write(String.format((Locale) null, "        %s\n", bdz.a(this.a.a(key))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}