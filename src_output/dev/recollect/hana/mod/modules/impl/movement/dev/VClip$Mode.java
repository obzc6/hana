/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.movement.dev.VClip;

public static final class VClip.Mode
extends Enum<VClip.Mode> {
    public static final /* enum */ VClip.Mode Teleport;
    public static final /* enum */ VClip.Mode Jump;
    public static final /* enum */ VClip.Mode Glitch;
    private static final /* synthetic */ VClip.Mode[] $VALUES;

    public static VClip.Mode[] values() {
        return (VClip.Mode[])$VALUES.clone();
    }

    static {
        Glitch = new VClip.Mode(Timer.ALLATORIxDEMO("~XM]\r\u000b"), 0);
        Teleport = new VClip.Mode(CrystalUtil.ALLATORIxDEMO("]\u001cG>P?S%"), 1);
        Jump = new VClip.Mode(Timer.ALLATORIxDEMO("n\\\u0003\u0013"), 2);
        $VALUES = VClip.Mode.$values();
    }

    public static VClip.Mode valueOf(String a) {
        return Enum.valueOf(VClip.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ VClip.Mode() {
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

    private static /* synthetic */ VClip.Mode[] $values() {
        VClip.Mode[] arrmode = new VClip.Mode[3];
        arrmode[0] = Glitch;
        arrmode[1] = Teleport;
        arrmode[2] = Jump;
        return arrmode;
    }
}
