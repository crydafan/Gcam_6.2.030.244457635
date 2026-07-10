package defpackage;

final /* synthetic */ class lsr implements lzb {
    private final lsq a;
    private final lzb b;

    lsr(lsq lsqVar, lzb lzbVar) {
        this.a = lsqVar;
        this.b = lzbVar;
    }

    @Override // defpackage.lzb
    public final void a(Object obj) {
        lsq lsqVar = this.a;
        lzb lzbVar = this.b;
        lsp lspVar = lsqVar.a;
        if (obj == null) {
            String valueOf = String.valueOf(lspVar.a);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("Input: ");
            sb.append(valueOf);
            sb.append(" returned a null value");
            throw new NullPointerException(sb.toString());
        }
        Object a = lspVar.a(obj);
        if (a != null) {
            lzbVar.a(a);
            return;
        }
        String valueOf2 = String.valueOf(obj);
        String name = lspVar.getClass().getName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 58 + String.valueOf(name).length());
        sb2.append("Transforming input value: ");
        sb2.append(valueOf2);
        sb2.append(" resulted in a null output for: ");
        sb2.append(name);
        throw new NullPointerException(sb2.toString());
    }
}