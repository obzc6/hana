/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.impl.render.DesyncESP;
import dev.recollect.hana.video.Renderer;

public static final class DesyncESP.Type
extends Enum<DesyncESP.Type> {
    private static final /* synthetic */ DesyncESP.Type[] $VALUES;
    public static final /* enum */ DesyncESP.Type ServerSide;
    public static final /* enum */ DesyncESP.Type ClientSide;

    /*
     * Exception decompiling
     */
    private /* synthetic */ DesyncESP.Type() {
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

    static {
        ClientSide = new DesyncESP.Type(GaussianFilter.ALLATORIxDEMO("\fO!A!W\u0001W|\u0011"), 0);
        ServerSide = new DesyncESP.Type(Renderer.ALLATORIxDEMO("N\u0005h\u0011x\u0012S\u0014.R"), 1);
        $VALUES = DesyncESP.Type.$values();
    }

    public static DesyncESP.Type valueOf(String a) {
        return Enum.valueOf(DesyncESP.Type.class, a);
    }

    private static /* synthetic */ DesyncESP.Type[] $values() {
        DesyncESP.Type[] arrtype = new DesyncESP.Type[2];
        arrtype[0] = ClientSide;
        arrtype[1] = ServerSide;
        return arrtype;
    }

    public static DesyncESP.Type[] values() {
        return (DesyncESP.Type[])$VALUES.clone();
    }
}
