/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.render.dev.KillEffects;

public static final class KillEffects.Mode
extends Enum<KillEffects.Mode> {
    public static final /* enum */ KillEffects.Mode LightningBolt;
    private static final /* synthetic */ KillEffects.Mode[] $VALUES;
    public static final /* enum */ KillEffects.Mode FallingLava;
    public static final /* enum */ KillEffects.Mode SakuraPetals;

    public static KillEffects.Mode valueOf(String a) {
        return Enum.valueOf(KillEffects.Mode.class, a);
    }

    static {
        FallingLava = new KillEffects.Mode(ColorUtil.ALLATORIxDEMO("X<w6u3|\fg|-"), 0);
        LightningBolt = new KillEffects.Mode(TimerManager.ALLATORIxDEMO("\r\u0015)\u0011?\u0010%\u0017,&9Bh"), 1);
        SakuraPetals = new KillEffects.Mode(ColorUtil.ALLATORIxDEMO("\u000b6n(}\r~4gf?"), 2);
        $VALUES = KillEffects.Mode.$values();
    }

    public static KillEffects.Mode[] values() {
        return (KillEffects.Mode[])$VALUES.clone();
    }

    private static /* synthetic */ KillEffects.Mode[] $values() {
        KillEffects.Mode[] arrmode = new KillEffects.Mode[3];
        arrmode[0] = FallingLava;
        arrmode[1] = LightningBolt;
        arrmode[2] = SakuraPetals;
        return arrmode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ KillEffects.Mode() {
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
