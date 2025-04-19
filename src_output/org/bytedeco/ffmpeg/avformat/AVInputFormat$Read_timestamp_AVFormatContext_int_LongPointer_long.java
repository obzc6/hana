/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    @Cast(value={"int64_t"})
    public native long call(AVFormatContext var1, int var2, @Cast(value={"int64_t*"}) LongPointer var3, @Cast(value={"int64_t"}) long var4);

    protected AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long() {
        AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long a;
        AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp_AVFormatContext_int_LongPointer_long = a;
        read_timestamp_AVFormatContext_int_LongPointer_long.allocate();
    }

    public AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long(Pointer pointer) {
        AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long a = pointer;
        AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long a2 = this;
        super((Pointer)a);
    }
}
