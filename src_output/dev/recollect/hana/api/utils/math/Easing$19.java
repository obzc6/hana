/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.19
extends Easing {
    @Override
    public double ease(double a) {
        if (a == 0.0) {
            return 0.0;
        }
        if (a == 1.0) {
            return 1.0;
        }
        if (a < 0.5) {
            return Math.pow(2.0, 20.0 * a - 10.0) / 2.0;
        }
        return (2.0 - Math.pow(2.0, -20.0 * a + 10.0)) / 2.0;
    }

    private /* synthetic */ Easing.19(String string, int n) {
        int a = n;
        Easing.19 var2_4 = this;
    }
}
