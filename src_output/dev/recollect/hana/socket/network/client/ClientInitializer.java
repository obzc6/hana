/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelInitializer
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.socket.SocketChannel
 *  io.netty.handler.codec.LengthFieldBasedFrameDecoder
 *  io.netty.handler.codec.LengthFieldPrepender
 */
package dev.recollect.hana.socket.network.client;

import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.handler.PacketDecoder;
import dev.recollect.hana.socket.network.handler.PacketEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class ClientInitializer
extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) {
        ClientInitializer a = socketChannel;
        ClientInitializer a2 = this;
        ChannelHandler[] arrchannelHandler = new ChannelHandler[1];
        arrchannelHandler[0] = new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4);
        a.pipeline().addLast(arrchannelHandler);
        ChannelHandler[] arrchannelHandler2 = new ChannelHandler[1];
        arrchannelHandler2[0] = new LengthFieldPrepender(4);
        a.pipeline().addLast(arrchannelHandler2);
        ChannelHandler[] arrchannelHandler3 = new ChannelHandler[1];
        arrchannelHandler3[0] = new PacketDecoder();
        a.pipeline().addLast(arrchannelHandler3);
        ChannelHandler[] arrchannelHandler4 = new ChannelHandler[1];
        arrchannelHandler4[0] = new PacketEncoder();
        a.pipeline().addLast(arrchannelHandler4);
        ChannelHandler[] arrchannelHandler5 = new ChannelHandler[1];
        arrchannelHandler5[0] = new ClientHandler();
        a.pipeline().addLast(arrchannelHandler5);
    }

    public ClientInitializer() {
        ClientInitializer a;
    }
}
