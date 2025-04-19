/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.MessageToByteEncoder
 */
package dev.recollect.hana.socket.network.handler;

import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.PacketFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder
extends MessageToByteEncoder<Packet> {
    /*
     * WARNING - void declaration
     */
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        void a;
        PacketEncoder a2 = byteBuf;
        PacketEncoder a3 = this;
        a2.writeInt(PacketFactory.getPacketId(a.getClass()).intValue());
        PacketBuffer a4 = new PacketBuffer((ByteBuf)a2);
        a.encode(a4);
    }

    public PacketEncoder() {
        PacketEncoder a;
    }
}
