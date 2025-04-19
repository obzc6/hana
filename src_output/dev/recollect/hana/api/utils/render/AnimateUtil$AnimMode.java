/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.render;

import dev.recollect.hana.api.utils.render.AnimateUtil;
import org.bytedeco.javacv.BufferRing;
import org.bytedeco.javacv.FrameConverter;

public static final class AnimateUtil.AnimMode
extends Enum<AnimateUtil.AnimMode> {
    public static final /* enum */ AnimateUtil.AnimMode Mio;
    private static final /* synthetic */ AnimateUtil.AnimMode[] $VALUES;
    public static final /* enum */ AnimateUtil.AnimMode Old;
    public static final /* enum */ AnimateUtil.AnimMode My;
    public static final /* enum */ AnimateUtil.AnimMode None;
    public static final /* enum */ AnimateUtil.AnimMode Normal;
    public static final /* enum */ AnimateUtil.AnimMode Thunder;

    public static AnimateUtil.AnimMode valueOf(String a) {
        return Enum.valueOf(AnimateUtil.AnimMode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AnimateUtil.AnimMode() {
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

    private static /* synthetic */ AnimateUtil.AnimMode[] $values() {
        AnimateUtil.AnimMode[] arranimMode = new AnimateUtil.AnimMode[6];
        arranimMode[0] = Thunder;
        arranimMode[1] = Mio;
        arranimMode[2] = My;
        arranimMode[3] = Old;
        arranimMode[4] = Normal;
        arranimMode[5] = None;
        return arranimMode;
    }

    static {
        Thunder = new AnimateUtil.AnimMode(BufferRing.ALLATORIxDEMO(".!\b:\u0004{X"), 0);
        Mio = new AnimateUtil.AnimMode(FrameConverter.ALLATORIxDEMO("AL)"), 1);
        My = new AnimateUtil.AnimMode(BufferRing.ALLATORIxDEMO("SS"), 2);
        Old = new AnimateUtil.AnimMode(FrameConverter.ALLATORIxDEMO("CI\""), 3);
        Normal = new AnimateUtil.AnimMode(BufferRing.ALLATORIxDEMO("\u0007\u0012&\rF"), 4);
        None = new AnimateUtil.AnimMode(FrameConverter.ALLATORIxDEMO("!cK#"), 5);
        $VALUES = AnimateUtil.AnimMode.$values();
    }

    public static AnimateUtil.AnimMode[] values() {
        return (AnimateUtil.AnimMode[])$VALUES.clone();
    }
}
