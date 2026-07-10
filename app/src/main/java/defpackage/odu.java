package defpackage;

final class odu extends ojj {
    private final ods a;

    odu(ods odsVar, int i) {
        super(odsVar.size(), i);
        this.a = odsVar;
    }

    @Override
    protected final Object a(int i) {
        return this.a.get(i);
    }
}