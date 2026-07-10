package defpackage;

final class oyf extends oye {
    oyf(ozs ozsVar, oyp oypVar) {
        super(ozsVar, oypVar);
    }

    @Override
    final Object a(Object obj, Object obj2) {
        oyp oypVar = (oyp) obj;
        ozs a = oypVar.a(obj2);
        ohr.a(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", oypVar);
        return a;
    }

    @Override
    final void a(Object obj) {
        a((ozs) obj);
    }
}