/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FPSManager {
    private final List<Long> records;

    public void record() {
        FPSManager a;
        a.records.add(System.currentTimeMillis());
    }

    public int getFps() {
        FPSManager a2;
        a2.records.removeIf(a -> a + 1000L < System.currentTimeMillis());
        return a2.records.size();
    }

    public FPSManager() {
        FPSManager a;
        FPSManager fPSManager = a;
        fPSManager.records = new ArrayList<Long>();
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ (2 << 2 ^ 1);
        5 << 3 ^ (3 ^ 5);
        int n4 = 3 << 3 ^ (2 ^ 5);
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
