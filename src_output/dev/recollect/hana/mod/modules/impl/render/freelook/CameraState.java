/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 */
package dev.recollect.hana.mod.modules.impl.render.freelook;

import net.minecraft.class_1297;
import net.minecraft.class_310;

public class CameraState {
    public boolean doLock;
    public boolean doTransition;
    public float transitionInitialYaw;
    public float transitionInitialPitch;
    public float lookYaw;
    public float lookPitch;

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 3 ^ 4;
        (2 ^ 5) << 4 ^ 5 << 1;
        int n4 = 5 << 4;
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

    public float originalYaw() {
        return class_310.method_1551().method_1560().method_5791();
    }

    public float originalPitch() {
        return class_310.method_1551().method_1560().method_36455();
    }

    public CameraState() {
        CameraState a;
    }
}
