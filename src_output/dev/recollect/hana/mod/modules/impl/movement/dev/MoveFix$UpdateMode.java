/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.movement.dev.MoveFix;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.socket.network.user.User;

public static final class MoveFix.UpdateMode
extends Enum<MoveFix.UpdateMode> {
    private static final /* synthetic */ MoveFix.UpdateMode[] $VALUES;
    public static final /* enum */ MoveFix.UpdateMode UpdateMouse;
    public static final /* enum */ MoveFix.UpdateMode MovementPacket;
    public static final /* enum */ MoveFix.UpdateMode All;

    /*
     * Exception decompiling
     */
    private /* synthetic */ MoveFix.UpdateMode() {
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

    public static MoveFix.UpdateMode valueOf(String a) {
        return Enum.valueOf(MoveFix.UpdateMode.class, a);
    }

    public static MoveFix.UpdateMode[] values() {
        return (MoveFix.UpdateMode[])$VALUES.clone();
    }

    static {
        MovementPacket = new MoveFix.UpdateMode(User.ALLATORIxDEMO("c]MBGSljp]H\\OB"), 0);
        UpdateMouse = new MoveFix.UpdateMode(ProjectionUtils.ALLATORIxDEMO("#Q\u0003h;N O\u0013R\u0002"), 1);
        All = new MoveFix.UpdateMode(User.ALLATORIxDEMO("vFZ"), 2);
        $VALUES = MoveFix.UpdateMode.$values();
    }

    private static /* synthetic */ MoveFix.UpdateMode[] $values() {
        MoveFix.UpdateMode[] arrupdateMode = new MoveFix.UpdateMode[3];
        arrupdateMode[0] = MovementPacket;
        arrupdateMode[1] = UpdateMouse;
        arrupdateMode[2] = All;
        return arrupdateMode;
    }
}
