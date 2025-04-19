/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.video.Renderer;

private static final class HUD.GreeterMode
extends Enum<HUD.GreeterMode> {
    private static final /* synthetic */ HUD.GreeterMode[] $VALUES;
    public static final /* enum */ HUD.GreeterMode CUSTOM;
    public static final /* enum */ HUD.GreeterMode PLAYER;

    /*
     * Exception decompiling
     */
    private /* synthetic */ HUD.GreeterMode() {
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

    public static HUD.GreeterMode valueOf(String a) {
        return Enum.valueOf(HUD.GreeterMode.class, a);
    }

    private static /* synthetic */ HUD.GreeterMode[] $values() {
        HUD.GreeterMode[] arrgreeterMode = new HUD.GreeterMode[2];
        arrgreeterMode[0] = PLAYER;
        arrgreeterMode[1] = CUSTOM;
        return arrgreeterMode;
    }

    public static HUD.GreeterMode[] values() {
        return (HUD.GreeterMode[])$VALUES.clone();
    }

    static {
        PLAYER = new HUD.GreeterMode(ProjectionUtils.ALLATORIxDEMO("{!a?d5"), 0);
        CUSTOM = new HUD.GreeterMode(Renderer.ALLATORIxDEMO("^5S)\u0005z"), 1);
        $VALUES = HUD.GreeterMode.$values();
    }
}
