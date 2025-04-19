/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public class BetterDynamicAnimation {
    private int prevStep;
    private double value;
    private final int maxTicks;
    private double dstValue;
    private int step;

    public BetterDynamicAnimation(int n) {
        int a = n;
        BetterDynamicAnimation a2 = this;
        a2.maxTicks = a;
    }

    public void setValue(double a) {
        BetterDynamicAnimation a2;
        if (a != a2.dstValue) {
            BetterDynamicAnimation betterDynamicAnimation = a2;
            a2.prevStep = 0;
            a2.step = 0;
            betterDynamicAnimation.value = a2.dstValue;
            betterDynamicAnimation.dstValue = a;
        }
    }

    public BetterDynamicAnimation() {
        a(5);
        BetterDynamicAnimation a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (2 ^ 5);
        1 << 3 ^ 3;
        int n4 = (2 ^ 5) << 4 ^ 3;
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

    public void update() {
        BetterDynamicAnimation a;
        BetterDynamicAnimation betterDynamicAnimation = a;
        betterDynamicAnimation.prevStep = betterDynamicAnimation.step;
        betterDynamicAnimation.step = class_3532.method_15340((int)(betterDynamicAnimation.step + 1), (int)0, (int)a.maxTicks);
    }

    public double getAnimationD() {
        BetterDynamicAnimation a;
        BetterDynamicAnimation betterDynamicAnimation = a;
        double d = betterDynamicAnimation.dstValue - a.value;
        BetterDynamicAnimation betterDynamicAnimation2 = a;
        double d2 = BetterDynamicAnimation.createAnimation((double)((float)betterDynamicAnimation.prevStep + (float)(a.step - betterDynamicAnimation2.prevStep) * Wrapper.mc.method_1488()) / (double)a.maxTicks);
        return betterDynamicAnimation2.value + d * d2;
    }

    public static double createAnimation(double a) {
        return Math.sqrt(1.0 - Math.pow(a - 1.0, 2.0));
    }
}
