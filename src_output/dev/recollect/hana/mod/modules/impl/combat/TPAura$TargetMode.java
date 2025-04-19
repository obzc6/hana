/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.TPAura;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.GameInfo;

private static final class TPAura.TargetMode
extends Enum<TPAura.TargetMode> {
    private static final /* synthetic */ TPAura.TargetMode[] $VALUES;
    public static final /* enum */ TPAura.TargetMode HEALTH;
    public static final /* enum */ TPAura.TargetMode DISTANCE;

    public static TPAura.TargetMode valueOf(String a) {
        return Enum.valueOf(TPAura.TargetMode.class, a);
    }

    static {
        DISTANCE = new TPAura.TargetMode(GameInfo.ALLATORIxDEMO("taA^XO[E"), 0);
        HEALTH = new TPAura.TargetMode(SocketClient.ALLATORIxDEMO("iAkCF"), 1);
        $VALUES = TPAura.TargetMode.$values();
    }

    private static /* synthetic */ TPAura.TargetMode[] $values() {
        TPAura.TargetMode[] arrtargetMode = new TPAura.TargetMode[2];
        arrtargetMode[0] = DISTANCE;
        arrtargetMode[1] = HEALTH;
        return arrtargetMode;
    }

    public static TPAura.TargetMode[] values() {
        return (TPAura.TargetMode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ TPAura.TargetMode() {
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
