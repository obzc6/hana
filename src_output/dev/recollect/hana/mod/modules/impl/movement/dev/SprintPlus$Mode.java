/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.movement.dev.SprintPlus;

public static final class SprintPlus.Mode
extends Enum<SprintPlus.Mode> {
    private static final /* synthetic */ SprintPlus.Mode[] $VALUES;
    public static final /* enum */ SprintPlus.Mode Normal;
    public static final /* enum */ SprintPlus.Mode Rotation;
    public static final /* enum */ SprintPlus.Mode Rage;
    public static final /* enum */ SprintPlus.Mode Legit;

    static {
        Legit = new SprintPlus.Mode(WebUtils.ALLATORIxDEMO("V+`m9"), 0);
        Normal = new SprintPlus.Mode(ColorUtil.ALLATORIxDEMO("\u0013t2kk "), 1);
        Rage = new SprintPlus.Mode(WebUtils.ALLATORIxDEMO("\u001cfc("), 2);
        Rotation = new SprintPlus.Mode(ColorUtil.ALLATORIxDEMO("\bs)z4oe\""), 3);
        $VALUES = SprintPlus.Mode.$values();
    }

    public static SprintPlus.Mode valueOf(String a) {
        return Enum.valueOf(SprintPlus.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SprintPlus.Mode() {
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

    private static /* synthetic */ SprintPlus.Mode[] $values() {
        SprintPlus.Mode[] arrmode = new SprintPlus.Mode[4];
        arrmode[0] = Legit;
        arrmode[1] = Normal;
        arrmode[2] = Rage;
        arrmode[3] = Rotation;
        return arrmode;
    }

    public static SprintPlus.Mode[] values() {
        return (SprintPlus.Mode[])$VALUES.clone();
    }
}
