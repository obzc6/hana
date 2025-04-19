/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.socket.network.user.User;

public static final class AutoCrystal.SwapMode
extends Enum<AutoCrystal.SwapMode> {
    public static final /* enum */ AutoCrystal.SwapMode Silent;
    public static final /* enum */ AutoCrystal.SwapMode Off;
    public static final /* enum */ AutoCrystal.SwapMode Normal;
    private static final /* synthetic */ AutoCrystal.SwapMode[] $VALUES;
    public static final /* enum */ AutoCrystal.SwapMode Inventory;

    public static AutoCrystal.SwapMode[] values() {
        return (AutoCrystal.SwapMode[])$VALUES.clone();
    }

    static {
        Off = new AutoCrystal.SwapMode(GaussianFilter.ALLATORIxDEMO("q~\u0012"), 0);
        Normal = new AutoCrystal.SwapMode(User.ALLATORIxDEMO("nSYZKZ"), 1);
        Silent = new AutoCrystal.SwapMode(GaussianFilter.ALLATORIxDEMO("\u001cJ>[v\u0000"), 2);
        Inventory = new AutoCrystal.SwapMode(User.ALLATORIxDEMO("jlhER_XXO"), 3);
        $VALUES = AutoCrystal.SwapMode.$values();
    }

    public static AutoCrystal.SwapMode valueOf(String a) {
        return Enum.valueOf(AutoCrystal.SwapMode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoCrystal.SwapMode() {
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

    private static /* synthetic */ AutoCrystal.SwapMode[] $values() {
        AutoCrystal.SwapMode[] arrswapMode = new AutoCrystal.SwapMode[4];
        arrswapMode[0] = Off;
        arrswapMode[1] = Normal;
        arrswapMode[2] = Silent;
        arrswapMode[3] = Inventory;
        return arrswapMode;
    }
}
