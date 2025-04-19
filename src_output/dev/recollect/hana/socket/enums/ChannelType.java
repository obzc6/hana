/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import org.bytedeco.javacv.BaseSettings;

public final class ChannelType
extends Enum<ChannelType> {
    public static final /* enum */ ChannelType GLOBAL = new ChannelType(BaseSettings.ALLATORIxDEMO("gYf^}E"), 0, Tab.ALLATORIxDEMO("H\u0000}\u00139W"));
    private final String name;
    public static final /* enum */ ChannelType PRIVATE = new ChannelType(BaseSettings.ALLATORIxDEMO("hr\\]hL"), 1, Tab.ALLATORIxDEMO(";}\u0005d\u0010,^"));
    private static final /* synthetic */ ChannelType[] $VALUES;

    /*
     * Exception decompiling
     */
    private /* synthetic */ ChannelType(String varnull) {
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

    public String getName() {
        ChannelType a;
        return a.name;
    }

    static {
        $VALUES = ChannelType.$values();
    }

    public static ChannelType[] values() {
        return (ChannelType[])$VALUES.clone();
    }

    public static ChannelType valueOf(String a) {
        return Enum.valueOf(ChannelType.class, a);
    }

    private static /* synthetic */ ChannelType[] $values() {
        ChannelType[] arrchannelType = new ChannelType[2];
        arrchannelType[0] = GLOBAL;
        arrchannelType[1] = PRIVATE;
        return arrchannelType;
    }
}
