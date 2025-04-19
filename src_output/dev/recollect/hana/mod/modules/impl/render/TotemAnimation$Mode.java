/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.render.TotemAnimation;
import dev.recollect.hana.socket.network.packet.Packet;

public static final class TotemAnimation.Mode
extends Enum<TotemAnimation.Mode> {
    public static final /* enum */ TotemAnimation.Mode Off;
    public static final /* enum */ TotemAnimation.Mode FadeOut;
    public static final /* enum */ TotemAnimation.Mode Rocket;
    public static final /* enum */ TotemAnimation.Mode Size;
    public static final /* enum */ TotemAnimation.Mode Insert;
    public static final /* enum */ TotemAnimation.Mode Fall;
    public static final /* enum */ TotemAnimation.Mode Roll;
    private static final /* synthetic */ TotemAnimation.Mode[] $VALUES;
    public static final /* enum */ TotemAnimation.Mode Otkisuli;

    /*
     * Exception decompiling
     */
    private /* synthetic */ TotemAnimation.Mode() {
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

    private static /* synthetic */ TotemAnimation.Mode[] $values() {
        TotemAnimation.Mode[] arrmode = new TotemAnimation.Mode[8];
        arrmode[0] = FadeOut;
        arrmode[1] = Size;
        arrmode[2] = Otkisuli;
        arrmode[3] = Insert;
        arrmode[4] = Fall;
        arrmode[5] = Rocket;
        arrmode[6] = Roll;
        arrmode[7] = Off;
        return arrmode;
    }

    public static TotemAnimation.Mode[] values() {
        return (TotemAnimation.Mode[])$VALUES.clone();
    }

    static {
        FadeOut = new TotemAnimation.Mode(Vec3.ALLATORIxDEMO("\u001cs\u001c|<m\u0006"), 0);
        Size = new TotemAnimation.Mode(Packet.ALLATORIxDEMO("MPe]"), 1);
        Otkisuli = new TotemAnimation.Mode(Vec3.ALLATORIxDEMO(".y\u0011j\u0006t\u001b"), 2);
        Insert = new TotemAnimation.Mode(Packet.ALLATORIxDEMO("\\\\m\\mL"), 3);
        Fall = new TotemAnimation.Mode(Vec3.ALLATORIxDEMO("_\u0012t\u001e"), 4);
        Rocket = new TotemAnimation.Mode(Packet.ALLATORIxDEMO("G]}RzL"), 5);
        Roll = new TotemAnimation.Mode(Vec3.ALLATORIxDEMO("K\u001ct\u001e"), 6);
        Off = new TotemAnimation.Mode(Packet.ALLATORIxDEMO("vy^"), 7);
        $VALUES = TotemAnimation.Mode.$values();
    }

    public static TotemAnimation.Mode valueOf(String a) {
        return Enum.valueOf(TotemAnimation.Mode.class, a);
    }
}
