/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.modules.impl.client.ModuleList;
import dev.recollect.hana.socket.network.packet.Packet;

private static final class ModuleList.Theme
extends Enum<ModuleList.Theme> {
    public static final /* enum */ ModuleList.Theme Light;
    private static final /* synthetic */ ModuleList.Theme[] $VALUES;
    public static final /* enum */ ModuleList.Theme Colorful;
    public static final /* enum */ ModuleList.Theme Dark;

    private static /* synthetic */ ModuleList.Theme[] $values() {
        ModuleList.Theme[] arrtheme = new ModuleList.Theme[3];
        arrtheme[0] = Dark;
        arrtheme[1] = Light;
        arrtheme[2] = Colorful;
        return arrtheme;
    }

    public static ModuleList.Theme[] values() {
        return (ModuleList.Theme[])$VALUES.clone();
    }

    public static ModuleList.Theme valueOf(String a) {
        return Enum.valueOf(ModuleList.Theme.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ModuleList.Theme() {
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
        Dark = new ModuleList.Theme(TimerManager.ALLATORIxDEMO(" 7\\w"), 0);
        Light = new ModuleList.Theme(Packet.ALLATORIxDEMO("t~WwL"), 1);
        Colorful = new ModuleList.Theme(TimerManager.ALLATORIxDEMO("=#\u0015$\u00160[p"), 2);
        $VALUES = ModuleList.Theme.$values();
    }
}
