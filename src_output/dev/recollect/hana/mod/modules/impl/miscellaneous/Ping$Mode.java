/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.impl.miscellaneous.Ping;
import dev.recollect.hana.socket.network.client.NpSocketClient;

public static final class Ping.Mode
extends Enum<Ping.Mode> {
    public static final /* enum */ Ping.Mode Command;
    private static final /* synthetic */ Ping.Mode[] $VALUES;
    public static final /* enum */ Ping.Mode Request;

    private static /* synthetic */ Ping.Mode[] $values() {
        Ping.Mode[] arrmode = new Ping.Mode[2];
        arrmode[0] = Request;
        arrmode[1] = Command;
        return arrmode;
    }

    public static Ping.Mode[] values() {
        return (Ping.Mode[])$VALUES.clone();
    }

    public static Ping.Mode valueOf(String a) {
        return Enum.valueOf(Ping.Mode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Ping.Mode() {
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
        Request = new Ping.Mode(CrystalUtil.ALLATORIxDEMO("+N*U5R%"), 0);
        Command = new Ping.Mode(NpSocketClient.ALLATORIxDEMO("&h*a-c)"), 1);
        $VALUES = Ping.Mode.$values();
    }
}
