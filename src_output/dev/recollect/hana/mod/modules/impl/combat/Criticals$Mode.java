/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.impl.combat.Criticals;

private static final class Criticals.Mode
extends Enum<Criticals.Mode> {
    public static final /* enum */ Criticals.Mode NCP = new Criticals.Mode(Timer.ALLATORIxDEMO("g-3"), 0);
    public static final /* enum */ Criticals.Mode Hypixel2K22;
    public static final /* enum */ Criticals.Mode Strict;
    private static final /* synthetic */ Criticals.Mode[] $VALUES;
    public static final /* enum */ Criticals.Mode OldNCP;
    public static final /* enum */ Criticals.Mode LowPacket;
    public static final /* enum */ Criticals.Mode Packet;
    public static final /* enum */ Criticals.Mode NewNCP;

    private static /* synthetic */ Criticals.Mode[] $values() {
        Criticals.Mode[] arrmode = new Criticals.Mode[7];
        arrmode[0] = NCP;
        arrmode[1] = Strict;
        arrmode[2] = Packet;
        arrmode[3] = LowPacket;
        arrmode[4] = Hypixel2K22;
        arrmode[5] = NewNCP;
        arrmode[6] = OldNCP;
        return arrmode;
    }

    public static Criticals.Mode[] values() {
        return (Criticals.Mode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Criticals.Mode() {
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

    public static Criticals.Mode valueOf(String a) {
        return Enum.valueOf(Criticals.Mode.class, a);
    }

    static {
        Strict = new Criticals.Mode(WebUtils.ALLATORIxDEMO("\u0000n<ng9"), 1);
        Packet = new Criticals.Mode(Timer.ALLATORIxDEMO("iUGB\u000b\u0017"), 2);
        LowPacket = new Criticals.Mode(WebUtils.ALLATORIxDEMO("V;j\u0003{-la9"), 3);
        Hypixel2K22 = new Criticals.Mode(Timer.ALLATORIxDEMO("y@DWK\\X\u0016b\\Q"), 4);
        NewNCP = new Criticals.Mode(WebUtils.ALLATORIxDEMO("\u001d9IG\u001d"), 5);
        OldNCP = new Criticals.Mode(Timer.ALLATORIxDEMO("vX@g-3"), 6);
        $VALUES = Criticals.Mode.$values();
    }
}
