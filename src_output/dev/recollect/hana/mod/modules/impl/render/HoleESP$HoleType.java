/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.impl.render.HoleESP;
import org.bytedeco.javacv.BufferRing;

public static final class HoleESP.HoleType
extends Enum<HoleESP.HoleType> {
    public static final /* enum */ HoleESP.HoleType Obsidian = new HoleESP.HoleType(BufferRing.ALLATORIxDEMO("\u0001\u0018:\u00140\tD"), 0);
    private static final /* synthetic */ HoleESP.HoleType[] $VALUES;
    public static final /* enum */ HoleESP.HoleType Bedrock = new HoleESP.HoleType(GaussianFilter.ALLATORIxDEMO("f*G Q{\u001f"), 1);
    public static final /* enum */ HoleESP.HoleType Other = new HoleESP.HoleType(BufferRing.ALLATORIxDEMO("2 \b{X"), 2);

    public static HoleESP.HoleType[] values() {
        return (HoleESP.HoleType[])$VALUES.clone();
    }

    public static HoleESP.HoleType valueOf(String a) {
        return Enum.valueOf(HoleESP.HoleType.class, a);
    }

    static {
        $VALUES = HoleESP.HoleType.$values();
    }

    private static /* synthetic */ HoleESP.HoleType[] $values() {
        HoleESP.HoleType[] arrholeType = new HoleESP.HoleType[3];
        arrholeType[0] = Obsidian;
        arrholeType[1] = Bedrock;
        arrholeType[2] = Other;
        return arrholeType;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ HoleESP.HoleType() {
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
