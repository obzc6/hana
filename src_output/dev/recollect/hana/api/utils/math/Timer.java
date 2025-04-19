/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

public class Timer {
    private long time;

    public boolean passed(double a) {
        Timer a2;
        return a2.passedMs((long)a);
    }

    public boolean passedMs(double a) {
        Timer a2;
        return a2.passedMs((long)a);
    }

    public Timer reset() {
        Timer a;
        a.time = System.nanoTime();
        return a;
    }

    public long getMs(long a) {
        return a / 1000000L;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5 << 4;
        (2 ^ 5) << 4 ^ 3 << 1;
        int n4 = 5 << 4 ^ (3 << 2 ^ 1);
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

    public long getPassedTimeMs() {
        Timer a;
        Timer timer = a;
        return timer.getMs(System.nanoTime() - timer.time);
    }

    public Timer() {
        Timer a;
        Timer timer = a;
        timer.time = -1L;
        timer.reset();
    }

    public boolean passedS(double a) {
        Timer a2;
        return a2.passedMs((long)a * 1000L);
    }

    public long convertToNS(long a) {
        return a * 1000000L;
    }

    public void setMs(long a) {
        Timer a2;
        a2.time = System.nanoTime() - a2.convertToNS(a);
    }

    public boolean passedTicks(int n) {
        int a = n;
        Timer a2 = this;
        return a2.passedMs((long)a * 50L);
    }

    public boolean passed(long a) {
        Timer a2;
        Timer timer = a2;
        return timer.passedNS(timer.convertToNS(a));
    }

    public boolean passedNS(long a) {
        Timer a2;
        return System.nanoTime() - a2.time >= a;
    }

    public boolean passedMs(long a) {
        Timer a2;
        Timer timer = a2;
        return timer.passedNS(timer.convertToNS(a));
    }
}
