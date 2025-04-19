/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.info;

import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.socket.network.info.record.UserInfo;

public class ClientInfo {
    private UserInfo user;
    private GameInfo game;
    private ClientType client;

    public void setUser(UserInfo userInfo) {
        UserInfo a = userInfo;
        ClientInfo a2 = this;
        a2.user = a;
    }

    public ClientType getClient() {
        ClientInfo a;
        return a.client;
    }

    public GameInfo getGame() {
        ClientInfo a;
        return a.game;
    }

    public UserInfo getUser() {
        ClientInfo a;
        return a.user;
    }

    /*
     * WARNING - void declaration
     */
    public ClientInfo(ClientType clientType, UserInfo userInfo, GameInfo gameInfo) {
        void a;
        ClientInfo a2;
        void a3;
        GameInfo a4 = gameInfo;
        ClientInfo clientInfo = a2 = this;
        a2.client = a3;
        clientInfo.user = a;
        clientInfo.game = a4;
    }

    public void setClient(ClientType clientType) {
        Object a = clientType;
        ClientInfo a2 = this;
        a2.client = a;
    }

    public void setGame(GameInfo gameInfo) {
        GameInfo a = gameInfo;
        ClientInfo a2 = this;
        a2.game = a;
    }

    public ClientInfo() {
        ClientInfo a;
        ClientInfo clientInfo = a;
        a.client = ClientType.EMPTY;
        clientInfo.user = null;
        clientInfo.game = null;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ 5 << 1;
        (3 ^ 5) << 4 ^ (2 ^ 5);
        int n4 = 4 << 3 ^ (2 ^ 5);
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
