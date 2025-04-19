/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.render.TwoDESP;
import org.bytedeco.javacv.FrameConverter;

public static final class TwoDESP.Page
extends Enum<TwoDESP.Page> {
    public static final /* enum */ TwoDESP.Page Setting = new TwoDESP.Page(ObsidianHelper.ALLATORIxDEMO("$H2_)G%"), 0);
    public static final /* enum */ TwoDESP.Page Color;
    private static final /* synthetic */ TwoDESP.Page[] $VALUES;
    public static final /* enum */ TwoDESP.Page Target;

    public static TwoDESP.Page valueOf(String a) {
        return Enum.valueOf(TwoDESP.Page.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ TwoDESP.Page() {
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

    private static /* synthetic */ TwoDESP.Page[] $values() {
        TwoDESP.Page[] arrpage = new TwoDESP.Page[3];
        arrpage[0] = Setting;
        arrpage[1] = Target;
        arrpage[2] = Color;
        return arrpage;
    }

    public static TwoDESP.Page[] values() {
        return (TwoDESP.Page[])$VALUES.clone();
    }

    static {
        Target = new TwoDESP.Page(FrameConverter.ALLATORIxDEMO("&p\u001dk@2"), 1);
        Color = new TwoDESP.Page(ObsidianHelper.ALLATORIxDEMO("\u0005D,F0"), 2);
        $VALUES = TwoDESP.Page.$values();
    }
}
