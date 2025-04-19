/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import org.bytedeco.javacv.FrameFilter;

public static final class AnchorAura.Page
extends Enum<AnchorAura.Page> {
    public static final /* enum */ AnchorAura.Page General = new AnchorAura.Page(BlockUpUtil.ALLATORIxDEMO("Z@t]u\u0013!"), 0);
    public static final /* enum */ AnchorAura.Page Rotate;
    public static final /* enum */ AnchorAura.Page Calc;
    public static final /* enum */ AnchorAura.Page Render;
    private static final /* synthetic */ AnchorAura.Page[] $VALUES;

    static {
        Calc = new AnchorAura.Page(FrameFilter.ALLATORIxDEMO("\u0006u+u"), 1);
        Rotate = new AnchorAura.Page(BlockUpUtil.ALLATORIxDEMO("wuLf\u0006("), 2);
        Render = new AnchorAura.Page(FrameFilter.ALLATORIxDEMO("\u0011w+p\"d"), 3);
        $VALUES = AnchorAura.Page.$values();
    }

    public static AnchorAura.Page valueOf(String a) {
        return Enum.valueOf(AnchorAura.Page.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AnchorAura.Page() {
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

    public static AnchorAura.Page[] values() {
        return (AnchorAura.Page[])$VALUES.clone();
    }

    private static /* synthetic */ AnchorAura.Page[] $values() {
        AnchorAura.Page[] arrpage = new AnchorAura.Page[4];
        arrpage[0] = General;
        arrpage[1] = Calc;
        arrpage[2] = Rotate;
        arrpage[3] = Render;
        return arrpage;
    }
}
