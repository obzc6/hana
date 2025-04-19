/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.info;

import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.enums.Rank;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.user.UserManager;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class OnlineUsersPacket
extends Packet {
    private List<OnlineUserInfo> onlineUsers;

    public OnlineUsersPacket(List<OnlineUserInfo> list) {
        List<OnlineUserInfo> a = list;
        OnlineUsersPacket a2 = this;
        a2.onlineUsers = a;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        OnlineUsersPacket a2 = this;
        UserManager.setOnlineUsers(a2.getOnlineUsers());
    }

    public OnlineUsersPacket() {
        OnlineUsersPacket a;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        PacketBuffer a2 = packetBuffer;
        OnlineUsersPacket a3 = this;
        a3.onlineUsers = a2.readList(a -> new OnlineUserInfo(a.readEnum(ClientType.class), a.readString(), a.readString(), a.readEnum(Rank.class)));
    }

    public List<OnlineUserInfo> getOnlineUsers() {
        OnlineUsersPacket a;
        return a.onlineUsers;
    }

    public void setOnlineUsers(List<OnlineUserInfo> list) {
        List<OnlineUserInfo> a = list;
        OnlineUsersPacket a2 = this;
        a2.onlineUsers = a;
    }

    @Override
    public void encode(PacketBuffer packetBuffer2) {
        PacketBuffer a = packetBuffer2;
        OnlineUsersPacket a2 = this;
        a.writeList(a2.onlineUsers, (packetBuffer, onlineUserInfo) -> {
            PacketBuffer a;
            OnlineUserInfo a2 = onlineUserInfo;
            PacketBuffer packetBuffer2 = a = packetBuffer;
            Object object = a2;
            a.writeEnum(a2.getClient());
            a.writeString(((OnlineUserInfo)object).getUsername());
            packetBuffer2.writeString(((OnlineUserInfo)object).getInGameName());
            packetBuffer2.writeEnum(a2.getRank());
        });
    }
}
