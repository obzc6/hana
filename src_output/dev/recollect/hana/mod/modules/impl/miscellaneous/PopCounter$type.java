/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.miscellaneous.PopCounter;
import org.bytedeco.javacv.FrameFilter;

public static final class PopCounter.type
extends Enum<PopCounter.type> {
    public static final /* enum */ PopCounter.type Chat;
    private static final /* synthetic */ PopCounter.type[] $VALUES;
    public static final /* enum */ PopCounter.type Notify;
    public static final /* enum */ PopCounter.type Both;

    private static /* synthetic */ PopCounter.type[] $values() {
        PopCounter.type[] arrtype = new PopCounter.type[3];
        arrtype[0] = Notify;
        arrtype[1] = Chat;
        arrtype[2] = Both;
        return arrtype;
    }

    static {
        Notify = new PopCounter.type(ObsidianHelper.ALLATORIxDEMO("{1H>O;"), 0);
        Chat = new PopCounter.type(FrameFilter.ALLATORIxDEMO("\u0011k&b"), 1);
        Both = new PopCounter.type(ObsidianHelper.ALLATORIxDEMO("~8]*"), 2);
        $VALUES = PopCounter.type.$values();
    }

    public static PopCounter.type[] values() {
        return (PopCounter.type[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PopCounter.type() {
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

    public static PopCounter.type valueOf(String a) {
        return Enum.valueOf(PopCounter.type.class, a);
    }
}
