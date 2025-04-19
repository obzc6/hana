/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.message;

import dev.recollect.hana.socket.enums.ChannelType;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;

public class ChatMessagePacket
extends Packet {
    private long timestamp;
    private ChannelType channel;
    private String message;

    public String getMessage() {
        ChatMessagePacket a;
        return a.message;
    }

    public ChannelType getChannel() {
        ChatMessagePacket a;
        return a.channel;
    }

    public void setMessage(String string) {
        String a = string;
        ChatMessagePacket a2 = this;
        a2.message = a;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        ChatMessagePacket a2 = this;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        ChatMessagePacket a2 = this;
        a2.channel = a.readEnum(ChannelType.class);
        ChatMessagePacket chatMessagePacket = a2;
        chatMessagePacket.message = a.readString();
        chatMessagePacket.timestamp = a.readLong();
    }

    /*
     * WARNING - void declaration
     */
    public ChatMessagePacket(ChannelType channelType, String string, long l) {
        void a;
        void a2;
        ChatMessagePacket a3;
        String a4 = string;
        ChatMessagePacket chatMessagePacket = a3 = this;
        a3.channel = a2;
        chatMessagePacket.message = a4;
        chatMessagePacket.timestamp = a;
    }

    public long getTimestamp() {
        ChatMessagePacket a;
        return a.timestamp;
    }

    public ChatMessagePacket() {
        ChatMessagePacket a;
    }

    public void setChannel(ChannelType channelType) {
        Object a = channelType;
        ChatMessagePacket a2 = this;
        a2.channel = a;
    }

    public void setTimestamp(long a) {
        a.timestamp = a;
    }

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        ChatMessagePacket a2 = this;
        Object object = a;
        ChatMessagePacket chatMessagePacket = a2;
        a.writeEnum(chatMessagePacket.channel);
        ((PacketBuffer)object).writeString(chatMessagePacket.message);
        ((PacketBuffer)object).writeLong(a2.timestamp);
    }
}
