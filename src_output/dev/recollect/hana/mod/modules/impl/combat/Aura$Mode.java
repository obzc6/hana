/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.combat.Aura;

public static final class Aura.Mode
extends Enum<Aura.Mode> {
    public static final /* enum */ Aura.Mode Star = new Aura.Mode(MathUtil.ALLATORIxDEMO("6\r\u0005\n"), 0);
    private static final /* synthetic */ Aura.Mode[] $VALUES;
    public static final /* enum */ Aura.Mode Circle2D = new Aura.Mode(ColorUtil.ALLATORIxDEMO("\u0019u/x,c8\b"), 1);
    public static final /* enum */ Aura.Mode Circle = new Aura.Mode(MathUtil.ALLATORIxDEMO("-\u001b\u0017\u001a\b\u001d"), 2);

    public static Aura.Mode valueOf(String a) {
        return Enum.valueOf(Aura.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Aura.Mode() {
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

    private static /* synthetic */ Aura.Mode[] $values() {
        Aura.Mode[] arrmode = new Aura.Mode[3];
        arrmode[0] = Star;
        arrmode[1] = Circle2D;
        arrmode[2] = Circle;
        return arrmode;
    }

    static {
        $VALUES = Aura.Mode.$values();
    }

    public static Aura.Mode[] values() {
        return (Aura.Mode[])$VALUES.clone();
    }
}
