/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.modules.impl.render.dev.CircleModule;
import dev.recollect.hana.video.FileUtil;

public static final class CircleModule.Mode
extends Enum<CircleModule.Mode> {
    private static final /* synthetic */ CircleModule.Mode[] $VALUES;
    public static final /* enum */ CircleModule.Mode Circle;
    public static final /* enum */ CircleModule.Mode Star;
    public static final /* enum */ CircleModule.Mode Circle2D;

    public static CircleModule.Mode[] values() {
        return (CircleModule.Mode[])$VALUES.clone();
    }

    public static CircleModule.Mode valueOf(String a) {
        return Enum.valueOf(CircleModule.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ CircleModule.Mode() {
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

    private static /* synthetic */ CircleModule.Mode[] $values() {
        CircleModule.Mode[] arrmode = new CircleModule.Mode[3];
        arrmode[0] = Star;
        arrmode[1] = Circle2D;
        arrmode[2] = Circle;
        return arrmode;
    }

    static {
        Star = new CircleModule.Mode(TimerManager.ALLATORIxDEMO("7\"On"), 0);
        Circle2D = new CircleModule.Mode(FileUtil.ALLATORIxDEMO("{>h\u0016}\u001b\";"), 1);
        Circle = new CircleModule.Mode(TimerManager.ALLATORIxDEMO(":\"\u00165By"), 2);
        $VALUES = CircleModule.Mode.$values();
    }
}
