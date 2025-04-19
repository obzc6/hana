/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FloatPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.ShortPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_alias64
extends Pointer {
    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native av_alias64 u64(long var1);

    @Cast(value={"uint64_t"})
    public native long u64();

    public native double f64();

    public native av_alias64 u32(int var1, int var2);

    @MemberGetter
    @Cast(value={"uint8_t*"})
    public native BytePointer u8();

    @MemberGetter
    @Cast(value={"uint16_t*"})
    public native ShortPointer u16();

    public av_alias64 position(long a) {
        av_alias64 a2;
        return (av_alias64)super.position(a);
    }

    public native av_alias64 f64(double var1);

    public av_alias64(long a) {
        super((Pointer)null);
        av_alias64 a2;
        a2.allocateArray(a);
    }

    public av_alias64 getPointer(long a) {
        av_alias64 a2;
        return (av_alias64)new av_alias64(a2).offsetAddress(a);
    }

    @MemberGetter
    @Cast(value={"uint32_t*"})
    public native IntPointer u32();

    public native av_alias64 u8(int var1, byte var2);

    @MemberGetter
    public native FloatPointer f32();

    @Cast(value={"uint8_t"})
    public native byte u8(int var1);

    public native av_alias64 u16(int var1, short var2);

    @Cast(value={"uint16_t"})
    public native short u16(int var1);

    public av_alias64(Pointer pointer) {
        av_alias64 a = pointer;
        av_alias64 a2 = this;
        super((Pointer)a);
    }

    public native float f32(int var1);

    @Cast(value={"uint32_t"})
    public native int u32(int var1);

    public native av_alias64 f32(int var1, float var2);

    public av_alias64() {
        super((Pointer)null);
        av_alias64 a;
        a.allocate();
    }
}
