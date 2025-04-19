/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.socket.network.info.ClientInfo;
import dev.recollect.hana.socket.network.info.record.UserInfo;

public static final class BedAura.Page
extends Enum<BedAura.Page> {
    public static final /* enum */ BedAura.Page Render;
    public static final /* enum */ BedAura.Page Calc;
    public static final /* enum */ BedAura.Page Rotate;
    public static final /* enum */ BedAura.Page General;
    public static final /* enum */ BedAura.Page Predict;
    private static final /* synthetic */ BedAura.Page[] $VALUES;

    public static BedAura.Page valueOf(String a) {
        return Enum.valueOf(BedAura.Page.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ BedAura.Page() {
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

    private static /* synthetic */ BedAura.Page[] $values() {
        BedAura.Page[] arrpage = new BedAura.Page[5];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        arrpage[2] = Calc;
        arrpage[3] = Predict;
        arrpage[4] = Render;
        return arrpage;
    }

    static {
        General = new BedAura.Page(UserInfo.ALLATORIxDEMO("0\u0006(\u00002\u0006."), 0);
        Rotate = new BedAura.Page(ClientInfo.ALLATORIxDEMO("Q!j2 |"), 1);
        Calc = new BedAura.Page(UserInfo.ALLATORIxDEMO("&!\u000b!"), 2);
        Predict = new BedAura.Page(ClientInfo.ALLATORIxDEMO("\u0019q+z:7m"), 3);
        Render = new BedAura.Page(UserInfo.ALLATORIxDEMO("1#\u000b$\u00020"), 4);
        $VALUES = BedAura.Page.$values();
    }

    public static BedAura.Page[] values() {
        return (BedAura.Page[])$VALUES.clone();
    }
}
