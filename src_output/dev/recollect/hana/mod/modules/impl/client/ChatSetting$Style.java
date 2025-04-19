/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;

public static final class ChatSetting.Style
extends Enum<ChatSetting.Style> {
    public static final /* enum */ ChatSetting.Style None;
    public static final /* enum */ ChatSetting.Style Mio;
    private static final /* synthetic */ ChatSetting.Style[] $VALUES;
    public static final /* enum */ ChatSetting.Style Future;
    public static final /* enum */ ChatSetting.Style Basic;
    public static final /* enum */ ChatSetting.Style Moon;
    public static final /* enum */ ChatSetting.Style Earth;

    /*
     * Exception decompiling
     */
    private /* synthetic */ ChatSetting.Style() {
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

    public static ChatSetting.Style valueOf(String a) {
        return Enum.valueOf(ChatSetting.Style.class, a);
    }

    private static /* synthetic */ ChatSetting.Style[] $values() {
        ChatSetting.Style[] arrstyle = new ChatSetting.Style[6];
        arrstyle[0] = Mio;
        arrstyle[1] = Basic;
        arrstyle[2] = Future;
        arrstyle[3] = Earth;
        arrstyle[4] = Moon;
        arrstyle[5] = None;
        return arrstyle;
    }

    static {
        Mio = new ChatSetting.Style(CameraState.ALLATORIxDEMO("q0Z"), 0);
        Basic = new ChatSetting.Style(TimerManager.ALLATORIxDEMO("\t\u0005%G"), 1);
        Future = new ChatSetting.Style(CameraState.ALLATORIxDEMO("\u0003\\$I+P"), 2);
        Earth = new ChatSetting.Style(TimerManager.ALLATORIxDEMO("\u000e\u0005$Zt"), 3);
        Moon = new ChatSetting.Style(CameraState.ALLATORIxDEMO("\u001dS6["), 4);
        None = new ChatSetting.Style(TimerManager.ALLATORIxDEMO("*9@y"), 5);
        $VALUES = ChatSetting.Style.$values();
    }

    public static ChatSetting.Style[] values() {
        return (ChatSetting.Style[])$VALUES.clone();
    }
}
