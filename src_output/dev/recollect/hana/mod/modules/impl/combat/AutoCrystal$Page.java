/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import org.bytedeco.javacv.BaseChildSettings;

public static final class AutoCrystal.Page
extends Enum<AutoCrystal.Page> {
    public static final /* enum */ AutoCrystal.Page Interact;
    private static final /* synthetic */ AutoCrystal.Page[] $VALUES;
    public static final /* enum */ AutoCrystal.Page Render;
    public static final /* enum */ AutoCrystal.Page Misc;
    public static final /* enum */ AutoCrystal.Page Rotate;
    public static final /* enum */ AutoCrystal.Page Calc;
    public static final /* enum */ AutoCrystal.Page General;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoCrystal.Page() {
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

    private static /* synthetic */ AutoCrystal.Page[] $values() {
        AutoCrystal.Page[] arrpage = new AutoCrystal.Page[6];
        arrpage[0] = General;
        arrpage[1] = Interact;
        arrpage[2] = Misc;
        arrpage[3] = Rotate;
        arrpage[4] = Calc;
        arrpage[5] = Render;
        return arrpage;
    }

    static {
        General = new AutoCrystal.Page(BaseChildSettings.ALLATORIxDEMO("\u0013B=_<\u0011h"), 0);
        Interact = new AutoCrystal.Page(RenderHelper.ALLATORIxDEMO("$|\u001ep\u0005i^6"), 1);
        Misc = new AutoCrystal.Page(BaseChildSettings.ALLATORIxDEMO("w'\u0003g"), 2);
        Rotate = new AutoCrystal.Page(RenderHelper.ALLATORIxDEMO("8z\u0003iI'"), 3);
        Calc = new AutoCrystal.Page(BaseChildSettings.ALLATORIxDEMO("y/\u001cg"), 4);
        Render = new AutoCrystal.Page(RenderHelper.ALLATORIxDEMO("8p\u0019lX0"), 5);
        $VALUES = AutoCrystal.Page.$values();
    }

    public static AutoCrystal.Page[] values() {
        return (AutoCrystal.Page[])$VALUES.clone();
    }

    public static AutoCrystal.Page valueOf(String a) {
        return Enum.valueOf(AutoCrystal.Page.class, a);
    }
}
