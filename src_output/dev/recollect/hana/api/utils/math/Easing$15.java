/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.15
extends Easing {
    @Override
    public double ease(double a) {
        if (a < 0.5) {
            return 16.0 * Math.pow(a, 5.0);
        }
        return 1.0 - Math.pow(-2.0 * a + 2.0, 5.0) / 2.0;
    }

    private /* synthetic */ Easing.15(String string, int n) {
        int a = n;
        Easing.15 var2_4 = this;
    }
}
