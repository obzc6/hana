/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.impl.combat.HoleFiller;
import dev.recollect.hana.socket.network.client.SocketClient;

public static final class HoleFiller.Page
extends Enum<HoleFiller.Page> {
    private static final /* synthetic */ HoleFiller.Page[] $VALUES;
    public static final /* enum */ HoleFiller.Page General = new HoleFiller.Page(RadiusUtils.ALLATORIxDEMO(" Q\u000eL\u000f\u0002["), 0);
    public static final /* enum */ HoleFiller.Page Rotate = new HoleFiller.Page(SocketClient.ALLATORIxDEMO("}e]m_k"), 1);

    /*
     * Exception decompiling
     */
    private /* synthetic */ HoleFiller.Page() {
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
        $VALUES = HoleFiller.Page.$values();
    }

    private static /* synthetic */ HoleFiller.Page[] $values() {
        HoleFiller.Page[] arrpage = new HoleFiller.Page[2];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        return arrpage;
    }

    public static HoleFiller.Page valueOf(String a) {
        return Enum.valueOf(HoleFiller.Page.class, a);
    }

    public static HoleFiller.Page[] values() {
        return (HoleFiller.Page[])$VALUES.clone();
    }
}
