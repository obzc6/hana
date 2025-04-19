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

class BetterAnimation {
    public static final class_310 mc = class_310.method_1551();
    private final int maxTick;
    private int prevTick;
    private int tick;

    public BetterAnimation(int n) {
        int a = n;
        BetterAnimation a2 = this;
        a2.maxTick = a;
    }

    public double getAnimationd() {
        BetterAnimation a;
        BetterAnimation betterAnimation = a;
        return BetterAnimation.dropAnimation(((float)a.prevTick + (float)(betterAnimation.tick - betterAnimation.prevTick) * mc.method_1488()) / (float)a.maxTick);
    }

    public void update(boolean bl) {
        BetterAnimation a;
        boolean a2 = bl;
        BetterAnimation betterAnimation = a = this;
        betterAnimation.prevTick = betterAnimation.tick;
        betterAnimation.tick = class_3532.method_15340((int)(betterAnimation.tick + (a2 ? 1 : -1)), (int)0, (int)a.maxTick);
    }

    public BetterAnimation() {
        a(10);
        BetterAnimation a;
    }

    public static double dropAnimation(double a) {
        double d = 1.70158;
        double d2 = 2.70158;
        return 1.0 + d2 * Math.pow(a - 1.0, 3.0) + d * Math.pow(a - 1.0, 2.0);
    }
}
