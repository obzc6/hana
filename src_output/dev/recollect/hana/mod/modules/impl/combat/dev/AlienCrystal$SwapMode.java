/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;

private static final class AlienCrystal.SwapMode
extends Enum<AlienCrystal.SwapMode> {
    private static final /* synthetic */ AlienCrystal.SwapMode[] $VALUES;
    public static final /* enum */ AlienCrystal.SwapMode Silent;
    public static final /* enum */ AlienCrystal.SwapMode Inventory;
    public static final /* enum */ AlienCrystal.SwapMode Off;
    public static final /* enum */ AlienCrystal.SwapMode Normal;

    private static /* synthetic */ AlienCrystal.SwapMode[] $values() {
        AlienCrystal.SwapMode[] arrswapMode = new AlienCrystal.SwapMode[4];
        arrswapMode[0] = Off;
        arrswapMode[1] = Normal;
        arrswapMode[2] = Silent;
        arrswapMode[3] = Inventory;
        return arrswapMode;
    }

    static {
        Off = new AlienCrystal.SwapMode(Tab.ALLATORIxDEMO(">>]"), 0);
        Normal = new AlienCrystal.SwapMode(ObsidianHelper.ALLATORIxDEMO("m'Z.H."), 1);
        Silent = new AlienCrystal.SwapMode(Tab.ALLATORIxDEMO("\\\u0005~\u00146O"), 2);
        Inventory = new AlienCrystal.SwapMode(ObsidianHelper.ALLATORIxDEMO("\u001eo\u001cF&\\,[;"), 3);
        $VALUES = AlienCrystal.SwapMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AlienCrystal.SwapMode() {
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

    public static AlienCrystal.SwapMode[] values() {
        return (AlienCrystal.SwapMode[])$VALUES.clone();
    }

    public static AlienCrystal.SwapMode valueOf(String a) {
        return Enum.valueOf(AlienCrystal.SwapMode.class, a);
    }
}
