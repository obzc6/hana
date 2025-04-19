/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2189
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_1297;
import net.minecraft.class_2189;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class CrystalUtil {
    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ 2 << 1;
        (3 ^ 5) << 3;
        int n4 = (3 ^ 5) << 3 ^ 4;
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

    public CrystalUtil() {
        CrystalUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static class_243 getMotionVec(class_1297 class_12972, int n, boolean bl) {
        void a;
        class_1297 a2;
        int a3 = bl;
        class_1297 class_12973 = a2 = class_12972;
        double d = a2.method_23317() - class_12973.field_6014;
        double d2 = class_12973.method_23321() - a2.field_5969;
        double d3 = 0.0;
        double d4 = 0.0;
        if (a3 != 0) {
            int n2 = a3 = 1;
            while (n2 <= a && Wrapper.mc.field_1687.method_8320(new class_2338((int)((double)a2.method_31477() + d * (double)a3), a2.method_31477(), (int)((double)a2.method_31479() + d2 * (double)a3))).method_26204() instanceof class_2189) {
                d3 = d * (double)a3;
                d4 = d2 * (double)a3++;
                n2 = a3;
            }
        } else {
            d3 = d * (double)a;
            d4 = d2 * (double)a;
        }
        return new class_243(d3, 0.0, d4);
    }
}
