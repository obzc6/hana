/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import dev.recollect.hana.api.utils.math.Easing;
import dev.recollect.hana.api.utils.math.FadeUtils;

public class Animation {
    private boolean setup;
    public double to;
    public double from;
    public final FadeUtils fadeUtils;

    public Animation() {
        Animation a;
        Animation animation = a;
        Animation animation2 = a;
        a.fadeUtils = new FadeUtils(0L);
        a.setup = false;
        animation.from = 0.0;
        animation.to = 0.0;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ 3;
        (2 ^ 5) << 4 ^ 1 << 1;
        int n4 = (2 ^ 5) << 4 ^ 4 << 1;
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

    /*
     * WARNING - void declaration
     */
    public double get(double d, long l, Easing easing) {
        Object a;
        void a2;
        void a3;
        Animation animation = object;
        Object object = easing;
        Animation a4 = animation;
        if (a3 != a4.to) {
            a4.from += (a4.to - a4.from) * a4.fadeUtils.ease((Easing)((Object)a));
            a4.to = a3;
            a4.fadeUtils.reset();
        }
        Animation animation2 = a4;
        animation2.fadeUtils.setLength((long)a2);
        return animation2.from + (a4.to - a4.from) * a4.fadeUtils.ease((Easing)((Object)a));
    }
}
