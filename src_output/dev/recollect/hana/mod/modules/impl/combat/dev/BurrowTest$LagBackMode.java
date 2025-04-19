/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.impl.combat.dev.BurrowTest;

private static final class BurrowTest.LagBackMode
extends Enum<BurrowTest.LagBackMode> {
    public static final /* enum */ BurrowTest.LagBackMode Normal;
    public static final /* enum */ BurrowTest.LagBackMode Invalid;
    public static final /* enum */ BurrowTest.LagBackMode Glide2;
    public static final /* enum */ BurrowTest.LagBackMode Glide;
    public static final /* enum */ BurrowTest.LagBackMode Rotation;
    public static final /* enum */ BurrowTest.LagBackMode Tongyiqianweng;
    public static final /* enum */ BurrowTest.LagBackMode ToVoid;
    public static final /* enum */ BurrowTest.LagBackMode Smart;
    public static final /* enum */ BurrowTest.LagBackMode ToVoid2;
    public static final /* enum */ BurrowTest.LagBackMode Fly;
    public static final /* enum */ BurrowTest.LagBackMode TrollHack;
    public static final /* enum */ BurrowTest.LagBackMode Seija;
    private static final /* synthetic */ BurrowTest.LagBackMode[] $VALUES;
    public static final /* enum */ BurrowTest.LagBackMode XIN;
    public static final /* enum */ BurrowTest.LagBackMode OBS;

    /*
     * Exception decompiling
     */
    private /* synthetic */ BurrowTest.LagBackMode() {
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

    public static BurrowTest.LagBackMode valueOf(String a) {
        return Enum.valueOf(BurrowTest.LagBackMode.class, a);
    }

    public static BurrowTest.LagBackMode[] values() {
        return (BurrowTest.LagBackMode[])$VALUES.clone();
    }

    static {
        Smart = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("\bM1S%"), 0);
        Invalid = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO("\u0019\u0000\u0004\u0004\u0015\r\u001c"), 1);
        TrollHack = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("\u000b{\u0016G7h1B:"), 2);
        ToVoid = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO(":\u001d3\u0016\r\u001c"), 3);
        ToVoid2 = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("-D\rO9Ec"), 4);
        Normal = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO(" \u001d\u0017\u0014\u0005\u0014"), 5);
        Rotation = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("[\u0016_:T9N?"), 6);
        Fly = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO("?\b\u0001"), 7);
        Glide = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("\u001cL9E4"), 8);
        OBS = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO("6&+"), 9);
        XIN = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("\bh\u001f"), 10);
        Seija = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO("!\u0000\u0010\u000e\u0019"), 11);
        Tongyiqianweng = new BurrowTest.LagBackMode(CrystalUtil.ALLATORIxDEMO("q:I0V6x\u0010J5W5O6"), 12);
        Glide2 = new BurrowTest.LagBackMode(MathUtil.ALLATORIxDEMO(")\u001e\f\u001d\u0001J"), 13);
        $VALUES = BurrowTest.LagBackMode.$values();
    }

    private static /* synthetic */ BurrowTest.LagBackMode[] $values() {
        BurrowTest.LagBackMode[] arrlagBackMode = new BurrowTest.LagBackMode[14];
        arrlagBackMode[0] = Smart;
        arrlagBackMode[1] = Invalid;
        arrlagBackMode[2] = TrollHack;
        arrlagBackMode[3] = ToVoid;
        arrlagBackMode[4] = ToVoid2;
        arrlagBackMode[5] = Normal;
        arrlagBackMode[6] = Rotation;
        arrlagBackMode[7] = Fly;
        arrlagBackMode[8] = Glide;
        arrlagBackMode[9] = OBS;
        arrlagBackMode[10] = XIN;
        arrlagBackMode[11] = Seija;
        arrlagBackMode[12] = Tongyiqianweng;
        arrlagBackMode[13] = Glide2;
        return arrlagBackMode;
    }
}
