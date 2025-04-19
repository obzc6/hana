/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.movement.dev.NewStep;
import dev.recollect.hana.xibao.Snow;

public static final class NewStep.Mode
extends Enum<NewStep.Mode> {
    public static final /* enum */ NewStep.Mode Vanilla = new NewStep.Mode(Snow.ALLATORIxDEMO("smin`jl"), 0);
    public static final /* enum */ NewStep.Mode NCP;
    public static final /* enum */ NewStep.Mode OldNCP;
    private static final /* synthetic */ NewStep.Mode[] $VALUES;

    private static /* synthetic */ NewStep.Mode[] $values() {
        NewStep.Mode[] arrmode = new NewStep.Mode[3];
        arrmode[0] = Vanilla;
        arrmode[1] = OldNCP;
        arrmode[2] = NCP;
        return arrmode;
    }

    static {
        OldNCP = new NewStep.Mode(ObsidianHelper.ALLATORIxDEMO("l$L\rj\u0012"), 1);
        NCP = new NewStep.Mode(Snow.ALLATORIxDEMO("BE]"), 2);
        $VALUES = NewStep.Mode.$values();
    }

    public static NewStep.Mode valueOf(String a) {
        return Enum.valueOf(NewStep.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ NewStep.Mode() {
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

    public static NewStep.Mode[] values() {
        return (NewStep.Mode[])$VALUES.clone();
    }
}
