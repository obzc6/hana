/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.render.SwingModifer;
import dev.recollect.hana.xibao.SnowAnimation;

public static final class SwingModifer.Mode
extends Enum<SwingModifer.Mode> {
    private static final /* synthetic */ SwingModifer.Mode[] $VALUES;
    public static final /* enum */ SwingModifer.Mode OFF;
    public static final /* enum */ SwingModifer.Mode Main;
    public static final /* enum */ SwingModifer.Mode None;

    static {
        Main = new SwingModifer.Mode(SnowAnimation.ALLATORIxDEMO("u\u0007P\t"), 0);
        OFF = new SwingModifer.Mode(Snow.ALLATORIxDEMO("\u001eB\u0016"), 1);
        None = new SwingModifer.Mode(SnowAnimation.ALLATORIxDEMO("v\tW\u0002"), 2);
        $VALUES = SwingModifer.Mode.$values();
    }

    public static SwingModifer.Mode valueOf(String a) {
        return Enum.valueOf(SwingModifer.Mode.class, a);
    }

    private static /* synthetic */ SwingModifer.Mode[] $values() {
        SwingModifer.Mode[] arrmode = new SwingModifer.Mode[3];
        arrmode[0] = Main;
        arrmode[1] = OFF;
        arrmode[2] = None;
        return arrmode;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ SwingModifer.Mode() {
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

    public static SwingModifer.Mode[] values() {
        return (SwingModifer.Mode[])$VALUES.clone();
    }
}
