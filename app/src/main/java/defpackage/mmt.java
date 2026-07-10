package defpackage;

public enum mmt {
    FRONT,
    BACK,
    EXTERNAL;

    public static String a(mmt mmtVar) {
        int ordinal = mmtVar.ordinal();
        return ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? "unknown" : "external" : "back" : "front";
    }
}