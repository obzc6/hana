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

public static class AVIOContext.Write_packet_Pointer_BytePointer_int
extends FunctionPointer {
    protected AVIOContext.Write_packet_Pointer_BytePointer_int() {
        AVIOContext.Write_packet_Pointer_BytePointer_int a;
        AVIOContext.Write_packet_Pointer_BytePointer_int write_packet_Pointer_BytePointer_int = a;
        write_packet_Pointer_BytePointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVIOContext.Write_packet_Pointer_BytePointer_int(Pointer pointer) {
        AVIOContext.Write_packet_Pointer_BytePointer_int a = pointer;
        AVIOContext.Write_packet_Pointer_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3);
}
