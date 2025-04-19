/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.mod.modules.impl.movement.Velocity;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.xibao.SnowAnimation;

public static final class Velocity.Mode
extends Enum<Velocity.Mode> {
    public static final /* enum */ Velocity.Mode Simple = new Velocity.Mode(SocketClient.ALLATORIxDEMO("rmGGk"), 0);
    public static final /* enum */ Velocity.Mode AACPull = new Velocity.Mode(SnowAnimation.ALLATORIxDEMO("\u000er.h\u0013U\u000b"), 1);
    public static final /* enum */ Velocity.Mode AACZero = new Velocity.Mode(SocketClient.ALLATORIxDEMO("g`GpjYa"), 2);
    private static final /* synthetic */ Velocity.Mode[] $VALUES;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Velocity.Mode() {
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

    private static /* synthetic */ Velocity.Mode[] $values() {
        Velocity.Mode[] arrmode = new Velocity.Mode[3];
        arrmode[0] = Simple;
        arrmode[1] = AACPull;
        arrmode[2] = AACZero;
        return arrmode;
    }

    static {
        $VALUES = Velocity.Mode.$values();
    }

    public static Velocity.Mode valueOf(String a) {
        return Enum.valueOf(Velocity.Mode.class, a);
    }

    public static Velocity.Mode[] values() {
        return (Velocity.Mode[])$VALUES.clone();
    }
}
