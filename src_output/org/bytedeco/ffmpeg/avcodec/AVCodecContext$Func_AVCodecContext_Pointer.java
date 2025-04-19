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
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVCodecContext.Func_AVCodecContext_Pointer
extends FunctionPointer {
    protected AVCodecContext.Func_AVCodecContext_Pointer() {
        AVCodecContext.Func_AVCodecContext_Pointer a;
        AVCodecContext.Func_AVCodecContext_Pointer func_AVCodecContext_Pointer = a;
        func_AVCodecContext_Pointer.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVCodecContext.Func_AVCodecContext_Pointer(Pointer pointer) {
        AVCodecContext.Func_AVCodecContext_Pointer a = pointer;
        AVCodecContext.Func_AVCodecContext_Pointer a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    public native int call(AVCodecContext var1, Pointer var2);
}
