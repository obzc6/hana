/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.info.record;

public class GameInfo {
    private long lastUpdateTime;
    private String uuid;
    private String inGameName;
    private String token;

    public GameInfo() {
        GameInfo a;
    }

    /*
     * WARNING - void declaration
     */
    public GameInfo(String string, String string2, String string3, long l) {
        GameInfo a;
        void a2;
        void a3;
        void a4;
        String a5 = string3;
        GameInfo gameInfo = a = this;
        GameInfo gameInfo2 = a;
        gameInfo2.inGameName = a4;
        gameInfo2.token = a3;
        gameInfo.uuid = a5;
        gameInfo.lastUpdateTime = a2;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
        4 << 4 ^ 3 << 1;
        int n4 = (3 ^ 5) << 4 ^ 5;
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
