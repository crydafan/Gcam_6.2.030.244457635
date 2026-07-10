package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class lof {
    private static HashMap f;
    private static Object k;
    private static boolean l;
    private static final Uri b = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri c = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern d = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern e = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    public static final AtomicBoolean a = new AtomicBoolean();
    private static final HashMap g = new HashMap();
    private static final HashMap h = new HashMap();
    private static final HashMap i = new HashMap();
    private static final HashMap j = new HashMap();
    private static String[] m = new String[0];

    public static float a(ContentResolver contentResolver, String str, float f2) {
        Object b2 = b(contentResolver);
        Float f3 = (Float) a(j, str, Float.valueOf(f2));
        if (f3 != null) {
            return f3.floatValue();
        }
        String a2 = a(contentResolver, str, (String) null);
        if (a2 != null) {
            try {
                float parseFloat = Float.parseFloat(a2);
                f3 = Float.valueOf(parseFloat);
                f2 = parseFloat;
            } catch (NumberFormatException e2) {
            }
        }
        a(b2, j, str, f3);
        return f2;
    }

    public static int a(ContentResolver contentResolver, String str, int i2) {
        Object b2 = b(contentResolver);
        Integer num = (Integer) a(h, str, Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        String a2 = a(contentResolver, str, (String) null);
        if (a2 != null) {
            try {
                int parseInt = Integer.parseInt(a2);
                num = Integer.valueOf(parseInt);
                i2 = parseInt;
            } catch (NumberFormatException e2) {
            }
        }
        a(b2, h, str, num);
        return i2;
    }

    private static Object a(HashMap hashMap, String str, Object obj) {
        synchronized (lof.class) {
            if (hashMap.containsKey(str)) {
                Object obj2 = hashMap.get(str);
                if (obj2 == null) {
                    obj2 = obj;
                }
                return obj2;
            }
            return null;
        }
    }

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (lof.class) {
            a(contentResolver);
            Object obj = k;
            if (f.containsKey(str)) {
                String str3 = (String) f.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
                return str3;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!l || f.isEmpty()) {
                        f.putAll(a(contentResolver, m));
                        l = true;
                        if (f.containsKey(str)) {
                            String str5 = (String) f.get(str);
                            if (str5 == null) {
                                str5 = str2;
                            }
                            return str5;
                        }
                    }
                    return str2;
                }
            }
            Cursor query = contentResolver.query(b, null, null, new String[]{str}, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return str2;
            }
            try {
                if (!query.moveToFirst()) {
                    a(obj, str, (String) null);
                    if (query != null) {
                        query.close();
                    }
                    return str2;
                }
                String string = query.getString(1);
                if (string != null && string.equals(str2)) {
                    string = str2;
                }
                a(obj, str, string);
                if (string != null) {
                    str2 = string;
                }
                if (query != null) {
                    query.close();
                }
                return str2;
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    private static Map a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(c, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
            return treeMap;
        }
        return treeMap;
    }

    private static void a(ContentResolver contentResolver) {
        if (f == null) {
            a.set(false);
            f = new HashMap();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(b, true, new log());
        } else if (!a.getAndSet(false)) {
        } else {
            f.clear();
            g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    private static void a(Object obj, String str, String str2) {
        synchronized (lof.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }

    private static void a(Object obj, HashMap hashMap, String str, Object obj2) {
        synchronized (lof.class) {
            if (obj == k) {
                hashMap.put(str, obj2);
                f.remove(str);
            }
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        Object b2 = b(contentResolver);
        Boolean bool = (Boolean) a(g, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String a2 = a(contentResolver, str, (String) null);
        if (a2 != null && !a2.equals("")) {
            if (d.matcher(a2).matches()) {
                bool = true;
                z = true;
            } else if (e.matcher(a2).matches()) {
                bool = false;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + a2 + "\") as boolean");
            }
        }
        a(b2, g, str, bool);
        return z;
    }

    private static Object b(ContentResolver contentResolver) {
        Object obj;
        synchronized (lof.class) {
            a(contentResolver);
            obj = k;
        }
        return obj;
    }
}