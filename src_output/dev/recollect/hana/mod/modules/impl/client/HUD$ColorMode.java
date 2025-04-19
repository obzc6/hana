/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.client.HUD;

private static final class HUD.ColorMode
extends Enum<HUD.ColorMode> {
    public static final /* enum */ HUD.ColorMode Rainbow;
    private static final /* synthetic */ HUD.ColorMode[] $VALUES;
    public static final /* enum */ HUD.ColorMode Pulse;
    public static final /* enum */ HUD.ColorMode Custom;
    public static final /* enum */ HUD.ColorMode PulseRainbow;

    private static /* synthetic */ HUD.ColorMode[] $values() {
        HUD.ColorMode[] arrcolorMode = new HUD.ColorMode[4];
        arrcolorMode[0] = Custom;
        arrcolorMode[1] = Pulse;
        arrcolorMode[2] = Rainbow;
        arrcolorMode[3] = PulseRainbow;
        return arrcolorMode;
    }

    static {
        Custom = new HUD.ColorMode(FPSManager.ALLATORIxDEMO("S\u0003~\u001f(L"), 0);
        Pulse = new HUD.ColorMode(ColorUtil.ALLATORIxDEMO("K5jy)"), 1);
        Rainbow = new HUD.ColorMode(FPSManager.ALLATORIxDEMO("#q\u001fc\t(V"), 2);
        PulseRainbow = new HUD.ColorMode(ColorUtil.ALLATORIxDEMO("\bk1h?N<r.de;"), 3);
        $VALUES = HUD.ColorMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HUD.ColorMode() {
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

    public static HUD.ColorMode[] values() {
        return (HUD.ColorMode[])$VALUES.clone();
    }

    public static HUD.ColorMode valueOf(String a) {
        return Enum.valueOf(HUD.ColorMode.class, a);
    }
}
