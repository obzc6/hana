/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.render.NameTags;

public static final class NameTags.Font
extends Enum<NameTags.Font> {
    public static final /* enum */ NameTags.Font Fancy = new NameTags.Font(TimerManager.ALLATORIxDEMO("\r\u00058Me"), 0);
    public static final /* enum */ NameTags.Font Fast = new NameTags.Font(Vec3.ALLATORIxDEMO("U\u0018z\u0017"), 1);
    private static final /* synthetic */ NameTags.Font[] $VALUES;

    private static /* synthetic */ NameTags.Font[] $values() {
        NameTags.Font[] arrfont = new NameTags.Font[2];
        arrfont[0] = Fancy;
        arrfont[1] = Fast;
        return arrfont;
    }

    static {
        $VALUES = NameTags.Font.$values();
    }

    public static NameTags.Font[] values() {
        return (NameTags.Font[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ NameTags.Font() {
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

    public static NameTags.Font valueOf(String a) {
        return Enum.valueOf(NameTags.Font.class, a);
    }
}
