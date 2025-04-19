/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.modules.impl.combat.Aura;

public static final class Aura.Page
extends Enum<Aura.Page> {
    public static final /* enum */ Aura.Page Target;
    private static final /* synthetic */ Aura.Page[] $VALUES;
    public static final /* enum */ Aura.Page Render;
    public static final /* enum */ Aura.Page Rotate;
    public static final /* enum */ Aura.Page General;

    public static Aura.Page[] values() {
        return (Aura.Page[])$VALUES.clone();
    }

    static {
        General = new Aura.Page(OLEPOSSUtils.ALLATORIxDEMO("j0D-Ec\u0011"), 0);
        Rotate = new Aura.Page(BOEntityUtils.ALLATORIxDEMO("@Q`Yb_"), 1);
        Target = new Aura.Page(OLEPOSSUtils.ALLATORIxDEMO("\u0001K:Pg\t"), 2);
        Render = new Aura.Page(BOEntityUtils.ALLATORIxDEMO("@[z\\sH"), 3);
        $VALUES = Aura.Page.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Aura.Page() {
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

    public static Aura.Page valueOf(String a) {
        return Enum.valueOf(Aura.Page.class, a);
    }

    private static /* synthetic */ Aura.Page[] $values() {
        Aura.Page[] arrpage = new Aura.Page[4];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        arrpage[2] = Target;
        arrpage[3] = Render;
        return arrpage;
    }
}
