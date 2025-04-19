/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.SimpleChannelInboundHandler
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  org.apache.logging.log4j.LogManager
 */
package dev.recollect.hana.socket.network.handler;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.render.EnumChatFormatting;
import dev.recollect.hana.socket.enums.ClientType;
import dev.recollect.hana.socket.enums.Rank;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.info.UserInfoPacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.net.SocketAddress;
import java.net.SocketException;
import net.minecraft.class_310;
import net.minecraft.class_320;
import org.apache.logging.log4j.LogManager;

public class ClientHandler
extends SimpleChannelInboundHandler<Packet> {
    /*
     * WARNING - void declaration
     */
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        void v0;
        void a;
        Throwable a2 = throwable;
        ClientHandler a3 = this;
        if (a2 instanceof SocketException) {
            LogManager.getLogger().error(NpSocketClient.ALLATORIxDEMO("\u0005in.l*r/c\"$6h>.fdRKt!d3-\"tfo9R\u0016l;&5d9p b:tt"));
            v0 = a;
        } else {
            a2.printStackTrace();
            v0 = a;
        }
        v0.close();
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ClientHandler a = channelHandlerContext;
        ClientHandler a2 = this;
        LogManager.getLogger().info("Connected to server: " + String.valueOf(a.channel().remoteAddress()));
        a.writeAndFlush((Object)new UserInfoPacket(ClientType.NullPoint, 0, String.valueOf((Object)EnumChatFormatting.RESET) + class_310.method_1551().method_1548().method_1676(), Rank.USER, 0L, 114514.0));
    }

    /*
     * WARNING - void declaration
     */
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) {
        void a;
        Packet a2 = packet;
        ClientHandler a3 = this;
        LogManager.getLogger().info("Received packet: " + a2.getClass().getSimpleName());
        a2.handler((ChannelHandlerContext)a, a3);
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ClientHandler a = channelHandlerContext;
        ClientHandler a2 = this;
        LogManager.getLogger().warn(Alt.ALLATORIxDEMO("*r2}+|&| w<[Ep>v.3:~3d-wq"));
    }

    public ClientHandler() {
        ClientHandler a;
    }
}
