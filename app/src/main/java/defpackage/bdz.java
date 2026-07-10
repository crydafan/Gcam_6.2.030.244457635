package defpackage;

import android.util.Pair;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;

public final class bdz {
    private static final String a = pra.a("CaptureDataSerilzr");

    static String a(Object obj) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    sb.append(a(Array.get(obj, i)));
                    if (i != length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append(']');
                return sb.toString();
            } else if (!(obj instanceof Pair)) {
                return obj.toString();
            } else {
                Pair<String, String> pair = (Pair) obj;
                String a2 = a(pair.first);
                String a3 = a(pair.second);
                return "Pair: " + a2 + " / " + a3;
            }
        }
        return "<null>";
    }

    public static void a(String str, mpz mpzVar, File file) {
        String str2;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bea beaVar = new bea(mpzVar, str);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            try {
                beaVar.a(bufferedWriter);
            } catch (/*IO*/Exception e) {
                pra.b(a, "dumpMetadata - Failed to dump metadata", e);
                try {
                    bufferedWriter.close();
                } catch (IOException e2) {
                    str2 = a;
                    pra.b(str2, "dumpMetadata - Failed to close writer.", e2);
                    fileWriter.close();
                }
            }
            try {
                bufferedWriter.close();
            } catch (IOException e3) {
                str2 = a;
                pra.b(str2, "dumpMetadata - Failed to close writer.", e3);
                fileWriter.close();
            }
            fileWriter.close();
        } catch (IOException e4) {
            pra.b(a, "Could not write capture data to file.", e4);
        }
    }
}