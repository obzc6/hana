/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int
extends FunctionPointer {
    protected AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int() {
        AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int a;
        AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int get_encode_buffer_AVCodecContext_AVPacket_int = a;
        get_encode_buffer_AVCodecContext_AVPacket_int.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int(Pointer pointer) {
        AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int a = pointer;
        AVCodecContext.Get_encode_buffer_AVCodecContext_AVPacket_int a2 = this;
        super((Pointer)a);
    }

    public native int call(AVCodecContext var1, AVPacket var2, int var3);

    static {
        Loader.load();
    }
}
