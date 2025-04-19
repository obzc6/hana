/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.mod.modules.impl.combat.dev.PushCleaner;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.xibao.Snow;

public static final class PushCleaner.SwapMode
extends Enum<PushCleaner.SwapMode> {
    public static final /* enum */ PushCleaner.SwapMode Inventory;
    public static final /* enum */ PushCleaner.SwapMode Off;
    private static final /* synthetic */ PushCleaner.SwapMode[] $VALUES;
    public static final /* enum */ PushCleaner.SwapMode Silent;
    public static final /* enum */ PushCleaner.SwapMode Normal;

    public static PushCleaner.SwapMode[] values() {
        return (PushCleaner.SwapMode[])$VALUES.clone();
    }

    private static /* synthetic */ PushCleaner.SwapMode[] $values() {
        PushCleaner.SwapMode[] arrswapMode = new PushCleaner.SwapMode[4];
        arrswapMode[0] = Off;
        arrswapMode[1] = Normal;
        arrswapMode[2] = Silent;
        arrswapMode[3] = Inventory;
        return arrswapMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PushCleaner.SwapMode() {
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
        Off = new PushCleaner.SwapMode(Setting.ALLATORIxDEMO("\n*i"), 0);
        Normal = new PushCleaner.SwapMode(Snow.ALLATORIxDEMO("Bhuaga"), 1);
        Silent = new PushCleaner.SwapMode(Setting.ALLATORIxDEMO("H1j \"{"), 2);
        Inventory = new PushCleaner.SwapMode(Snow.ALLATORIxDEMO("Q@Siisctt"), 3);
        $VALUES = PushCleaner.SwapMode.$values();
    }

    public static PushCleaner.SwapMode valueOf(String a) {
        return Enum.valueOf(PushCleaner.SwapMode.class, a);
    }
}
