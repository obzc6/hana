/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.skybox;

public class BackgroundInfo {
    public static final float blindness = 0.0f;
    public static final float fogDensity = 1.0f;
    public static final float fogColorRed = 0.3061791f;
    public static final float fogColorGreen = 0.2449433f;
    public static final float fogColorBlue = 0.3061791f;

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 3 ^ 5;
        5 << 4 ^ (2 << 2 ^ 1);
        int n4 = 4 << 3 ^ 2;
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

    public BackgroundInfo() {
        BackgroundInfo a;
    }
}
