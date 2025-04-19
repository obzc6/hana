/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;

final class Easing.22
extends Easing {
    @Override
    public double ease(double a) {
        if (a < 0.36363636363636365) {
            return 7.5625 * a * a;
        }
        if (a < 0.7272727272727273) {
            return 7.5625 * (a -= 0.5454545454545454) * a + 0.75;
        }
        if (a < 0.9090909090909091) {
            return 7.5625 * (a -= 0.8181818181818182) * a + 0.9375;
        }
        return 7.5625 * (a -= 0.9545454545454546) * a + 0.984375;
    }

    private /* synthetic */ Easing.22(String string, int n) {
        int a = n;
        Easing.22 var2_4 = this;
    }
}
