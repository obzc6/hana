/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.info;

import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;

public class GameInfoPacket
extends Packet {
    private String inGameName;
    private long lastUpdateTime;
    private String uuid;

    public long getLastUpdateTime() {
        GameInfoPacket a;
        return a.lastUpdateTime;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        GameInfoPacket a;
        PacketBuffer a2 = packetBuffer;
        GameInfoPacket gameInfoPacket = a = this;
        Object object = a2;
        a.inGameName = ((PacketBuffer)object).readString();
        gameInfoPacket.uuid = ((PacketBuffer)object).readString();
        gameInfoPacket.lastUpdateTime = a2.readLong();
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        GameInfoPacket a2 = this;
    }

    public void setUuid(String string) {
        String a = string;
        GameInfoPacket a2 = this;
        a2.uuid = a;
    }

    public String getUuid() {
        GameInfoPacket a;
        return a.uuid;
    }

    public void setInGameName(String string) {
        String a = string;
        GameInfoPacket a2 = this;
        a2.inGameName = a;
    }

    public void setLastUpdateTime(long a) {
        a.lastUpdateTime = a;
    }

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        GameInfoPacket a2 = this;
        Object object = a;
        GameInfoPacket gameInfoPacket = a2;
        a.writeString(gameInfoPacket.inGameName);
        ((PacketBuffer)object).writeString(gameInfoPacket.uuid);
        ((PacketBuffer)object).writeLong(a2.lastUpdateTime);
    }

    public String getInGameName() {
        GameInfoPacket a;
        return a.inGameName;
    }

    public GameInfoPacket() {
        GameInfoPacket a;
    }

    /*
     * WARNING - void declaration
     */
    public GameInfoPacket(String string, String string2, String string3, long l) {
        void a;
        GameInfoPacket a2;
        void a3;
        String a4 = string3;
        GameInfoPacket gameInfoPacket = a2 = this;
        a2.inGameName = a3;
        gameInfoPacket.uuid = a4;
        gameInfoPacket.lastUpdateTime = a;
    }
}
