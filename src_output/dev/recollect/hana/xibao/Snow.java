/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.xibao;

public class Snow {
    public int baseX;
    public int source;
    public boolean removed;
    public int x;
    public int y;
    public int k;

    public void move() {
        Snow a;
        Snow snow = a;
        ++snow.y;
        a.x = snow.baseX + a.y / a.k;
    }

    /*
     * WARNING - void declaration
     */
    public Snow(int n, int n2, int n3) {
        void a;
        void a2;
        Snow a3;
        int a4 = n;
        Snow snow = a3 = this;
        Snow snow2 = a3;
        Snow snow3 = a3;
        snow3.removed = false;
        snow3.y = 0;
        snow2.x = a4;
        snow2.baseX = a4;
        snow.k = a2;
        snow.source = a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ 3;
        (2 ^ 5) << 3 ^ 2;
        int n4 = (3 ^ 5) << 4 ^ 4 << 1;
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
