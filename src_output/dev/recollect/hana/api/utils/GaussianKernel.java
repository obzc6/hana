/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils;

public class GaussianKernel {
    private final int size;
    private final float[] kernel;

    public int getSize() {
        GaussianKernel a;
        return a.size;
    }

    public void compute() {
        GaussianKernel a;
        GaussianKernel gaussianKernel = a;
        float f = (float)gaussianKernel.size / 2.0f;
        float f2 = 0.0f;
        int n = a = 0;
        while (n < gaussianKernel.size) {
            float f3 = (float)a / f;
            gaussianKernel.kernel[a] = 1.0f / (Math.abs(f) * 2.5066283f) * (float)Math.exp(-0.5 * (double)f3 * (double)f3);
            f2 += a > 0 ? gaussianKernel.kernel[a] * 2.0f : gaussianKernel.kernel[0];
            n = ++a;
        }
        int n2 = a = 0;
        while (n2 < gaussianKernel.size) {
            float[] arrf = gaussianKernel.kernel;
            int n3 = a++;
            arrf[n3] = arrf[n3] / f2;
            n2 = a;
        }
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 3 ^ 5;
        (3 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int n4 = 5 << 3 ^ (2 ^ 5);
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

    public float[] getKernel() {
        GaussianKernel a;
        return a.kernel;
    }

    public GaussianKernel(int n) {
        GaussianKernel a;
        int a2 = n;
        GaussianKernel gaussianKernel = a = this;
        gaussianKernel.size = a2;
        gaussianKernel.kernel = new float[a2];
    }
}
