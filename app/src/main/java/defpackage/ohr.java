package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ohr {
    @SafeVarargs
    public static ArrayList a(Object... objArr) {
        b(objArr);
        int length = objArr.length;
        oxl.a(length, "arraySize");
        ArrayList arrayList = new ArrayList(oxl.a(length + 5 + (length / 10)));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    static int a(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ((i + (next != null ? next.hashCode() : 0)) ^ (-1)) ^ (-1);
        }
        return i;
    }

    static Object[] a(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    static boolean a(Set set, Object obj) {
        if (set != obj) {
            if (obj instanceof Set) {
                Set set2 = (Set) obj;
                try {
                    if (set.size() == set2.size()) {
                        if (set.containsAll(set2)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ClassCastException e) {
                } catch (NullPointerException e2) {
                }
            }
            return false;
        }
        return true;
    }

    static boolean a(List list, nyu nyuVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!nyuVar.a(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException e) {
                        a(list, nyuVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException e2) {
                        a(list, nyuVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    public static oji a(Iterator it, nyu nyuVar) {
        b((Object) it);
        b(nyuVar);
        return new ofo(it, nyuVar);
    }

    public static boolean a(Iterable iterable, nyu nyuVar) {
        Iterator it = iterable.iterator();
        b(nyuVar, "predicate");
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (nyuVar.a(it.next())) {
                if (i != -1) {
                    return true;
                }
                break;
            } else {
                i++;
            }
        }
        return false;
    }

    public static boolean a(Collection collection, Iterator it) {
        b((Object) collection);
        b((Object) it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    private static void a(List list, nyu nyuVar, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (nyuVar.a(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    public static int a(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = a("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static String a(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String a(String str, Object... objArr) {
        int length;
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = c(objArr[i2]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length << 4));
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i >= length || (indexOf = valueOf.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append(valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append(valueOf, i3, valueOf.length());
        if (i < length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void a(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void a(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void a(boolean z, String str, char c) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, c));
    }

    public static void a(boolean z, String str, int i) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, i));
    }

    public static void a(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, i, i2));
    }

    public static void a(boolean z, String str, long j) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, j));
    }

    public static void a(boolean z, String str, long j, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(a(str, j, obj));
    }

    public static void a(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, obj));
    }

    public static void a(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, obj, obj2));
    }

    public static void a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(a(str, obj, obj2, obj3));
    }

    public static void a(int i, int i2, int i3) {
        if (i >= 0 && i2 >= i && i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException((i < 0 || i > i3) ? a(i, i3, "start index") : (i2 < 0 || i2 > i3) ? a(i2, i3, "end index") : a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
    }

    public static ArrayList b(Iterator it) {
        ArrayList c = c();
        a((Collection) c, it);
        return c;
    }

    public static <E> ArrayList<E> c() {
        return new ArrayList<>();
    }

    public static void b(boolean z ) {
        if (z) {
            return;
        }
        throw new IllegalStateException();
    }

    public static <T> T b(T obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static <T> T b(T obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void b(boolean z, String str, int i) {
        if (z) {
            return;
        }
        throw new IllegalStateException(a(str, i));
    }

    public static void b(boolean z, String str, long j) {
        if (z) {
            return;
        }
        throw new IllegalStateException(a(str, Long.valueOf(j)));
    }

    private static String c(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            String sb2 = name + '@' + hexString;
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            logger.logp(level, "com.google.common.base.Strings", "lenientToString", sb2.length() == 0 ?
                    "Exception during lenientFormat for " : "Exception during lenientFormat for ".concat(sb2), e);
            String name2 = e.getClass().getName();
            return "<" + sb2 + " threw " + name2 + ">";
        }
    }
}
