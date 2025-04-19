/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int
extends FunctionPointer {
    static {
        Loader.load();
    }

    public AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int(Pointer pointer) {
        AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int a = pointer;
        AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int a2 = this;
        super((Pointer)a);
    }

    protected AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int() {
        AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int a;
        AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int = a;
        execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    public native int call(AVCodecContext var1, AVCodecContext.Func_AVCodecContext_Pointer_int_int var2, Pointer var3, IntPointer var4, int var5);
}
