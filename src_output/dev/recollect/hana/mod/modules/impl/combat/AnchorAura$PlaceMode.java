/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.settings.Setting;
import org.bytedeco.javacv.FrameFilter;

public static final class AnchorAura.PlaceMode
extends Enum<AnchorAura.PlaceMode> {
    public static final /* enum */ AnchorAura.PlaceMode NullPoint;
    public static final /* enum */ AnchorAura.PlaceMode tick;
    private static final /* synthetic */ AnchorAura.PlaceMode[] $VALUES;

    static {
        tick = new AnchorAura.PlaceMode(Setting.ALLATORIxDEMO("r,/d"), 0);
        NullPoint = new AnchorAura.PlaceMode(FrameFilter.ALLATORIxDEMO("X\u001aR!L)~)b"), 1);
        $VALUES = AnchorAura.PlaceMode.$values();
    }

    public static AnchorAura.PlaceMode valueOf(String a) {
        return Enum.valueOf(AnchorAura.PlaceMode.class, a);
    }

    public static AnchorAura.PlaceMode[] values() {
        return (AnchorAura.PlaceMode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AnchorAura.PlaceMode() {
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

    private static /* synthetic */ AnchorAura.PlaceMode[] $values() {
        AnchorAura.PlaceMode[] arrplaceMode = new AnchorAura.PlaceMode[2];
        arrplaceMode[0] = tick;
        arrplaceMode[1] = NullPoint;
        return arrplaceMode;
    }
}
