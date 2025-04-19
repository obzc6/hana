/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.combat.SelfFill;
import dev.recollect.hana.socket.network.packet.Packet;

public static final class SelfFill.Page
extends Enum<SelfFill.Page> {
    public static final /* enum */ SelfFill.Page RotateBypass;
    public static final /* enum */ SelfFill.Page Move;
    public static final /* enum */ SelfFill.Page FakeJump;
    public static final /* enum */ SelfFill.Page Packet;
    public static final /* enum */ SelfFill.Page Place;
    private static final /* synthetic */ SelfFill.Page[] $VALUES;
    public static final /* enum */ SelfFill.Page Misc;

    public static SelfFill.Page[] values() {
        return (SelfFill.Page[])$VALUES.clone();
    }

    public static SelfFill.Page valueOf(String a) {
        return Enum.valueOf(SelfFill.Page.class, a);
    }

    private static /* synthetic */ SelfFill.Page[] $values() {
        SelfFill.Page[] arrpage = new SelfFill.Page[6];
        arrpage[0] = Packet;
        arrpage[1] = Place;
        arrpage[2] = Misc;
        arrpage[3] = RotateBypass;
        arrpage[4] = Move;
        arrpage[5] = FakeJump;
        return arrpage;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SelfFill.Page() {
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
        Packet = new SelfFill.Page(TipUtils.ALLATORIxDEMO("\u0011\u000f?\u0018sM"), 0);
        Place = new SelfFill.Page(Packet.ALLATORIxDEMO("lq[|]"), 1);
        Misc = new SelfFill.Page(TipUtils.ALLATORIxDEMO("\u0011\u001aeZ"), 2);
        RotateBypass = new SelfFill.Page(Packet.ALLATORIxDEMO("D^*\u0018^hYEm[lK"), 3);
        Move = new SelfFill.Page(TipUtils.ALLATORIxDEMO("\u0011\u001c`\\"), 4);
        FakeJump = new SelfFill.Page(Packet.ALLATORIxDEMO("llpYWOrH"), 5);
        $VALUES = SelfFill.Page.$values();
    }
}
