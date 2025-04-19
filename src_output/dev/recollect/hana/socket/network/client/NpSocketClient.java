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

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.socket.enums.ConnectionState;
import dev.recollect.hana.socket.network.client.SocketClient;
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

public class NpSocketClient {
    private ExecutorService executorService;
    private ConnectionState connectionState;
    private final int port;
    private final String host;
    private Channel channel;

    public ExecutorService getExecutorService() {
        NpSocketClient a;
        return a.executorService;
    }

    public void shutdown() {
        NpSocketClient a;
        a.executorService.shutdownNow();
        try {
            if (!a.executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                LogManager.getLogger().error(Hole.ALLATORIxDEMO("&b\\#,T\bldY\u0011eTc\u0013qR\u0006h9D\u0015c\nbRb\u0017 \u0017r\u0001=\u001ej\u000et\u0017n\u0016nXu\tt\u001c."));
                return;
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public void disconnect() {
        NpSocketClient a;
        if (a.channel != null && a.channel.isOpen()) {
            a.channel.close().addListener(future -> {
                NpSocketClient npSocketClient;
                NpSocketClient a = future;
                NpSocketClient a2 = this;
                if (a.isSuccess()) {
                    LogManager.getLogger().info(SocketClient.ALLATORIxDEMO("zrn[NjCmFtNj\u001alxKAbTqM{LiC1"));
                    npSocketClient = a2;
                } else {
                    LogManager.getLogger().warn(Hole.ALLATORIxDEMO("A\u0005t\u0018h\u001c!\roYd\u001bx\u0017b\rtV)Qr"));
                    npSocketClient = a2;
                }
                npSocketClient.setConnectionState(ConnectionState.DISCONNECTED);
            });
            a.shutdown();
            return;
        }
        LogManager.getLogger().info(SocketClient.ALLATORIxDEMO("C\b$CfGk\u0007kX.AiHz\u0001!y\u0005]wrKD`\rgW EaN?dFKsNcGgZ`^1"));
    }

    public NpSocketClient() {
        a(SocketClient.ALLATORIxDEMO("kHaJbHjIk"), 11451);
        NpSocketClient a;
    }

    public boolean isConnecting() {
        NpSocketClient a;
        return a.connectionState == ConnectionState.CONNECTING;
    }

    /*
     * WARNING - void declaration
     */
    public NpSocketClient(String string, int n) {
        void a;
        NpSocketClient a2;
        int a3 = n;
        NpSocketClient npSocketClient = a2 = this;
        a2.connectionState = ConnectionState.DISCONNECTED;
        a2.host = a;
        npSocketClient.port = a3;
        npSocketClient.executorService = Executors.newFixedThreadPool(2);
    }

    public boolean isConnected() {
        NpSocketClient a;
        return a.connectionState == ConnectionState.CONNECTED && a.channel.isActive();
    }

    public void send(Packet packet) {
        Packet a2 = packet;
        NpSocketClient a3 = this;
        if (a3.channel != null && a3.channel.isActive()) {
            a3.channel.writeAndFlush((Object)a2).addListener(a -> {
                if (!a.isSuccess()) {
                    LogManager.getLogger().error("Failed to send packet: " + a.cause().getMessage());
                }
            });
        }
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ 4 << 1;
        4 << 4 ^ (2 ^ 5) << 1;
        int n4 = 5 << 3;
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

    private /* synthetic */ void setConnectionState(ConnectionState connectionState) {
        Object a = connectionState;
        NpSocketClient a2 = this;
        a2.connectionState = a;
        LogManager.getLogger().info("Connection state changed to: " + String.valueOf(a));
    }

    public ConnectionState getConnectionState() {
        NpSocketClient a;
        return a.connectionState;
    }

    public void start() {
        NpSocketClient a;
        NpSocketClient npSocketClient = a;
        npSocketClient.start(a.host, npSocketClient.port);
    }

    /*
     * WARNING - void declaration
     */
    public void start(String string, int n) {
        void a;
        int a2 = n;
        NpSocketClient a3 = this;
        if (a3.isConnected() || a3.isConnecting()) {
            LogManager.getLogger().warn(Hole.ALLATORIxDEMO(" vP%7TGw7\u001d\u0019m\u0006h\u001da\u000b+\u0000u:C\u001ea\nb\u0016+\u0016rCy\u000bs\r\u0015{\fr\u00044"));
            return;
        }
        if (a3.executorService.isShutdown() || a3.executorService.isTerminated()) {
            a3.executorService = Executors.newFixedThreadPool(2);
        }
        NpSocketClient npSocketClient = a3;
        npSocketClient.setConnectionState(ConnectionState.CONNECTING);
        npSocketClient.executorService.submit(() -> a3.lambda$start$0((String)a, a2));
    }

    public Channel getChannel() {
        NpSocketClient a;
        return a.channel;
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
