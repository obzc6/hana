/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.21
extends Easing {
    private /* synthetic */ Easing.21(String string, int n) {
        int a = n;
        Easing.21 var2_4 = this;
    }

    @Override
    public double ease(double a) {
        if (a < 0.5) {
            return Math.pow(2.0 * a, 2.0) * (7.189819 * a - 2.5949095) / 2.0;
        }
        return (Math.pow(2.0 * a - 2.0, 2.0) * (3.5949095 * (a * 2.0 - 2.0) + 2.5949095) + 2.0) / 2.0;
    }
}
