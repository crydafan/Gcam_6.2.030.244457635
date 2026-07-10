package defpackage;

public enum jge {
    NORMAL(1),
    HEAT_WARNING(2),
    HEAT_CRITICAL(3),
    HEAT_FATAL(4),
    UNKNOWN(5),
    COLD(6);
    
    public final int g;

    jge(int i) {
        this.g = i;
    }
}