/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.alts;

public class Alt {
    private String email;

    public Alt(String string) {
        String a = string;
        Alt a2 = this;
        a2.email = a;
    }

    public String getEmail() {
        Alt a;
        return a.email;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ (2 ^ 5);
        2 << 3 ^ (3 ^ 5);
        int n4 = 5 << 3 ^ 5;
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

    public void setEmail(String string) {
        String a = string;
        Alt a2 = this;
        a2.email = a;
    }
}
