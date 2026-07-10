package defpackage;

public final class gnf extends lss {
    public final lrm a;

    public gnf(lsg lsgVar) {
        super(lsgVar);
        this.a = lsgVar;
    }

    @Override // defpackage.lss
    public final /* synthetic */ Object b(Object obj) {
        int ordinal = ((gne) obj).ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return 6;
            }
            if (ordinal == 2) {
                return 5;
            }
            if (ordinal == 3) {
                return 2;
            }
            if (ordinal == 4) {
                return 3;
            }
            if (ordinal == 5) {
                return 0;
            }
            throw new RuntimeException("Unknown WB output value");
        }
        return 1;
    }

    @Override // defpackage.lss
    public final /* synthetic */ Object c(Object obj) {
        int intValue = (Integer) obj;
        if (intValue != 0) {
            if (intValue == 1) {
                return gne.AUTO;
            }
            if (intValue == 2) {
                return gne.INCANDESCENT;
            }
            if (intValue == 3) {
                return gne.FLUORESCENT;
            }
            if (intValue == 5) {
                return gne.SUNNY;
            }
            if (intValue != 6) {
                throw new RuntimeException("Unknown WB input value");
            }
            return gne.CLOUDY;
        }
        return gne.GOOGLE;
    }
}