/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 */
package dev.recollect.hana.api.utils.dev.hole;

import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.xibao.SnowAnimation;
import java.util.Arrays;
import net.minecraft.class_2338;
import net.minecraft.class_243;

public class Hole {
    public final HoleType type;
    public final class_243 middle;
    public final class_2338 pos;
    public final class_2338[] positions;

    /*
     * Exception decompiling
     */
    public Hole(class_2338 var1_1, HoleType var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 1[CASE]
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

    public String toString() {
        Hole a;
        return "Hole{pos=" + String.valueOf((Object)a.pos) + ", type=" + String.valueOf((Object)a.type) + ", positions=" + Arrays.toString((Object[])a.positions) + ", middle=" + String.valueOf((Object)a.middle) + "}";
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 2 << 3 ^ (2 ^ 5);
        5 << 4 ^ 5 << 1;
        int n4 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public class_2338[] positions() {
        Hole a;
        return a.positions;
    }

    public HoleType getType() {
        Hole a;
        return a.type;
    }

    public static final class HoleType
    extends Enum<HoleType> {
        public static final /* enum */ HoleType DoubleX;
        public static final /* enum */ HoleType DoubleZ;
        private static final /* synthetic */ HoleType[] $VALUES;
        public static final /* enum */ HoleType NotHole;
        public static final /* enum */ HoleType Single;
        public static final /* enum */ HoleType Quad;

        public static HoleType[] values() {
            return (HoleType[])$VALUES.clone();
        }

        public static HoleType valueOf(String a) {
            return Enum.valueOf(HoleType.class, a);
        }

        private static /* synthetic */ HoleType[] $values() {
            HoleType[] arrholeType = new HoleType[5];
            arrholeType[0] = NotHole;
            arrholeType[1] = Single;
            arrholeType[2] = DoubleX;
            arrholeType[3] = DoubleZ;
            arrholeType[4] = Quad;
            return arrholeType;
        }

        static {
            NotHole = new HoleType(SnowAnimation.ALLATORIxDEMO("\u0018J\u000fd\u001dU\u0002"), 0);
            Single = new HoleType(ProjectionUtils.ALLATORIxDEMO("n\u0012Z\u0015M\u0002"), 1);
            DoubleX = new HoleType(SnowAnimation.ALLATORIxDEMO("\u0012J\u000eN\u001e\\?"), 2);
            DoubleZ = new HoleType(ProjectionUtils.ALLATORIxDEMO("\u0012R\u000eV\u001eD="), 3);
            Quad = new HoleType(SnowAnimation.ALLATORIxDEMO("}\u0007X\u0003"), 4);
            $VALUES = HoleType.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ HoleType() {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}
