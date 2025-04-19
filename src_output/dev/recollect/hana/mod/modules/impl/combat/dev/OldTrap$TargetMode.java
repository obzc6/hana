/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldTrap;
import org.bytedeco.javacv.FrameConverter;

public static final class OldTrap.TargetMode
extends Enum<OldTrap.TargetMode> {
    public static final /* enum */ OldTrap.TargetMode Multi;
    public static final /* enum */ OldTrap.TargetMode Single;
    private static final /* synthetic */ OldTrap.TargetMode[] $VALUES;

    /*
     * Exception decompiling
     */
    private /* synthetic */ OldTrap.TargetMode() {
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

    public static OldTrap.TargetMode valueOf(String a) {
        return Enum.valueOf(OldTrap.TargetMode.class, a);
    }

    private static /* synthetic */ OldTrap.TargetMode[] $values() {
        OldTrap.TargetMode[] arrtargetMode = new OldTrap.TargetMode[2];
        arrtargetMode[0] = Single;
        arrtargetMode[1] = Multi;
        return arrtargetMode;
    }

    public static OldTrap.TargetMode[] values() {
        return (OldTrap.TargetMode[])$VALUES.clone();
    }

    static {
        Single = new OldTrap.TargetMode(FrameConverter.ALLATORIxDEMO("!x\u0001kI#"), 0);
        Multi = new OldTrap.TargetMode(Snow.ALLATORIxDEMO("\u0017p=p9"), 1);
        $VALUES = OldTrap.TargetMode.$values();
    }
}
