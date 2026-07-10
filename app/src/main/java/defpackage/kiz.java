package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.FixBSG;

public final class kiz {
    private final Context a;

    public kiz(Context context) {
        this.a = context;
    }

    private static boolean a(String str, String str2) {
        try {
            return new kiy(str).a(new kiy(str2)) >= 0;
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Fail to check the version between ");
            sb.append(str);
            sb.append(" and ");
            sb.append(str2);
            pra.b("PhotosPkgDtr", sb.toString());
            return false;
        }
    }

    public final boolean a(String str) {
        ohr.b(str);
        try {
            if (FixBSG.MenuValue("google_photos_key") != 0) {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo("com.google.android.apps.photos", 0);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (!str2.equals("DEVELOPMENT")) {
                        return a(str2, str);
                    }
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}