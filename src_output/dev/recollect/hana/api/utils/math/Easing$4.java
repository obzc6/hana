/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.4
extends Easing {
    @Override
    public double ease(double a) {
        return Math.pow(a, 3.0);
    }

    private /* synthetic */ Easing.4(String string, int n) {
        int a = n;
        Easing.4 var2_4 = this;
    }
}
