/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 */
package dev.recollect.hana.api.utils.render;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EnumChatFormatting
extends Enum<EnumChatFormatting> {
    public static final /* enum */ EnumChatFormatting ITALIC;
    public static final /* enum */ EnumChatFormatting DARK_RED;
    public static final /* enum */ EnumChatFormatting AQUA;
    public static final /* enum */ EnumChatFormatting DARK_GREEN;
    public static final /* enum */ EnumChatFormatting GREEN;
    public static final /* enum */ EnumChatFormatting STRIKETHROUGH;
    public static final /* enum */ EnumChatFormatting DARK_BLUE;
    public static final /* enum */ EnumChatFormatting DARK_PURPLE;
    public static final /* enum */ EnumChatFormatting DARK_AQUA;
    public static final /* enum */ EnumChatFormatting WHITE;
    public static final /* enum */ EnumChatFormatting GOLD;
    public static final /* enum */ EnumChatFormatting RESET;
    public static final /* enum */ EnumChatFormatting UNDERLINE;
    private static final /* synthetic */ EnumChatFormatting[] $VALUES;
    private final boolean fancyStyling;
    private static final Pattern formattingCodePattern;
    public static final /* enum */ EnumChatFormatting BOLD;
    private final String name;
    private static final Map<String, EnumChatFormatting> nameMapping;
    private final String controlString;
    public static final /* enum */ EnumChatFormatting YELLOW;
    public static final /* enum */ EnumChatFormatting GRAY;
    public static final /* enum */ EnumChatFormatting RED;
    private final char formattingCode;
    public static final /* enum */ EnumChatFormatting BLUE;
    private final int colorIndex;
    public static final /* enum */ EnumChatFormatting DARK_GRAY;
    public static final /* enum */ EnumChatFormatting BLACK;
    public static final /* enum */ EnumChatFormatting LIGHT_PURPLE;
    public static final /* enum */ EnumChatFormatting OBFUSCATED;

    public static String getTextWithoutFormattingCodes(String a) {
        if (a == null) {
            return null;
        }
        return formattingCodePattern.matcher(a).replaceAll("");
    }

    public static EnumChatFormatting getValueByName(String a) {
        if (a == null) {
            return null;
        }
        return nameMapping.get(EnumChatFormatting.func_175745_c(a));
    }

    public String toString() {
        EnumChatFormatting a;
        return a.controlString;
    }

    /*
     * WARNING - void declaration
     */
    public static Collection<String> getValidValues(boolean bl, boolean bl2) {
        int a;
        boolean bl3 = bl;
        ArrayList arrayList = Lists.newArrayList();
        EnumChatFormatting[] arrenumChatFormatting = EnumChatFormatting.values();
        int n = arrenumChatFormatting.length;
        int n2 = a = 0;
        while (n2 < n) {
            void a2;
            EnumChatFormatting enumChatFormatting = arrenumChatFormatting[a];
            if (!(enumChatFormatting.isColor() && !bl3 || enumChatFormatting.isFancyStyling() && a2 == false)) {
                arrayList.add(enumChatFormatting.getFriendlyName());
            }
            n2 = ++a;
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ EnumChatFormatting(String varnull, char varnull, boolean var3_2, int var4_3) {
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

    public boolean isFancyStyling() {
        EnumChatFormatting a;
        return a.fancyStyling;
    }

    public boolean isColor() {
        EnumChatFormatting a;
        return !a.fancyStyling && a != RESET;
    }

    static {
        int n;
        BLACK = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0003J\u0007L\u0004"), 0, CrystalUtil.ALLATORIxDEMO("\u001ff\u001b`\u0018"), '0', 0);
        DARK_BLUE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0018]\u000eJ\u001eD\nZ\n"), 1, CrystalUtil.ALLATORIxDEMO("\u0004q\u0012f\u0002h\u0016v\u0016"), '1', 1);
        DARK_GREEN = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("X\u001dN\u0017^\u0006T\u0003J\u0001"), 2, CrystalUtil.ALLATORIxDEMO("t\u0001b\u000br\u001ax\u001ff\u001d"), '2', 2);
        DARK_AQUA = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0018]\u000eJ\u001eG\u0017Z\u000e"), 3, CrystalUtil.ALLATORIxDEMO("\u0004q\u0012f\u0002k\u000bv\u0012"), '3', 3);
        DARK_RED = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("X\u001dS\nY\u0014J\u000b"), 4, CrystalUtil.ALLATORIxDEMO("t\u0001\u0016u\bf\u0017"), '4', 4);
        DARK_PURPLE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\r]\u000eW\u0003Q\u0014T\u0016C\n"), 5, CrystalUtil.ALLATORIxDEMO("\u0011q\u0012{\u001f}\bx\no\u0016"), '5', 5);
        GOLD = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("A\tC\u000b"), 6, CrystalUtil.ALLATORIxDEMO("m\u0015o\u0017"), '6', 6);
        GRAY = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("A\u0014N\u0016"), 7, CrystalUtil.ALLATORIxDEMO("m\bb\n"), '7', 7);
        DARK_GRAY = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0018]\u000eJ\u001eA\u0014N\u0016"), 8, CrystalUtil.ALLATORIxDEMO("\u0004q\u0012f\u0002m\bb\n"), '8', 8);
        BLUE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("D\nZ\n"), 9, CrystalUtil.ALLATORIxDEMO("h\u0016v\u0016"), '9', 9);
        GREEN = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0006T\u0003J\u0001"), 10, CrystalUtil.ALLATORIxDEMO("\u001ax\u001ff\u001d"), 'a', 10);
        AQUA = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("G\u0017Z\u000e"), 11, CrystalUtil.ALLATORIxDEMO("k\u000bv\u0012"), 'b', 11);
        RED = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0014J\u000b"), 12, CrystalUtil.ALLATORIxDEMO("\bf\u0017"), 'c', 12);
        LIGHT_PURPLE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("E\u0000[\u0014H\u0003Q\u0014T\u0016C\n"), 13, CrystalUtil.ALLATORIxDEMO("i\u001cw\bd\u001f}\bx\no\u0016"), 'd', 13);
        YELLOW = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("X\u0004J\n@\u0018"), 14, CrystalUtil.ALLATORIxDEMO("t\u0018f\u0016l\u0004"), 'e', 14);
        WHITE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0016N\u000f[\n"), 15, CrystalUtil.ALLATORIxDEMO("\nb\u0013w\u0016"), 'f', 15);
        OBFUSCATED = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("S\u001eZ\tR\u0002G\u0012J\u000b"), 16, CrystalUtil.ALLATORIxDEMO("\u0002v\u0015~\u001ek\u000ef\u0017"), 'k', true);
        BOLD = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("D\tC\u000b"), 17, CrystalUtil.ALLATORIxDEMO("h\u0015o\u0017"), 'l', true);
        STRIKETHROUGH = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0016]\u001bU\u0017Y\bI\u0013I\u0013H\u0007"), 18, CrystalUtil.ALLATORIxDEMO("\nq\u0007y\u000bu\u0014e\u000fe\u000fd\u001b"), 'm', true);
        UNDERLINE = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\tR\u0018D\u0013J\u000fA\n"), 19, CrystalUtil.ALLATORIxDEMO("\u0015~\u0004h\u000ff\u0013m\u0016"), 'n', true);
        ITALIC = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("H\u0015G\nF\f"), 20, CrystalUtil.ALLATORIxDEMO("d\tk\u0016j\u0010"), 'o', true);
        RESET = new EnumChatFormatting(NpSocketClient.ALLATORIxDEMO("\u0013C\u0015J\u001b"), 21, CrystalUtil.ALLATORIxDEMO("\u000fo\tf\u0007"), 'r', -1);
        $VALUES = EnumChatFormatting.$values();
        nameMapping = Maps.newHashMap();
        formattingCodePattern = Pattern.compile(NpSocketClient.ALLATORIxDEMO("o%3,\u00e2Ry1e]qG\n+\t]\u0012"));
        EnumChatFormatting[] arrenumChatFormatting = EnumChatFormatting.values();
        int n2 = arrenumChatFormatting.length;
        int n3 = n = 0;
        while (n3 < n2) {
            EnumChatFormatting enumChatFormatting = arrenumChatFormatting[n];
            nameMapping.put(EnumChatFormatting.func_175745_c(enumChatFormatting.name), enumChatFormatting);
            n3 = ++n;
        }
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ EnumChatFormatting(String varnull, char varnull, int var3_2) {
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

    public static EnumChatFormatting[] values() {
        return (EnumChatFormatting[])$VALUES.clone();
    }

    public int getColorIndex() {
        EnumChatFormatting a;
        return a.colorIndex;
    }

    public static EnumChatFormatting valueOf(String a) {
        return Enum.valueOf(EnumChatFormatting.class, a);
    }

    private static /* synthetic */ EnumChatFormatting[] $values() {
        EnumChatFormatting[] arrenumChatFormatting = new EnumChatFormatting[22];
        arrenumChatFormatting[0] = BLACK;
        arrenumChatFormatting[1] = DARK_BLUE;
        arrenumChatFormatting[2] = DARK_GREEN;
        arrenumChatFormatting[3] = DARK_AQUA;
        arrenumChatFormatting[4] = DARK_RED;
        arrenumChatFormatting[5] = DARK_PURPLE;
        arrenumChatFormatting[6] = GOLD;
        arrenumChatFormatting[7] = GRAY;
        arrenumChatFormatting[8] = DARK_GRAY;
        arrenumChatFormatting[9] = BLUE;
        arrenumChatFormatting[10] = GREEN;
        arrenumChatFormatting[11] = AQUA;
        arrenumChatFormatting[12] = RED;
        arrenumChatFormatting[13] = LIGHT_PURPLE;
        arrenumChatFormatting[14] = YELLOW;
        arrenumChatFormatting[15] = WHITE;
        arrenumChatFormatting[16] = OBFUSCATED;
        arrenumChatFormatting[17] = BOLD;
        arrenumChatFormatting[18] = STRIKETHROUGH;
        arrenumChatFormatting[19] = UNDERLINE;
        arrenumChatFormatting[20] = ITALIC;
        arrenumChatFormatting[21] = RESET;
        return arrenumChatFormatting;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ EnumChatFormatting(String varnull, char varnull, boolean var3_2) {
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

    public String getFriendlyName() {
        EnumChatFormatting a;
        return a.name().toLowerCase();
    }

    private static /* synthetic */ String func_175745_c(String a) {
        return a.toLowerCase().replaceAll(CrystalUtil.ALLATORIxDEMO("v\u0003KwY\u000e"), "");
    }

    public static EnumChatFormatting func_175744_a(int a) {
        int n = a;
        if (n < 0) {
            return RESET;
        }
        EnumChatFormatting[] arrenumChatFormatting = EnumChatFormatting.values();
        int n2 = arrenumChatFormatting.length;
        int n3 = a = 0;
        while (n3 < n2) {
            EnumChatFormatting enumChatFormatting = arrenumChatFormatting[a];
            if (enumChatFormatting.getColorIndex() == n) {
                return enumChatFormatting;
            }
            n3 = ++a;
        }
        return null;
    }
}
