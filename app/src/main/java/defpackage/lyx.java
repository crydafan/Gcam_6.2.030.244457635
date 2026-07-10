package defpackage;

import android.annotation.TargetApi;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class lyx {
    public static String a(lyw lywVar) {
        int i = lywVar.a;
        int i2 = lywVar.b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }

    @TargetApi(21)
    public static List<lyw> a(Size[] sizeArr) {
        if (sizeArr != null) {
            ArrayList<lyw> arrayList = new ArrayList<>(sizeArr.length);
            for (Size size : sizeArr) {
                if (size != null) {
                    arrayList.add(new lyw(size.getWidth(), size.getHeight()));
                }
            }
            return arrayList;
        }
        //return ods.g();
        return new ArrayList<>();
    }

    public static lyw a(String str) {
        if (str != null) {
            String[] split = str.split("x");
            if (split.length == 2) {
                try {
                    return new lyw(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } catch (NumberFormatException e) {
                }
            }
        }
        return null;
    }

    public static lyw a(List list) {
        ohr.b(!list.isEmpty());
        return (lyw) Collections.max(list, (Comparator<lyw>) (lyw, t1) -> {
            long b = lyw.b();
            long b2 = t1.b();
            int i = (b > b2 ? 1 : (b == b2 ? 0 : -1));
            if (b == b2) {
                i = Integer.compare(Math.min(lyw.a, lyw.b), Math.min(t1.a, t1.b));
            }
            return i != 0 ? i : Integer.compare(lyw.a, t1.a);
        });
    }

    public static Size b(lyw lywVar) {
        return new Size(lywVar.a, lywVar.b);
    }
}