/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;

public static final class ChatSetting.code
extends Enum<ChatSetting.code> {
    public static final /* enum */ ChatSetting.code Earth;
    public static final /* enum */ ChatSetting.code None;
    private static final /* synthetic */ ChatSetting.code[] $VALUES;
    public static final /* enum */ ChatSetting.code Mio;
    public static final /* enum */ ChatSetting.code Custom;

    private static /* synthetic */ ChatSetting.code[] $values() {
        ChatSetting.code[] arrcode = new ChatSetting.code[4];
        arrcode[0] = Mio;
        arrcode[1] = Earth;
        arrcode[2] = Custom;
        arrcode[3] = None;
        return arrcode;
    }

    public static ChatSetting.code[] values() {
        return (ChatSetting.code[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ChatSetting.code() {
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
        Mio = new ChatSetting.code(Snow.ALLATORIxDEMO("\u001cm?"), 0);
        Earth = new ChatSetting.code(GaussianFilter.ALLATORIxDEMO("f3Ll\u001c"), 1);
        Custom = new ChatSetting.code(Snow.ALLATORIxDEMO("M/v%k="), 2);
        None = new ChatSetting.code(GaussianFilter.ALLATORIxDEMO("\u001cQv\u0011"), 3);
        $VALUES = ChatSetting.code.$values();
    }

    public static ChatSetting.code valueOf(String a) {
        return Enum.valueOf(ChatSetting.code.class, a);
    }
}
