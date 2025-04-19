/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.video.FileUtil;

public static final class BedAura.Mode
extends Enum<BedAura.Mode> {
    private static final /* synthetic */ BedAura.Mode[] $VALUES;
    public static final /* enum */ BedAura.Mode Scanner;
    public static final /* enum */ BedAura.Mode NullPoint;

    public static BedAura.Mode valueOf(String a) {
        return Enum.valueOf(BedAura.Mode.class, a);
    }

    private static /* synthetic */ BedAura.Mode[] $values() {
        BedAura.Mode[] arrmode = new BedAura.Mode[2];
        arrmode[0] = NullPoint;
        arrmode[1] = Scanner;
        return arrmode;
    }

    public static BedAura.Mode[] values() {
        return (BedAura.Mode[])$VALUES.clone();
    }

    static {
        NullPoint = new BedAura.Mode(SocketClient.ALLATORIxDEMO("\u0001vJMTEfEz"), 0);
        Scanner = new BedAura.Mode(FileUtil.ALLATORIxDEMO("\u0004y\u0014\u0010u\r"), 1);
        $VALUES = BedAura.Mode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ BedAura.Mode() {
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
