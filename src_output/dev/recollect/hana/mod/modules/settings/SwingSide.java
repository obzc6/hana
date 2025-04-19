/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;

public final class SwingSide
extends Enum<SwingSide> {
    public static final /* enum */ SwingSide None;
    public static final /* enum */ SwingSide Server;
    public static final /* enum */ SwingSide Client;
    private static final /* synthetic */ SwingSide[] $VALUES;
    public static final /* enum */ SwingSide All;

    private static /* synthetic */ SwingSide[] $values() {
        SwingSide[] arrswingSide = new SwingSide[4];
        arrswingSide[0] = All;
        arrswingSide[1] = Client;
        arrswingSide[2] = Server;
        arrswingSide[3] = None;
        return arrswingSide;
    }

    public static SwingSide[] values() {
        return (SwingSide[])$VALUES.clone();
    }

    static {
        All = new SwingSide(TimerManager.ALLATORIxDEMO("\u0017Bp"), 0);
        Client = new SwingSide(HoleUtils.ALLATORIxDEMO("m}JyLi"), 1);
        Server = new SwingSide(TimerManager.ALLATORIxDEMO("*.\u0016 Kn"), 2);
        None = new SwingSide(HoleUtils.ALLATORIxDEMO("msLx"), 3);
        $VALUES = SwingSide.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SwingSide() {
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

    public static SwingSide valueOf(String a) {
        return Enum.valueOf(SwingSide.class, a);
    }
}
