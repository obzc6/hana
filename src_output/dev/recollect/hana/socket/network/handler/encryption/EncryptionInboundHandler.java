/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelInboundHandlerAdapter
 */
package dev.recollect.hana.socket.network.handler.encryption;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bytedeco.javacv.BufferRing;

public class EncryptionInboundHandler
extends ChannelInboundHandlerAdapter {
    private final SecretKeySpec key;
    private final Cipher cipher;
    private final IvParameterSpec iv;

    /*
     * WARNING - void declaration
     */
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        void a;
        ByteBuf a2 = object;
        EncryptionInboundHandler a3 = this;
        ByteBuf byteBuf = a2;
        a2 = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes((byte[])a2);
        EncryptionInboundHandler encryptionInboundHandler = a3;
        a3.cipher.init(2, (Key)encryptionInboundHandler.key, a3.iv);
        a2 = Unpooled.wrappedBuffer((byte[])encryptionInboundHandler.cipher.doFinal((byte[])a2));
        a.fireChannelRead((Object)a2);
    }

    public EncryptionInboundHandler() {
        Object a22;
        EncryptionInboundHandler encryptionInboundHandler = a22;
        a22 = GaussianFilter.ALLATORIxDEMO("g\u0006|{{N$`m't.G6Wv\u0013");
        byte[] arrby = BufferRing.ALLATORIxDEMO("rI\u0005?oL\u000e9\u001b\t\u0010;5QZl").getBytes();
        byte[] arrby2 = new byte[16];
        EncryptionInboundHandler encryptionInboundHandler2 = encryptionInboundHandler;
        encryptionInboundHandler.key = new SecretKeySpec(arrby, GaussianFilter.ALLATORIxDEMO("]'"));
        encryptionInboundHandler.iv = new IvParameterSpec(arrby2);
        try {
            encryptionInboundHandler.cipher = Cipher.getInstance((String)a22);
            return;
        }
        catch (Exception a22) {
            throw new RuntimeException(a22);
        }
    }
}
