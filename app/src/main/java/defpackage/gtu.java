package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class gtu extends mqi {
    public final Map a;

    public gtu(gtu gtuVar) {
        this((mqm) gtuVar);
        this.a.putAll(gtuVar.a);
    }

    private gtu(mqm mqmVar) {
        super(mqmVar);
        this.a = new ConcurrentHashMap();
    }

    public gtu(mqm mqmVar, Map map) {
        super(mqmVar);
        this.a = new ConcurrentHashMap(map);
    }

    public gtu(mqm mqmVar, ozs ozsVar) {
        this(mqmVar);
        if (ozsVar != null) {
            this.a.put(gtw.a, ozsVar);
        }
    }

    public static gtu a(mqm mqmVar) {
        return new gtu(mqmVar);
    }

    private final Object b(gtv gtvVar) {
        if (this.a.containsKey(gtvVar)) {
            return this.a.get(gtvVar);
        }
        return null;
    }

    public final gtu a(gtv gtvVar, Object obj) {
        ohr.b(gtvVar);
        ohr.b(obj);
        this.a.put(gtvVar, obj);
        return this;
    }

    public final Object a(gtv gtvVar) {
        Object objB = b(gtvVar);
        String strValueOf = String.valueOf(gtvVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 24);
        sb.append("No value found for key: ");
        sb.append(strValueOf);
        return ohr.b(objB, sb.toString());
    }

    public final boolean i() {
        return b() != -1;
    }

    public final ozs j() {
        return (ozs) b(gtw.a);
    }
}