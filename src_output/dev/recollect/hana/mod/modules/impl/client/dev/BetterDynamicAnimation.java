/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import net.minecraft.class_310;
import net.minecraft.class_3532;

class BetterDynamicAnimation {
    private double dstValue;
    private int step;
    private final int maxTicks;
    private int prevStep;
    private double value;
    public static final class_310 mc = class_310.method_1551();

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

    public static double createAnimation(double a) {
        return Math.sqrt(1.0 - Math.pow(a - 1.0, 2.0));
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
        double d2 = BetterDynamicAnimation.createAnimation((double)((float)betterDynamicAnimation.prevStep + (float)(a.step - betterDynamicAnimation2.prevStep) * mc.method_1488()) / (double)a.maxTicks);
        return betterDynamicAnimation2.value + d * d2;
    }

    public BetterDynamicAnimation(int n) {
        int a = n;
        BetterDynamicAnimation a2 = this;
        a2.maxTicks = a;
    }

    public BetterDynamicAnimation() {
        a(5);
        BetterDynamicAnimation a;
    }
}
