/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.socket.network.user.User;

public final class Placement
extends Enum<Placement> {
    public static final /* enum */ Placement Vanilla = new Placement(FPSManager.ALLATORIxDEMO("'q\u0018d\u0007+@"), 0);
    private static final /* synthetic */ Placement[] $VALUES;
    public static final /* enum */ Placement Legit;
    public static final /* enum */ Placement AirPlace;
    public static final /* enum */ Placement Strict;

    public static Placement valueOf(String a) {
        return Enum.valueOf(Placement.class, a);
    }

    public static Placement[] values() {
        return (Placement[])$VALUES.clone();
    }

    static {
        Strict = new Placement(User.ALLATORIxDEMO("yBSTXS"), 1);
        Legit = new Placement(FPSManager.ALLATORIxDEMO(":h\f.U"), 2);
        AirPlace = new Placement(User.ALLATORIxDEMO("cWXfM\\XB"), 3);
        $VALUES = Placement.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Placement() {
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

    private static /* synthetic */ Placement[] $values() {
        Placement[] arrplacement = new Placement[4];
        arrplacement[0] = Vanilla;
        arrplacement[1] = Strict;
        arrplacement[2] = Legit;
        arrplacement[3] = AirPlace;
        return arrplacement;
    }
}
