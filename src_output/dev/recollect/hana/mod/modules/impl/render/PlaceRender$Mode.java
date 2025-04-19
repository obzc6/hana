/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.render.PlaceRender;
import org.bytedeco.javacv.BufferRing;

private static final class PlaceRender.Mode
extends Enum<PlaceRender.Mode> {
    private static final /* synthetic */ PlaceRender.Mode[] $VALUES;
    public static final /* enum */ PlaceRender.Mode Shrink;
    public static final /* enum */ PlaceRender.Mode All;
    public static final /* enum */ PlaceRender.Mode Fade;

    public static PlaceRender.Mode valueOf(String a) {
        return Enum.valueOf(PlaceRender.Mode.class, a);
    }

    public static PlaceRender.Mode[] values() {
        return (PlaceRender.Mode[])$VALUES.clone();
    }

    static {
        Fade = new PlaceRender.Mode(BufferRing.ALLATORIxDEMO("\u0012\u0001zO"), 0);
        Shrink = new PlaceRender.Mode(TipUtils.ALLATORIxDEMO("\u0012\u0006.\u001axR"), 1);
        All = new PlaceRender.Mode(BufferRing.ALLATORIxDEMO("!rF"), 2);
        $VALUES = PlaceRender.Mode.$values();
    }

    private static /* synthetic */ PlaceRender.Mode[] $values() {
        PlaceRender.Mode[] arrmode = new PlaceRender.Mode[3];
        arrmode[0] = Fade;
        arrmode[1] = Shrink;
        arrmode[2] = All;
        return arrmode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PlaceRender.Mode() {
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
}
