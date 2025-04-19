/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.14
extends Easing {
    private /* synthetic */ Easing.14(String string, int n) {
        int a = n;
        Easing.14 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        return 1.0 - Math.pow(1.0 - a, 5.0);
    }
}
