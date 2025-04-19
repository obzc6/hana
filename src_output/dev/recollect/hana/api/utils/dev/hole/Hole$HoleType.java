/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.dev.hole;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.xibao.SnowAnimation;

public static final class Hole.HoleType
extends Enum<Hole.HoleType> {
    public static final /* enum */ Hole.HoleType DoubleX;
    public static final /* enum */ Hole.HoleType DoubleZ;
    private static final /* synthetic */ Hole.HoleType[] $VALUES;
    public static final /* enum */ Hole.HoleType NotHole;
    public static final /* enum */ Hole.HoleType Single;
    public static final /* enum */ Hole.HoleType Quad;

    public static Hole.HoleType[] values() {
        return (Hole.HoleType[])$VALUES.clone();
    }

    public static Hole.HoleType valueOf(String a) {
        return Enum.valueOf(Hole.HoleType.class, a);
    }

    private static /* synthetic */ Hole.HoleType[] $values() {
        Hole.HoleType[] arrholeType = new Hole.HoleType[5];
        arrholeType[0] = NotHole;
        arrholeType[1] = Single;
        arrholeType[2] = DoubleX;
        arrholeType[3] = DoubleZ;
        arrholeType[4] = Quad;
        return arrholeType;
    }

    static {
        NotHole = new Hole.HoleType(SnowAnimation.ALLATORIxDEMO("\u0018J\u000fd\u001dU\u0002"), 0);
        Single = new Hole.HoleType(ProjectionUtils.ALLATORIxDEMO("n\u0012Z\u0015M\u0002"), 1);
        DoubleX = new Hole.HoleType(SnowAnimation.ALLATORIxDEMO("\u0012J\u000eN\u001e\\?"), 2);
        DoubleZ = new Hole.HoleType(ProjectionUtils.ALLATORIxDEMO("\u0012R\u000eV\u001eD="), 3);
        Quad = new Hole.HoleType(SnowAnimation.ALLATORIxDEMO("}\u0007X\u0003"), 4);
        $VALUES = Hole.HoleType.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Hole.HoleType() {
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
}
