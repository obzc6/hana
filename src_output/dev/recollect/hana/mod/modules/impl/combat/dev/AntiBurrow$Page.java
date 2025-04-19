/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiBurrow;
import org.bytedeco.javacv.FrameConverter;

public static final class AntiBurrow.Page
extends Enum<AntiBurrow.Page> {
    private static final /* synthetic */ AntiBurrow.Page[] $VALUES;
    public static final /* enum */ AntiBurrow.Page Rotate;
    public static final /* enum */ AntiBurrow.Page General;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AntiBurrow.Page() {
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

    static {
        General = new AntiBurrow.Page(FrameConverter.ALLATORIxDEMO("Q\u0017\n~D*"), 0);
        Rotate = new AntiBurrow.Page(NCPRaytracer.ALLATORIxDEMO("XJxBzD"), 1);
        $VALUES = AntiBurrow.Page.$values();
    }

    public static AntiBurrow.Page[] values() {
        return (AntiBurrow.Page[])$VALUES.clone();
    }

    private static /* synthetic */ AntiBurrow.Page[] $values() {
        AntiBurrow.Page[] arrpage = new AntiBurrow.Page[2];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        return arrpage;
    }

    public static AntiBurrow.Page valueOf(String a) {
        return Enum.valueOf(AntiBurrow.Page.class, a);
    }
}
