/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVIOContext.Read_packet_Pointer_BytePointer_int
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    public AVIOContext.Read_packet_Pointer_BytePointer_int(Pointer pointer) {
        AVIOContext.Read_packet_Pointer_BytePointer_int a = pointer;
        AVIOContext.Read_packet_Pointer_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    protected AVIOContext.Read_packet_Pointer_BytePointer_int() {
        AVIOContext.Read_packet_Pointer_BytePointer_int a;
        AVIOContext.Read_packet_Pointer_BytePointer_int read_packet_Pointer_BytePointer_int = a;
        read_packet_Pointer_BytePointer_int.allocate();
    }

    static {
        Loader.load();
    }

    public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3);
}
