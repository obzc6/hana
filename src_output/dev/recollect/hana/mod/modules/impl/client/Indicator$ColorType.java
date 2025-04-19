/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.modules.impl.client.Indicator;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;

private static final class Indicator.ColorType
extends Enum<Indicator.ColorType> {
    private static final /* synthetic */ Indicator.ColorType[] $VALUES;
    public static final /* enum */ Indicator.ColorType White;
    public static final /* enum */ Indicator.ColorType Red;
    public static final /* enum */ Indicator.ColorType Green;

    public static Indicator.ColorType valueOf(String a) {
        return Enum.valueOf(Indicator.ColorType.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Indicator.ColorType() {
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
        Red = new Indicator.ColorType(TimerManager.ALLATORIxDEMO("\u0004Kx"), 0);
        Green = new Indicator.ColorType(BackgroundInfo.ALLATORIxDEMO("\f33nr"), 1);
        White = new Indicator.ColorType(TimerManager.ALLATORIxDEMO("\u001c\f?Zy"), 2);
        $VALUES = Indicator.ColorType.$values();
    }

    public static Indicator.ColorType[] values() {
        return (Indicator.ColorType[])$VALUES.clone();
    }

    private static /* synthetic */ Indicator.ColorType[] $values() {
        Indicator.ColorType[] arrcolorType = new Indicator.ColorType[3];
        arrcolorType[0] = Red;
        arrcolorType[1] = Green;
        arrcolorType[2] = White;
        return arrcolorType;
    }
}
