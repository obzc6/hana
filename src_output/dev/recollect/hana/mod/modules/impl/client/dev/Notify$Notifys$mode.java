/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;

public static final class Notify.Notifys.mode
extends Enum<Notify.Notifys.mode> {
    public static final /* enum */ Notify.Notifys.mode Fill;
    private static final /* synthetic */ Notify.Notifys.mode[] $VALUES;
    public static final /* enum */ Notify.Notifys.mode Line;

    static {
        Line = new Notify.Notifys.mode(Hole.ALLATORIxDEMO("/sG5"), 0);
        Fill = new Notify.Notifys.mode(Animation.ALLATORIxDEMO("auJq"), 1);
        $VALUES = Notify.Notifys.mode.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Notify.Notifys.mode() {
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

    private static /* synthetic */ Notify.Notifys.mode[] $values() {
        Notify.Notifys.mode[] arrmode = new Notify.Notifys.mode[2];
        arrmode[0] = Line;
        arrmode[1] = Fill;
        return arrmode;
    }

    public static Notify.Notifys.mode valueOf(String a) {
        return Enum.valueOf(Notify.Notifys.mode.class, a);
    }

    public static Notify.Notifys.mode[] values() {
        return (Notify.Notifys.mode[])$VALUES.clone();
    }
}
