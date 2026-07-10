package defpackage;

import java.util.concurrent.Executor;

final class lsq implements lrm {
    public final /* synthetic */ lsp a;
    private final /* synthetic */ lrm b;

    lsq(lsp lspVar, lrm lrmVar) {
        this.a = lspVar;
        this.b = lrmVar;
    }

    @Override // defpackage.lrm
    public final lyu a(lzb lzbVar, Executor executor) {
        return this.b.a(new lsr(this, lzbVar), executor);
    }

    @Override // defpackage.lrm
    public final Object b_() {
        lsp lspVar = this.a;
        Object b_ = this.b.b_();
        if (b_ == null) {
            String valueOf = String.valueOf(lspVar.a);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("Input: ");
            sb.append(valueOf);
            sb.append(" returned a null value");
            throw new NullPointerException(sb.toString());
        }
        Object a = lspVar.a(b_);
        if (a != null) {
            return a;
        }
        String valueOf2 = String.valueOf(b_);
        String name = lspVar.getClass().getName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 58 + String.valueOf(name).length());
        sb2.append("Transforming input value: ");
        sb2.append(valueOf2);
        sb2.append(" resulted in a null output for: ");
        sb2.append(name);
        throw new NullPointerException(sb2.toString());
    }
}