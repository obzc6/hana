/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.mod.modules.impl.client.OnlyNPIRC;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;

public static final class OnlyNPIRC.type
extends Enum<OnlyNPIRC.type> {
    public static final /* enum */ OnlyNPIRC.type Notify = new OnlyNPIRC.type(ObsidianHelper.ALLATORIxDEMO("{1H>O;"), 0);
    public static final /* enum */ OnlyNPIRC.type Chat = new OnlyNPIRC.type(BackgroundInfo.ALLATORIxDEMO("\u0002>jh"), 1);
    private static final /* synthetic */ OnlyNPIRC.type[] $VALUES;

    /*
     * Exception decompiling
     */
    private /* synthetic */ OnlyNPIRC.type() {
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
        $VALUES = OnlyNPIRC.type.$values();
    }

    public static OnlyNPIRC.type valueOf(String a) {
        return Enum.valueOf(OnlyNPIRC.type.class, a);
    }

    private static /* synthetic */ OnlyNPIRC.type[] $values() {
        OnlyNPIRC.type[] arrtype = new OnlyNPIRC.type[2];
        arrtype[0] = Notify;
        arrtype[1] = Chat;
        return arrtype;
    }

    public static OnlyNPIRC.type[] values() {
        return (OnlyNPIRC.type[])$VALUES.clone();
    }
}
