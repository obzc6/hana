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
public class Alloc_long
extends FunctionPointer {
    public Alloc_long(Pointer pointer) {
        Alloc_long a = pointer;
        Alloc_long a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected Alloc_long() {
        Alloc_long a;
        Alloc_long alloc_long = a;
        alloc_long.allocate();
    }

    public native AVBufferRef call(@Cast(value={"size_t"}) long var1);
}
