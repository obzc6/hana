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

public static class AVCodecContext.Func_AVCodecContext_Pointer_int_int
extends FunctionPointer {
    public AVCodecContext.Func_AVCodecContext_Pointer_int_int(Pointer pointer) {
        AVCodecContext.Func_AVCodecContext_Pointer_int_int a = pointer;
        AVCodecContext.Func_AVCodecContext_Pointer_int_int a2 = this;
        super((Pointer)a);
    }

    public native int call(AVCodecContext var1, Pointer var2, int var3, int var4);

    protected AVCodecContext.Func_AVCodecContext_Pointer_int_int() {
        AVCodecContext.Func_AVCodecContext_Pointer_int_int a;
        AVCodecContext.Func_AVCodecContext_Pointer_int_int func_AVCodecContext_Pointer_int_int = a;
        func_AVCodecContext_Pointer_int_int.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();
}
