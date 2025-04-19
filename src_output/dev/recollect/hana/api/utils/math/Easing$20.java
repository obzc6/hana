/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.20
extends Easing {
    @Override
    public double ease(double a) {
        double d = 1.70158;
        double d2 = 1.70158 + 1.0;
        return 1.0 + d2 * Math.pow(a - 1.0, 3.0) + d * Math.pow(a - 1.0, 2.0);
    }

    private /* synthetic */ Easing.20(String string, int n) {
        int a = n;
        Easing.20 var2_4 = this;
    }
}
