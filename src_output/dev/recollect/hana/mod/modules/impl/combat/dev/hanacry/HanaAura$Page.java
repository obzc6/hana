/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.xibao.Snow;

public static final class HanaAura.Page
extends Enum<HanaAura.Page> {
    public static final /* enum */ HanaAura.Page Interact;
    public static final /* enum */ HanaAura.Page Render;
    public static final /* enum */ HanaAura.Page Rotate;
    public static final /* enum */ HanaAura.Page Sync;
    private static final /* synthetic */ HanaAura.Page[] $VALUES;
    public static final /* enum */ HanaAura.Page General;
    public static final /* enum */ HanaAura.Page Calc;
    public static final /* enum */ HanaAura.Page Misc;

    public static HanaAura.Page[] values() {
        return (HanaAura.Page[])$VALUES.clone();
    }

    static {
        General = new HanaAura.Page(BOEntityUtils.ALLATORIxDEMO("HwPqJwV"), 0);
        Interact = new HanaAura.Page(Snow.ALLATORIxDEMO("zVvlvney"), 1);
        Misc = new HanaAura.Page(BOEntityUtils.ALLATORIxDEMO("YQeY"), 2);
        Rotate = new HanaAura.Page(Snow.ALLATORIxDEMO("Pfpnrh"), 3);
        Calc = new HanaAura.Page(BOEntityUtils.ALLATORIxDEMO("WYzY"), 4);
        Render = new HanaAura.Page(Snow.ALLATORIxDEMO("Pljkc"), 5);
        Sync = new HanaAura.Page(BOEntityUtils.ALLATORIxDEMO("GAxY"), 6);
        $VALUES = HanaAura.Page.$values();
    }

    public static HanaAura.Page valueOf(String a) {
        return Enum.valueOf(HanaAura.Page.class, a);
    }

    private static /* synthetic */ HanaAura.Page[] $values() {
        HanaAura.Page[] arrpage = new HanaAura.Page[7];
        arrpage[0] = General;
        arrpage[1] = Interact;
        arrpage[2] = Misc;
        arrpage[3] = Rotate;
        arrpage[4] = Calc;
        arrpage[5] = Render;
        arrpage[6] = Sync;
        return arrpage;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HanaAura.Page() {
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
}
