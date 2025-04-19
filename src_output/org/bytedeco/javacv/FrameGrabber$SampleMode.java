/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.socket.network.client.SocketClient;
import org.bytedeco.javacv.FrameGrabber;

public static final class FrameGrabber.SampleMode
extends Enum<FrameGrabber.SampleMode> {
    public static final /* enum */ FrameGrabber.SampleMode RAW;
    public static final /* enum */ FrameGrabber.SampleMode FLOAT;
    private static final /* synthetic */ FrameGrabber.SampleMode[] $VALUES;
    public static final /* enum */ FrameGrabber.SampleMode SHORT;

    /*
     * Exception decompiling
     */
    private /* synthetic */ FrameGrabber.SampleMode() {
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
        SHORT = new FrameGrabber.SampleMode(CrystalUtil.ALLATORIxDEMO("\bh\u001fs\u0005"), 0);
        FLOAT = new FrameGrabber.SampleMode(SocketClient.ALLATORIxDEMO("Bf@jZ"), 1);
        RAW = new FrameGrabber.SampleMode(CrystalUtil.ALLATORIxDEMO("\u0002`\u0006"), 2);
        $VALUES = FrameGrabber.SampleMode.$values();
    }

    public static FrameGrabber.SampleMode[] values() {
        return (FrameGrabber.SampleMode[])$VALUES.clone();
    }

    private static /* synthetic */ FrameGrabber.SampleMode[] $values() {
        FrameGrabber.SampleMode[] arrsampleMode = new FrameGrabber.SampleMode[3];
        arrsampleMode[0] = SHORT;
        arrsampleMode[1] = FLOAT;
        arrsampleMode[2] = RAW;
        return arrsampleMode;
    }

    public static FrameGrabber.SampleMode valueOf(String a) {
        return Enum.valueOf(FrameGrabber.SampleMode.class, a);
    }
}
