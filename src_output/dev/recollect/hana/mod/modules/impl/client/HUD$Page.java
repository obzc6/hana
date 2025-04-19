/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.client.HUD;

private static final class HUD.Page
extends Enum<HUD.Page> {
    public static final /* enum */ HUD.Page GLOBAL;
    public static final /* enum */ HUD.Page ELEMENTS;
    private static final /* synthetic */ HUD.Page[] $VALUES;
    public static final /* enum */ HUD.Page Color;

    public static HUD.Page valueOf(String a) {
        return Enum.valueOf(HUD.Page.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HUD.Page() {
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

    public static HUD.Page[] values() {
        return (HUD.Page[])$VALUES.clone();
    }

    static {
        ELEMENTS = new HUD.Page(TipUtils.ALLATORIxDEMO("\u0003%\u0004#\u0019=Bj"), 0);
        GLOBAL = new HUD.Page(NCPRaytracer.ALLATORIxDEMO("MiCaOm"), 1);
        Color = new HUD.Page(TipUtils.ALLATORIxDEMO("-3\u001fyK"), 2);
        $VALUES = HUD.Page.$values();
    }

    private static /* synthetic */ HUD.Page[] $values() {
        HUD.Page[] arrpage = new HUD.Page[3];
        arrpage[0] = ELEMENTS;
        arrpage[1] = GLOBAL;
        arrpage[2] = Color;
        return arrpage;
    }
}
