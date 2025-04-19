/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
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
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_alias32
extends Pointer {
    @MemberGetter
    @Cast(value={"uint8_t*"})
    public native BytePointer u8();

    @MemberGetter
    @Cast(value={"uint16_t*"})
    public native ShortPointer u16();

    public av_alias32 getPointer(long a) {
        av_alias32 a2;
        return (av_alias32)new av_alias32(a2).offsetAddress(a);
    }

    public av_alias32 position(long a) {
        av_alias32 a2;
        return (av_alias32)super.position(a);
    }

    private native /* synthetic */ void allocate();

    public av_alias32() {
        super((Pointer)null);
        av_alias32 a;
        a.allocate();
    }

    public native av_alias32 f32(float var1);

    @Cast(value={"uint8_t"})
    public native byte u8(int var1);

    public av_alias32(Pointer pointer) {
        av_alias32 a = pointer;
        av_alias32 a2 = this;
        super((Pointer)a);
    }

    public native av_alias32 u8(int var1, byte var2);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"uint32_t"})
    public native int u32();

    public native float f32();

    public native av_alias32 u16(int var1, short var2);

    public av_alias32(long a) {
        super((Pointer)null);
        av_alias32 a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    @Cast(value={"uint16_t"})
    public native short u16(int var1);

    public native av_alias32 u32(int var1);
}
