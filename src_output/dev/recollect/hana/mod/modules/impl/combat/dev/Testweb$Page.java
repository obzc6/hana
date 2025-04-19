/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.dev.Testweb;
import org.bytedeco.javacv.BaseSettings;

public static final class Testweb.Page
extends Enum<Testweb.Page> {
    private static final /* synthetic */ Testweb.Page[] $VALUES;
    public static final /* enum */ Testweb.Page Rotate;
    public static final /* enum */ Testweb.Page General;
    public static final /* enum */ Testweb.Page WebPredictor;

    public static Testweb.Page[] values() {
        return (Testweb.Page[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Testweb.Page() {
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

    private static /* synthetic */ Testweb.Page[] $values() {
        Testweb.Page[] arrpage = new Testweb.Page[3];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        arrpage[2] = WebPredictor;
        return arrpage;
    }

    public static Testweb.Page valueOf(String a) {
        return Enum.valueOf(Testweb.Page.class, a);
    }

    static {
        General = new Testweb.Page(Timer.ALLATORIxDEMO("t\\ZA[\u000f\u000f"), 0);
        Rotate = new Testweb.Page(BaseSettings.ALLATORIxDEMO("jbJjHl"), 1);
        WebPredictor = new Testweb.Page(Timer.ALLATORIxDEMO("kT[dLV]]G]\u0001\u0011"), 2);
        $VALUES = Testweb.Page.$values();
    }
}
