/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.math.Easing;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.socket.network.info.record.UserInfo;

public class FadeUtils {
    public long length;
    private long start;

    public double easeCubicOut() {
        FadeUtils a;
        double d = a.getFadeOne();
        return 1.0 - Math.pow(1.0 - d, 3.0);
    }

    public double easeCubicInOut() {
        double d;
        FadeUtils a;
        double d2 = a.getFadeOne();
        if (d < 0.5) {
            return 4.0 * Math.pow(d2, 3.0);
        }
        return 1.0 - Math.pow(-2.0 * d2 + 2.0, 3.0) / 2.0;
    }

    public double easeCubicIn() {
        FadeUtils a;
        return Math.pow(a.getFadeOne(), 3.0);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5;
        5 << 3 ^ (3 ^ 5);
        int n4 = 5 << 4 ^ 2 << 1;
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

    /*
     * Exception decompiling
     */
    public double ease(Ease var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[DOLOOP]], but top level block is 9[CASE]
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

    public double getFadeOne() {
        FadeUtils a;
        if (a.isEnd()) {
            return 1.0;
        }
        return (double)a.getTime() / (double)a.length;
    }

    public boolean isEnd() {
        FadeUtils a;
        return a.getTime() >= a.length;
    }

    public double getFadeOutDefault() {
        FadeUtils a;
        return 1.0 - Math.tanh((double)a.getTime() / (double)a.length * 3.0);
    }

    public double getEpsEzFadeIn() {
        FadeUtils a;
        return 1.0 - Math.sin(1.5707963267948966 * a.getFadeOne()) * Math.sin(2.5132741228718345 * a.getFadeOne());
    }

    public static double easeOutBounce(double a) {
        if (a < 0.36363636363636365) {
            return 7.5625 * a * a;
        }
        if (a < 0.7272727272727273) {
            return 7.5625 * (a -= 0.5454545454545454) * a + 0.75;
        }
        if (a < 0.9090909090909091) {
            return 7.5625 * (a -= 0.8181818181818182) * a + 0.9375;
        }
        return 7.5625 * (a -= 0.9545454545454546) * a + 0.984375;
    }

    public double ease(Easing easing) {
        Easing a = easing;
        FadeUtils a2 = this;
        return a.ease(a2.getFadeOne());
    }

    public void setLength(long a) {
        a.length = a;
    }

    /*
     * Exception decompiling
     */
    public double getQuad(Quad var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
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

    public double easeOutQuint() {
        FadeUtils a;
        return 1.0 - (1.0 - a.getFadeOne()) * (1.0 - a.getFadeOne()) * (1.0 - a.getFadeOne()) * (1.0 - a.getFadeOne());
    }

    public double getFadeInDefault() {
        FadeUtils a;
        return Math.tanh((double)a.getTime() / (double)a.length * 3.0);
    }

    public FadeUtils(long a) {
        FadeUtils a2;
        FadeUtils fadeUtils = a2;
        fadeUtils.length = a;
        fadeUtils.reset();
    }

    public double easeInQuad() {
        FadeUtils a;
        return a.getFadeOne() * a.getFadeOne();
    }

    protected long getTime() {
        FadeUtils a;
        return System.currentTimeMillis() - a.start;
    }

    public double easeOutQuad() {
        FadeUtils a;
        return 1.0 - (1.0 - a.getFadeOne()) * (1.0 - a.getFadeOne());
    }

    public FadeUtils reset() {
        FadeUtils a;
        a.start = System.currentTimeMillis();
        return a;
    }

    public double getEpsEzFadeOut() {
        FadeUtils a;
        return Math.sin(1.5707963267948966 * a.getFadeOne()) * Math.sin(2.5132741228718345 * a.getFadeOne());
    }

    public double easeInQuintQuad() {
        FadeUtils a;
        return a.getFadeOne() * a.getFadeOne() * a.getFadeOne() * a.getFadeOne();
    }

    public static final class Ease
    extends Enum<Ease> {
        public static final /* enum */ Ease Normal;
        public static final /* enum */ Ease OutQuint;
        public static final /* enum */ Ease Slow;
        private static final /* synthetic */ Ease[] $VALUES;
        public static final /* enum */ Ease CUBIC_IN_OUT;
        public static final /* enum */ Ease Out;
        public static final /* enum */ Ease In2;
        public static final /* enum */ Ease InQuint;
        public static final /* enum */ Ease CUBIC_OUT;
        public static final /* enum */ Ease CUBIC_IN;
        public static final /* enum */ Ease Fast;
        public static final /* enum */ Ease In;
        public static final /* enum */ Ease Bounce;

        static {
            Bounce = new Ease(UserInfo.ALLATORIxDEMO("!)\u0004:\u0004'"), 0);
            CUBIC_OUT = new Ease(ProjectionUtils.ALLATORIxDEMO("eT\u0005l h>t3"), 1);
            CUBIC_IN = new Ease(UserInfo.ALLATORIxDEMO("\u00047!\u000f2\u000b.\f"), 2);
            CUBIC_IN_OUT = new Ease(ProjectionUtils.ALLATORIxDEMO("t$\"oB\u0018l-h>t3"), 3);
            Fast = new Ease(UserInfo.ALLATORIxDEMO("75\u00146"), 4);
            In = new Ease(ProjectionUtils.ALLATORIxDEMO("h\t"), 5);
            In2 = new Ease(UserInfo.ALLATORIxDEMO("\u001d\tp"), 6);
            InQuint = new Ease(ProjectionUtils.ALLATORIxDEMO("\u000eK2B\u0018O\u0013"), 7);
            Normal = new Ease(UserInfo.ALLATORIxDEMO("-)\u00039\u0006."), 8);
            Out = new Ease(ProjectionUtils.ALLATORIxDEMO(">T\u0013"), 9);
            OutQuint = new Ease(UserInfo.ALLATORIxDEMO("\b\u0017\u0017\u0017\u0004=\t6"), 10);
            Slow = new Ease(ProjectionUtils.ALLATORIxDEMO("d\u001dN\u0010"), 11);
            $VALUES = Ease.$values();
        }

        public static Ease[] values() {
            return (Ease[])$VALUES.clone();
        }

        private static /* synthetic */ Ease[] $values() {
            Ease[] arrease = new Ease[12];
            arrease[0] = Bounce;
            arrease[1] = CUBIC_OUT;
            arrease[2] = CUBIC_IN;
            arrease[3] = CUBIC_IN_OUT;
            arrease[4] = Fast;
            arrease[5] = In;
            arrease[6] = In2;
            arrease[7] = InQuint;
            arrease[8] = Normal;
            arrease[9] = Out;
            arrease[10] = OutQuint;
            arrease[11] = Slow;
            return arrease;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Ease() {
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

        public static Ease valueOf(String a) {
            return Enum.valueOf(Ease.class, a);
        }
    }

    public static final class Quad
    extends Enum<Quad> {
        public static final /* enum */ Quad In = new Quad(RadiusUtils.ALLATORIxDEMO("*Y"), 0);
        private static final /* synthetic */ Quad[] $VALUES;
        public static final /* enum */ Quad Out;
        public static final /* enum */ Quad In2;

        /*
         * Exception decompiling
         */
        private /* synthetic */ Quad() {
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

        static {
            In2 = new Quad(BetterDynamicAnimation.ALLATORIxDEMO("[M%"), 1);
            Out = new Quad(RadiusUtils.ALLATORIxDEMO("2\u0016C"), 2);
            $VALUES = Quad.$values();
        }

        public static Quad valueOf(String a) {
            return Enum.valueOf(Quad.class, a);
        }

        private static /* synthetic */ Quad[] $values() {
            Quad[] arrquad = new Quad[3];
            arrquad[0] = In;
            arrquad[1] = In2;
            arrquad[2] = Out;
            return arrquad;
        }

        public static Quad[] values() {
            return (Quad[])$VALUES.clone();
        }
    }

}
