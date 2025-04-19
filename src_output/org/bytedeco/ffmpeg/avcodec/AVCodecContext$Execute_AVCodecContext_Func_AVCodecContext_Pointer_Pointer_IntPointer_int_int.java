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

public static class AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int() {
        AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int a;
        AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int = a;
        execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int.allocate();
    }

    public AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int(Pointer pointer) {
        AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int a = pointer;
        AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int a2 = this;
        super((Pointer)a);
    }

    public native int call(AVCodecContext var1, AVCodecContext.Func_AVCodecContext_Pointer var2, Pointer var3, IntPointer var4, int var5, int var6);
}
