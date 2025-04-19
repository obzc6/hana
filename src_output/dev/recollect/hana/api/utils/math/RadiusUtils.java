/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.FadeUtils;

public class RadiusUtils {
    private final FadeUtils fadeUtils;
    private double targetRadius;
    private double currentRadius;

    public void setTargetRadius(double a) {
        RadiusUtils a2;
        a2.targetRadius = a;
        a2.reset();
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5 << 4 ^ (3 << 2 ^ 1);
        (2 ^ 5) << 3 ^ 4;
        int n4 = 1 << 3 ^ 1;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public void reset() {
        RadiusUtils a;
        a.currentRadius = 0.0;
        a.fadeUtils.reset();
    }

    public double getTargetRadius() {
        RadiusUtils a;
        return a.targetRadius;
    }

    public double getCurrentRadius() {
        RadiusUtils a;
        if (a.fadeUtils.isEnd()) {
            return a.targetRadius;
        }
        RadiusUtils radiusUtils = a;
        a.currentRadius = radiusUtils.targetRadius * a.fadeUtils.ease(FadeUtils.Ease.Out);
        return radiusUtils.currentRadius;
    }

    public RadiusUtils(double a, long a2) {
        RadiusUtils a3;
        RadiusUtils radiusUtils = a3;
        radiusUtils.currentRadius = 0.0;
        radiusUtils.targetRadius = a;
        radiusUtils.fadeUtils = new FadeUtils(a2);
        a3.fadeUtils.reset();
    }
}
