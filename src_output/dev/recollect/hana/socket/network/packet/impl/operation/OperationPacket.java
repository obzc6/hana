/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package dev.recollect.hana.socket.network.packet.impl.operation;

import dev.recollect.hana.socket.enums.Operation;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.handler.ClientHandler;
import dev.recollect.hana.socket.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;

public class OperationPacket
extends Packet {
    private String message;
    private Operation operation;
    private String initiatorUsername;
    private String targetUsername;

    public String getMessage() {
        OperationPacket a;
        return a.message;
    }

    public void setInitiatorUsername(String string) {
        String a = string;
        OperationPacket a2 = this;
        a2.initiatorUsername = a;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, ClientHandler clientHandler) {
        Object a = clientHandler;
        OperationPacket a2 = this;
        a2.getOperation().handler(a2.getMessage());
    }

    public Operation getOperation() {
        OperationPacket a;
        return a.operation;
    }

    @Override
    public void decode(PacketBuffer packetBuffer) {
        OperationPacket a;
        PacketBuffer a2 = packetBuffer;
        OperationPacket operationPacket = a = this;
        Object object = a2;
        a.initiatorUsername = a2.readString();
        a.targetUsername = ((PacketBuffer)object).readString();
        operationPacket.message = ((PacketBuffer)object).readString();
        operationPacket.operation = a2.readEnum(Operation.class);
    }

    /*
     * WARNING - void declaration
     */
    public OperationPacket(String string, String string2, String string3, Operation operation) {
        Object a;
        void a2;
        void a3;
        void a4;
        OperationPacket a5;
        OperationPacket operationPacket = object;
        Object object = operation;
        OperationPacket operationPacket2 = a5 = operationPacket;
        OperationPacket operationPacket3 = a5;
        operationPacket3.initiatorUsername = a4;
        operationPacket3.targetUsername = a3;
        operationPacket2.message = a2;
        operationPacket2.operation = a;
    }

    @Override
    public void encode(PacketBuffer packetBuffer) {
        PacketBuffer a = packetBuffer;
        OperationPacket a2 = this;
        Object object = a;
        OperationPacket operationPacket = a2;
        a.writeString(a2.initiatorUsername);
        a.writeString(operationPacket.targetUsername);
        ((PacketBuffer)object).writeString(operationPacket.message);
        ((PacketBuffer)object).writeEnum(a2.operation);
    }

    public void setOperation(Operation operation) {
        Object a = operation;
        OperationPacket a2 = this;
        a2.operation = a;
    }

    public String getTargetUsername() {
        OperationPacket a;
        return a.targetUsername;
    }

    public void setMessage(String string) {
        String a = string;
        OperationPacket a2 = this;
        a2.message = a;
    }

    public OperationPacket() {
        OperationPacket a;
    }

    public void setTargetUsername(String string) {
        String a = string;
        OperationPacket a2 = this;
        a2.targetUsername = a;
    }

    public String getInitiatorUsername() {
        OperationPacket a;
        return a.initiatorUsername;
    }
}
