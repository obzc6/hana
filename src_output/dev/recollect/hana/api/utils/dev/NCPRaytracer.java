/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2404
 *  net.minecraft.class_243
 *  net.minecraft.class_2510
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2404;
import net.minecraft.class_243;
import net.minecraft.class_2510;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class NCPRaytracer {
    public static boolean raytrace(class_243 a, class_243 a2, class_238 a3) {
        class_243 class_2432 = a;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        float f = a = 0.0f;
        while (f < 1.0f) {
            double d;
            double d2;
            class_243 class_2433 = class_2432;
            double d3 = NCPRaytracer.lerp(class_2433.field_1352, a2.field_1352, a);
            if (a3.method_1008(d3, d2 = NCPRaytracer.lerp(class_2433.field_1351, a2.field_1351, a), d = NCPRaytracer.lerp(class_2433.field_1350, a2.field_1350, a))) {
                return true;
            }
            int n4 = (int)Math.floor(d3);
            int n5 = (int)Math.floor(d2);
            int n6 = (int)Math.floor(d);
            if (n != n4 || n2 != n5 || n3 != n6) {
                class_2338 class_23382;
                class_2338 class_23383 = class_23382 = new class_2338(n4, n5, n6);
                if (NCPRaytracer.validForCheck(class_23383, Wrapper.mc.field_1687.method_8320(class_23383))) {
                    return false;
                }
            }
            n = n4;
            n2 = n5;
            n3 = n6;
            f = (float)((double)a + 0.001);
        }
        return false;
    }

    public NCPRaytracer() {
        NCPRaytracer a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
        (3 ^ 5) << 4;
        int n4 = 4 << 4 ^ 2 << 1;
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

    public static boolean validForCheck(class_2338 class_23382, class_2680 class_26802) {
        class_2338 a = class_26802;
        class_2338 a2 = class_23382;
        if (a.method_51367()) {
            return true;
        }
        if (a.method_26204() instanceof class_2404) {
            return false;
        }
        if (a.method_26204() instanceof class_2510) {
            return false;
        }
        if (a.method_31709()) {
            return false;
        }
        return a.method_26234((class_1922)Wrapper.mc.field_1687, a2);
    }

    private static /* synthetic */ double lerp(double a, double a2, double a3) {
        double d = a;
        return d + (a2 - d) * a3;
    }
}
