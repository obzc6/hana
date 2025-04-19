/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;

public static final class AlienCrystal.TargetESP
extends Enum<AlienCrystal.TargetESP> {
    private static final /* synthetic */ AlienCrystal.TargetESP[] $VALUES;
    public static final /* enum */ AlienCrystal.TargetESP None;
    public static final /* enum */ AlienCrystal.TargetESP Box;
    public static final /* enum */ AlienCrystal.TargetESP Jello;

    public static AlienCrystal.TargetESP valueOf(String a) {
        return Enum.valueOf(AlienCrystal.TargetESP.class, a);
    }

    static {
        Box = new AlienCrystal.TargetESP(Hole.ALLATORIxDEMO("XF("), 0);
        Jello = new AlienCrystal.TargetESP(GaussianKernel.ALLATORIxDEMO(" \u000b\u0010\u0001\u0010"), 1);
        None = new AlienCrystal.TargetESP(Hole.ALLATORIxDEMO("-uG5"), 2);
        $VALUES = AlienCrystal.TargetESP.$values();
    }

    public static AlienCrystal.TargetESP[] values() {
        return (AlienCrystal.TargetESP[])$VALUES.clone();
    }

    private static /* synthetic */ AlienCrystal.TargetESP[] $values() {
        AlienCrystal.TargetESP[] arrtargetESP = new AlienCrystal.TargetESP[3];
        arrtargetESP[0] = Box;
        arrtargetESP[1] = Jello;
        arrtargetESP[2] = None;
        return arrtargetESP;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AlienCrystal.TargetESP() {
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
