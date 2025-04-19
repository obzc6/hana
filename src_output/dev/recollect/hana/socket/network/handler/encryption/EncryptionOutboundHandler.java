/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelOutboundHandlerAdapter
 *  io.netty.channel.ChannelPromise
 */
package dev.recollect.hana.socket.network.handler.encryption;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.xibao.SnowAnimation;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionOutboundHandler
extends ChannelOutboundHandlerAdapter {
    private final Cipher cipher;
    private final SecretKeySpec key;
    private final IvParameterSpec iv;

    /*
     * WARNING - void declaration
     */
    public void write(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) throws Exception {
        void a;
        void a2;
        ByteBuf a3 = object;
        EncryptionOutboundHandler a4 = this;
        ByteBuf byteBuf = a3;
        a3 = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes((byte[])a3);
        EncryptionOutboundHandler encryptionOutboundHandler = a4;
        a4.cipher.init(1, (Key)encryptionOutboundHandler.key, a4.iv);
        a3 = Unpooled.wrappedBuffer((byte[])encryptionOutboundHandler.cipher.doFinal((byte[])a3));
        a.write((Object)a3, (ChannelPromise)a2);
    }

    public EncryptionOutboundHandler() {
        Object a22;
        EncryptionOutboundHandler encryptionOutboundHandler = a22;
        a22 = SnowAnimation.ALLATORIxDEMO("-}5;\ti1\u001d\"W6Q\n]\u000e@\u0017");
        byte[] arrby = Vec3.ALLATORIxDEMO(".Kb\u0006o\u0012T=L\u0000H=yCK#").getBytes();
        byte[] arrby2 = new byte[16];
        EncryptionOutboundHandler encryptionOutboundHandler2 = encryptionOutboundHandler;
        encryptionOutboundHandler.key = new SecretKeySpec(arrby, SnowAnimation.ALLATORIxDEMO("&k#"));
        encryptionOutboundHandler.iv = new IvParameterSpec(arrby2);
        try {
            encryptionOutboundHandler.cipher = Cipher.getInstance((String)a22);
            return;
        }
        catch (Exception a22) {
            throw new RuntimeException(a22);
        }
    }
}
