/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.video.FileUtil;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

public static final class HanaAura.CircleMode
extends Enum<HanaAura.CircleMode> {
    private static final /* synthetic */ HanaAura.CircleMode[] $VALUES;
    public static final /* enum */ HanaAura.CircleMode Circle2D;
    public static final /* enum */ HanaAura.CircleMode Star;
    public static final /* enum */ HanaAura.CircleMode Circle;

    public static HanaAura.CircleMode valueOf(String a) {
        return Enum.valueOf(HanaAura.CircleMode.class, a);
    }

    static {
        Star = new HanaAura.CircleMode(RenderHelper.ALLATORIxDEMO("$|\\0"), 0);
        Circle2D = new HanaAura.CircleMode(FileUtil.ALLATORIxDEMO("{>h\u0016}\u001b\";"), 1);
        Circle = new HanaAura.CircleMode(RenderHelper.ALLATORIxDEMO(")|\u0005kQ'"), 2);
        $VALUES = HanaAura.CircleMode.$values();
    }

    public static HanaAura.CircleMode[] values() {
        return (HanaAura.CircleMode[])$VALUES.clone();
    }

    private static /* synthetic */ HanaAura.CircleMode[] $values() {
        HanaAura.CircleMode[] arrcircleMode = new HanaAura.CircleMode[3];
        arrcircleMode[0] = Star;
        arrcircleMode[1] = Circle2D;
        arrcircleMode[2] = Circle;
        return arrcircleMode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HanaAura.CircleMode() {
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
