/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.movement.dev.GrimSpeed;
import dev.recollect.hana.mod.modules.settings.Setting;
import org.bytedeco.javacv.FrameFilter;

public static final class GrimSpeed.Mode
extends Enum<GrimSpeed.Mode> {
    public static final /* enum */ GrimSpeed.Mode GrimCollide;
    public static final /* enum */ GrimSpeed.Mode StrafeStrict;
    public static final /* enum */ GrimSpeed.Mode Custom;
    private static final /* synthetic */ GrimSpeed.Mode[] $VALUES;

    static {
        Custom = new GrimSpeed.Mode(Setting.ALLATORIxDEMO("X-u1#b"), 0);
        GrimCollide = new GrimSpeed.Mode(FrameFilter.ALLATORIxDEMO("Pt>\u0002}\"p*~#s"), 1);
        StrafeStrict = new GrimSpeed.Mode(Setting.ALLATORIxDEMO("M)i9z:H,t,/{"), 2);
        $VALUES = GrimSpeed.Mode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ GrimSpeed.Mode() {
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

    public static GrimSpeed.Mode[] values() {
        return (GrimSpeed.Mode[])$VALUES.clone();
    }

    private static /* synthetic */ GrimSpeed.Mode[] $values() {
        GrimSpeed.Mode[] arrmode = new GrimSpeed.Mode[3];
        arrmode[0] = Custom;
        arrmode[1] = GrimCollide;
        arrmode[2] = StrafeStrict;
        return arrmode;
    }

    public static GrimSpeed.Mode valueOf(String a) {
        return Enum.valueOf(GrimSpeed.Mode.class, a);
    }
}
