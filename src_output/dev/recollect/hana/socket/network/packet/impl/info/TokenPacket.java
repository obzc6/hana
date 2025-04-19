/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.info;

import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;

public class TokenPacket
extends Packet {
    private String token;
    private ClientType client;

    @Override
    public void decode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        TokenPacket a2 = this;
        a2.client = a.readEnum(ClientType.class);
        a2.token = a.readString();
    }

    public String getToken() {
        TokenPacket a;
        return a.token;
    }

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        TokenPacket a2 = this;
        Object object = a;
        ((PacketBuffer)object).writeEnum(a2.client);
        ((PacketBuffer)object).writeString(a2.token);
    }

    public TokenPacket() {
        TokenPacket a;
    }

    public void setToken(String string) {
        String a = string;
        TokenPacket a2 = this;
        a2.token = a;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        TokenPacket a2 = this;
    }

    public void setClient(ClientType clientType) {
        Object a = clientType;
        TokenPacket a2 = this;
        a2.client = a;
    }

    /*
     * WARNING - void declaration
     */
    public TokenPacket(ClientType clientType, String string) {
        TokenPacket a;
        void a2;
        String a3 = string;
        TokenPacket tokenPacket = a = this;
        tokenPacket.client = a2;
        tokenPacket.token = a3;
    }

    public ClientType getClient() {
        TokenPacket a;
        return a.client;
    }
}
