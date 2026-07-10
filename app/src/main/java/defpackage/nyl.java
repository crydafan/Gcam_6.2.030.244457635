package defpackage;

import java.io.Serializable;
import java.util.regex.Pattern;

final class nyl extends nyg implements Serializable {
    public static final long serialVersionUID = 0;
    private final Pattern a;

    nyl(Pattern pattern) {
        this.a = (Pattern) ohr.b(pattern);
    }

    @Override
    public final nyf a(CharSequence charSequence) {
        return new nyf(this.a.matcher(charSequence));
    }

    public final String toString() {
        return this.a.toString();
    }
}