/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.5
extends Easing {
    @Override
    public double ease(double a) {
        return 1.0 - Math.pow(1.0 - a, 3.0);
    }

    private /* synthetic */ Easing.5(String string, int n) {
        int a = n;
        Easing.5 var2_4 = this;
    }
}
