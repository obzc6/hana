/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.video.FileUtil;
import org.bytedeco.javacv.FrameFilter;

public static final class Notify.Notifys.icon
extends Enum<Notify.Notifys.icon> {
    public static final /* enum */ Notify.Notifys.icon Success = new Notify.Notifys.icon(FrameFilter.ALLATORIxDEMO("I4s.y?n"), 0);
    public static final /* enum */ Notify.Notifys.icon Error = new Notify.Notifys.icon(FileUtil.ALLATORIxDEMO("<h\u0007t\u0006"), 1);
    private static final /* synthetic */ Notify.Notifys.icon[] $VALUES;

    public static Notify.Notifys.icon valueOf(String a) {
        return Enum.valueOf(Notify.Notifys.icon.class, a);
    }

    public static Notify.Notifys.icon[] values() {
        return (Notify.Notifys.icon[])$VALUES.clone();
    }

    static {
        $VALUES = Notify.Notifys.icon.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Notify.Notifys.icon() {
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

    private static /* synthetic */ Notify.Notifys.icon[] $values() {
        Notify.Notifys.icon[] arricon = new Notify.Notifys.icon[2];
        arricon[0] = Success;
        arricon[1] = Error;
        return arricon;
    }
}
