/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaCrystalBase;
import org.bytedeco.javacv.FrameConverter;

private static final class HanaCrystalBase.Page
extends Enum<HanaCrystalBase.Page> {
    public static final /* enum */ HanaCrystalBase.Page General = new HanaCrystalBase.Page(FrameConverter.ALLATORIxDEMO("Q\u0017\n~D*"), 0);
    public static final /* enum */ HanaCrystalBase.Page Rotate;
    private static final /* synthetic */ HanaCrystalBase.Page[] $VALUES;
    public static final /* enum */ HanaCrystalBase.Page Calc;
    public static final /* enum */ HanaCrystalBase.Page Interact;
    public static final /* enum */ HanaCrystalBase.Page Misc;

    public static HanaCrystalBase.Page valueOf(String a) {
        return Enum.valueOf(HanaCrystalBase.Page.class, a);
    }

    private static /* synthetic */ HanaCrystalBase.Page[] $values() {
        HanaCrystalBase.Page[] arrpage = new HanaCrystalBase.Page[5];
        arrpage[0] = General;
        arrpage[1] = Interact;
        arrpage[2] = Misc;
        arrpage[3] = Rotate;
        arrpage[4] = Calc;
        return arrpage;
    }

    static {
        Interact = new HanaCrystalBase.Page(BetterDynamicAnimation.ALLATORIxDEMO("^MRwRuAb"), 1);
        Misc = new HanaCrystalBase.Page(FrameConverter.ALLATORIxDEMO("\"eV%"), 2);
        Rotate = new HanaCrystalBase.Page(BetterDynamicAnimation.ALLATORIxDEMO("t}TuVs"), 3);
        Calc = new HanaCrystalBase.Page(FrameConverter.ALLATORIxDEMO(",mI%"), 4);
        $VALUES = HanaCrystalBase.Page.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HanaCrystalBase.Page() {
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

    public static HanaCrystalBase.Page[] values() {
        return (HanaCrystalBase.Page[])$VALUES.clone();
    }
}
