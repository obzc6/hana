/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.GameInfo;

public final class ClientType
extends Enum<ClientType> {
    public static final /* enum */ ClientType Artist;
    public static final /* enum */ ClientType NullPoint;
    public static final /* enum */ ClientType EMPTY;
    public static final /* enum */ ClientType Dominic;
    public static final /* enum */ ClientType Rebirth;
    public static final /* enum */ ClientType NEVER;
    public static final /* enum */ ClientType Forever;
    public static final /* enum */ ClientType ArtDay;
    public static final /* enum */ ClientType Salt;
    private final String name;
    public static final /* enum */ ClientType Ark;
    public static final /* enum */ ClientType Eve;
    public static final /* enum */ ClientType FoxSense;
    public static final /* enum */ ClientType EDFDP;
    public static final /* enum */ ClientType Kura;
    private static final /* synthetic */ ClientType[] $VALUES;

    private static /* synthetic */ ClientType[] $values() {
        ClientType[] arrclientType = new ClientType[14];
        arrclientType[0] = EMPTY;
        arrclientType[1] = Kura;
        arrclientType[2] = Rebirth;
        arrclientType[3] = ArtDay;
        arrclientType[4] = FoxSense;
        arrclientType[5] = Dominic;
        arrclientType[6] = Artist;
        arrclientType[7] = EDFDP;
        arrclientType[8] = Salt;
        arrclientType[9] = Forever;
        arrclientType[10] = NullPoint;
        arrclientType[11] = Ark;
        arrclientType[12] = Eve;
        arrclientType[13] = NEVER;
        return arrclientType;
    }

    public static ClientType valueOf(String a) {
        return Enum.valueOf(ClientType.class, a);
    }

    static {
        EMPTY = new ClientType(SocketClient.ALLATORIxDEMO("WsKW"), 0, GameInfo.ALLATORIxDEMO("Y`ely"));
        Kura = new ClientType(SocketClient.ALLATORIxDEMO("unYo"), 1, GameInfo.ALLATORIxDEMO("F`ja"));
        Rebirth = new ClientType(SocketClient.ALLATORIxDEMO("mRpWi_f"), 2, GameInfo.ALLATORIxDEMO("ca~dglh"));
        ArtDay = new ClientType(SocketClient.ALLATORIxDEMO("v`J_Jw"), 3, GameInfo.ALLATORIxDEMO("EnyQyy"));
        FoxSense = new ClientType(SocketClient.ALLATORIxDEMO("\\POA[uXk"), 4, GameInfo.ALLATORIxDEMO("o^|Oh{ke"));
        Dominic = new ClientType(SocketClient.ALLATORIxDEMO("{XWuBm"), 5, GameInfo.ALLATORIxDEMO("ukqd{qc"));
        Artist = new ClientType(SocketClient.ALLATORIxDEMO("v`JrXz"), 6, GameInfo.ALLATORIxDEMO("Eny|kt"));
        EDFDP = new ClientType(SocketClient.ALLATORIxDEMO("Wz]o^"), 7, GameInfo.ALLATORIxDEMO("Yis|p"));
        Salt = new ClientType(SocketClient.ALLATORIxDEMO("mzGz"), 8, GameInfo.ALLATORIxDEMO("^ttt"));
        Forever = new ClientType(SocketClient.ALLATORIxDEMO("yX`[mN|"), 9, GameInfo.ALLATORIxDEMO("wknhc}r"));
        NullPoint = new ClientType(SocketClient.ALLATORIxDEMO("QoS[BQrEz"), 10, GameInfo.ALLATORIxDEMO("_\\]hLb|vt"));
        Ark = new ClientType(SocketClient.ALLATORIxDEMO("ZYe"), 11, GameInfo.ALLATORIxDEMO("Tjk"));
        Eve = new ClientType(SocketClient.ALLATORIxDEMO("^]k"), 12, GameInfo.ALLATORIxDEMO("Pne"));
        NEVER = new ClientType(SocketClient.ALLATORIxDEMO("\\{Mn\\"), 13, GameInfo.ALLATORIxDEMO("Rhc}r"));
        $VALUES = ClientType.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ClientType(String varnull) {
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

    public String getName() {
        ClientType a;
        return a.name;
    }

    public static ClientType[] values() {
        return (ClientType[])$VALUES.clone();
    }
}
