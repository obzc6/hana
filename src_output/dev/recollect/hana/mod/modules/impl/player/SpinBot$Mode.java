/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.impl.player.SpinBot;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;

public static final class SpinBot.Mode
extends Enum<SpinBot.Mode> {
    public static final /* enum */ SpinBot.Mode Spin;
    public static final /* enum */ SpinBot.Mode Static;
    public static final /* enum */ SpinBot.Mode None;
    private static final /* synthetic */ SpinBot.Mode[] $VALUES;
    public static final /* enum */ SpinBot.Mode RandomAngle;

    public static SpinBot.Mode valueOf(String a) {
        return Enum.valueOf(SpinBot.Mode.class, a);
    }

    public static SpinBot.Mode[] values() {
        return (SpinBot.Mode[])$VALUES.clone();
    }

    private static /* synthetic */ SpinBot.Mode[] $values() {
        SpinBot.Mode[] arrmode = new SpinBot.Mode[4];
        arrmode[0] = None;
        arrmode[1] = RandomAngle;
        arrmode[2] = Spin;
        arrmode[3] = Static;
        return arrmode;
    }

    static {
        None = new SpinBot.Mode(BackgroundInfo.ALLATORIxDEMO("\u000f9ey"), 0);
        RandomAngle = new SpinBot.Mode(CrystalUtil.ALLATORIxDEMO("\u0012\u0001~m\u0016F\u001aN7M4"), 1);
        Spin = new SpinBot.Mode(BackgroundInfo.ALLATORIxDEMO("\u0012&br"), 2);
        Static = new SpinBot.Mode(CrystalUtil.ALLATORIxDEMO("x/A$H2"), 3);
        $VALUES = SpinBot.Mode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SpinBot.Mode() {
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
}
