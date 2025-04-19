/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.socket.network.info.ClientInfo;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameConverter;

public static final class Frame.Type
extends Enum<Frame.Type> {
    private static final /* synthetic */ Frame.Type[] $VALUES;
    public static final /* enum */ Frame.Type AUDIO;
    public static final /* enum */ Frame.Type DATA;
    public static final /* enum */ Frame.Type ATTACHMENT;
    public static final /* enum */ Frame.Type VIDEO;
    public static final /* enum */ Frame.Type SUBTITLE;

    static {
        VIDEO = new Frame.Type(FrameConverter.ALLATORIxDEMO("G&H`\t"), 0);
        AUDIO = new Frame.Type(ClientInfo.ALLATORIxDEMO("\u000fK\u0017\u001dV"), 1);
        DATA = new Frame.Type(FrameConverter.ALLATORIxDEMO("+Mq\u0007"), 2);
        SUBTITLE = new Frame.Type(ClientInfo.ALLATORIxDEMO("W\u001cA\u001aW\u0007\u0018\\"), 3);
        ATTACHMENT = new Frame.Type(FrameConverter.ALLATORIxDEMO("3E!W1Y\"Ik\u0012"), 4);
        $VALUES = Frame.Type.$values();
    }

    private static /* synthetic */ Frame.Type[] $values() {
        Frame.Type[] arrtype = new Frame.Type[5];
        arrtype[0] = VIDEO;
        arrtype[1] = AUDIO;
        arrtype[2] = DATA;
        arrtype[3] = SUBTITLE;
        arrtype[4] = ATTACHMENT;
        return arrtype;
    }

    public static Frame.Type valueOf(String a) {
        return Enum.valueOf(Frame.Type.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Frame.Type() {
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

    public static Frame.Type[] values() {
        return (Frame.Type[])$VALUES.clone();
    }
}
