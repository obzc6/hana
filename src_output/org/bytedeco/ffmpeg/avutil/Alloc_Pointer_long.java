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

import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Alloc_Pointer_long
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    public native AVBufferRef call(Pointer var1, @Cast(value={"size_t"}) long var2);

    static {
        Loader.load();
    }

    protected Alloc_Pointer_long() {
        Alloc_Pointer_long a;
        Alloc_Pointer_long alloc_Pointer_long = a;
        alloc_Pointer_long.allocate();
    }

    public Alloc_Pointer_long(Pointer pointer) {
        Alloc_Pointer_long a = pointer;
        Alloc_Pointer_long a2 = this;
        super((Pointer)a);
    }
}
