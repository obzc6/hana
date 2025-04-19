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
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int
extends FunctionPointer {
    protected AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int() {
        AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int a;
        AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int get_buffer2_AVCodecContext_AVFrame_int = a;
        get_buffer2_AVCodecContext_AVFrame_int.allocate();
    }

    public native int call(AVCodecContext var1, AVFrame var2, int var3);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int(Pointer pointer) {
        AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int a = pointer;
        AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int a2 = this;
        super((Pointer)a);
    }
}
