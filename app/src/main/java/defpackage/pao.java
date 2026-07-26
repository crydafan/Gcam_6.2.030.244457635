package defpackage;

public final class pao {
    public static /* final */ pap a;

    // static {
    //     pau pau0;
    //     Integer integer0 = null;
    //     try {
    //         integer0 = pao.a();
    //         if(integer0 == null) {
    //         label_13:
    //             pau0 = (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) == 0 ? new pat() : new pas();
    //         }
    //         else {
    //             if(((int)integer0) < 19) {
    //                 goto label_13;
    //             }
    //             pau0 = new pau();
    //         }
    //     }
    //     catch(Throwable throwable0) {
    //         System.err.println("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy " + pat.class.getName() + "will be used. The error is: ");
    //         throwable0.printStackTrace(System.err);
    //         pau0 = new pat();
    //     }
    //     pao.a = pau0;
    //     if(integer0 != null) {
    //         integer0.intValue();
    //     }
    // }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception exception0) {
            System.err.println(
                    "Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            exception0.printStackTrace(System.err);
            return null;
        }
    }

    public static void a(Throwable throwable0, Throwable throwable1) {
        pao.a.a(throwable0, throwable1);
    }
}
