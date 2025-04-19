/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 */
package dev.recollect.hana.socket.network.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PacketBuffer {
    private final ByteBuf buffer;

    public String readString() {
        byte[] a;
        byte[] arrby;
        byte[] arrby2 = arrby = a;
        a = new byte[arrby2.buffer.readInt()];
        arrby2.buffer.readBytes(a);
        return new String(a, StandardCharsets.UTF_8);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 3 << 3 ^ 3;
        5 << 4 ^ 3;
        int n4 = (2 ^ 5) << 4 ^ (3 ^ 5) << 1;
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

    public <T> List<T> readList(Function<PacketBuffer, T> a) {
        ArrayList a2;
        int n;
        PacketBuffer packetBuffer = a2;
        int n2 = packetBuffer.readInt();
        a2 = new ArrayList(n2);
        int n3 = n = 0;
        while (n3 < n2) {
            T t = a.apply(packetBuffer);
            a2.add(t);
            n3 = ++n;
        }
        return a2;
    }

    public void clear() {
        PacketBuffer a;
        a.buffer.clear();
    }

    public double readDouble() {
        PacketBuffer a;
        return a.buffer.readDouble();
    }

    public ByteBuf getInternalBuffer() {
        PacketBuffer a;
        return a.buffer;
    }

    public <E extends Enum<E>> void writeEnum(E e) {
        PacketBuffer a = e;
        PacketBuffer a2 = this;
        a2.buffer.writeInt(((Enum)((Object)a)).ordinal());
    }

    public PacketBuffer(ByteBuf byteBuf) {
        PacketBuffer a = byteBuf;
        PacketBuffer a2 = this;
        a2.buffer = a;
    }

    public void writeString(String string) {
        byte[] a = string;
        PacketBuffer a2 = this;
        a = a.getBytes(StandardCharsets.UTF_8);
        a2.buffer.writeInt(a.length);
        a2.buffer.writeBytes(a);
    }

    public void writeDouble(double a) {
        PacketBuffer a2;
        a2.buffer.writeDouble(a);
    }

    public void writeInt(int n) {
        int a = n;
        PacketBuffer a2 = this;
        a2.buffer.writeInt(a);
    }

    public <E extends Enum<E>> E readEnum(Class<E> class_) {
        Class<E> a22 = class_;
        PacketBuffer a = this;
        int a22 = a.buffer.readInt();
        return (E)((Enum[])a22.getEnumConstants())[a22];
    }

    public PacketBuffer() {
        PacketBuffer a;
        a.buffer = Unpooled.buffer();
    }

    public void writeLong(long a) {
        PacketBuffer a2;
        a2.buffer.writeLong(a);
    }

    /*
     * WARNING - void declaration
     */
    public <T> void writeList(List<T> list, BiConsumer<PacketBuffer, T> biConsumer) {
        Iterator a = list;
        PacketBuffer a2 = this;
        Iterator iterator = a;
        a2.writeInt(iterator.size());
        Iterator iterator2 = a = iterator.iterator();
        while (iterator2.hasNext()) {
            void a3;
            Iterator iterator3 = a;
            iterator2 = iterator3;
            Object e = iterator3.next();
            a3.accept(a2, e);
        }
    }

    public int readInt() {
        PacketBuffer a;
        return a.buffer.readInt();
    }

    public long readLong() {
        PacketBuffer a;
        return a.buffer.readLong();
    }
}
