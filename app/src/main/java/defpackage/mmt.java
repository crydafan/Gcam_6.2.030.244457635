package defpackage;

public enum mmt {
    a,
    b,
    c;

    public static String a(mmt mmtVar) {
        switch (mmtVar.ordinal()) {
            case 0:
                return "front";
            case 1:
                return "back";
            case 2:
                return "external";
            default:
                return "unknown";
        }
    }
}