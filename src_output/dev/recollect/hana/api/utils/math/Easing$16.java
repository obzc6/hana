/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.16
extends Easing {
    @Override
    public double ease(double a) {
        return 1.0 - Math.sqrt(1.0 - Math.pow(a, 2.0));
    }

    private /* synthetic */ Easing.16(String string, int n) {
        int a = n;
        Easing.16 var2_4 = this;
    }
}
