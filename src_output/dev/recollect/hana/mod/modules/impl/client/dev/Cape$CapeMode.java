/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.client.dev.Cape;
import dev.recollect.hana.mod.modules.settings.Setting;

public static final class Cape.CapeMode
extends Enum<Cape.CapeMode> {
    public static final /* enum */ Cape.CapeMode Vape;
    public static final /* enum */ Cape.CapeMode Reimu;
    public static final /* enum */ Cape.CapeMode Anime;
    public static final /* enum */ Cape.CapeMode OF;
    private static final /* synthetic */ Cape.CapeMode[] $VALUES;
    public static final /* enum */ Cape.CapeMode Azureware;
    public static final /* enum */ Cape.CapeMode Steam;
    public static final /* enum */ Cape.CapeMode Moon;
    public static final /* enum */ Cape.CapeMode RUSHERHACK;
    public static final /* enum */ Cape.CapeMode HYPER;
    public static final /* enum */ Cape.CapeMode NONE;
    public static final /* enum */ Cape.CapeMode FUTURE;
    public static final /* enum */ Cape.CapeMode FDP;
    public static final /* enum */ Cape.CapeMode Hanabi;

    private static /* synthetic */ Cape.CapeMode[] $values() {
        Cape.CapeMode[] arrcapeMode = new Cape.CapeMode[13];
        arrcapeMode[0] = FUTURE;
        arrcapeMode[1] = RUSHERHACK;
        arrcapeMode[2] = HYPER;
        arrcapeMode[3] = Vape;
        arrcapeMode[4] = Anime;
        arrcapeMode[5] = OF;
        arrcapeMode[6] = Moon;
        arrcapeMode[7] = Reimu;
        arrcapeMode[8] = Azureware;
        arrcapeMode[9] = Hanabi;
        arrcapeMode[10] = Steam;
        arrcapeMode[11] = FDP;
        arrcapeMode[12] = NONE;
        return arrcapeMode;
    }

    public static Cape.CapeMode[] values() {
        return (Cape.CapeMode[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Cape.CapeMode() {
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
        FUTURE = new Cape.CapeMode(Setting.ALLATORIxDEMO("]\rR\u0010\u001eJ"), 0);
        RUSHERHACK = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO(">h8r)o9ax!"), 1);
        HYPER = new Cape.CapeMode(Setting.ALLATORIxDEMO("\u0010_\u0015\t]"), 2);
        Vape = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO("'AK\u000f"), 3);
        Anime = new Cape.CapeMode(Setting.ALLATORIxDEMO("\u0019h,!j"), 4);
        OF = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO("t,"), 5);
        Moon = new Cape.CapeMode(Setting.ALLATORIxDEMO("K*#a"), 6);
        Reimu = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO("o\u0014IV\u001f"), 7);
        Azureware = new Cape.CapeMode(Setting.ALLATORIxDEMO("\u0019f*i=q$>j"), 8);
        Hanabi = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO("$\\\u001fAY\u0003"), 9);
        Steam = new Cape.CapeMode(Setting.ALLATORIxDEMO("\u000br -b"), 10);
        FDP = new Cape.CapeMode(FadeUtils.ALLATORIxDEMO("f:"), 11);
        NONE = new Cape.CapeMode(Setting.ALLATORIxDEMO("H\n\u0002J"), 12);
        $VALUES = Cape.CapeMode.$values();
    }

    public static Cape.CapeMode valueOf(String a) {
        return Enum.valueOf(Cape.CapeMode.class, a);
    }
}
