package defpackage;

public class cvg {
    public final String b;

    public cvg(String flagName) {
        ohr.b(flagName);
        if (flagName.startsWith("persist.")) {
            throw new IllegalArgumentException("The provided flag name of '" + flagName + "'  starts with 'persist.'. 'persist.' will be automatically prepended to the adb property name.");
        }
        String flag = "persist.";
        if (flagName.length() > 0) {
            flag = flag.concat(flagName);
        }
        if (flag.length() <= 31) {
            this.b = flagName;
        } else {
            throw new IllegalArgumentException("The provided name of '" + flagName + "' is longer than adb can support (31 characters) when the prefix is added: " + flag);
        }
    }
}