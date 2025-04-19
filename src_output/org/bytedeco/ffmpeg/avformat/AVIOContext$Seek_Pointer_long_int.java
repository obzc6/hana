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

public static class AVIOContext.Seek_Pointer_long_int
extends FunctionPointer {
    public AVIOContext.Seek_Pointer_long_int(Pointer pointer) {
        AVIOContext.Seek_Pointer_long_int a = pointer;
        AVIOContext.Seek_Pointer_long_int a2 = this;
        super((Pointer)a);
    }

    protected AVIOContext.Seek_Pointer_long_int() {
        AVIOContext.Seek_Pointer_long_int a;
        AVIOContext.Seek_Pointer_long_int seek_Pointer_long_int = a;
        seek_Pointer_long_int.allocate();
    }

    @Cast(value={"int64_t"})
    public native long call(Pointer var1, @Cast(value={"int64_t"}) long var2, int var4);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
