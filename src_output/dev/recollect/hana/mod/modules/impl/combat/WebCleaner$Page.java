/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.mod.modules.impl.combat.WebCleaner;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;

public static final class WebCleaner.Page
extends Enum<WebCleaner.Page> {
    public static final /* enum */ WebCleaner.Page Rotate;
    private static final /* synthetic */ WebCleaner.Page[] $VALUES;
    public static final /* enum */ WebCleaner.Page General;

    static {
        General = new WebCleaner.Page(GaussianKernel.ALLATORIxDEMO("89 ?:9&"), 0);
        Rotate = new WebCleaner.Page(CameraState.ALLATORIxDEMO("\u000f^/V-P"), 1);
        $VALUES = WebCleaner.Page.$values();
    }

    public static WebCleaner.Page[] values() {
        return (WebCleaner.Page[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ WebCleaner.Page() {
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

    public static WebCleaner.Page valueOf(String a) {
        return Enum.valueOf(WebCleaner.Page.class, a);
    }

    private static /* synthetic */ WebCleaner.Page[] $values() {
        WebCleaner.Page[] arrpage = new WebCleaner.Page[2];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        return arrpage;
    }
}
