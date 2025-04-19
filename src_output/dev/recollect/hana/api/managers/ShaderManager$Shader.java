/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.ShaderManager;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import org.bytedeco.javacv.FrameFilter;

public static final class ShaderManager.Shader
extends Enum<ShaderManager.Shader> {
    public static final /* enum */ ShaderManager.Shader Solid = new ShaderManager.Shader(FrameFilter.ALLATORIxDEMO("D(z9e"), 0);
    public static final /* enum */ ShaderManager.Shader Snow;
    public static final /* enum */ ShaderManager.Shader Flow;
    public static final /* enum */ ShaderManager.Shader Smoke;
    private static final /* synthetic */ ShaderManager.Shader[] $VALUES;
    public static final /* enum */ ShaderManager.Shader Gradient;
    public static final /* enum */ ShaderManager.Shader Rainbow;

    static {
        Smoke = new ShaderManager.Shader(OLEPOSSUtils.ALLATORIxDEMO("y%Xi\u0018"), 1);
        Gradient = new ShaderManager.Shader(FrameFilter.ALLATORIxDEMO("\u0004`'s.s>u"), 2);
        Snow = new ShaderManager.Shader(OLEPOSSUtils.ALLATORIxDEMO("\u001bYm\n"), 3);
        Flow = new ShaderManager.Shader(FrameFilter.ALLATORIxDEMO("\u0001z?v"), 4);
        Rainbow = new ShaderManager.Shader(OLEPOSSUtils.ALLATORIxDEMO("4C&Um\n"), 5);
        $VALUES = ShaderManager.Shader.$values();
    }

    public static ShaderManager.Shader valueOf(String a) {
        return Enum.valueOf(ShaderManager.Shader.class, a);
    }

    private static /* synthetic */ ShaderManager.Shader[] $values() {
        ShaderManager.Shader[] arrshader = new ShaderManager.Shader[6];
        arrshader[0] = Solid;
        arrshader[1] = Smoke;
        arrshader[2] = Gradient;
        arrshader[3] = Snow;
        arrshader[4] = Flow;
        arrshader[5] = Rainbow;
        return arrshader;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ ShaderManager.Shader() {
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

    public static ShaderManager.Shader[] values() {
        return (ShaderManager.Shader[])$VALUES.clone();
    }
}
