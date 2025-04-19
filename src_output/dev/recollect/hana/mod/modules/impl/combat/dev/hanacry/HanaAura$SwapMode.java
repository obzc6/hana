/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;

public static final class HanaAura.SwapMode
extends Enum<HanaAura.SwapMode> {
    private static final /* synthetic */ HanaAura.SwapMode[] $VALUES;
    public static final /* enum */ HanaAura.SwapMode Normal;
    public static final /* enum */ HanaAura.SwapMode Inventory;
    public static final /* enum */ HanaAura.SwapMode Off;
    public static final /* enum */ HanaAura.SwapMode Silent;

    static {
        Off = new HanaAura.SwapMode(CameraState.ALLATORIxDEMO("{?S"), 0);
        Normal = new HanaAura.SwapMode(BlockUpUtil.ALLATORIxDEMO("kuJj\u0013!"), 1);
        Silent = new HanaAura.SwapMode(CameraState.ALLATORIxDEMO("\u0000V4Q7A"), 2);
        Inventory = new HanaAura.SwapMode(BlockUpUtil.ALLATORIxDEMO("SLk@tLh\u00004"), 3);
        $VALUES = HanaAura.SwapMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HanaAura.SwapMode() {
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

    public static HanaAura.SwapMode valueOf(String a) {
        return Enum.valueOf(HanaAura.SwapMode.class, a);
    }

    public static HanaAura.SwapMode[] values() {
        return (HanaAura.SwapMode[])$VALUES.clone();
    }

    private static /* synthetic */ HanaAura.SwapMode[] $values() {
        HanaAura.SwapMode[] arrswapMode = new HanaAura.SwapMode[4];
        arrswapMode[0] = Off;
        arrswapMode[1] = Normal;
        arrswapMode[2] = Silent;
        arrswapMode[3] = Inventory;
        return arrswapMode;
    }
}
