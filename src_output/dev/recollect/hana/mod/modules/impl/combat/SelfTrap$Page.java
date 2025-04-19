/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.combat.SelfTrap;

public static final class SelfTrap.Page
extends Enum<SelfTrap.Page> {
    public static final /* enum */ SelfTrap.Page General = new SelfTrap.Page(Vec3.ALLATORIxDEMO("\u0000y\u0018\u0002y\u001e"), 0);
    private static final /* synthetic */ SelfTrap.Page[] $VALUES;
    public static final /* enum */ SelfTrap.Page Rotate = new SelfTrap.Page(Timer.ALLATORIxDEMO("k[PH\u001a\u0006"), 1);

    static {
        $VALUES = SelfTrap.Page.$values();
    }

    private static /* synthetic */ SelfTrap.Page[] $values() {
        SelfTrap.Page[] arrpage = new SelfTrap.Page[2];
        arrpage[0] = General;
        arrpage[1] = Rotate;
        return arrpage;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SelfTrap.Page() {
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

    public static SelfTrap.Page[] values() {
        return (SelfTrap.Page[])$VALUES.clone();
    }

    public static SelfTrap.Page valueOf(String a) {
        return Enum.valueOf(SelfTrap.Page.class, a);
    }
}
