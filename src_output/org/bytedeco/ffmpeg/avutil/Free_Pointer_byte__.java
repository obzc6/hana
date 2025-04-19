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

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Free_Pointer_byte__
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    protected Free_Pointer_byte__() {
        Free_Pointer_byte__ a;
        Free_Pointer_byte__ free_Pointer_byte__ = a;
        free_Pointer_byte__.allocate();
    }

    static {
        Loader.load();
    }

    public native void call(Pointer var1, @Cast(value={"uint8_t*"}) byte[] var2);

    public Free_Pointer_byte__(Pointer pointer) {
        Free_Pointer_byte__ a = pointer;
        Free_Pointer_byte__ a2 = this;
        super((Pointer)a);
    }
}
