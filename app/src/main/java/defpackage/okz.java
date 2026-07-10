package defpackage;

abstract class okz implements ole {
    okz() {
    }

    public ole a(char c) {
        throw null;
    }

    @Override
    public ole a(int i) {
        throw null;
    }

    @Override
    public final ole a(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            a(charSequence.charAt(i));
        }
        return this;
    }
}