/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.WebCleaner;
import org.bytedeco.javacv.FrameFilter;

public static final class WebCleaner.SwapMode
extends Enum<WebCleaner.SwapMode> {
    public static final /* enum */ WebCleaner.SwapMode Off = new WebCleaner.SwapMode(Snow.ALLATORIxDEMO("\u001eb6"), 0);
    public static final /* enum */ WebCleaner.SwapMode Silent;
    public static final /* enum */ WebCleaner.SwapMode Inventory;
    public static final /* enum */ WebCleaner.SwapMode Normal;
    private static final /* synthetic */ WebCleaner.SwapMode[] $VALUES;

    public static WebCleaner.SwapMode valueOf(String a) {
        return Enum.valueOf(WebCleaner.SwapMode.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ WebCleaner.SwapMode() {
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

    private static /* synthetic */ WebCleaner.SwapMode[] $values() {
        WebCleaner.SwapMode[] arrswapMode = new WebCleaner.SwapMode[4];
        arrswapMode[0] = Off;
        arrswapMode[1] = Normal;
        arrswapMode[2] = Silent;
        arrswapMode[3] = Inventory;
        return arrswapMode;
    }

    static {
        Normal = new WebCleaner.SwapMode(FrameFilter.ALLATORIxDEMO("\u0003s4z&z"), 1);
        Silent = new WebCleaner.SwapMode(Snow.ALLATORIxDEMO("]3i4j$"), 2);
        Inventory = new WebCleaner.SwapMode(FrameFilter.ALLATORIxDEMO("J\u0001H(r2x5o"), 3);
        $VALUES = WebCleaner.SwapMode.$values();
    }

    public static WebCleaner.SwapMode[] values() {
        return (WebCleaner.SwapMode[])$VALUES.clone();
    }
}
