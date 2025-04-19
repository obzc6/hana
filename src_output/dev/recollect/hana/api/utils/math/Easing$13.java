/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.13
extends Easing {
    @Override
    public double ease(double a) {
        return Math.pow(a, 5.0);
    }

    private /* synthetic */ Easing.13(String string, int n) {
        int a = n;
        Easing.13 var2_4 = this;
    }
}
