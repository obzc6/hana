/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.render.dev.BAHalo;
import dev.recollect.hana.socket.network.client.NpSocketClient;

private static final class BAHalo.Mode
extends Enum<BAHalo.Mode> {
    public static final /* enum */ BAHalo.Mode Hoshino;
    public static final /* enum */ BAHalo.Mode Shiroko;
    public static final /* enum */ BAHalo.Mode Aris;
    public static final /* enum */ BAHalo.Mode Yuuka;
    public static final /* enum */ BAHalo.Mode Natsu;
    private static final /* synthetic */ BAHalo.Mode[] $VALUES;

    public static BAHalo.Mode[] values() {
        return (BAHalo.Mode[])$VALUES.clone();
    }

    static {
        Shiroko = new BAHalo.Mode(TipUtils.ALLATORIxDEMO(":)\u0007.\u001c}V"), 0);
        Hoshino = new BAHalo.Mode(NpSocketClient.ALLATORIxDEMO("-h4d%c\""), 1);
        Aris = new BAHalo.Mode(TipUtils.ALLATORIxDEMO("\u001d\u0001J"), 2);
        Yuuka = new BAHalo.Mode(NpSocketClient.ALLATORIxDEMO("\u001ey9f,"), 3);
        Natsu = new BAHalo.Mode(TipUtils.ALLATORIxDEMO(" =\u0007eL"), 4);
        $VALUES = BAHalo.Mode.$values();
    }

    public static BAHalo.Mode valueOf(String a) {
        return Enum.valueOf(BAHalo.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ BAHalo.Mode() {
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

    private static /* synthetic */ BAHalo.Mode[] $values() {
        BAHalo.Mode[] arrmode = new BAHalo.Mode[5];
        arrmode[0] = Shiroko;
        arrmode[1] = Hoshino;
        arrmode[2] = Aris;
        arrmode[3] = Yuuka;
        arrmode[4] = Natsu;
        return arrmode;
    }
}
