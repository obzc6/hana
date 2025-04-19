/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.message;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.render.EnumChatFormatting;
import dev.recollect.hana.mod.modules.impl.client.IRC;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.enums.ChannelType;
import dev.recollect.hana.socket.enums.ChatType;
import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.enums.Rank;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.video.Renderer;
import io.netty.channel.ChannelHandlerContext;

public class MessagePacket
extends Packet {
    private String username;
    private ChatType chat;
    private ClientType client;
    private ChannelType channel;
    private String message;
    private long timestamp;
    private Rank rank;

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        MessagePacket a2 = this;
        Object object = a;
        MessagePacket messagePacket = a2;
        Object object2 = a;
        MessagePacket messagePacket2 = a2;
        a.writeEnum(a2.client);
        a.writeEnum(messagePacket2.rank);
        ((PacketBuffer)object2).writeEnum(messagePacket2.channel);
        ((PacketBuffer)object2).writeEnum(a2.chat);
        a.writeString(messagePacket.username);
        ((PacketBuffer)object).writeString(messagePacket.message);
        ((PacketBuffer)object).writeLong(a2.timestamp);
    }

    /*
     * WARNING - void declaration
     */
    public MessagePacket(ClientType clientType, Rank rank, ChannelType channelType, ChatType chatType, String string, String string2, long l) {
        void a;
        void a2;
        void a3;
        void a4;
        String a5;
        MessagePacket a6;
        void a7;
        void a8;
        MessagePacket messagePacket = string3;
        String string3 = string2;
        MessagePacket messagePacket2 = a6 = messagePacket;
        MessagePacket messagePacket3 = a6;
        MessagePacket messagePacket4 = a6;
        a6.client = a2;
        messagePacket4.rank = a4;
        messagePacket4.channel = a3;
        messagePacket3.chat = a7;
        messagePacket3.username = a;
        messagePacket2.message = a5;
        messagePacket2.timestamp = a8;
    }

    public MessagePacket() {
        MessagePacket a;
    }

    public long getTimestamp() {
        MessagePacket a;
        return a.timestamp;
    }

    public String getUsername() {
        MessagePacket a;
        return a.username;
    }

    public ChatType getChat() {
        MessagePacket a;
        return a.chat;
    }

    public String getMessage() {
        MessagePacket a;
        return a.message;
    }

    public ClientType getClient() {
        MessagePacket a;
        return a.client;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        MessagePacket a2 = this;
        a2.client = a.readEnum(ClientType.class);
        a2.rank = a.readEnum(Rank.class);
        a2.channel = a.readEnum(ChannelType.class);
        a2.chat = a.readEnum(ChatType.class);
        MessagePacket messagePacket = a2;
        Object object = a;
        a2.username = ((PacketBuffer)object).readString();
        messagePacket.message = ((PacketBuffer)object).readString();
        messagePacket.timestamp = a.readLong();
    }

    public String build(String string) {
        String a = string;
        MessagePacket a2 = this;
        return a.replace(GaussianFilter.ALLATORIxDEMO("jQ+H)\u000b"), a2.getRank().getName()).replace(Renderer.ALLATORIxDEMO("4\u001ea\u0013}4b\u0013q\u000fj\u0000tH"), String.valueOf((Object)a2.getRank().color()) + a2.getRank().getName() + String.valueOf((Object)EnumChatFormatting.RESET)).replace(GaussianFilter.ALLATORIxDEMO("\r0W.M$C.\u000b"), a2.getChannel().getName()).replace(Renderer.ALLATORIxDEMO("8\u0003p\u0004dH"), a2.getChat().getName()).replace(GaussianFilter.ALLATORIxDEMO("a] Z=M+K'\u000b"), a2.getUsername()).replace(Renderer.ALLATORIxDEMO("$\u001fq\t}\u000bdH"), a2.getClient().getName()).replace(GaussianFilter.ALLATORIxDEMO("\r>Z<P+A'\u000b"), a2.getMessage());
    }

    public ChannelType getChannel() {
        MessagePacket a;
        return a.channel;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        MessagePacket a2 = this;
        if (IRC.INSTANCE.isOn() && IRC.INSTANCE.tp.getValue() == IRC.type.Chat) {
            CommandManager.sendChatMessage(String.valueOf((Object)EnumChatFormatting.GOLD) + "[IRC] " + String.valueOf((Object)EnumChatFormatting.RESET) + a2.build("[%rank_colored%] " + String.valueOf((Object)EnumChatFormatting.AQUA) + "(%channel%)" + String.valueOf((Object)EnumChatFormatting.RESET) + " %username%" + String.valueOf((Object)EnumChatFormatting.DARK_GRAY) + " <%client%>" + String.valueOf((Object)EnumChatFormatting.GRAY) + " %message%"));
        }
    }

    public Rank getRank() {
        MessagePacket a;
        return a.rank;
    }
}
