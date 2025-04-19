/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.vanilla;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.vanilla.VAnchorAura;
import dev.recollect.hana.socket.network.packet.Packet;

public static final class VAnchorAura.CalcMode
extends Enum<VAnchorAura.CalcMode> {
    public static final /* enum */ VAnchorAura.CalcMode Mio;
    public static final /* enum */ VAnchorAura.CalcMode Meteor;
    private static final /* synthetic */ VAnchorAura.CalcMode[] $VALUES;
    public static final /* enum */ VAnchorAura.CalcMode Thunder;
    public static final /* enum */ VAnchorAura.CalcMode Edit;
    public static final /* enum */ VAnchorAura.CalcMode OyVey;

    private static /* synthetic */ VAnchorAura.CalcMode[] $values() {
        VAnchorAura.CalcMode[] arrcalcMode = new VAnchorAura.CalcMode[5];
        arrcalcMode[0] = OyVey;
        arrcalcMode[1] = Meteor;
        arrcalcMode[2] = Thunder;
        arrcalcMode[3] = Edit;
        arrcalcMode[4] = Mio;
        return arrcalcMode;
    }

    public static VAnchorAura.CalcMode[] values() {
        return (VAnchorAura.CalcMode[])$VALUES.clone();
    }

    static {
        OyVey = new VAnchorAura.CalcMode(Packet.ALLATORIxDEMO("}gozA"), 0);
        Meteor = new VAnchorAura.CalcMode(Snow.ALLATORIxDEMO("C?q4k\""), 1);
        Thunder = new VAnchorAura.CalcMode(Packet.ALLATORIxDEMO("D}Gp]zJ"), 2);
        Edit = new VAnchorAura.CalcMode(Snow.ALLATORIxDEMO("@5m$"), 3);
        Mio = new VAnchorAura.CalcMode(Packet.ALLATORIxDEMO("tvW"), 4);
        $VALUES = VAnchorAura.CalcMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ VAnchorAura.CalcMode() {
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

    public static VAnchorAura.CalcMode valueOf(String a) {
        return Enum.valueOf(VAnchorAura.CalcMode.class, a);
    }
}
