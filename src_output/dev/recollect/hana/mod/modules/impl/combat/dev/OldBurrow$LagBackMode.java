/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.mod.modules.impl.combat.dev.OldBurrow;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import org.bytedeco.javacv.BaseChildSettings;

private static final class OldBurrow.LagBackMode
extends Enum<OldBurrow.LagBackMode> {
    public static final /* enum */ OldBurrow.LagBackMode OBSTest;
    public static final /* enum */ OldBurrow.LagBackMode TrollHack;
    public static final /* enum */ OldBurrow.LagBackMode Normal;
    private static final /* synthetic */ OldBurrow.LagBackMode[] $VALUES;
    public static final /* enum */ OldBurrow.LagBackMode Rotation;
    public static final /* enum */ OldBurrow.LagBackMode Test;
    public static final /* enum */ OldBurrow.LagBackMode Old;
    public static final /* enum */ OldBurrow.LagBackMode Glide;
    public static final /* enum */ OldBurrow.LagBackMode Void;
    public static final /* enum */ OldBurrow.LagBackMode Strict;

    public static OldBurrow.LagBackMode valueOf(String a) {
        return Enum.valueOf(OldBurrow.LagBackMode.class, a);
    }

    private static /* synthetic */ OldBurrow.LagBackMode[] $values() {
        OldBurrow.LagBackMode[] arrlagBackMode = new OldBurrow.LagBackMode[9];
        arrlagBackMode[0] = Normal;
        arrlagBackMode[1] = Strict;
        arrlagBackMode[2] = Void;
        arrlagBackMode[3] = OBSTest;
        arrlagBackMode[4] = Old;
        arrlagBackMode[5] = Glide;
        arrlagBackMode[6] = Test;
        arrlagBackMode[7] = TrollHack;
        arrlagBackMode[8] = Rotation;
        return arrlagBackMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ OldBurrow.LagBackMode() {
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
        Normal = new OldBurrow.LagBackMode(BaseChildSettings.ALLATORIxDEMO("i<H#\u0011h"), 0);
        Strict = new OldBurrow.LagBackMode(GameInfo.ALLATORIxDEMO("A~kh{t"), 1);
        Void = new OldBurrow.LagBackMode(BaseChildSettings.ALLATORIxDEMO("l!\u0019`"), 2);
        OBSTest = new OldBurrow.LagBackMode(GameInfo.ALLATORIxDEMO("gPYMdkt"), 3);
        Old = new OldBurrow.LagBackMode(BaseChildSettings.ALLATORIxDEMO("\u0001\u001c`"), 4);
        Glide = new OldBurrow.LagBackMode(GameInfo.ALLATORIxDEMO("Muh|e"), 5);
        Test = new OldBurrow.LagBackMode(BaseChildSettings.ALLATORIxDEMO("n+\u0003p"), 6);
        TrollHack = new OldBurrow.LagBackMode(GameInfo.ALLATORIxDEMO("ZBG~fQ`{k"), 7);
        Rotation = new OldBurrow.LagBackMode(BaseChildSettings.ALLATORIxDEMO("r;S2N'\u001fj"), 8);
        $VALUES = OldBurrow.LagBackMode.$values();
    }

    public static OldBurrow.LagBackMode[] values() {
        return (OldBurrow.LagBackMode[])$VALUES.clone();
    }
}
