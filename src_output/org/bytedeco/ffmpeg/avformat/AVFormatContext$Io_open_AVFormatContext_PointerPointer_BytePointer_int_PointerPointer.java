/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer() {
        AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a;
        AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer = a;
        io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer.allocate();
    }

    public AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer(Pointer pointer) {
        AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a = pointer;
        AVFormatContext.Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a2 = this;
        super((Pointer)a);
    }

    public native int call(AVFormatContext var1, @Cast(value={"AVIOContext**"}) PointerPointer var2, @Cast(value={"const char*"}) BytePointer var3, int var4, @Cast(value={"AVDictionary**"}) PointerPointer var5);
}
