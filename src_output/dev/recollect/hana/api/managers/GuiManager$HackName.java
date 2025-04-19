/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

public static final class GuiManager.HackName
extends Enum<GuiManager.HackName> {
    public static final /* enum */ GuiManager.HackName MadCat;
    public static final /* enum */ GuiManager.HackName MoonGod;
    private static final /* synthetic */ GuiManager.HackName[] $VALUES;
    public static final /* enum */ GuiManager.HackName Mio;
    public static final /* enum */ GuiManager.HackName nullpoint;
    public static final /* enum */ GuiManager.HackName MoonEmoji;
    public static final /* enum */ GuiManager.HackName Moon;

    public static GuiManager.HackName[] values() {
        return (GuiManager.HackName[])$VALUES.clone();
    }

    public static GuiManager.HackName valueOf(String a) {
        return Enum.valueOf(GuiManager.HackName.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ GuiManager.HackName() {
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

    private static /* synthetic */ GuiManager.HackName[] $values() {
        GuiManager.HackName[] arrhackName = new GuiManager.HackName[6];
        arrhackName[0] = MoonEmoji;
        arrhackName[1] = nullpoint;
        arrhackName[2] = MadCat;
        arrhackName[3] = Moon;
        arrhackName[4] = MoonGod;
        arrhackName[5] = Mio;
        return arrhackName;
    }

    static {
        MoonEmoji = new GuiManager.HackName(Vec3.ALLATORIxDEMO("1\\6r3}\u0015r\u001b"), 0);
        nullpoint = new GuiManager.HackName(RenderHelper.ALLATORIxDEMO("{\u0018~\u0006e\u0018aS6"), 1);
        MadCat = new GuiManager.HackName(Vec3.ALLATORIxDEMO("Q\u0017t9y\u0006"), 2);
        Moon = new GuiManager.HackName(RenderHelper.ALLATORIxDEMO(":gR,"), 3);
        MoonGod = new GuiManager.HackName(Vec3.ALLATORIxDEMO("\u0014s\u0019~=w\u0016"), 4);
        Mio = new GuiManager.HackName(RenderHelper.ALLATORIxDEMO("ET-"), 5);
        $VALUES = GuiManager.HackName.$values();
    }
}
