/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.Blocker;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import org.bytedeco.javacv.BufferRing;

public static final class Blocker.Page
extends Enum<Blocker.Page> {
    public static final /* enum */ Blocker.Page Target;
    public static final /* enum */ Blocker.Page Check;
    public static final /* enum */ Blocker.Page Render;
    public static final /* enum */ Blocker.Page General;
    private static final /* synthetic */ Blocker.Page[] $VALUES;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Blocker.Page() {
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

    public static Blocker.Page valueOf(String a) {
        return Enum.valueOf(Blocker.Page.class, a);
    }

    static {
        General = new Blocker.Page(BufferRing.ALLATORIxDEMO("=,\u00131\u0012F"), 0);
        Target = new Blocker.Page(RenderHelper.ALLATORIxDEMO(">t\u0005oX6"), 1);
        Check = new Blocker.Page(BufferRing.ALLATORIxDEMO("><\u0005}A"), 2);
        Render = new Blocker.Page(RenderHelper.ALLATORIxDEMO("8p\u0019lX0"), 3);
        $VALUES = Blocker.Page.$values();
    }

    public static Blocker.Page[] values() {
        return (Blocker.Page[])$VALUES.clone();
    }

    private static /* synthetic */ Blocker.Page[] $values() {
        Blocker.Page[] arrpage = new Blocker.Page[4];
        arrpage[0] = General;
        arrpage[1] = Target;
        arrpage[2] = Check;
        arrpage[3] = Render;
        return arrpage;
    }
}
