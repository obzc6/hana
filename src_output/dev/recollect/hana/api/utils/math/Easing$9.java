/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.9
extends Easing {
    private /* synthetic */ Easing.9(String string, int n) {
        int a = n;
        Easing.9 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        if (a < 0.5) {
            return 8.0 * Math.pow(a, 4.0);
        }
        return 1.0 - Math.pow(-2.0 * a + 2.0, 4.0) / 2.0;
    }
}
