/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVTXContext;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_tx_fn
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public av_tx_fn(Pointer pointer) {
        av_tx_fn a = pointer;
        av_tx_fn a2 = this;
        super((Pointer)a);
    }

    protected av_tx_fn() {
        av_tx_fn a;
        av_tx_fn av_tx_fn2 = a;
        av_tx_fn2.allocate();
    }

    public native void call(AVTXContext var1, Pointer var2, Pointer var3, @Cast(value={"ptrdiff_t"}) long var4);
}
