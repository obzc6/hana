/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.video.FileUtil;
import org.bytedeco.javacv.FrameGrabber;

public static final class FrameGrabber.ImageMode
extends Enum<FrameGrabber.ImageMode> {
    public static final /* enum */ FrameGrabber.ImageMode GRAY;
    private static final /* synthetic */ FrameGrabber.ImageMode[] $VALUES;
    public static final /* enum */ FrameGrabber.ImageMode RAW;
    public static final /* enum */ FrameGrabber.ImageMode COLOR;

    static {
        COLOR = new FrameGrabber.ImageMode(NpSocketClient.ALLATORIxDEMO("\u0004C\u0000B\u001f"), 0);
        GRAY = new FrameGrabber.ImageMode(FileUtil.ALLATORIxDEMO("V,Q&"), 1);
        RAW = new FrameGrabber.ImageMode(NpSocketClient.ALLATORIxDEMO("\u001eL\u001a"), 2);
        $VALUES = FrameGrabber.ImageMode.$values();
    }

    public static FrameGrabber.ImageMode[] values() {
        return (FrameGrabber.ImageMode[])$VALUES.clone();
    }

    private static /* synthetic */ FrameGrabber.ImageMode[] $values() {
        FrameGrabber.ImageMode[] arrimageMode = new FrameGrabber.ImageMode[3];
        arrimageMode[0] = COLOR;
        arrimageMode[1] = GRAY;
        arrimageMode[2] = RAW;
        return arrimageMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ FrameGrabber.ImageMode() {
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

    public static FrameGrabber.ImageMode valueOf(String a) {
        return Enum.valueOf(FrameGrabber.ImageMode.class, a);
    }
}
