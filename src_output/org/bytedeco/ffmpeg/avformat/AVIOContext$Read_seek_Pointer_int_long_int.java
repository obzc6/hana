/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVIOContext.Read_seek_Pointer_int_long_int
extends FunctionPointer {
    protected AVIOContext.Read_seek_Pointer_int_long_int() {
        AVIOContext.Read_seek_Pointer_int_long_int a;
        AVIOContext.Read_seek_Pointer_int_long_int read_seek_Pointer_int_long_int = a;
        read_seek_Pointer_int_long_int.allocate();
    }

    @Cast(value={"int64_t"})
    public native long call(Pointer var1, int var2, @Cast(value={"int64_t"}) long var3, int var5);

    public AVIOContext.Read_seek_Pointer_int_long_int(Pointer pointer) {
        AVIOContext.Read_seek_Pointer_int_long_int a = pointer;
        AVIOContext.Read_seek_Pointer_int_long_int a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
