/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.info.record;

import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.enums.Rank;

public class OnlineUserInfo {
    private Rank rank;
    private ClientType client;
    private String inGameName;
    private String username;

    public void setClient(ClientType clientType) {
        Object a = clientType;
        OnlineUserInfo a2 = this;
        a2.client = a;
    }

    public void setUsername(String string) {
        String a = string;
        OnlineUserInfo a2 = this;
        a2.username = a;
    }

    public void setInGameName(String string) {
        String a = string;
        OnlineUserInfo a2 = this;
        a2.inGameName = a;
    }

    public String getUsername() {
        OnlineUserInfo a;
        return a.username;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4;
        (2 ^ 5) << 3;
        int n4 = (3 ^ 5) << 3 ^ (2 ^ 5);
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

    public Rank getRank() {
        OnlineUserInfo a;
        return a.rank;
    }

    public ClientType getClient() {
        OnlineUserInfo a;
        return a.client;
    }

    public String getInGameName() {
        OnlineUserInfo a;
        return a.inGameName;
    }

    /*
     * WARNING - void declaration
     */
    public OnlineUserInfo(ClientType clientType, String string, String string2, Rank rank) {
        Object a;
        OnlineUserInfo a2;
        void a3;
        void a4;
        void a5;
        OnlineUserInfo onlineUserInfo = object;
        Object object = rank;
        OnlineUserInfo onlineUserInfo2 = a2 = onlineUserInfo;
        OnlineUserInfo onlineUserInfo3 = a2;
        onlineUserInfo3.client = a4;
        onlineUserInfo3.username = a3;
        onlineUserInfo2.inGameName = a5;
        onlineUserInfo2.rank = a;
    }

    public void setRank(Rank rank) {
        Object a = rank;
        OnlineUserInfo a2 = this;
        a2.rank = a;
    }
}
