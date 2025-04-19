/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import org.bytedeco.javacv.FrameConverter;

public static final class Notify.Notifys.type
extends Enum<Notify.Notifys.type> {
    public static final /* enum */ Notify.Notifys.type Chat;
    private static final /* synthetic */ Notify.Notifys.type[] $VALUES;
    public static final /* enum */ Notify.Notifys.type Both;
    public static final /* enum */ Notify.Notifys.type Notify;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Notify.Notifys.type() {
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

    public static Notify.Notifys.type[] values() {
        return (Notify.Notifys.type[])$VALUES.clone();
    }

    private static /* synthetic */ Notify.Notifys.type[] $values() {
        Notify.Notifys.type[] arrtype = new Notify.Notifys.type[3];
        arrtype[0] = Notify;
        arrtype[1] = Chat;
        arrtype[2] = Both;
        return arrtype;
    }

    static {
        Notify = new Notify.Notifys.type(FrameConverter.ALLATORIxDEMO("<~\u001beC?"), 0);
        Chat = new Notify.Notifys.type(GameInfo.ALLATORIxDEMO("N}yt"), 1);
        Both = new Notify.Notifys.type(FrameConverter.ALLATORIxDEMO("-cQ."), 2);
        $VALUES = Notify.Notifys.type.$values();
    }

    public static Notify.Notifys.type valueOf(String a) {
        return Enum.valueOf(Notify.Notifys.type.class, a);
    }
}
