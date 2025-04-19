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

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVInputFormat.Read_seek_AVFormatContext_int_long_int
extends FunctionPointer {
    public native int call(AVFormatContext var1, int var2, @Cast(value={"int64_t"}) long var3, int var5);

    private native /* synthetic */ void allocate();

    protected AVInputFormat.Read_seek_AVFormatContext_int_long_int() {
        AVInputFormat.Read_seek_AVFormatContext_int_long_int a;
        AVInputFormat.Read_seek_AVFormatContext_int_long_int read_seek_AVFormatContext_int_long_int = a;
        read_seek_AVFormatContext_int_long_int.allocate();
    }

    static {
        Loader.load();
    }

    public AVInputFormat.Read_seek_AVFormatContext_int_long_int(Pointer pointer) {
        AVInputFormat.Read_seek_AVFormatContext_int_long_int a = pointer;
        AVInputFormat.Read_seek_AVFormatContext_int_long_int a2 = this;
        super((Pointer)a);
    }
}
