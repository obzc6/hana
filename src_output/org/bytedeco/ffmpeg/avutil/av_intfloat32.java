/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_intfloat32
extends Pointer {
    public native float f();

    public native av_intfloat32 f(float var1);

    private native /* synthetic */ void allocateArray(long var1);

    public av_intfloat32(long a) {
        super((Pointer)null);
        av_intfloat32 a2;
        a2.allocateArray(a);
    }

    public av_intfloat32() {
        super((Pointer)null);
        av_intfloat32 a;
        a.allocate();
    }

    private native /* synthetic */ void allocate();

    public av_intfloat32(Pointer pointer) {
        av_intfloat32 a = pointer;
        av_intfloat32 a2 = this;
        super((Pointer)a);
    }

    public native av_intfloat32 i(int var1);

    public av_intfloat32 getPointer(long a) {
        av_intfloat32 a2;
        return (av_intfloat32)new av_intfloat32(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public av_intfloat32 position(long a) {
        av_intfloat32 a2;
        return (av_intfloat32)super.position(a);
    }

    @Cast(value={"uint32_t"})
    public native int i();
}
