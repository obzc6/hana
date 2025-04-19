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
public class Func_AVCodecContext_Pointer
extends FunctionPointer {
    static {
        Loader.load();
    }

    public native int call(AVCodecContext var1, Pointer var2);

    public Func_AVCodecContext_Pointer(Pointer pointer) {
        Func_AVCodecContext_Pointer a = pointer;
        Func_AVCodecContext_Pointer a2 = this;
        super((Pointer)a);
    }

    protected Func_AVCodecContext_Pointer() {
        Func_AVCodecContext_Pointer a;
        Func_AVCodecContext_Pointer func_AVCodecContext_Pointer = a;
        func_AVCodecContext_Pointer.allocate();
    }

    private native /* synthetic */ void allocate();
}
