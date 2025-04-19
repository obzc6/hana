/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.impl.movement.Speed;

public static final class Speed.SpeedMode
extends Enum<Speed.SpeedMode> {
    public static final /* enum */ Speed.SpeedMode NCP;
    public static final /* enum */ Speed.SpeedMode Vanilla;
    public static final /* enum */ Speed.SpeedMode VHop;
    public static final /* enum */ Speed.SpeedMode LowHop;
    public static final /* enum */ Speed.SpeedMode Constantiam;
    public static final /* enum */ Speed.SpeedMode Strafe;
    public static final /* enum */ Speed.SpeedMode None;
    public static final /* enum */ Speed.SpeedMode Bhop;
    private static final /* synthetic */ Speed.SpeedMode[] $VALUES;
    public static final /* enum */ Speed.SpeedMode GayHop;
    public static final /* enum */ Speed.SpeedMode Instant;
    public static final /* enum */ Speed.SpeedMode OnGround;
    public static final /* enum */ Speed.SpeedMode OldGround;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Speed.SpeedMode() {
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

    public static Speed.SpeedMode[] values() {
        return (Speed.SpeedMode[])$VALUES.clone();
    }

    public static Speed.SpeedMode valueOf(String a) {
        return Enum.valueOf(Speed.SpeedMode.class, a);
    }

    static {
        Instant = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO("\u0005\u00178\u00107@h"), 0);
        OldGround = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("SfQoeLiLy"), 1);
        OnGround = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO("1\">9\u000b#@x"), 2);
        Vanilla = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("cIyJpN|"), 3);
        NCP = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO("\u0018mL"), 4);
        Strafe = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("{cQ}Dx"), 5);
        GayHop = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO(">*\u001d\u001eAl"), 6);
        Bhop = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("atMm"), 7);
        VHop = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO("2\u001eAl"), 8);
        LowHop = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("dxTTMm"), 9);
        Constantiam = new Speed.SpeedMode(TimerManager.ALLATORIxDEMO("\r\u0016%\r8\u0018%\u0010?Oq"), 10);
        None = new Speed.SpeedMode(HoleUtils.ALLATORIxDEMO("msLx"), 11);
        $VALUES = Speed.SpeedMode.$values();
    }

    private static /* synthetic */ Speed.SpeedMode[] $values() {
        Speed.SpeedMode[] arrspeedMode = new Speed.SpeedMode[12];
        arrspeedMode[0] = Instant;
        arrspeedMode[1] = OldGround;
        arrspeedMode[2] = OnGround;
        arrspeedMode[3] = Vanilla;
        arrspeedMode[4] = NCP;
        arrspeedMode[5] = Strafe;
        arrspeedMode[6] = GayHop;
        arrspeedMode[7] = Bhop;
        arrspeedMode[8] = VHop;
        arrspeedMode[9] = LowHop;
        arrspeedMode[10] = Constantiam;
        arrspeedMode[11] = None;
        return arrspeedMode;
    }
}
