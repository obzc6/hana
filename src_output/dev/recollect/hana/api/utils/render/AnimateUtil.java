/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package dev.recollect.hana.api.utils.render;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_310;
import org.bytedeco.javacv.BufferRing;
import org.bytedeco.javacv.FrameConverter;

public class AnimateUtil
implements Wrapper {
    public static double normal(double a, double a2, double a3) {
        boolean bl = a2 > a;
        a3 *= 10.0;
        if (Math.abs(Math.max(a2, a) - Math.min(a2, a)) <= a3) {
            return a2;
        }
        return a + (bl ? a3 : -a3);
    }

    /*
     * Exception decompiling
     */
    public static double animate(double a, double a, double a, AnimMode a) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 2[CASE]
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

    public static double animate(double a, double a2, double a3) {
        if (a3 >= 1.0) {
            return a2;
        }
        if (a3 == 0.0) {
            return a;
        }
        return AnimateUtil.thunder(a, a2, a3);
    }

    public static double my(double a, double a2, double a3) {
        double d;
        int n;
        if (Math.max(a2, a) - Math.min(a2, a) < 0.001) {
            return a2;
        }
        int n2 = n = a3 < 0.0 ? -1 : 1;
        if (n == -1) {
            a3 *= -1.0;
        }
        a3 = (a2 -= a) * (double)mc.method_1488() * a3;
        if (a2 < 0.0 && a3 < a2) {
            a3 = a2;
            d = a;
        } else {
            if (a2 > 0.0 && a3 >= a2) {
                a3 = a2;
            }
            d = a;
        }
        return d + a3 * (double)n;
    }

    public static double mio(double a, double a2, double a3) {
        double d;
        int n;
        if (Math.max(a2, a) - Math.min(a2, a) < 0.001) {
            return a2;
        }
        int n2 = n = a3 < 0.0 ? -1 : 1;
        if (n == -1) {
            a3 *= -1.0;
        }
        a3 = (a2 -= a) * (double)mc.method_1488() / (1.0 / a3 * (Math.min(240.0, (double)Hana.FPS.getFps()) / 240.0));
        if (a2 < 0.0 && a3 < a2) {
            a3 = a2;
            d = a;
        } else {
            if (a2 > 0.0 && a3 >= a2) {
                a3 = a2;
            }
            d = a;
        }
        return d + a3 * (double)n;
    }

    public static double old(double a, double a2, double a3) {
        double d;
        int n;
        if (Math.max(a2, a) - Math.min(a2, a) < 0.001) {
            return a2;
        }
        int n2 = n = a3 < 0.0 ? -1 : 1;
        if (n == -1) {
            a3 *= -1.0;
        }
        a3 = (a2 -= a) * a3;
        if (a2 < 0.0 && a3 < a2) {
            a3 = a2;
            d = a;
        } else {
            if (a2 > 0.0 && a3 >= a2) {
                a3 = a2;
            }
            d = a;
        }
        return d + a3 * (double)n;
    }

    public AnimateUtil() {
        AnimateUtil a;
    }

    public static double thunder(double a, double a2, double a3) {
        double d;
        boolean bl = a2 > a;
        double d2 = Math.max(a2, a) - Math.min(a2, a);
        if (Math.abs(d) <= 0.001) {
            return a2;
        }
        a2 = d2 * a3;
        return a + (bl ? a2 : -a2);
    }

    public static final class AnimMode
    extends Enum<AnimMode> {
        public static final /* enum */ AnimMode Mio;
        private static final /* synthetic */ AnimMode[] $VALUES;
        public static final /* enum */ AnimMode Old;
        public static final /* enum */ AnimMode My;
        public static final /* enum */ AnimMode None;
        public static final /* enum */ AnimMode Normal;
        public static final /* enum */ AnimMode Thunder;

        public static AnimMode valueOf(String a) {
            return Enum.valueOf(AnimMode.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ AnimMode() {
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

        private static /* synthetic */ AnimMode[] $values() {
            AnimMode[] arranimMode = new AnimMode[6];
            arranimMode[0] = Thunder;
            arranimMode[1] = Mio;
            arranimMode[2] = My;
            arranimMode[3] = Old;
            arranimMode[4] = Normal;
            arranimMode[5] = None;
            return arranimMode;
        }

        static {
            Thunder = new AnimMode(BufferRing.ALLATORIxDEMO(".!\b:\u0004{X"), 0);
            Mio = new AnimMode(FrameConverter.ALLATORIxDEMO("AL)"), 1);
            My = new AnimMode(BufferRing.ALLATORIxDEMO("SS"), 2);
            Old = new AnimMode(FrameConverter.ALLATORIxDEMO("CI\""), 3);
            Normal = new AnimMode(BufferRing.ALLATORIxDEMO("\u0007\u0012&\rF"), 4);
            None = new AnimMode(FrameConverter.ALLATORIxDEMO("!cK#"), 5);
            $VALUES = AnimMode.$values();
        }

        public static AnimMode[] values() {
            return (AnimMode[])$VALUES.clone();
        }
    }

}
