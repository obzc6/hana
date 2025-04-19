/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.combat.Criticals;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;

public static final class Criticals.InteractType
extends Enum<Criticals.InteractType> {
    private static final /* synthetic */ Criticals.InteractType[] $VALUES;
    public static final /* enum */ Criticals.InteractType INTERACT_AT;
    public static final /* enum */ Criticals.InteractType ATTACK;
    public static final /* enum */ Criticals.InteractType INTERACT;

    public static Criticals.InteractType valueOf(String a) {
        return Enum.valueOf(Criticals.InteractType.class, a);
    }

    static {
        INTERACT = new Criticals.InteractType(TipUtils.ALLATORIxDEMO("\u000f'\u0015+\u000e2Um"), 0);
        ATTACK = new Criticals.InteractType(ObsidianHelper.ALLATORIxDEMO("t\nh\u0016j\t"), 1);
        INTERACT_AT = new Criticals.InteractType(TipUtils.ALLATORIxDEMO("\"\u000f:\u0003;\u0000-\b,Wm"), 2);
        $VALUES = Criticals.InteractType.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Criticals.InteractType() {
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

    public static Criticals.InteractType[] values() {
        return (Criticals.InteractType[])$VALUES.clone();
    }

    private static /* synthetic */ Criticals.InteractType[] $values() {
        Criticals.InteractType[] arrinteractType = new Criticals.InteractType[3];
        arrinteractType[0] = INTERACT;
        arrinteractType[1] = ATTACK;
        arrinteractType[2] = INTERACT_AT;
        return arrinteractType;
    }
}
