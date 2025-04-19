/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.SelfFill;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import dev.recollect.hana.xibao.SnowAnimation;

private static final class SelfFill.FakeJumpMode
extends Enum<SelfFill.FakeJumpMode> {
    public static final /* enum */ SelfFill.FakeJumpMode M7;
    public static final /* enum */ SelfFill.FakeJumpMode Normal;
    private static final /* synthetic */ SelfFill.FakeJumpMode[] $VALUES;
    public static final /* enum */ SelfFill.FakeJumpMode NullPoint;

    public static SelfFill.FakeJumpMode[] values() {
        return (SelfFill.FakeJumpMode[])$VALUES.clone();
    }

    public static SelfFill.FakeJumpMode valueOf(String a) {
        return Enum.valueOf(SelfFill.FakeJumpMode.class, a);
    }

    private static /* synthetic */ SelfFill.FakeJumpMode[] $values() {
        SelfFill.FakeJumpMode[] arrfakeJumpMode = new SelfFill.FakeJumpMode[3];
        arrfakeJumpMode[0] = NullPoint;
        arrfakeJumpMode[1] = M7;
        arrfakeJumpMode[2] = Normal;
        return arrfakeJumpMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SelfFill.FakeJumpMode() {
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
        NullPoint = new SelfFill.FakeJumpMode(UserInfo.ALLATORIxDEMO("\u0019:\u0006\u0001\u0018\t*\t6"), 0);
        M7 = new SelfFill.FakeJumpMode(SnowAnimation.ALLATORIxDEMO("tP"), 1);
        Normal = new SelfFill.FakeJumpMode(UserInfo.ALLATORIxDEMO("#'\u0014.\u0006."), 2);
        $VALUES = SelfFill.FakeJumpMode.$values();
    }
}
