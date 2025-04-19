/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.impl.combat.dev.BurrowTest;

private static final class BurrowTest.RotateMode
extends Enum<BurrowTest.RotateMode> {
    public static final /* enum */ BurrowTest.RotateMode None;
    private static final /* synthetic */ BurrowTest.RotateMode[] $VALUES;
    public static final /* enum */ BurrowTest.RotateMode Bypass;
    public static final /* enum */ BurrowTest.RotateMode Normal;

    /*
     * Exception decompiling
     */
    private /* synthetic */ BurrowTest.RotateMode() {
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

    public static BurrowTest.RotateMode valueOf(String a) {
        return Enum.valueOf(BurrowTest.RotateMode.class, a);
    }

    private static /* synthetic */ BurrowTest.RotateMode[] $values() {
        BurrowTest.RotateMode[] arrrotateMode = new BurrowTest.RotateMode[3];
        arrrotateMode[0] = Bypass;
        arrrotateMode[1] = Normal;
        arrrotateMode[2] = None;
        return arrrotateMode;
    }

    static {
        Bypass = new BurrowTest.RotateMode(BlockUpUtil.ALLATORIxDEMO("gcHf\u0001>"), 0);
        Normal = new BurrowTest.RotateMode(TimeHelper.ALLATORIxDEMO("n\rO\u0012\u0016Y"), 1);
        None = new BurrowTest.RotateMode(BlockUpUtil.ALLATORIxDEMO("vh\u001c("), 2);
        $VALUES = BurrowTest.RotateMode.$values();
    }

    public static BurrowTest.RotateMode[] values() {
        return (BurrowTest.RotateMode[])$VALUES.clone();
    }
}
