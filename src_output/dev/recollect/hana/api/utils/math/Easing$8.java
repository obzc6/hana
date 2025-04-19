/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.8
extends Easing {
    @Override
    public double ease(double a) {
        return 1.0 - (1.0 - a) * (1.0 - a);
    }

    private /* synthetic */ Easing.8(String string, int n) {
        int a = n;
        Easing.8 var2_4 = this;
    }
}
