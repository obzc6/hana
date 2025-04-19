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
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;

public class UserInfoPacket
extends Packet {
    private int userId;
    private ClientType client;
    private Rank rank;
    private long expiryDate;
    private String username;
    private double balance;

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        UserInfoPacket a2 = this;
        Object object = a;
        UserInfoPacket userInfoPacket = a2;
        Object object2 = a;
        UserInfoPacket userInfoPacket2 = a2;
        a.writeEnum(userInfoPacket2.client);
        ((PacketBuffer)object2).writeInt(userInfoPacket2.userId);
        ((PacketBuffer)object2).writeString(a2.username);
        a.writeEnum(userInfoPacket.rank);
        ((PacketBuffer)object).writeLong(userInfoPacket.expiryDate);
        ((PacketBuffer)object).writeDouble(a2.balance);
    }

    public int getUserId() {
        UserInfoPacket a;
        return a.userId;
    }

    public void setBalance(double a) {
        a.balance = a;
    }

    public void setRank(Rank rank) {
        Object a = rank;
        UserInfoPacket a2 = this;
        a2.rank = a;
    }

    public void setExpiryDate(long a) {
        a.expiryDate = a;
    }

    public UserInfoPacket() {
        UserInfoPacket a;
    }

    public void setUserId(int n) {
        int a = n;
        UserInfoPacket a2 = this;
        a2.userId = a;
    }

    public String getUsername() {
        UserInfoPacket a;
        return a.username;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        UserInfoPacket a2 = this;
        a2.client = a.readEnum(ClientType.class);
        UserInfoPacket userInfoPacket = a2;
        Object object = a;
        a2.userId = ((PacketBuffer)object).readInt();
        userInfoPacket.username = ((PacketBuffer)object).readString();
        userInfoPacket.rank = a.readEnum(Rank.class);
        UserInfoPacket userInfoPacket2 = a2;
        userInfoPacket2.expiryDate = a.readLong();
        userInfoPacket2.balance = a.readDouble();
    }

    public Rank getRank() {
        UserInfoPacket a;
        return a.rank;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        UserInfoPacket a2 = this;
    }

    /*
     * WARNING - void declaration
     */
    public UserInfoPacket(ClientType clientType, int n, String string, Rank rank, long l, double d) {
        void a;
        void a2;
        Object a3;
        void a4;
        void a5;
        void a6;
        UserInfoPacket a7;
        UserInfoPacket userInfoPacket = object;
        Object object = rank;
        UserInfoPacket userInfoPacket2 = a7 = userInfoPacket;
        UserInfoPacket userInfoPacket3 = a7;
        UserInfoPacket userInfoPacket4 = a7;
        userInfoPacket4.client = a6;
        userInfoPacket4.userId = a5;
        userInfoPacket3.username = a4;
        userInfoPacket3.rank = a3;
        userInfoPacket2.expiryDate = a2;
        userInfoPacket2.balance = a;
    }

    public double getBalance() {
        UserInfoPacket a;
        return a.balance;
    }

    public ClientType getClient() {
        UserInfoPacket a;
        return a.client;
    }

    public long getExpiryDate() {
        UserInfoPacket a;
        return a.expiryDate;
    }

    public void setClient(ClientType clientType) {
        Object a = clientType;
        UserInfoPacket a2 = this;
        a2.client = a;
    }

    public void setUsername(String string) {
        String a = string;
        UserInfoPacket a2 = this;
        a2.username = a;
    }
}
