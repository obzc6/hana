/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.2
extends Easing {
    private /* synthetic */ Easing.2(String string, int n) {
        int a = n;
        Easing.2 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        return Math.sin(a * 3.141592653589793 / 2.0);
    }
}
