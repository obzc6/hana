/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVCodecContext.Get_format_AVCodecContext_IntPointer
extends FunctionPointer {
    static {
        Loader.load();
    }

    protected AVCodecContext.Get_format_AVCodecContext_IntPointer() {
        AVCodecContext.Get_format_AVCodecContext_IntPointer a;
        AVCodecContext.Get_format_AVCodecContext_IntPointer get_format_AVCodecContext_IntPointer = a;
        get_format_AVCodecContext_IntPointer.allocate();
    }

    @Cast(value={"AVPixelFormat"})
    public native int call(AVCodecContext var1, @Cast(value={"const AVPixelFormat*"}) IntPointer var2);

    public AVCodecContext.Get_format_AVCodecContext_IntPointer(Pointer pointer) {
        AVCodecContext.Get_format_AVCodecContext_IntPointer a = pointer;
        AVCodecContext.Get_format_AVCodecContext_IntPointer a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();
}
