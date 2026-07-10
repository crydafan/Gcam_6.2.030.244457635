
package defpackage;

import android.content.res.Resources;

final class kad implements jzy {
    private final int a;
    private final Object[] b;

    kad(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    @Override // defpackage.jzy
    public final String a(Resources resources) {
        return resources.getString(this.a, this.b);
    }
}