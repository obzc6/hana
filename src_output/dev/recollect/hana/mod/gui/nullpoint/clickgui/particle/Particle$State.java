/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.particle;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Particle;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

private static final class Particle.State
extends Enum<Particle.State> {
    public static final /* enum */ Particle.State TWO;
    public static final /* enum */ Particle.State ONE;
    public static final /* enum */ Particle.State THREE;
    private static final /* synthetic */ Particle.State[] $VALUES;

    public static Particle.State valueOf(String a) {
        return Enum.valueOf(Particle.State.class, a);
    }

    public static Particle.State[] values() {
        return (Particle.State[])$VALUES.clone();
    }

    private static /* synthetic */ Particle.State[] $values() {
        Particle.State[] arrstate = new Particle.State[3];
        arrstate[0] = ONE;
        arrstate[1] = TWO;
        arrstate[2] = THREE;
        return arrstate;
    }

    static {
        ONE = new Particle.State(RenderHelper.ALLATORIxDEMO("Gs\u0007"), 0);
        TWO = new Particle.State(Packet.ALLATORIxDEMO("}Hw"), 1);
        THREE = new Particle.State(RenderHelper.ALLATORIxDEMO("A?Zx\u0007"), 2);
        $VALUES = Particle.State.$values();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Particle.State() {
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
