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
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVCodecParser;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVCodecParser.Split_AVCodecContext_BytePointer_int
extends FunctionPointer {
    public AVCodecParser.Split_AVCodecContext_BytePointer_int(Pointer pointer) {
        AVCodecParser.Split_AVCodecContext_BytePointer_int a = pointer;
        AVCodecParser.Split_AVCodecContext_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    protected AVCodecParser.Split_AVCodecContext_BytePointer_int() {
        AVCodecParser.Split_AVCodecContext_BytePointer_int a;
        AVCodecParser.Split_AVCodecContext_BytePointer_int split_AVCodecContext_BytePointer_int = a;
        split_AVCodecContext_BytePointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    public native int call(AVCodecContext var1, @Cast(value={"const uint8_t*"}) BytePointer var2, int var3);

    static {
        Loader.load();
    }
}
