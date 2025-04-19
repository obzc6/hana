/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  org.apache.logging.log4j.LogManager
 */
package dev.recollect.hana.socket.network.client;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.socket.enums.ConnectionState;
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.bytedeco.javacv.BufferRing;

public class SocketClient {
    private ConnectionState connectionState;
    private final int port;
    private final String host;
    private ExecutorService executorService;
    private Channel channel;

    public ConnectionState getConnectionState() {
        SocketClient a;
        return a.connectionState;
    }

    public void start() {
        SocketClient a;
        SocketClient socketClient = a;
        socketClient.start(a.host, socketClient.port);
    }

    public boolean isConnecting() {
        SocketClient a;
        return a.connectionState == ConnectionState.CONNECTING;
    }

    /*
     * WARNING - void declaration
     */
    public void start(String string, int n) {
        void a;
        int a2 = n;
        SocketClient a3 = this;
        if (a3.isConnected() || a3.isConnecting()) {
            LogManager.getLogger().warn(TipUtils.ALLATORIxDEMO("\u000e\u000e/\f2\u0007&@\bt&\u00049\u0001\"\b4B?\u001c\u0005*!\b5\u000b)B)\u001b|\u00104\u001a2\u0016*\u00123\u001b;]"));
            return;
        }
        if (a3.executorService.isShutdown() || a3.executorService.isTerminated()) {
            a3.executorService = Executors.newFixedThreadPool(2);
        }
        SocketClient socketClient = a3;
        socketClient.setConnectionState(ConnectionState.CONNECTING);
        socketClient.executorService.submit(() -> a3.lambda$start$0((String)a, a2));
    }

    public SocketClient() {
        a(BufferRing.ALLATORIxDEMO("\u0011!\u0019(\u0011<\u000fm^"), 11452);
        SocketClient a;
    }

    public ExecutorService getExecutorService() {
        SocketClient a;
        return a.executorService;
    }

    private /* synthetic */ void setConnectionState(ConnectionState connectionState) {
        Object a = connectionState;
        SocketClient a2 = this;
        a2.connectionState = a;
        LogManager.getLogger().info("Connection state changed to: " + String.valueOf(a));
    }

    public void send(Packet packet) {
        Packet a2 = packet;
        SocketClient a3 = this;
        if (a3.channel != null && a3.channel.isActive()) {
            a3.channel.writeAndFlush((Object)a2).addListener(a -> {
                if (!a.isSuccess()) {
                    LogManager.getLogger().error("Failed to send packet: " + a.cause().getMessage());
                }
            });
        }
    }

    public void shutdown() {
        SocketClient a;
        a.executorService.shutdownNow();
        try {
            if (!a.executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                LogManager.getLogger().error(TipUtils.ALLATORIxDEMO("\b\u001a#\n)\u0007i[[0.\fk\n,\u0018m\u00169\u0001\u0006-*\n5\u000bm\u000b(I(\u001b>T!\u00031\u001d(\u0007)\u0007g\u001c6\u001d#G"));
                return;
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public Channel getChannel() {
        SocketClient a;
        return a.channel;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (2 ^ 5) << 1;
        int n4 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public boolean isConnected() {
        SocketClient a;
        return a.connectionState == ConnectionState.CONNECTED && a.channel.isActive();
    }

    public void disconnect() {
        SocketClient a;
        if (a.channel != null && a.channel.isOpen()) {
            a.channel.close().addListener(future -> {
                SocketClient socketClient;
                SocketClient a = future;
                SocketClient a2 = this;
                if (a.isSuccess()) {
                    LogManager.getLogger().info(BufferRing.ALLATORIxDEMO("@Y7\u0013&\u0013=\u0002 \u0003*\u001fn\t;\u0019&\u00140\u00042\u0015h\\k\b"));
                    socketClient = a2;
                } else {
                    LogManager.getLogger().warn(TipUtils.ALLATORIxDEMO("(:\u001d'\u0001#H2\u0006f\r$\u0011(\u000b2\u001di@n\u001b"));
                    socketClient = a2;
                }
                socketClient.setConnectionState(ConnectionState.DISCONNECTED);
            });
            a.shutdown();
            return;
        }
        LogManager.getLogger().info(BufferRing.ALLATORIxDEMO("y\u001b&!\u0015&\u001bk\u00166Q5\f\u00112-\u001c0]&\u001d!\t1\u0004d\u001f;]=\b7W&\u0015'\u000e'\u001b)\u00189\u00120N"));
    }

    /*
     * WARNING - void declaration
     */
    public SocketClient(String string, int n) {
        void a;
        SocketClient a2;
        int a3 = n;
        SocketClient socketClient = a2 = this;
        a2.connectionState = ConnectionState.DISCONNECTED;
        a2.host = a;
        socketClient.port = a3;
        socketClient.executorService = Executors.newFixedThreadPool(2);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void lambda$start$0(String a, int a) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 6[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}
