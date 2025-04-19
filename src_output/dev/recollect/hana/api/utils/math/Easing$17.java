/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.17
extends Easing {
    @Override
    public double ease(double a) {
        return Math.sqrt(1.0 - Math.pow(a - 1.0, 2.0));
    }

    private /* synthetic */ Easing.17(String string, int n) {
        int a = n;
        Easing.17 var2_4 = this;
    }
}
