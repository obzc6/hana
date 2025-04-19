/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;

public static final class UIModule.BYDMode
extends Enum<UIModule.BYDMode> {
    public static final /* enum */ UIModule.BYDMode madcat = new UIModule.BYDMode(ObsidianHelper.ALLATORIxDEMO("N)L H6"), 0);
    public static final /* enum */ UIModule.BYDMode gun = new UIModule.BYDMode(TimeHelper.ALLATORIxDEMO("\u0018\u0002["), 1);
    public static final /* enum */ UIModule.BYDMode little = new UIModule.BYDMode(ObsidianHelper.ALLATORIxDEMO("O!\\7E'"), 2);
    private static final /* synthetic */ UIModule.BYDMode[] $VALUES;

    static {
        $VALUES = UIModule.BYDMode.$values();
    }

    private static /* synthetic */ UIModule.BYDMode[] $values() {
        UIModule.BYDMode[] arrbYDMode = new UIModule.BYDMode[3];
        arrbYDMode[0] = madcat;
        arrbYDMode[1] = gun;
        arrbYDMode[2] = little;
        return arrbYDMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ UIModule.BYDMode() {
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

    public static UIModule.BYDMode[] values() {
        return (UIModule.BYDMode[])$VALUES.clone();
    }

    public static UIModule.BYDMode valueOf(String a) {
        return Enum.valueOf(UIModule.BYDMode.class, a);
    }
}
