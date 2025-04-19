/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoWebPuls;
import org.bytedeco.javacv.BufferRing;

public static final class AutoWebPuls.Page
extends Enum<AutoWebPuls.Page> {
    public static final /* enum */ AutoWebPuls.Page WebPredictor;
    private static final /* synthetic */ AutoWebPuls.Page[] $VALUES;
    public static final /* enum */ AutoWebPuls.Page Rotate;
    public static final /* enum */ AutoWebPuls.Page General;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoWebPuls.Page() {
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

    public static AutoWebPuls.Page[] values() {
        return (AutoWebPuls.Page[])$VALUES.clone();
    }

    static {
        General = new AutoWebPuls.Page(MathUtil.ALLATORIxDEMO("\n\u0005\u0012\u0003\b\u0005\u0014"), 0);
        Rotate = new AutoWebPuls.Page(BufferRing.ALLATORIxDEMO("\u001b\u0012 \u0001jO"), 1);
        WebPredictor = new AutoWebPuls.Page(MathUtil.ALLATORIxDEMO("%\u000bGi#(\u0004\u0015\u0005\u000e\u000b\n"), 2);
        $VALUES = AutoWebPuls.Page.$values();
    }

    public static AutoWebPuls.Page valueOf(String a) {
        return Enum.valueOf(AutoWebPuls.Page.class, a);
    }

    private static /* synthetic */ AutoWebPuls.Page[] $values() {
        AutoWebPuls.Page[] arrpage = new AutoWebPuls.Page[3];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        arrpage[2] = WebPredictor;
        return arrpage;
    }
}
