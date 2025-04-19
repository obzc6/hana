/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.Burrow;
import dev.recollect.hana.socket.network.client.SocketClient;
import org.bytedeco.javacv.BufferRing;

private static final class Burrow.LagBackMode
extends Enum<Burrow.LagBackMode> {
    public static final /* enum */ Burrow.LagBackMode Tongyiqianweng;
    private static final /* synthetic */ Burrow.LagBackMode[] $VALUES;
    public static final /* enum */ Burrow.LagBackMode Smart;
    public static final /* enum */ Burrow.LagBackMode Normal;
    public static final /* enum */ Burrow.LagBackMode ToVoid;
    public static final /* enum */ Burrow.LagBackMode TrollHack;
    public static final /* enum */ Burrow.LagBackMode Fly;
    public static final /* enum */ Burrow.LagBackMode Invalid;
    public static final /* enum */ Burrow.LagBackMode Rotation;

    static {
        Smart = new Burrow.LagBackMode(BufferRing.ALLATORIxDEMO(".9\u0001l^"), 0);
        Invalid = new Burrow.LagBackMode(SocketClient.ALLATORIxDEMO("oOrKcBj"), 1);
        TrollHack = new Burrow.LagBackMode(BufferRing.ALLATORIxDEMO(")<\u0015%\u0011\u001c\u0001}A"), 2);
        ToVoid = new Burrow.LagBackMode(SocketClient.ALLATORIxDEMO("uk|`Bj"), 3);
        Normal = new Burrow.LagBackMode(BufferRing.ALLATORIxDEMO("\u0007\u0012&\rF"), 4);
        Rotation = new Burrow.LagBackMode(SocketClient.ALLATORIxDEMO("QIUe^fD`"), 5);
        Fly = new Burrow.LagBackMode(BufferRing.ALLATORIxDEMO("&rS"), 6);
        Tongyiqianweng = new Burrow.LagBackMode(SocketClient.ALLATORIxDEMO("{eCo\\irO@j]jEi"), 7);
        $VALUES = Burrow.LagBackMode.$values();
    }

    private static /* synthetic */ Burrow.LagBackMode[] $values() {
        Burrow.LagBackMode[] arrlagBackMode = new Burrow.LagBackMode[8];
        arrlagBackMode[0] = Smart;
        arrlagBackMode[1] = Invalid;
        arrlagBackMode[2] = TrollHack;
        arrlagBackMode[3] = ToVoid;
        arrlagBackMode[4] = Normal;
        arrlagBackMode[5] = Rotation;
        arrlagBackMode[6] = Fly;
        arrlagBackMode[7] = Tongyiqianweng;
        return arrlagBackMode;
    }

    public static Burrow.LagBackMode valueOf(String a) {
        return Enum.valueOf(Burrow.LagBackMode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Burrow.LagBackMode() {
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

    public static Burrow.LagBackMode[] values() {
        return (Burrow.LagBackMode[])$VALUES.clone();
    }
}
