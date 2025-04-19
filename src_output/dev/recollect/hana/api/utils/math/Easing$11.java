/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.11
extends Easing {
    @Override
    public double ease(double a) {
        return 1.0 - Math.pow(1.0 - a, 4.0);
    }

    private /* synthetic */ Easing.11(String string, int n) {
        int a = n;
        Easing.11 var2_4 = this;
    }
}
