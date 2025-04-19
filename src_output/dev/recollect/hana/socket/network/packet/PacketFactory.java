/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 */
package dev.recollect.hana.socket.network.packet;

import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.info.GameInfoPacket;
import dev.recollect.hana.socket.network.packet.impl.info.OnlineUsersPacket;
import dev.recollect.hana.socket.network.packet.impl.info.TokenPacket;
import dev.recollect.hana.socket.network.packet.impl.info.UserInfoPacket;
import dev.recollect.hana.socket.network.packet.impl.message.ChatMessagePacket;
import dev.recollect.hana.socket.network.packet.impl.message.MessagePacket;
import dev.recollect.hana.socket.network.packet.impl.operation.OperationPacket;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;

public class PacketFactory {
    private static final Map<Integer, Class<? extends Packet>> packetMap = new HashMap<Integer, Class<? extends Packet>>();

    static {
        packetMap.put(0, TokenPacket.class);
        packetMap.put(1, UserInfoPacket.class);
        packetMap.put(2, GameInfoPacket.class);
        packetMap.put(3, OnlineUsersPacket.class);
        packetMap.put(4, MessagePacket.class);
        packetMap.put(5, ChatMessagePacket.class);
        packetMap.put(6, OperationPacket.class);
    }

    public static Packet createPacket(int a22) {
        int n = a22;
        Class<? extends Packet> a22 = packetMap.get(n);
        if (a22 != null) {
            try {
                return a22.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (Exception a22) {
                LogManager.getLogger().info("Error instantiating packet class for ID " + n + ": " + a22.getMessage());
            }
        }
        return null;
    }

    public PacketFactory() {
        PacketFactory a;
    }

    public static Integer getPacketId(Class<? extends Packet> a) {
        return packetMap.entrySet().stream().filter(entry -> {
            Map.Entry a = entry;
            Class a2 = a;
            return a2.equals(a.getValue());
        }).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public static Class<? extends Packet> getPacketClass(int a) {
        return packetMap.get(a);
    }
}
