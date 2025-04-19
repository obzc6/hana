/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4184
 *  net.minecraft.class_7172
 *  net.minecraft.class_757
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 */
package dev.recollect.hana.mod.modules.impl.render.freelook;

import net.minecraft.class_1041;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4184;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class ProjectionUtils {
    public ProjectionUtils() {
        ProjectionUtils a;
    }

    public static class_243 worldToScreen(class_243 a) {
        class_243 class_2432 = a;
        class_310 class_3102 = class_310.method_1551();
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        a = class_41842.method_19326();
        a = class_41842.method_23767().conjugate().transform(a.method_1020(class_2432).method_46409());
        Integer n = (Integer)class_3102.field_1690.method_41808().method_41753();
        double d = (double)(class_3102.method_22683().method_4502() / 2) / ((double)a.z() * Math.tan(Math.toRadians(n / 2)));
        return new class_243((double)a.x() * d, (double)a.y() * d, (double)a.z());
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ 2 << 1;
        (2 ^ 5) << 4 ^ 2 << 1;
        int n4 = 2;
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
}
