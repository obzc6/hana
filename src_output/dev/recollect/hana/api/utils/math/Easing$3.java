/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.3
extends Easing {
    private /* synthetic */ Easing.3(String string, int n) {
        int a = n;
        Easing.3 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        return -(Math.cos(3.141592653589793 * a) - 1.0) / 2.0;
    }
}
