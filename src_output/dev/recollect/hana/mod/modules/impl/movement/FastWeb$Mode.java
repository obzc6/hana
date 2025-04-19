/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.movement.FastWeb;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;

public static final class FastWeb.Mode
extends Enum<FastWeb.Mode> {
    public static final /* enum */ FastWeb.Mode Vanilla = new FastWeb.Mode(PacketBuffer.ALLATORIxDEMO("g\u0015}\u0016t\u0012x"), 0);
    public static final /* enum */ FastWeb.Mode Strict = new FastWeb.Mode(Vec3.ALLATORIxDEMO("A\fk\u001a{\u0006"), 1);
    private static final /* synthetic */ FastWeb.Mode[] $VALUES;
    public static final /* enum */ FastWeb.Mode Ignore;
    public static final /* enum */ FastWeb.Mode Custom;

    /*
     * Exception decompiling
     */
    private /* synthetic */ FastWeb.Mode() {
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

    private static /* synthetic */ FastWeb.Mode[] $values() {
        FastWeb.Mode[] arrmode = new FastWeb.Mode[4];
        arrmode[0] = Vanilla;
        arrmode[1] = Strict;
        arrmode[2] = Custom;
        arrmode[3] = Ignore;
        return arrmode;
    }

    public static FastWeb.Mode[] values() {
        return (FastWeb.Mode[])$VALUES.clone();
    }

    static {
        Custom = new FastWeb.Mode(PacketBuffer.ALLATORIxDEMO("7f\fl\u0011t"), 2);
        Ignore = new FastWeb.Mode(Vec3.ALLATORIxDEMO("[\u001fw\u001cj\u0017"), 3);
        $VALUES = FastWeb.Mode.$values();
    }

    public static FastWeb.Mode valueOf(String a) {
        return Enum.valueOf(FastWeb.Mode.class, a);
    }
}
