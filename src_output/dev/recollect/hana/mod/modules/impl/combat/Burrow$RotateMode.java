/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.Burrow;
import dev.recollect.hana.socket.network.info.record.UserInfo;

private static final class Burrow.RotateMode
extends Enum<Burrow.RotateMode> {
    private static final /* synthetic */ Burrow.RotateMode[] $VALUES;
    public static final /* enum */ Burrow.RotateMode Normal;
    public static final /* enum */ Burrow.RotateMode Bypass;
    public static final /* enum */ Burrow.RotateMode None;

    static {
        Bypass = new Burrow.RotateMode(UserInfo.ALLATORIxDEMO("/1\u0016\"\u00141"), 0);
        Normal = new Burrow.RotateMode(Snow.ALLATORIxDEMO("@5w<e<"), 1);
        None = new Burrow.RotateMode(UserInfo.ALLATORIxDEMO("(,\t'"), 2);
        $VALUES = Burrow.RotateMode.$values();
    }

    public static Burrow.RotateMode[] values() {
        return (Burrow.RotateMode[])$VALUES.clone();
    }

    private static /* synthetic */ Burrow.RotateMode[] $values() {
        Burrow.RotateMode[] arrrotateMode = new Burrow.RotateMode[3];
        arrrotateMode[0] = Bypass;
        arrrotateMode[1] = Normal;
        arrrotateMode[2] = None;
        return arrrotateMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Burrow.RotateMode() {
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

    public static Burrow.RotateMode valueOf(String a) {
        return Enum.valueOf(Burrow.RotateMode.class, a);
    }
}
