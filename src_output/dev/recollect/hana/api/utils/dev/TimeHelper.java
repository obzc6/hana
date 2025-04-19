/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.dev;

public class TimeHelper {
    private long lastMs;
    private long lastMS2 = -1L;

    public boolean hasReached(long a) {
        TimeHelper a2;
        return a2.getCurrentMS2() - a2.lastMS2 >= a;
    }

    public void setLastMs(int n) {
        int a = n;
        TimeHelper a2 = this;
        a2.lastMs = System.currentTimeMillis() + (long)a;
    }

    public void reset2() {
        TimeHelper a;
        a.lastMS2 = a.getCurrentMS2();
    }

    public TimeHelper() {
        TimeHelper a;
    }

    public boolean hasReachedfloat(float f) {
        float a = f;
        TimeHelper a2 = this;
        return (float)(a2.getCurrentMS2() - a2.lastMS2) >= a;
    }

    public boolean hasReachedfloat2(float f) {
        float a = f;
        TimeHelper a2 = this;
        return (float)(a2.getCurrentMS2() - a2.lastMS2) >= a;
    }

    public void reset() {
        a.lastMs = System.currentTimeMillis();
    }

    public long getLastMs() {
        TimeHelper a;
        return a.lastMs;
    }

    public boolean isDelayComplete(long a) {
        TimeHelper a2;
        return System.currentTimeMillis() - a2.lastMs > a;
    }

    public long getCurrentMS2() {
        return System.nanoTime() / 10000000L;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (2 << 2 ^ 1);
        (3 ^ 5) << 4;
        int n4 = 1 << 3 ^ 3;
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
}
