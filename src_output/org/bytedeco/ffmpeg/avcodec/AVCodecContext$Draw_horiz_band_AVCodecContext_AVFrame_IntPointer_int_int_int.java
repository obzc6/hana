/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Const
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Const;

public static class AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int
extends FunctionPointer {
    protected AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int() {
        AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int a;
        AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int = a;
        draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int.allocate();
    }

    static {
        Loader.load();
    }

    public native void call(AVCodecContext var1, @Const AVFrame var2, IntPointer var3, int var4, int var5, int var6);

    private native /* synthetic */ void allocate();

    public AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int(Pointer pointer) {
        AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int a = pointer;
        AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int a2 = this;
        super((Pointer)a);
    }
}
