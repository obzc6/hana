/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.user;

import dev.recollect.hana.socket.enums.Rank;
import java.util.Date;

public class User {
    private String avatarData;
    private Date expireDate;
    private String password;
    private String username;
    private String token;
    private int userId;
    private static Rank rank;
    private double balance;

    public void setBalance(double a) {
        a.balance = a;
    }

    public String getAvatarData() {
        User a;
        return a.avatarData;
    }

    public Date getExpireDate() {
        User a;
        return a.expireDate;
    }

    public void setUsername(String string) {
        String a = string;
        User a2 = this;
        a2.username = a;
    }

    public void setUserId(int n) {
        int a = n;
        User a2 = this;
        a2.userId = a;
    }

    public void setExpireDate(Date date) {
        Date a = date;
        User a2 = this;
        a2.expireDate = a;
    }

    public double getBalance() {
        User a;
        return a.balance;
    }

    public Rank getRank() {
        return rank;
    }

    public int getUserId() {
        User a;
        return a.userId;
    }

    /*
     * WARNING - void declaration
     */
    public User(int n, String string, String string2, String string3, Rank rank, Date date, double d) {
        void a;
        void a2;
        User a3;
        void a4;
        Date a5;
        void a6;
        void a7;
        void a8;
        User user = date2;
        Date date2 = date;
        User user2 = a3 = user;
        User user3 = a3;
        a3.userId = a2;
        user3.username = a7;
        user3.password = a6;
        user2.token = a;
        User.rank = a4;
        user2.expireDate = a5;
        a3.balance = a8;
        a3.avatarData = "";
    }

    public void setRank(Rank rank) {
        Object a = rank;
        User a2 = this;
        User.rank = a;
    }

    public String getUsername() {
        User a;
        return a.username;
    }

    public String getToken() {
        User a;
        return a.token;
    }

    public void setAvatarData(String string) {
        String a = string;
        User a2 = this;
        a2.avatarData = a;
    }

    /*
     * WARNING - void declaration
     */
    public User(int n, String string, String string2, String string3, Rank rank, Date date, double d, String string4) {
        void a;
        void a2;
        User a3;
        void a4;
        void a5;
        void a6;
        String a7;
        void a8;
        void a9;
        User user = string5;
        String string5 = string4;
        User user2 = a3 = user;
        User user3 = a3;
        a3.userId = a;
        user3.username = a4;
        user3.password = a9;
        user2.token = a6;
        User.rank = a2;
        user2.expireDate = a8;
        a3.balance = a5;
        a3.avatarData = a7;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (3 << 2 ^ 3);
        5 << 4 ^ 1;
        int n4 = 5 << 4 ^ 3;
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

    public String getPassword() {
        User a;
        return a.password;
    }

    public void setPassword(String string) {
        String a = string;
        User a2 = this;
        a2.password = a;
    }

    public void setToken(String string) {
        String a = string;
        User a2 = this;
        a2.token = a;
    }
}
