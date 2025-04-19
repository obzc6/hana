/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.client.dev.ModuleListTest;

private static final class ModuleListTest.ColorMode
extends Enum<ModuleListTest.ColorMode> {
    private static final /* synthetic */ ModuleListTest.ColorMode[] $VALUES;
    public static final /* enum */ ModuleListTest.ColorMode Rainbow;
    public static final /* enum */ ModuleListTest.ColorMode Pulse;
    public static final /* enum */ ModuleListTest.ColorMode Custom;

    static {
        Custom = new ModuleListTest.ColorMode(Vec3.ALLATORIxDEMO("Q\rj\u0007w\u001f"), 0);
        Pulse = new ModuleListTest.ColorMode(Animation.ALLATORIxDEMO("GRpUx"), 1);
        Rainbow = new ModuleListTest.ColorMode(Vec3.ALLATORIxDEMO("\bs\u0011w\u0011w\u0005"), 2);
        $VALUES = ModuleListTest.ColorMode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ModuleListTest.ColorMode() {
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

    public static ModuleListTest.ColorMode valueOf(String a) {
        return Enum.valueOf(ModuleListTest.ColorMode.class, a);
    }

    public static ModuleListTest.ColorMode[] values() {
        return (ModuleListTest.ColorMode[])$VALUES.clone();
    }

    private static /* synthetic */ ModuleListTest.ColorMode[] $values() {
        ModuleListTest.ColorMode[] arrcolorMode = new ModuleListTest.ColorMode[3];
        arrcolorMode[0] = Custom;
        arrcolorMode[1] = Pulse;
        arrcolorMode[2] = Rainbow;
        return arrcolorMode;
    }
}
