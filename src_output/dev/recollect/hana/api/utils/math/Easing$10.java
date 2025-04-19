/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.10
extends Easing {
    private /* synthetic */ Easing.10(String string, int n) {
        int a = n;
        Easing.10 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        return Math.pow(a, 4.0);
    }
}
