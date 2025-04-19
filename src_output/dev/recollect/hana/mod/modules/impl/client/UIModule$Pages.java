/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import org.bytedeco.javacv.BaseSettings;

private static final class UIModule.Pages
extends Enum<UIModule.Pages> {
    private static final /* synthetic */ UIModule.Pages[] $VALUES;
    public static final /* enum */ UIModule.Pages General = new UIModule.Pages(BaseSettings.ALLATORIxDEMO("J[eY{Ks"), 0);
    public static final /* enum */ UIModule.Pages Color = new UIModule.Pages(GaussianFilter.ALLATORIxDEMO("`=Rw\u0006"), 1);

    public static UIModule.Pages valueOf(String a) {
        return Enum.valueOf(UIModule.Pages.class, a);
    }

    static {
        $VALUES = UIModule.Pages.$values();
    }

    public static UIModule.Pages[] values() {
        return (UIModule.Pages[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ UIModule.Pages() {
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

    private static /* synthetic */ UIModule.Pages[] $values() {
        UIModule.Pages[] arrpages = new UIModule.Pages[2];
        arrpages[0] = General;
        arrpages[1] = Color;
        return arrpages;
    }
}
