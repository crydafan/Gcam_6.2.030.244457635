package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;

public final class cgv extends LinearLayout {
    private final TextView a;

    public cgv(Context context) {
        super(context);
        new lpx();
        setOrientation(LinearLayout.VERTICAL);
        ColorDrawable colorDrawable = new ColorDrawable(-12303292);
        colorDrawable.setAlpha(51);
        setBackground(colorDrawable);
        cgw cgwVar = new cgw(context);
        cgwVar.setTextColor(-1);
        cgwVar.setMaxLines(20);
        cgwVar.setGravity(80);
        cgwVar.setMovementMethod(new ScrollingMovementMethod());
        this.a = cgwVar;
        addView(this.a);
        new HashMap();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}