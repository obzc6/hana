/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldBurrow;

private static final class OldBurrow.RotateMode
extends Enum<OldBurrow.RotateMode> {
    private static final /* synthetic */ OldBurrow.RotateMode[] $VALUES;
    public static final /* enum */ OldBurrow.RotateMode Normal;
    public static final /* enum */ OldBurrow.RotateMode Bypass;
    public static final /* enum */ OldBurrow.RotateMode None;

    public static OldBurrow.RotateMode valueOf(String a) {
        return Enum.valueOf(OldBurrow.RotateMode.class, a);
    }

    static {
        Bypass = new OldBurrow.RotateMode(FadeUtils.ALLATORIxDEMO(".D\u0001AH\u0019"), 0);
        Normal = new OldBurrow.RotateMode(GaussianKernel.ALLATORIxDEMO("\u001c/+&9&"), 1);
        None = new OldBurrow.RotateMode(FadeUtils.ALLATORIxDEMO("?OU\u000f"), 2);
        $VALUES = OldBurrow.RotateMode.$values();
    }

    private static /* synthetic */ OldBurrow.RotateMode[] $values() {
        OldBurrow.RotateMode[] arrrotateMode = new OldBurrow.RotateMode[3];
        arrrotateMode[0] = Bypass;
        arrrotateMode[1] = Normal;
        arrrotateMode[2] = None;
        return arrrotateMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ OldBurrow.RotateMode() {
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

    public static OldBurrow.RotateMode[] values() {
        return (OldBurrow.RotateMode[])$VALUES.clone();
    }
}
