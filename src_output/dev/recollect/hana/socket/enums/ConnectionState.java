/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.socket.network.info.ClientInfo;

public final class ConnectionState
extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES;
    public static final /* enum */ ConnectionState DISCONNECTED;
    public static final /* enum */ ConnectionState CONNECTED;
    public static final /* enum */ ConnectionState CONNECTING;

    public static ConnectionState[] values() {
        return (ConnectionState[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ConnectionState() {
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

    public static ConnectionState valueOf(String a) {
        return Enum.valueOf(ConnectionState.class, a);
    }

    private static /* synthetic */ ConnectionState[] $values() {
        ConnectionState[] arrconnectionState = new ConnectionState[3];
        arrconnectionState[0] = CONNECTED;
        arrconnectionState[1] = DISCONNECTED;
        arrconnectionState[2] = CONNECTING;
        return arrconnectionState;
    }

    static {
        CONNECTED = new ConnectionState(ClientInfo.ALLATORIxDEMO("\rK\u0007M\u000b]\u0007\u0011]"), 0);
        DISCONNECTED = new ConnectionState(OLEPOSSUtils.ALLATORIxDEMO("\u0014f\u0006i\u001dc\u001bo\u000bcG9"), 1);
        CONNECTING = new ConnectionState(ClientInfo.ALLATORIxDEMO("@\u0001J\u0007F\rJ\u001a\u001a^"), 2);
        $VALUES = ConnectionState.$values();
    }
}
