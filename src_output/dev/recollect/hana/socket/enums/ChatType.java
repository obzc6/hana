/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.video.Renderer;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

public final class ChatType
extends Enum<ChatType> {
    public static final /* enum */ ChatType NORMAL = new ChatType(RenderHelper.ALLATORIxDEMO("$Z%E|\u000e"), 0, Renderer.ALLATORIxDEMO("S\u000fr\u0010+["));
    private static final /* synthetic */ ChatType[] $VALUES;
    public static final /* enum */ ChatType SERVER;
    private final String name;
    public static final /* enum */ ChatType NOTICE;

    private static /* synthetic */ ChatType[] $values() {
        ChatType[] arrchatType = new ChatType[3];
        arrchatType[0] = NORMAL;
        arrchatType[1] = NOTICE;
        arrchatType[2] = SERVER;
        return arrchatType;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ChatType(String varnull) {
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

    public static ChatType valueOf(String a) {
        return Enum.valueOf(ChatType.class, a);
    }

    public String getName() {
        ChatType a;
        return a.name;
    }

    public static ChatType[] values() {
        return (ChatType[])$VALUES.clone();
    }

    static {
        NOTICE = new ChatType(RenderHelper.ALLATORIxDEMO("$Z#A~\u0007"), 1, Renderer.ALLATORIxDEMO("S\u000ft\u0014)R"));
        SERVER = new ChatType(RenderHelper.ALLATORIxDEMO("9P%^x\u0010"), 2, Renderer.ALLATORIxDEMO("N\u0005r\u000b/E"));
        $VALUES = ChatType.$values();
    }
}
