/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.modules.impl.combat.AutoAnchor;

public static final class AutoAnchor.CalcMode
extends Enum<AutoAnchor.CalcMode> {
    private static final /* synthetic */ AutoAnchor.CalcMode[] $VALUES;
    public static final /* enum */ AutoAnchor.CalcMode Meteor;
    public static final /* enum */ AutoAnchor.CalcMode Oyvey;
    public static final /* enum */ AutoAnchor.CalcMode Thunder;
    public static final /* enum */ AutoAnchor.CalcMode Edit;

    private static /* synthetic */ AutoAnchor.CalcMode[] $values() {
        AutoAnchor.CalcMode[] arrcalcMode = new AutoAnchor.CalcMode[4];
        arrcalcMode[0] = Oyvey;
        arrcalcMode[1] = Meteor;
        arrcalcMode[2] = Thunder;
        arrcalcMode[3] = Edit;
        return arrcalcMode;
    }

    public static AutoAnchor.CalcMode valueOf(String a) {
        return Enum.valueOf(AutoAnchor.CalcMode.class, a);
    }

    public static AutoAnchor.CalcMode[] values() {
        return (AutoAnchor.CalcMode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoAnchor.CalcMode() {
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
        Oyvey = new AutoAnchor.CalcMode(OLEPOSSUtils.ALLATORIxDEMO("e1Ag\u0004"), 0);
        Meteor = new AutoAnchor.CalcMode(Alt.ALLATORIxDEMO("U'g,}:"), 1);
        Thunder = new AutoAnchor.CalcMode(OLEPOSSUtils.ALLATORIxDEMO("y=_&Sg\u000f"), 2);
        Edit = new AutoAnchor.CalcMode(Alt.ALLATORIxDEMO("V-{<"), 3);
        $VALUES = AutoAnchor.CalcMode.$values();
    }
}
