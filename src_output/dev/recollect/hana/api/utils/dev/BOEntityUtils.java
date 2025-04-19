/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class BOEntityUtils {
    public static boolean isBlockLag(class_1657 a) {
        return BOEntityUtils.doesBoxTouchBlock(a.method_5829(), class_2246.field_10540);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ 3;
        2 << 3 ^ 1;
        int n4 = 5 << 4 ^ (3 << 2 ^ 3);
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

    public static boolean isWebbed(class_1657 a) {
        return BOEntityUtils.doesBoxTouchBlock(a.method_5829(), class_2246.field_10343);
    }

    public BOEntityUtils() {
        BOEntityUtils a;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean doesBoxTouchBlock(class_238 class_2382, boolean bl) {
        int n;
        class_238 class_2383 = class_2382;
        int n2 = n = (int)Math.floor(class_2383.field_1323);
        while ((double)n2 < Math.ceil(class_2383.field_1320)) {
            int n3 = (int)Math.floor(class_2383.field_1322);
            while ((double)n3 < Math.ceil(class_2383.field_1325)) {
                int n4;
                int n5 = (int)Math.floor(class_2383.field_1321);
                while ((double)n5 < Math.ceil(class_2383.field_1324)) {
                    int a;
                    void a2;
                    if (Wrapper.mc.field_1687.method_8320(new class_2338(n, n4, a)).method_26204() == class_2246.field_10540 || Wrapper.mc.field_1687.method_8320(new class_2338(n, n4, a)).method_26204() == class_2246.field_9987 || Wrapper.mc.field_1687.method_8320(new class_2338(n, n4, a)).method_26204() == class_2246.field_10443 && a2 != false) {
                        return true;
                    }
                    n5 = ++a;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
        return false;
    }

    public static boolean isBurrowed(class_1657 class_16572, boolean bl) {
        boolean a = bl;
        class_1657 a2 = class_16572;
        return BOEntityUtils.doesBoxTouchBlock(a2.method_5829(), a);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean doesBoxTouchBlock(class_238 class_2382, class_2248 class_22482) {
        int n;
        class_238 class_2383 = class_2382;
        int n2 = n = (int)Math.floor(class_2383.field_1323);
        while ((double)n2 < Math.ceil(class_2383.field_1320)) {
            int n3 = (int)Math.floor(class_2383.field_1322);
            while ((double)n3 < Math.ceil(class_2383.field_1325)) {
                int n4;
                int n5 = (int)Math.floor(class_2383.field_1321);
                while ((double)n5 < Math.ceil(class_2383.field_1324)) {
                    int a;
                    void a2;
                    if (Wrapper.mc.field_1687.method_8320(new class_2338(n, n4, a)).method_26204() == a2) {
                        return true;
                    }
                    n5 = ++a;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
        return false;
    }
}
