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
public class av_intfloat64
extends Pointer {
    public native av_intfloat64 i(long var1);

    static {
        Loader.load();
    }

    public av_intfloat64 position(long a) {
        av_intfloat64 a2;
        return (av_intfloat64)super.position(a);
    }

    private native /* synthetic */ void allocate();

    public av_intfloat64 getPointer(long a) {
        av_intfloat64 a2;
        return (av_intfloat64)new av_intfloat64(a2).offsetAddress(a);
    }

    public native av_intfloat64 f(double var1);

    public av_intfloat64() {
        super((Pointer)null);
        av_intfloat64 a;
        a.allocate();
    }

    public native double f();

    public av_intfloat64(long a) {
        super((Pointer)null);
        av_intfloat64 a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint64_t"})
    public native long i();

    private native /* synthetic */ void allocateArray(long var1);

    public av_intfloat64(Pointer pointer) {
        av_intfloat64 a = pointer;
        av_intfloat64 a2 = this;
        super((Pointer)a);
    }
}
