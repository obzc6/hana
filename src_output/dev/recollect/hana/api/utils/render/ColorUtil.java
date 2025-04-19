/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.render;

import java.awt.Color;

public class ColorUtil {
    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 3 ^ 4;
        (2 ^ 5) << 4 ^ (2 ^ 5);
        int n4 = (2 ^ 5) << 4 ^ 1 << 1;
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

    public static Color injectAlpha(Color color, int n) {
        int a = n;
        Color a2 = color;
        return new Color(a2.getRed(), a2.getGreen(), a2.getBlue(), a);
    }

    public static int injectAlpha(int n, int n2) {
        int a = n2;
        int a2 = n;
        return ColorUtil.toRGBA(new Color(a2).getRed(), new Color(a2).getGreen(), new Color(a2).getBlue(), a);
    }

    /*
     * WARNING - void declaration
     */
    public static int toRGBA(int n, int n2, int n3, int n4) {
        void a;
        void a2;
        int a3 = n4;
        int a4 = n;
        return (a4 << 16) + (a2 << 8) + a + (a3 << 24);
    }

    public static Color pulseColor(Color a, int a22, int a3) {
        float[] arrf = a;
        a = new float[3];
        Color.RGBtoHSB(arrf.getRed(), arrf.getGreen(), arrf.getBlue(), a);
        float a22 = Math.abs(((float)(System.currentTimeMillis() % 2000L) / Float.intBitsToFloat(Float.floatToIntBits(0.0013786979f) ^ 2127476077) + (float)a22 / (float)a3 * Float.intBitsToFloat(Float.floatToIntBits(0.09192204f) ^ 2109489567)) % Float.intBitsToFloat(Float.floatToIntBits(0.7858098f) ^ 2135501525) - Float.intBitsToFloat(Float.floatToIntBits(6.46708f) ^ 2135880274));
        a22 = Float.intBitsToFloat(Float.floatToIntBits(18.996923f) ^ 2123889075) + Float.intBitsToFloat(Float.floatToIntBits(2.7958195f) ^ 2134044341) * a22;
        a[2] = a22 % Float.intBitsToFloat(Float.floatToIntBits(0.8992331f) ^ 2137404452);
        return new Color(Color.HSBtoRGB(a[0], a[1], a[2]));
    }

    /*
     * WARNING - void declaration
     */
    public static Color fadeColor(Color color, Color color2, double d) {
        void a22;
        Color color3;
        void a;
        Color color4 = color3 = color;
        int n = color4.getRed();
        int n2 = color4.getGreen();
        int n3 = color4.getBlue();
        int a3 = color4.getAlpha();
        void v1 = a22;
        int a22 = v1.getRed();
        int n4 = v1.getGreen();
        int n5 = v1.getBlue();
        int n6 = v1.getAlpha();
        return new Color((int)((double)n + (double)(a22 - n) * a), (int)((double)n2 + (double)(n4 - n2) * a), (int)((double)n3 + (double)(n5 - n3) * a), (int)((double)a3 + (double)(n6 - a3) * a));
    }

    public ColorUtil() {
        ColorUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static Color pulseColor(Color color, Color color2, int n, int n2, double d) {
        void a;
        double a2;
        void a3;
        int a4 = n2;
        Color a5 = color;
        a2 = Math.abs(((double)System.currentTimeMillis() * a2 % 2000.0 / (double)Float.intBitsToFloat(Float.floatToIntBits(0.0013786979f) ^ 2127476077) + (double)a / (double)a4 * (double)Float.intBitsToFloat(Float.floatToIntBits(0.09192204f) ^ 2109489567)) % (double)Float.intBitsToFloat(Float.floatToIntBits(0.7858098f) ^ 2135501525) - (double)Float.intBitsToFloat(Float.floatToIntBits(6.46708f) ^ 2135880274)) % (double)Float.intBitsToFloat(Float.floatToIntBits(0.8992331f) ^ 2137404452);
        return ColorUtil.fadeColor(a5, (Color)a3, a2);
    }
}
