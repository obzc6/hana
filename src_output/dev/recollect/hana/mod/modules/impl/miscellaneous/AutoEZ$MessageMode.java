/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoEZ;

public static final class AutoEZ.MessageMode
extends Enum<AutoEZ.MessageMode> {
    public static final /* enum */ AutoEZ.MessageMode NEW;
    public static final /* enum */ AutoEZ.MessageMode Kouzi;
    private static final /* synthetic */ AutoEZ.MessageMode[] $VALUES;
    public static final /* enum */ AutoEZ.MessageMode Rebirth;
    public static final /* enum */ AutoEZ.MessageMode lag;
    public static final /* enum */ AutoEZ.MessageMode Custom;

    /*
     * Exception decompiling
     */
    private /* synthetic */ AutoEZ.MessageMode() {
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
        Kouzi = new AutoEZ.MessageMode(HoleUtils.ALLATORIxDEMO("\\LiXt"), 0);
        Rebirth = new AutoEZ.MessageMode(Hole.ALLATORIxDEMO("R\u001be\nh]8"), 1);
        NEW = new AutoEZ.MessageMode(HoleUtils.ALLATORIxDEMO("RgJ"), 2);
        Custom = new AutoEZ.MessageMode(Hole.ALLATORIxDEMO("=r\u0010nF="), 3);
        lag = new AutoEZ.MessageMode(HoleUtils.ALLATORIxDEMO("pCz"), 4);
        $VALUES = AutoEZ.MessageMode.$values();
    }

    private static /* synthetic */ AutoEZ.MessageMode[] $values() {
        AutoEZ.MessageMode[] arrmessageMode = new AutoEZ.MessageMode[5];
        arrmessageMode[0] = Kouzi;
        arrmessageMode[1] = Rebirth;
        arrmessageMode[2] = NEW;
        arrmessageMode[3] = Custom;
        arrmessageMode[4] = lag;
        return arrmessageMode;
    }

    public static AutoEZ.MessageMode valueOf(String a) {
        return Enum.valueOf(AutoEZ.MessageMode.class, a);
    }

    public static AutoEZ.MessageMode[] values() {
        return (AutoEZ.MessageMode[])$VALUES.clone();
    }
}
