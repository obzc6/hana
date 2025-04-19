/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.socket.network;

import dev.recollect.hana.socket.enums.ChannelType;
import dev.recollect.hana.socket.enums.Operation;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.message.ChatMessagePacket;
import dev.recollect.hana.socket.network.packet.impl.operation.OperationPacket;
import dev.recollect.hana.socket.network.user.UserManager;

public class NpSocketManager {
    private final NpSocketClient client;
    private static String prefix = "!";

    public String getPrefix() {
        return prefix;
    }

    public void send(Packet packet) {
        Packet a = packet;
        NpSocketManager a2 = this;
        a2.client.send(a);
    }

    public void chat(String string) {
        String a = string;
        Object a2 = this;
        ((NpSocketManager)a2).send(new ChatMessagePacket(ChannelType.PRIVATE, a, System.currentTimeMillis()));
    }

    public NpSocketManager() {
        NpSocketManager a;
        NpSocketManager npSocketManager = a;
        npSocketManager.client = new NpSocketClient();
    }

    /*
     * WARNING - void declaration
     */
    public void operation(Operation operation, String string, String string2) {
        void a;
        void a2;
        String a3 = string2;
        Object a4 = this;
        ((NpSocketManager)a4).send(new OperationPacket(UserManager.getUser().getUsername(), (String)a, a3, (Operation)a2));
    }

    public NpSocketClient getClient() {
        NpSocketManager a;
        return a.client;
    }
}
