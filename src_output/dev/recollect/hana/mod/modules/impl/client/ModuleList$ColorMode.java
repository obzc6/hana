/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.mod.modules.impl.client.ModuleList;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.socket.network.packet.Packet;

private static final class ModuleList.ColorMode
extends Enum<ModuleList.ColorMode> {
    public static final /* enum */ ModuleList.ColorMode Custom = new ModuleList.ColorMode(Setting.ALLATORIxDEMO("X-u1#b"), 0);
    private static final /* synthetic */ ModuleList.ColorMode[] $VALUES;
    public static final /* enum */ ModuleList.ColorMode Pulse = new ModuleList.ColorMode(Packet.ALLATORIxDEMO("bkUl]"), 1);
    public static final /* enum */ ModuleList.ColorMode Rainbow = new ModuleList.ColorMode(Setting.ALLATORIxDEMO("\rz1h'#x"), 2);

    private static /* synthetic */ ModuleList.ColorMode[] $values() {
        ModuleList.ColorMode[] arrcolorMode = new ModuleList.ColorMode[3];
        arrcolorMode[0] = Custom;
        arrcolorMode[1] = Pulse;
        arrcolorMode[2] = Rainbow;
        return arrcolorMode;
    }

    public static ModuleList.ColorMode valueOf(String a) {
        return Enum.valueOf(ModuleList.ColorMode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ModuleList.ColorMode() {
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
        $VALUES = ModuleList.ColorMode.$values();
    }

    public static ModuleList.ColorMode[] values() {
        return (ModuleList.ColorMode[])$VALUES.clone();
    }
}
