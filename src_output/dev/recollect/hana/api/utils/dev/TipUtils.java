/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_310
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.managers.CommandManager;
import net.minecraft.class_124;
import net.minecraft.class_310;

public class TipUtils {
    public static void lol() {
        class_310.method_1551();
        CommandManager.sendChatMessage(String.valueOf((Object)class_124.field_1061) + "\u529f\u80fd\u5f00\u53d1\u4e2d!");
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5 << 3;
        (2 ^ 5) << 4 ^ 2 << 1;
        int n4 = 2 ^ 5;
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

    public TipUtils() {
        TipUtils a;
    }
}
