/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.socket.network.info.record.UserInfo;

public static final class FadeUtils.Ease
extends Enum<FadeUtils.Ease> {
    public static final /* enum */ FadeUtils.Ease Normal;
    public static final /* enum */ FadeUtils.Ease OutQuint;
    public static final /* enum */ FadeUtils.Ease Slow;
    private static final /* synthetic */ FadeUtils.Ease[] $VALUES;
    public static final /* enum */ FadeUtils.Ease CUBIC_IN_OUT;
    public static final /* enum */ FadeUtils.Ease Out;
    public static final /* enum */ FadeUtils.Ease In2;
    public static final /* enum */ FadeUtils.Ease InQuint;
    public static final /* enum */ FadeUtils.Ease CUBIC_OUT;
    public static final /* enum */ FadeUtils.Ease CUBIC_IN;
    public static final /* enum */ FadeUtils.Ease Fast;
    public static final /* enum */ FadeUtils.Ease In;
    public static final /* enum */ FadeUtils.Ease Bounce;

    static {
        Bounce = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("!)\u0004:\u0004'"), 0);
        CUBIC_OUT = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO("eT\u0005l h>t3"), 1);
        CUBIC_IN = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("\u00047!\u000f2\u000b.\f"), 2);
        CUBIC_IN_OUT = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO("t$\"oB\u0018l-h>t3"), 3);
        Fast = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("75\u00146"), 4);
        In = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO("h\t"), 5);
        In2 = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("\u001d\tp"), 6);
        InQuint = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO("\u000eK2B\u0018O\u0013"), 7);
        Normal = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("-)\u00039\u0006."), 8);
        Out = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO(">T\u0013"), 9);
        OutQuint = new FadeUtils.Ease(UserInfo.ALLATORIxDEMO("\b\u0017\u0017\u0017\u0004=\t6"), 10);
        Slow = new FadeUtils.Ease(ProjectionUtils.ALLATORIxDEMO("d\u001dN\u0010"), 11);
        $VALUES = FadeUtils.Ease.$values();
    }

    public static FadeUtils.Ease[] values() {
        return (FadeUtils.Ease[])$VALUES.clone();
    }

    private static /* synthetic */ FadeUtils.Ease[] $values() {
        FadeUtils.Ease[] arrease = new FadeUtils.Ease[12];
        arrease[0] = Bounce;
        arrease[1] = CUBIC_OUT;
        arrease[2] = CUBIC_IN;
        arrease[3] = CUBIC_IN_OUT;
        arrease[4] = Fast;
        arrease[5] = In;
        arrease[6] = In2;
        arrease[7] = InQuint;
        arrease[8] = Normal;
        arrease[9] = Out;
        arrease[10] = OutQuint;
        arrease[11] = Slow;
        return arrease;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ FadeUtils.Ease() {
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

    public static FadeUtils.Ease valueOf(String a) {
        return Enum.valueOf(FadeUtils.Ease.class, a);
    }
}
