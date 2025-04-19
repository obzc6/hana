/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.combat.AntiWeakness;

public static final class AntiWeakness.SwapMode
extends Enum<AntiWeakness.SwapMode> {
    private static final /* synthetic */ AntiWeakness.SwapMode[] $VALUES;
    public static final /* enum */ AntiWeakness.SwapMode Silent;
    public static final /* enum */ AntiWeakness.SwapMode Inventory;
    public static final /* enum */ AntiWeakness.SwapMode Normal;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AntiWeakness.SwapMode() {
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

    public static AntiWeakness.SwapMode[] values() {
        return (AntiWeakness.SwapMode[])$VALUES.clone();
    }

    private static /* synthetic */ AntiWeakness.SwapMode[] $values() {
        AntiWeakness.SwapMode[] arrswapMode = new AntiWeakness.SwapMode[3];
        arrswapMode[0] = Normal;
        arrswapMode[1] = Silent;
        arrswapMode[2] = Inventory;
        return arrswapMode;
    }

    public static AntiWeakness.SwapMode valueOf(String a) {
        return Enum.valueOf(AntiWeakness.SwapMode.class, a);
    }

    static {
        Normal = new AntiWeakness.SwapMode(Vec3.ALLATORIxDEMO("\\\u0017k\u001ey\u001e"), 0);
        Silent = new AntiWeakness.SwapMode(Vec3.ALLATORIxDEMO("A\u0011u\u0016v\u0006"), 1);
        Inventory = new AntiWeakness.SwapMode(Vec3.ALLATORIxDEMO(".^,w\u0016m\u001cj\u000b"), 2);
        $VALUES = AntiWeakness.SwapMode.$values();
    }
}
