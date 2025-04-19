/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.SelfFill;
import org.bytedeco.javacv.FrameFilter;

public static final class SelfFill.Mode
extends Enum<SelfFill.Mode> {
    public static final /* enum */ SelfFill.Mode Nu;
    private static final /* synthetic */ SelfFill.Mode[] $VALUES;
    public static final /* enum */ SelfFill.Mode Smart;
    public static final /* enum */ SelfFill.Mode Xin;
    public static final /* enum */ SelfFill.Mode Scanner;
    public static final /* enum */ SelfFill.Mode ToVoid;
    public static final /* enum */ SelfFill.Mode Auto;
    public static final /* enum */ SelfFill.Mode Au;
    public static final /* enum */ SelfFill.Mode Invalid;

    private static /* synthetic */ SelfFill.Mode[] $values() {
        SelfFill.Mode[] arrmode = new SelfFill.Mode[8];
        arrmode[0] = Xin;
        arrmode[1] = Auto;
        arrmode[2] = Scanner;
        arrmode[3] = Nu;
        arrmode[4] = Au;
        arrmode[5] = Invalid;
        arrmode[6] = Smart;
        arrmode[7] = ToVoid;
        return arrmode;
    }

    public static SelfFill.Mode valueOf(String a) {
        return Enum.valueOf(SelfFill.Mode.class, a);
    }

    static {
        Xin = new SelfFill.Mode(Snow.ALLATORIxDEMO("\tm>"), 0);
        Auto = new SelfFill.Mode(FrameFilter.ALLATORIxDEMO("\u0007b3y"), 1);
        Scanner = new SelfFill.Mode(Snow.ALLATORIxDEMO("+m;k?a\""), 2);
        Nu = new SelfFill.Mode(FrameFilter.ALLATORIxDEMO("\tc"), 3);
        Au = new SelfFill.Mode(Snow.ALLATORIxDEMO("E%"), 4);
        Invalid = new SelfFill.Mode(FrameFilter.ALLATORIxDEMO("w#j'{.r"), 5);
        Smart = new SelfFill.Mode(Snow.ALLATORIxDEMO("\th0v$"), 6);
        ToVoid = new SelfFill.Mode(FrameFilter.ALLATORIxDEMO("\u0019s\u0010x.r"), 7);
        $VALUES = SelfFill.Mode.$values();
    }

    public static SelfFill.Mode[] values() {
        return (SelfFill.Mode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SelfFill.Mode() {
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
