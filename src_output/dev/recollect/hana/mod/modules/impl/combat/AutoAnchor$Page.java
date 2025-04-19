/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.AutoAnchor;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import org.bytedeco.javacv.BufferRing;

public static final class AutoAnchor.Page
extends Enum<AutoAnchor.Page> {
    public static final /* enum */ AutoAnchor.Page Rotate;
    private static final /* synthetic */ AutoAnchor.Page[] $VALUES;
    public static final /* enum */ AutoAnchor.Page General;
    public static final /* enum */ AutoAnchor.Page Calc;
    public static final /* enum */ AutoAnchor.Page Render;

    static {
        General = new AutoAnchor.Page(BufferRing.ALLATORIxDEMO("=,\u00131\u0012F"), 0);
        Calc = new AutoAnchor.Page(PacketBuffer.ALLATORIxDEMO("?z\u0012z"), 1);
        Rotate = new AutoAnchor.Page(BufferRing.ALLATORIxDEMO("\u001b\u0012 \u0001jO"), 2);
        Render = new AutoAnchor.Page(PacketBuffer.ALLATORIxDEMO("(x\u0012\u001bk"), 3);
        $VALUES = AutoAnchor.Page.$values();
    }

    private static /* synthetic */ AutoAnchor.Page[] $values() {
        AutoAnchor.Page[] arrpage = new AutoAnchor.Page[4];
        arrpage[0] = General;
        arrpage[1] = Calc;
        arrpage[2] = Rotate;
        arrpage[3] = Render;
        return arrpage;
    }

    public static AutoAnchor.Page[] values() {
        return (AutoAnchor.Page[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoAnchor.Page() {
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

    public static AutoAnchor.Page valueOf(String a) {
        return Enum.valueOf(AutoAnchor.Page.class, a);
    }
}
