/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.video.Renderer;
import org.bytedeco.javacv.BaseSettings;

public static final class AnchorAura.CalcMode
extends Enum<AnchorAura.CalcMode> {
    private static final /* synthetic */ AnchorAura.CalcMode[] $VALUES;
    public static final /* enum */ AnchorAura.CalcMode Wink;
    public static final /* enum */ AnchorAura.CalcMode Edit;
    public static final /* enum */ AnchorAura.CalcMode Thunder;
    public static final /* enum */ AnchorAura.CalcMode OyVey;
    public static final /* enum */ AnchorAura.CalcMode Meteor;
    public static final /* enum */ AnchorAura.CalcMode Mio;

    public static AnchorAura.CalcMode[] values() {
        return (AnchorAura.CalcMode[])$VALUES.clone();
    }

    static {
        OyVey = new AnchorAura.CalcMode(Renderer.ALLATORIxDEMO("/y+/N"), 0);
        Meteor = new AnchorAura.CalcMode(BaseSettings.ALLATORIxDEMO("{fImS{"), 1);
        Thunder = new AnchorAura.CalcMode(Renderer.ALLATORIxDEMO("3u\u0015n\u0019/E"), 2);
        Edit = new AnchorAura.CalcMode(BaseSettings.ALLATORIxDEMO("xlU}"), 3);
        Mio = new AnchorAura.CalcMode(Renderer.ALLATORIxDEMO("0#X"), 4);
        Wink = new AnchorAura.CalcMode(BaseSettings.ALLATORIxDEMO("jaRb"), 5);
        $VALUES = AnchorAura.CalcMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AnchorAura.CalcMode() {
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

    private static /* synthetic */ AnchorAura.CalcMode[] $values() {
        AnchorAura.CalcMode[] arrcalcMode = new AnchorAura.CalcMode[6];
        arrcalcMode[0] = OyVey;
        arrcalcMode[1] = Meteor;
        arrcalcMode[2] = Thunder;
        arrcalcMode[3] = Edit;
        arrcalcMode[4] = Mio;
        arrcalcMode[5] = Wink;
        return arrcalcMode;
    }

    public static AnchorAura.CalcMode valueOf(String a) {
        return Enum.valueOf(AnchorAura.CalcMode.class, a);
    }
}
