/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network;

import dev.recollect.hana.socket.enums.ChannelType;
import dev.recollect.hana.socket.enums.Operation;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.message.ChatMessagePacket;
import dev.recollect.hana.socket.network.packet.impl.operation.OperationPacket;
import dev.recollect.hana.socket.network.user.UserManager;

public class SocketManager {
    private final SocketClient client;
    private static String prefix = "!";

    /*
     * WARNING - void declaration
     */
    public void operation(Operation operation, String string, String string2) {
        void a;
        void a2;
        String a3 = string2;
        Object a4 = this;
        ((SocketManager)a4).send(new OperationPacket(UserManager.getUser().getUsername(), (String)a2, a3, (Operation)a));
    }

    public String getPrefix() {
        return prefix;
    }

    public void chat(String string) {
        String a = string;
        Object a2 = this;
        ((SocketManager)a2).send(new ChatMessagePacket(ChannelType.GLOBAL, a, System.currentTimeMillis()));
    }

    public SocketClient getClient() {
        SocketManager a;
        return a.client;
    }

    public SocketManager() {
        SocketManager a;
        SocketManager socketManager = a;
        socketManager.client = new SocketClient();
    }

    public void send(Packet packet) {
        Packet a = packet;
        SocketManager a2 = this;
        a2.client.send(a);
    }
}
