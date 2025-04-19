/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_pixelutils_sad_fn
extends FunctionPointer {
    public native int call(@Cast(value={"const uint8_t*"}) BytePointer var1, @Cast(value={"ptrdiff_t"}) long var2, @Cast(value={"const uint8_t*"}) BytePointer var4, @Cast(value={"ptrdiff_t"}) long var5);

    private native /* synthetic */ void allocate();

    public av_pixelutils_sad_fn(Pointer pointer) {
        av_pixelutils_sad_fn a = pointer;
        av_pixelutils_sad_fn a2 = this;
        super((Pointer)a);
    }

    protected av_pixelutils_sad_fn() {
        av_pixelutils_sad_fn a;
        av_pixelutils_sad_fn av_pixelutils_sad_fn2 = a;
        av_pixelutils_sad_fn2.allocate();
    }

    static {
        Loader.load();
    }
}
