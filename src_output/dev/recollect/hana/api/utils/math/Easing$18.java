/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.18
extends Easing {
    @Override
    public double ease(double a) {
        if (a < 0.5) {
            return (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * a, 2.0))) / 2.0;
        }
        return (Math.sqrt(1.0 - Math.pow(-2.0 * a + 2.0, 2.0)) + 1.0) / 2.0;
    }

    private /* synthetic */ Easing.18(String string, int n) {
        int a = n;
        Easing.18 var2_4 = this;
    }
}
