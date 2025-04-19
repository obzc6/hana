/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import org.bytedeco.javacv.BaseSettings;

public abstract class Easing
extends Enum<Easing> {
    public static final /* enum */ Easing CircOut;
    public static final /* enum */ Easing Expo;
    public static final /* enum */ Easing QuadIn;
    public static final /* enum */ Easing QuintIn;
    public static final /* enum */ Easing QuartOut;
    private static final /* synthetic */ Easing[] $VALUES;
    public static final /* enum */ Easing CubicIn;
    public static final /* enum */ Easing CubicOut;
    public static final /* enum */ Easing QuintInOut;
    public static final /* enum */ Easing CircInOut;
    public static final /* enum */ Easing QuintOut;
    public static final /* enum */ Easing CubicInOut;
    public static final /* enum */ Easing SineOut;
    public static final /* enum */ Easing QuartIn;
    public static final /* enum */ Easing Linear;
    public static final /* enum */ Easing BackInOut;
    public static final /* enum */ Easing Bounce;
    public static final /* enum */ Easing CircIn;
    public static final /* enum */ Easing BackOut;
    public static final /* enum */ Easing QuadInOut;
    public static final /* enum */ Easing SineInOut;
    public static final /* enum */ Easing QuartInOut;
    public static final /* enum */ Easing QuadOut;

    /*
     * Exception decompiling
     */
    private /* synthetic */ Easing() {
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

    private static /* synthetic */ Easing[] $values() {
        Easing[] arreasing = new Easing[22];
        arreasing[0] = Linear;
        arreasing[1] = SineOut;
        arreasing[2] = SineInOut;
        arreasing[3] = CubicIn;
        arreasing[4] = CubicOut;
        arreasing[5] = CubicInOut;
        arreasing[6] = QuadIn;
        arreasing[7] = QuadOut;
        arreasing[8] = QuadInOut;
        arreasing[9] = QuartIn;
        arreasing[10] = QuartOut;
        arreasing[11] = QuartInOut;
        arreasing[12] = QuintIn;
        arreasing[13] = QuintOut;
        arreasing[14] = QuintInOut;
        arreasing[15] = CircIn;
        arreasing[16] = CircOut;
        arreasing[17] = CircInOut;
        arreasing[18] = Expo;
        arreasing[19] = BackOut;
        arreasing[20] = BackInOut;
        arreasing[21] = Bounce;
        return arreasing;
    }

    static {
        Linear = new Easing(BaseSettings.ALLATORIxDEMO("|lYg_y"), 0){
            {
                int a = n;
                1 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                return a;
            }
        };
        SineOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("~<D-xw\t"), 1){
            {
                int a = n;
                2 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                return Math.sin(a * 3.141592653589793 / 2.0);
            }
        };
        SineInOut = new Easing(BaseSettings.ALLATORIxDEMO("^CqULYMK"), 2){
            {
                int a = n;
                3 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                return -(Math.cos(3.141592653589793 * a) - 1.0) / 2.0;
            }
        };
        CubicIn = new Easing(OLEPOSSUtils.ALLATORIxDEMO("n H!TK\u0013"), 3){

            @Override
            public double ease(double a) {
                return Math.pow(a, 3.0);
            }
            {
                int a = n;
                4 var2_4 = this;
            }
        };
        CubicOut = new Easing(BaseSettings.ALLATORIxDEMO("ijRlTMK"), 4){

            @Override
            public double ease(double a) {
                return 1.0 - Math.pow(1.0 - a, 3.0);
            }
            {
                int a = n;
                5 var2_4 = this;
            }
        };
        CubicInOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("\u0016_0D6c&xw\t"), 5){

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return 4.0 * Math.pow(a, 3.0);
                }
                return 1.0 - Math.pow(-2.0 * a + 2.0, 3.0) / 2.0;
            }
            {
                int a = n;
                6 var2_4 = this;
            }
        };
        QuadIn = new Easing(BaseSettings.ALLATORIxDEMO("apVfwe"), 6){

            @Override
            public double ease(double a) {
                return Math.pow(a, 2.0);
            }
            {
                int a = n;
                7 var2_4 = this;
            }
        };
        QuadOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("| K,xw\t"), 7){

            @Override
            public double ease(double a) {
                return 1.0 - (1.0 - a) * (1.0 - a);
            }
            {
                int a = n;
                8 var2_4 = this;
            }
        };
        QuadInOut = new Easing(BaseSettings.ALLATORIxDEMO("\\_~TLYMK"), 8){
            {
                int a = n;
                9 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return 8.0 * Math.pow(a, 4.0);
                }
                return 1.0 - Math.pow(-2.0 * a + 2.0, 4.0) / 2.0;
            }
        };
        QuartIn = new Easing(OLEPOSSUtils.ALLATORIxDEMO("| K:CK\u0013"), 9){
            {
                int a = n;
                10 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                return Math.pow(a, 4.0);
            }
        };
        QuartOut = new Easing(BaseSettings.ALLATORIxDEMO("{jQwCMK"), 10){

            @Override
            public double ease(double a) {
                return 1.0 - Math.pow(1.0 - a, 4.0);
            }
            {
                int a = n;
                11 var2_4 = this;
            }
        };
        QuartInOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("\u0004_3_!c&xw\t"), 11){
            {
                int a = n;
                12 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return 8.0 * Math.pow(a, 4.0);
                }
                return 1.0 - Math.pow(-2.0 * a + 2.0, 4.0) / 2.0;
            }
        };
        QuintIn = new Easing(BaseSettings.ALLATORIxDEMO("NElYvwe"), 12){

            @Override
            public double ease(double a) {
                return Math.pow(a, 5.0);
            }
            {
                int a = n;
                13 var2_4 = this;
            }
        };
        QuintOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("\u0003X<D<xw\t"), 13){
            {
                int a = n;
                14 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                return 1.0 - Math.pow(1.0 - a, 5.0);
            }
        };
        QuintInOut = new Easing(BaseSettings.ALLATORIxDEMO("ixCqDLYMK"), 14){

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return 16.0 * Math.pow(a, 5.0);
                }
                return 1.0 - Math.pow(-2.0 * a + 2.0, 5.0) / 2.0;
            }
            {
                int a = n;
                15 var2_4 = this;
            }
        };
        CircIn = new Easing(OLEPOSSUtils.ALLATORIxDEMO("\u0016C:TK\u0013"), 15){

            @Override
            public double ease(double a) {
                return 1.0 - Math.sqrt(1.0 - Math.pow(a, 2.0));
            }
            {
                int a = n;
                16 var2_4 = this;
            }
        };
        CircOut = new Easing(BaseSettings.ALLATORIxDEMO("\\YwTMK"), 16){

            @Override
            public double ease(double a) {
                return Math.sqrt(1.0 - Math.pow(a - 1.0, 2.0));
            }
            {
                int a = n;
                17 var2_4 = this;
            }
        };
        CircInOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("i;_6c&xw\t"), 17){

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * a, 2.0))) / 2.0;
                }
                return (Math.sqrt(1.0 - Math.pow(-2.0 * a + 2.0, 2.0)) + 1.0) / 2.0;
            }
            {
                int a = n;
                18 var2_4 = this;
            }
        };
        Expo = new Easing(BaseSettings.ALLATORIxDEMO("rzNd"), 18){

            @Override
            public double ease(double a) {
                if (a == 0.0) {
                    return 0.0;
                }
                if (a == 1.0) {
                    return 1.0;
                }
                if (a < 0.5) {
                    return Math.pow(2.0, 20.0 * a - 10.0) / 2.0;
                }
                return (2.0 - Math.pow(2.0, -20.0 * a + 10.0)) / 2.0;
            }
            {
                int a = n;
                19 var2_4 = this;
            }
        };
        BackOut = new Easing(OLEPOSSUtils.ALLATORIxDEMO("o4I#xw\t"), 19){

            @Override
            public double ease(double a) {
                double d = 1.70158;
                double d2 = 1.70158 + 1.0;
                return 1.0 + d2 * Math.pow(a - 1.0, 3.0) + d * Math.pow(a - 1.0, 2.0);
            }
            {
                int a = n;
                20 var2_4 = this;
            }
        };
        BackInOut = new Easing(BaseSettings.ALLATORIxDEMO("OK|[LYMK"), 20){
            {
                int a = n;
                21 var2_4 = this;
            }

            @Override
            public double ease(double a) {
                if (a < 0.5) {
                    return Math.pow(2.0 * a, 2.0) * (7.189819 * a - 2.5949095) / 2.0;
                }
                return (Math.pow(2.0 * a - 2.0, 2.0) * (3.5949095 * (a * 2.0 - 2.0) + 2.5949095) + 2.0) / 2.0;
            }
        };
        Bounce = new Easing(OLEPOSSUtils.ALLATORIxDEMO("\u0017E=Ya\u0018"), 21){

            @Override
            public double ease(double a) {
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
            {
                int a = n;
                22 var2_4 = this;
            }
        };
        $VALUES = Easing.$values();
    }

    public static Easing valueOf(String a) {
        return Enum.valueOf(Easing.class, a);
    }

    public static Easing[] values() {
        return (Easing[])$VALUES.clone();
    }

    public abstract double ease(double var1);

}
