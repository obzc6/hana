/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class Func_AVCodecContext_Pointer_int_int
extends FunctionPointer {
    public native int call(AVCodecContext var1, Pointer var2, int var3, int var4);

    protected Func_AVCodecContext_Pointer_int_int() {
        Func_AVCodecContext_Pointer_int_int a;
        Func_AVCodecContext_Pointer_int_int func_AVCodecContext_Pointer_int_int = a;
        func_AVCodecContext_Pointer_int_int.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public Func_AVCodecContext_Pointer_int_int(Pointer pointer) {
        Func_AVCodecContext_Pointer_int_int a = pointer;
        Func_AVCodecContext_Pointer_int_int a2 = this;
        super((Pointer)a);
    }
}
