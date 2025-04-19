/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.ByteToMessageDecoder
 */
package dev.recollect.hana.socket.network.handler;

import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.PacketFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

public class PacketDecoder
extends ByteToMessageDecoder {
    public PacketDecoder() {
        PacketDecoder a;
    }

    /*
     * WARNING - void declaration
     */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object a = byteBuf;
        PacketDecoder a2 = this;
        Packet a3 = PacketFactory.createPacket(a.readInt());
        a = new PacketBuffer((ByteBuf)a);
        if (a3 != null) {
            void a4;
            Packet packet = a3;
            packet.decode((PacketBuffer)a);
            a4.add(packet);
        }
    }
}
