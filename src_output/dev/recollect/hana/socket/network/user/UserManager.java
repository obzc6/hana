/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network.user;

import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.socket.network.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserManager {
    private static List<OnlineUserInfo> onlineUsers = new ArrayList<OnlineUserInfo>();
    private static User user;

    public static boolean add(OnlineUserInfo a) {
        return onlineUsers.add(a);
    }

    public static boolean remove(OnlineUserInfo a) {
        return onlineUsers.remove(a);
    }

    public static User getUser() {
        return user;
    }

    public static void setOnlineUsers(List<OnlineUserInfo> a) {
    }

    public static void setUser(User a) {
    }

    public UserManager() {
        UserManager a;
    }

    public static List<String> getUsernames() {
        return onlineUsers.stream().map(OnlineUserInfo::getUsername).collect(Collectors.toList());
    }

    public static List<OnlineUserInfo> getOnlineUsers() {
        return onlineUsers;
    }
}
