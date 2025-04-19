/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.vanilla;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.impl.vanilla.VAnchorAura;
import dev.recollect.hana.socket.network.info.record.GameInfo;

public static final class VAnchorAura.Page
extends Enum<VAnchorAura.Page> {
    public static final /* enum */ VAnchorAura.Page Render;
    public static final /* enum */ VAnchorAura.Page Calc;
    public static final /* enum */ VAnchorAura.Page General;
    public static final /* enum */ VAnchorAura.Page Rotate;
    private static final /* synthetic */ VAnchorAura.Page[] $VALUES;

    private static /* synthetic */ VAnchorAura.Page[] $values() {
        VAnchorAura.Page[] arrpage = new VAnchorAura.Page[4];
        arrpage[0] = General;
        arrpage[1] = Calc;
        arrpage[2] = Rotate;
        arrpage[3] = Render;
        return arrpage;
    }

    static {
        General = new VAnchorAura.Page(GameInfo.ALLATORIxDEMO("ryjpyl"), 0);
        Calc = new VAnchorAura.Page(GaussianFilter.ALLATORIxDEMO("\u0011_t\u0017"), 1);
        Rotate = new VAnchorAura.Page(GameInfo.ALLATORIxDEMO("Nkncle"), 2);
        Render = new VAnchorAura.Page(GaussianFilter.ALLATORIxDEMO("\u001dF<Z}\u0006"), 3);
        $VALUES = VAnchorAura.Page.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ VAnchorAura.Page() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException
        // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
        // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static VAnchorAura.Page[] values() {
        return (VAnchorAura.Page[])$VALUES.clone();
    }

    public static VAnchorAura.Page valueOf(String a) {
        return Enum.valueOf(VAnchorAura.Page.class, a);
    }
}
