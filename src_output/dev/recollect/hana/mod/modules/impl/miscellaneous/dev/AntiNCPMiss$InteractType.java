/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AntiNCPMiss;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

public static final class AntiNCPMiss.InteractType
extends Enum<AntiNCPMiss.InteractType> {
    public static final /* enum */ AntiNCPMiss.InteractType INTERACT_AT;
    public static final /* enum */ AntiNCPMiss.InteractType INTERACT;
    private static final /* synthetic */ AntiNCPMiss.InteractType[] $VALUES;
    public static final /* enum */ AntiNCPMiss.InteractType ATTACK;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AntiNCPMiss.InteractType() {
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
        INTERACT = new AntiNCPMiss.InteractType(FPSManager.ALLATORIxDEMO("^?D3_*\u0004u"), 0);
        ATTACK = new AntiNCPMiss.InteractType(RenderHelper.ALLATORIxDEMO("+A#I~\t"), 1);
        INTERACT_AT = new AntiNCPMiss.InteractType(FPSManager.ALLATORIxDEMO(":^\"R#Q5Y4\u0006u"), 2);
        $VALUES = AntiNCPMiss.InteractType.$values();
    }

    private static /* synthetic */ AntiNCPMiss.InteractType[] $values() {
        AntiNCPMiss.InteractType[] arrinteractType = new AntiNCPMiss.InteractType[3];
        arrinteractType[0] = INTERACT;
        arrinteractType[1] = ATTACK;
        arrinteractType[2] = INTERACT_AT;
        return arrinteractType;
    }

    public static AntiNCPMiss.InteractType[] values() {
        return (AntiNCPMiss.InteractType[])$VALUES.clone();
    }

    public static AntiNCPMiss.InteractType valueOf(String a) {
        return Enum.valueOf(AntiNCPMiss.InteractType.class, a);
    }
}
