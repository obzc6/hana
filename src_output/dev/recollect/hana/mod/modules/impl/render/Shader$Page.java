/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.impl.render.Shader;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;

private static final class Shader.Page
extends Enum<Shader.Page> {
    public static final /* enum */ Shader.Page Shader = new Shader.Page(RadiusUtils.ALLATORIxDEMO("g\bH\u0019\u0006E"), 0);
    private static final /* synthetic */ Shader.Page[] $VALUES;
    public static final /* enum */ Shader.Page Target = new Shader.Page(OnlineUserInfo.ALLATORIxDEMO("u7U7@&"), 1);
    public static final /* enum */ Shader.Page Legacy = new Shader.Page(RadiusUtils.ALLATORIxDEMO("x\u0005N\u001c\u0000N"), 2);

    public static Shader.Page[] values() {
        return (Shader.Page[])$VALUES.clone();
    }

    static {
        $VALUES = Shader.Page.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Shader.Page() {
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

    private static /* synthetic */ Shader.Page[] $values() {
        Shader.Page[] arrpage = new Shader.Page[3];
        arrpage[0] = Shader;
        arrpage[1] = Target;
        arrpage[2] = Legacy;
        return arrpage;
    }

    public static Shader.Page valueOf(String a) {
        return Enum.valueOf(Shader.Page.class, a);
    }
}
