/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2189
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2404
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_4770
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.dev.hole;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.asm.mixins.AbstractBlockAccessor;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2189;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2404;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_4770;
import net.minecraft.class_638;

public class OLEPOSSUtils {
    public static class_238 getCrystalBox(class_243 a) {
        return new class_238(a.method_10216() - 1.0, a.method_10214(), a.method_10215() - 1.0, a.method_10216() + 1.0, a.method_10214() + 2.0, a.method_10215() + 1.0);
    }

    public static class_238 getCrystalBox(class_2338 a) {
        return new class_238((double)a.method_10263() - 0.5, (double)a.method_10264(), (double)a.method_10260() - 0.5, (double)a.method_10263() + 1.5, (double)(a.method_10264() + 2), (double)a.method_10260() + 1.5);
    }

    /*
     * WARNING - void declaration
     */
    public static class_243 getClosest(class_243 class_2432, class_243 class_2433, double d, double d2) {
        void a;
        void a2;
        class_243 a3 = class_2433;
        class_243 a4 = class_2432;
        return new class_243(Math.min(Math.max(a4.field_1352, a3.field_1352 - a / 2.0), a3.field_1352 + a / 2.0), Math.min(Math.max(a4.field_1351, a3.field_1351), a3.field_1351 + a2), Math.min(Math.max(a4.field_1350, a3.field_1350 - a / 2.0), a3.field_1350 + a / 2.0));
    }

    public static boolean solid2(class_2338 a) {
        return Wrapper.mc.field_1687.method_8320(a).method_51367();
    }

    public static boolean collidable(class_2338 a) {
        return ((AbstractBlockAccessor)Wrapper.mc.field_1687.method_8320(a).method_26204()).isCollidable();
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 3 ^ 4;
        (2 ^ 5) << 4 ^ 3 << 1;
        int n4 = 4 << 4 ^ 3;
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

    public static boolean isGapple(class_1799 a) {
        return OLEPOSSUtils.isGapple(a.method_7909());
    }

    /*
     * Exception decompiling
     */
    public static boolean strictDir(class_2338 var0, class_2350 var1_7) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[DOLOOP]], but top level block is 1[CASE]
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

    public static class_243 getMiddle(class_238 a) {
        return new class_243((a.field_1323 + a.field_1320) / 2.0, (a.field_1322 + a.field_1325) / 2.0, (a.field_1321 + a.field_1324) / 2.0);
    }

    public static boolean solid(class_2338 a) {
        class_2338 class_23382 = a;
        a = Wrapper.mc.field_1687.method_8320(class_23382).method_26204();
        return !(a instanceof class_4770) && !(a instanceof class_2404) && !(a instanceof class_2189);
    }

    public OLEPOSSUtils() {
        OLEPOSSUtils a;
    }

    public static boolean isGapple(class_1792 a) {
        return a == class_1802.field_8463 || a == class_1802.field_8367;
    }

    public static boolean inside(class_1657 class_16572, class_238 class_2382) {
        class_1657 a = class_2382;
        class_1657 a2 = class_16572;
        return Wrapper.mc.field_1687 != null && Wrapper.mc.field_1687.method_20812((class_1297)a2, (class_238)a).iterator().hasNext();
    }

    public static int closerToZero(int a) {
        return (int)((float)a - Math.signum(a));
    }

}
