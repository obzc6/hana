/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVComplexInt32
extends Pointer {
    public AVComplexInt32(long a) {
        super((Pointer)null);
        AVComplexInt32 a2;
        a2.allocateArray(a);
    }

    public AVComplexInt32 getPointer(long a) {
        AVComplexInt32 a2;
        return (AVComplexInt32)new AVComplexInt32(a2).offsetAddress(a);
    }

    public AVComplexInt32 position(long a) {
        AVComplexInt32 a2;
        return (AVComplexInt32)super.position(a);
    }

    public native AVComplexInt32 re(int var1);

    static {
        Loader.load();
    }

    public native int re();

    public AVComplexInt32() {
        super((Pointer)null);
        AVComplexInt32 a;
        a.allocate();
    }

    public AVComplexInt32(Pointer pointer) {
        AVComplexInt32 a = pointer;
        AVComplexInt32 a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public native AVComplexInt32 im(int var1);

    public native int im();
}
