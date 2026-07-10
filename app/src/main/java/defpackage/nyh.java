package defpackage;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class nyh {
    private static final Map<Class<?>, Map<String, WeakReference<Enum<?>>>> a = new WeakHashMap<>();

    static Map<String, WeakReference<Enum<?>>> a(Class cls) {
        Map<String, WeakReference<Enum<?>>> map;
        synchronized (a) {
            map = a.get(cls);
            if (map == null) {
                map = new HashMap<>();
                for (Enum<?> r3 : (Iterable<Enum<?>>) EnumSet.allOf(cls)) {
                    map.put(r3.name(), new WeakReference<>(r3));
                }
                a.put(cls, map);
            }
        }
        return map;
    }

    public static nyp a(Class cls, String str) {
        ohr.b(cls);
        ohr.b(str);
        return nys.a(cls, str);
    }
}