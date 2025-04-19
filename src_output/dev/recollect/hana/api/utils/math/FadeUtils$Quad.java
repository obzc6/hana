/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.RadiusUtils;

public static final class FadeUtils.Quad
extends Enum<FadeUtils.Quad> {
    public static final /* enum */ FadeUtils.Quad In = new FadeUtils.Quad(RadiusUtils.ALLATORIxDEMO("*Y"), 0);
    private static final /* synthetic */ FadeUtils.Quad[] $VALUES;
    public static final /* enum */ FadeUtils.Quad Out;
    public static final /* enum */ FadeUtils.Quad In2;

    /*
     * Exception decompiling
     */
    private /* synthetic */ FadeUtils.Quad() {
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
        In2 = new FadeUtils.Quad(BetterDynamicAnimation.ALLATORIxDEMO("[M%"), 1);
        Out = new FadeUtils.Quad(RadiusUtils.ALLATORIxDEMO("2\u0016C"), 2);
        $VALUES = FadeUtils.Quad.$values();
    }

    public static FadeUtils.Quad valueOf(String a) {
        return Enum.valueOf(FadeUtils.Quad.class, a);
    }

    private static /* synthetic */ FadeUtils.Quad[] $values() {
        FadeUtils.Quad[] arrquad = new FadeUtils.Quad[3];
        arrquad[0] = In;
        arrquad[1] = In2;
        arrquad[2] = Out;
        return arrquad;
    }

    public static FadeUtils.Quad[] values() {
        return (FadeUtils.Quad[])$VALUES.clone();
    }
}
