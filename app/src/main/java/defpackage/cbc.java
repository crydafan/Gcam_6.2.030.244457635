package defpackage;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import com.FixBSG;

public final class cbc {
    public final ContentResolver a;
    public final kib b;
    private final SharedPreferences c;

    public cbc(ContentResolver contentResolver, kib kibVar, SharedPreferences sharedPreferences) {
        this.a = contentResolver;
        this.b = kibVar;
        this.c = sharedPreferences;
        new pxn();
    }

    public final String a() {
        return lof.a(this.a, "camera:blacklisted_resolutions_back", "");
    }

    public final boolean a(ContentResolver contentResolver, String str, boolean z) {
        return this.c.contains(str) ? this.c.getBoolean(str, z) : lof.a(contentResolver, str, z);
    }

    public final boolean b() {
        return a(this.a, "camera:gcam_enabled", true);
    }

    public final int c() {
        return lof.a(this.a, "camera:max_imagereader_image_count", 20);
    }

    public final int d() {
        int i;
        if (!this.b.a.e()) {
            i = 7;
            int MenuValue = FixBSG.MenuValue("quality_key");
            if (MenuValue != 0) {
                i = 7 + (MenuValue / 10);
            }
        } else {
            i = 5;
        }
        return lof.a(this.a, "camera:max_hdr_plus_burst_frame_count", i);
    }

    public final int e() {
        int d = d();
        if (this.b.a.b()) {
            d *= 5;
        } else if (this.b.a.c()) {
            d <<= 2;
        } else if (this.b.a.d() || this.b.a.e()) {
            d <<= 2;
        }
        return lof.a(this.a, "camera:max_hdr_plus_imagereader_image_count", d);
    }

    public final int f() {
        int i = 4;
        if (!this.b.a.d() && !this.b.a.e()) {
            i = 5;
        }
        return lof.a(this.a, "camera:max_gouda_inflight_shots", i);
    }
}