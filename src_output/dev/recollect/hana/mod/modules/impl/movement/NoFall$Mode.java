/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.mod.modules.impl.movement.NoFall;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import org.bytedeco.javacv.BufferRing;

public static final class NoFall.Mode
extends Enum<NoFall.Mode> {
    public static final /* enum */ NoFall.Mode Hypixel;
    private static final /* synthetic */ NoFall.Mode[] $VALUES;
    public static final /* enum */ NoFall.Mode SpoofGround;
    public static final /* enum */ NoFall.Mode AACV364;

    private static /* synthetic */ NoFall.Mode[] $values() {
        NoFall.Mode[] arrmode = new NoFall.Mode[3];
        arrmode[0] = SpoofGround;
        arrmode[1] = Hypixel;
        arrmode[2] = AACV364;
        return arrmode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ NoFall.Mode() {
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

    public static NoFall.Mode[] values() {
        return (NoFall.Mode[])$VALUES.clone();
    }

    static {
        SpoofGround = new NoFall.Mode(BufferRing.ALLATORIxDEMO("+9\u0012!\u001c\u000e\u000f;\u0015pN"), 0);
        Hypixel = new NoFall.Mode(ProjectionUtils.ALLATORIxDEMO("\u0007R\u001dI\u001eD\u000b"), 1);
        AACV364 = new NoFall.Mode(BufferRing.ALLATORIxDEMO(";\b>\u0002S(\u001e"), 2);
        $VALUES = NoFall.Mode.$values();
    }

    public static NoFall.Mode valueOf(String a) {
        return Enum.valueOf(NoFall.Mode.class, a);
    }
}
