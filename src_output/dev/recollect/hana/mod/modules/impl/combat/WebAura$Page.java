/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.impl.combat.WebAura;
import org.bytedeco.javacv.BaseSettings;

public static final class WebAura.Page
extends Enum<WebAura.Page> {
    public static final /* enum */ WebAura.Page Rotate;
    public static final /* enum */ WebAura.Page General;
    private static final /* synthetic */ WebAura.Page[] $VALUES;

    static {
        General = new WebAura.Page(CrystalUtil.ALLATORIxDEMO("#@;F!@="), 0);
        Rotate = new WebAura.Page(BaseSettings.ALLATORIxDEMO("jbJjHl"), 1);
        $VALUES = WebAura.Page.$values();
    }

    private static /* synthetic */ WebAura.Page[] $values() {
        WebAura.Page[] arrpage = new WebAura.Page[2];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        return arrpage;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ WebAura.Page() {
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

    public static WebAura.Page valueOf(String a) {
        return Enum.valueOf(WebAura.Page.class, a);
    }

    public static WebAura.Page[] values() {
        return (WebAura.Page[])$VALUES.clone();
    }
}
