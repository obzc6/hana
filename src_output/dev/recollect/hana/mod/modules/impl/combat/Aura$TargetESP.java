/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.Aura;

public static final class Aura.TargetESP
extends Enum<Aura.TargetESP> {
    public static final /* enum */ Aura.TargetESP Box = new Aura.TargetESP(CrystalUtil.ALLATORIxDEMO("%{\u001c"), 0);
    private static final /* synthetic */ Aura.TargetESP[] $VALUES;
    public static final /* enum */ Aura.TargetESP Jello = new Aura.TargetESP(Timer.ALLATORIxDEMO("~AE\u0002\f"), 1);
    public static final /* enum */ Aura.TargetESP None = new Aura.TargetESP(CrystalUtil.ALLATORIxDEMO("Y\bz\u0001"), 2);

    public static Aura.TargetESP valueOf(String a) {
        return Enum.valueOf(Aura.TargetESP.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Aura.TargetESP() {
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

    private static /* synthetic */ Aura.TargetESP[] $values() {
        Aura.TargetESP[] arrtargetESP = new Aura.TargetESP[3];
        arrtargetESP[0] = Box;
        arrtargetESP[1] = Jello;
        arrtargetESP[2] = None;
        return arrtargetESP;
    }

    static {
        $VALUES = Aura.TargetESP.$values();
    }

    public static Aura.TargetESP[] values() {
        return (Aura.TargetESP[])$VALUES.clone();
    }
}
