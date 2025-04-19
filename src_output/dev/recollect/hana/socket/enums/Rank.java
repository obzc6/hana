/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.render.EnumChatFormatting;
import dev.recollect.hana.socket.network.info.record.GameInfo;

public final class Rank
extends Enum<Rank> {
    public static final /* enum */ Rank MEDIA;
    public static final /* enum */ Rank ADMIN;
    public static final /* enum */ Rank FEMBOY;
    private static final /* synthetic */ Rank[] $VALUES;
    public static final /* enum */ Rank GAY;
    public static final /* enum */ Rank DEV;
    public static final /* enum */ Rank USER;
    public static final /* enum */ Rank EMPTY;
    public static final /* enum */ Rank OWNER;
    public static final /* enum */ Rank MODERATOR;
    public static final /* enum */ Rank BETA;
    public static final /* enum */ Rank TESTER;
    private final String name;
    public static final /* enum */ Rank PARTNER;
    public static final /* enum */ Rank CONTRIBUTOR;

    public String getName() {
        Rank a;
        return a.name;
    }

    static {
        EMPTY = new Rank(GameInfo.ALLATORIxDEMO("A^[BW"), 0, HoleUtils.ALLATORIxDEMO("\\DfXj"));
        USER = new Rank(GameInfo.ALLATORIxDEMO("FXS\\"), 1, HoleUtils.ALLATORIxDEMO("|eIa"));
        CONTRIBUTOR = new Rank(GameInfo.ALLATORIxDEMO("U\u001c\u0005{eUFF_Y\\"), 2, HoleUtils.ALLATORIxDEMO("H\u00068aXO{\\bCa"));
        BETA = new Rank(GameInfo.ALLATORIxDEMO("QNBO"), 3, HoleUtils.ALLATORIxDEMO("ksXr"));
        TESTER = new Rank(GameInfo.ALLATORIxDEMO("HA@_S\\"), 4, HoleUtils.ALLATORIxDEMO("r|ZbIa"));
        MEDIA = new Rank(GameInfo.ALLATORIxDEMO("IVO_O"), 5, HoleUtils.ALLATORIxDEMO("TLrEr"));
        PARTNER = new Rank(GameInfo.ALLATORIxDEMO("g]VGES\\"), 6, HoleUtils.ALLATORIxDEMO("zGk]xIa"));
        MODERATOR = new Rank(GameInfo.ALLATORIxDEMO("\u0006`sYVR_Y\\"), 7, HoleUtils.ALLATORIxDEMO("\u001bzNCkHbCa"));
        DEV = new Rank(GameInfo.ALLATORIxDEMO("OSX"), 8, HoleUtils.ALLATORIxDEMO("RIe"));
        ADMIN = new Rank(GameInfo.ALLATORIxDEMO("EWF_@"), 9, HoleUtils.ALLATORIxDEMO("XM{E}"));
        FEMBOY = new Rank(GameInfo.ALLATORIxDEMO("ZA^IYW"), 10, HoleUtils.ALLATORIxDEMO("`|DtCj"));
        GAY = new Rank(GameInfo.ALLATORIxDEMO("LWW"), 11, HoleUtils.ALLATORIxDEMO("QMj"));
        OWNER = new Rank(GameInfo.ALLATORIxDEMO("KDES\\"), 12, HoleUtils.ALLATORIxDEMO("V^xIa"));
        $VALUES = Rank.$values();
    }

    public EnumChatFormatting color() {
        Rank a;
        Rank rank = a;
        return rank.color(rank);
    }

    public static Rank valueOf(String a) {
        return Enum.valueOf(Rank.class, a);
    }

    /*
     * Exception decompiling
     */
    public EnumChatFormatting color(Rank a) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[DOLOOP]], but top level block is 13[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Rank(String varnull) {
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

    private static /* synthetic */ Rank[] $values() {
        Rank[] arrrank = new Rank[13];
        arrrank[0] = EMPTY;
        arrrank[1] = USER;
        arrrank[2] = CONTRIBUTOR;
        arrrank[3] = BETA;
        arrrank[4] = TESTER;
        arrrank[5] = MEDIA;
        arrrank[6] = PARTNER;
        arrrank[7] = MODERATOR;
        arrrank[8] = DEV;
        arrrank[9] = ADMIN;
        arrrank[10] = FEMBOY;
        arrrank[11] = GAY;
        arrrank[12] = OWNER;
        return arrrank;
    }

    public EnumChatFormatting color(String string) {
        String a = string;
        Rank a2 = this;
        return a2.color(Rank.valueOf(a.toUpperCase()));
    }

    public static Rank[] values() {
        return (Rank[])$VALUES.clone();
    }
}
