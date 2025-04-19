/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFly;

public static final class ElytraFly.Mode
extends Enum<ElytraFly.Mode> {
    public static final /* enum */ ElytraFly.Mode Freeze;
    public static final /* enum */ ElytraFly.Mode Control;
    public static final /* enum */ ElytraFly.Mode Boost;
    public static final /* enum */ ElytraFly.Mode Bounce;
    public static final /* enum */ ElytraFly.Mode None;
    private static final /* synthetic */ ElytraFly.Mode[] $VALUES;

    private static /* synthetic */ ElytraFly.Mode[] $values() {
        ElytraFly.Mode[] arrmode = new ElytraFly.Mode[5];
        arrmode[0] = Control;
        arrmode[1] = Boost;
        arrmode[2] = Bounce;
        arrmode[3] = Freeze;
        arrmode[4] = None;
        return arrmode;
    }

    public static ElytraFly.Mode valueOf(String a) {
        return Enum.valueOf(ElytraFly.Mode.class, a);
    }

    public static ElytraFly.Mode[] values() {
        return (ElytraFly.Mode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ElytraFly.Mode() {
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

    static {
        Control = new ElytraFly.Mode(TimerManager.ALLATORIxDEMO("\u000f\u0016%\u0010$Ap"), 0);
        Boost = new ElytraFly.Mode(GaussianKernel.ALLATORIxDEMO("\u00026$+>"), 1);
        Bounce = new ElytraFly.Mode(TimerManager.ALLATORIxDEMO(";$\u00118My"), 2);
        Freeze = new ElytraFly.Mode(GaussianKernel.ALLATORIxDEMO("\u00142<.\"/"), 3);
        None = new ElytraFly.Mode(TimerManager.ALLATORIxDEMO("*9@y"), 4);
        $VALUES = ElytraFly.Mode.$values();
    }
}
