/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.video.Renderer;

public static final class UIModule.Mode
extends Enum<UIModule.Mode> {
    public static final /* enum */ UIModule.Mode Reset;
    public static final /* enum */ UIModule.Mode Scissor;
    private static final /* synthetic */ UIModule.Mode[] $VALUES;
    public static final /* enum */ UIModule.Mode Pull;
    public static final /* enum */ UIModule.Mode Scale;
    public static final /* enum */ UIModule.Mode None;

    public static UIModule.Mode valueOf(String a) {
        return Enum.valueOf(UIModule.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ UIModule.Mode() {
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
        Scale = new UIModule.Mode(ColorUtil.ALLATORIxDEMO("H#gf)"), 0);
        Pull = new UIModule.Mode(Renderer.ALLATORIxDEMO("P\b&["), 1);
        Scissor = new UIModule.Mode(ColorUtil.ALLATORIxDEMO("O>r3ue>"), 2);
        Reset = new UIModule.Mode(Renderer.ALLATORIxDEMO("2e\u000e/C"), 3);
        None = new UIModule.Mode(ColorUtil.ALLATORIxDEMO("\u000eid)"), 4);
        $VALUES = UIModule.Mode.$values();
    }

    private static /* synthetic */ UIModule.Mode[] $values() {
        UIModule.Mode[] arrmode = new UIModule.Mode[5];
        arrmode[0] = Scale;
        arrmode[1] = Pull;
        arrmode[2] = Scissor;
        arrmode[3] = Reset;
        arrmode[4] = None;
        return arrmode;
    }

    public static UIModule.Mode[] values() {
        return (UIModule.Mode[])$VALUES.clone();
    }
}
