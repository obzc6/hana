/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import dev.recollect.hana.socket.network.client.SocketClient;

public static final class PacketFly2.Phase
extends Enum<PacketFly2.Phase> {
    private static final /* synthetic */ PacketFly2.Phase[] $VALUES;
    public static final /* enum */ PacketFly2.Phase Off = new PacketFly2.Phase(SocketClient.ALLATORIxDEMO("WMh"), 0);
    public static final /* enum */ PacketFly2.Phase Full;
    public static final /* enum */ PacketFly2.Phase Semi;

    public static PacketFly2.Phase[] values() {
        return (PacketFly2.Phase[])$VALUES.clone();
    }

    public static PacketFly2.Phase valueOf(String a) {
        return Enum.valueOf(PacketFly2.Phase.class, a);
    }

    private static /* synthetic */ PacketFly2.Phase[] $values() {
        PacketFly2.Phase[] arrphase = new PacketFly2.Phase[3];
        arrphase[0] = Off;
        arrphase[1] = Semi;
        arrphase[2] = Full;
        return arrphase;
    }

    static {
        Semi = new PacketFly2.Phase(Vec3.ALLATORIxDEMO("]\u0001u\u001b"), 1);
        Full = new PacketFly2.Phase(SocketClient.ALLATORIxDEMO("{mGb"), 2);
        $VALUES = PacketFly2.Phase.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PacketFly2.Phase() {
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
}
