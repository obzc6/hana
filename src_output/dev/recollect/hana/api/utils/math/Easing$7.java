/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.7
extends Easing {
    @Override
    public double ease(double a) {
        return Math.pow(a, 2.0);
    }

    private /* synthetic */ Easing.7(String string, int n) {
        int a = n;
        Easing.7 var2_4 = this;
    }
}
