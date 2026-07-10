package defpackage;

import java.util.regex.Pattern;

final class nyt implements nyr {
    nyt() {
    }

    @Override
    public final nyg a(String str) {
        return new nyl(Pattern.compile(str));
    }
}