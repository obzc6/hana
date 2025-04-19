/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.info.record;

import dev.recollect.hana.socket.enums.Rank;
import java.util.Date;

public class UserInfo {
    private final int userId;
    private final Date expiryDate;
    private final String username;
    private final double balance;
    private final String token;
    private final Rank rank;

    public String getUsername() {
        UserInfo a;
        return a.username;
    }

    /*
     * WARNING - void declaration
     */
    public UserInfo(String string, int n, String string2, Rank rank, Date date, double d) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        UserInfo a6;
        Date a7;
        UserInfo userInfo = date2;
        Date date2 = date;
        UserInfo userInfo2 = a6 = userInfo;
        UserInfo userInfo3 = a6;
        UserInfo userInfo4 = a6;
        userInfo4.token = a5;
        userInfo4.userId = a4;
        userInfo3.username = a3;
        userInfo3.rank = a2;
        userInfo2.expiryDate = a7;
        userInfo2.balance = a;
    }

    public Rank getRank() {
        UserInfo a;
        return a.rank;
    }

    public int getUserId() {
        UserInfo a;
        return a.userId;
    }

    public Date getExpiryDate() {
        UserInfo a;
        return a.expiryDate;
    }

    public String getToken() {
        UserInfo a;
        return a.token;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 2;
        (3 ^ 5) << 4 ^ (3 << 2 ^ 1);
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

    public double getBalance() {
        UserInfo a;
        return a.balance;
    }
}
