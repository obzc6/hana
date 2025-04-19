/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;

public static final class PacketFly2.Mode
extends Enum<PacketFly2.Mode> {
    private static final /* synthetic */ PacketFly2.Mode[] $VALUES;
    public static final /* enum */ PacketFly2.Mode Fast;
    public static final /* enum */ PacketFly2.Mode Factor;
    public static final /* enum */ PacketFly2.Mode Increment;
    public static final /* enum */ PacketFly2.Mode Compatibility;
    public static final /* enum */ PacketFly2.Mode Slow;
    public static final /* enum */ PacketFly2.Mode Setback;

    public static PacketFly2.Mode[] values() {
        return (PacketFly2.Mode[])$VALUES.clone();
    }

    private static /* synthetic */ PacketFly2.Mode[] $values() {
        PacketFly2.Mode[] arrmode = new PacketFly2.Mode[6];
        arrmode[0] = Setback;
        arrmode[1] = Fast;
        arrmode[2] = Factor;
        arrmode[3] = Slow;
        arrmode[4] = Increment;
        arrmode[5] = Compatibility;
        return arrmode;
    }

    public static PacketFly2.Mode valueOf(String a) {
        return Enum.valueOf(PacketFly2.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PacketFly2.Mode() {
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
        Setback = new PacketFly2.Mode(BackgroundInfo.ALLATORIxDEMO("\u001f9?#7hw"), 0);
        Fast = new PacketFly2.Mode(TipUtils.ALLATORIxDEMO("\u001a\u0012eM"), 1);
        Factor = new PacketFly2.Mode(BackgroundInfo.ALLATORIxDEMO("\u001a*\"\"dn"), 2);
        Slow = new PacketFly2.Mode(TipUtils.ALLATORIxDEMO("\u000f\u001fyN"), 3);
        Increment = new PacketFly2.Mode(BackgroundInfo.ALLATORIxDEMO("\u00025/..,3eh"), 4);
        Compatibility = new PacketFly2.Mode(TipUtils.ALLATORIxDEMO("'+\u00061\u000f2\u0000#\u00070\u001ab@"), 5);
        $VALUES = PacketFly2.Mode.$values();
    }
}
