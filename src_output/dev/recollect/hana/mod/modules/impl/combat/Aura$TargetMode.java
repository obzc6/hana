/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;

private static final class Aura.TargetMode
extends Enum<Aura.TargetMode> {
    private static final /* synthetic */ Aura.TargetMode[] $VALUES;
    public static final /* enum */ Aura.TargetMode HEALTH;
    public static final /* enum */ Aura.TargetMode DISTANCE;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Aura.TargetMode() {
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

    public static Aura.TargetMode[] values() {
        return (Aura.TargetMode[])$VALUES.clone();
    }

    static {
        DISTANCE = new Aura.TargetMode(CameraState.ALLATORIxDEMO("5T\u0000k\u0019z\u001ap"), 0);
        HEALTH = new Aura.TargetMode(CrystalUtil.ALLATORIxDEMO("c\u001ea\u001cu\u0019"), 1);
        $VALUES = Aura.TargetMode.$values();
    }

    private static /* synthetic */ Aura.TargetMode[] $values() {
        Aura.TargetMode[] arrtargetMode = new Aura.TargetMode[2];
        arrtargetMode[0] = DISTANCE;
        arrtargetMode[1] = HEALTH;
        return arrtargetMode;
    }

    public static Aura.TargetMode valueOf(String a) {
        return Enum.valueOf(Aura.TargetMode.class, a);
    }
}
