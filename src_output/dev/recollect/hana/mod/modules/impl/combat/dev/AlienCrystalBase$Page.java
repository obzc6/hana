/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystalBase;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import org.bytedeco.javacv.BaseChildSettings;

private static final class AlienCrystalBase.Page
extends Enum<AlienCrystalBase.Page> {
    public static final /* enum */ AlienCrystalBase.Page Calc;
    public static final /* enum */ AlienCrystalBase.Page Interact;
    private static final /* synthetic */ AlienCrystalBase.Page[] $VALUES;
    public static final /* enum */ AlienCrystalBase.Page General;
    public static final /* enum */ AlienCrystalBase.Page Misc;
    public static final /* enum */ AlienCrystalBase.Page Rotate;

    static {
        General = new AlienCrystalBase.Page(GameInfo.ALLATORIxDEMO("ryjpyl"), 0);
        Interact = new AlienCrystalBase.Page(BaseChildSettings.ALLATORIxDEMO("i:S6H/\u0013p"), 1);
        Misc = new AlienCrystalBase.Page(GameInfo.ALLATORIxDEMO("Wkkc"), 2);
        Rotate = new AlienCrystalBase.Page(BaseChildSettings.ALLATORIxDEMO("u<N/\u0004a"), 3);
        Calc = new AlienCrystalBase.Page(GameInfo.ALLATORIxDEMO("Yctc"), 4);
        $VALUES = AlienCrystalBase.Page.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ AlienCrystalBase.Page() {
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

    private static /* synthetic */ AlienCrystalBase.Page[] $values() {
        AlienCrystalBase.Page[] arrpage = new AlienCrystalBase.Page[5];
        arrpage[0] = General;
        arrpage[1] = Interact;
        arrpage[2] = Misc;
        arrpage[3] = Rotate;
        arrpage[4] = Calc;
        return arrpage;
    }

    public static AlienCrystalBase.Page valueOf(String a) {
        return Enum.valueOf(AlienCrystalBase.Page.class, a);
    }

    public static AlienCrystalBase.Page[] values() {
        return (AlienCrystalBase.Page[])$VALUES.clone();
    }
}
