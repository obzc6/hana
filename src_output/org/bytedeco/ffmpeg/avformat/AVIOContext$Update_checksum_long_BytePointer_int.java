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

public static class AVIOContext.Update_checksum_long_BytePointer_int
extends FunctionPointer {
    @Cast(value={"unsigned long"})
    public native long call(@Cast(value={"unsigned long"}) long var1, @Cast(value={"const uint8_t*"}) BytePointer var3, @Cast(value={"unsigned int"}) int var4);

    protected AVIOContext.Update_checksum_long_BytePointer_int() {
        AVIOContext.Update_checksum_long_BytePointer_int a;
        AVIOContext.Update_checksum_long_BytePointer_int update_checksum_long_BytePointer_int = a;
        update_checksum_long_BytePointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVIOContext.Update_checksum_long_BytePointer_int(Pointer pointer) {
        AVIOContext.Update_checksum_long_BytePointer_int a = pointer;
        AVIOContext.Update_checksum_long_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }
}
