/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class av_alias16
extends Pointer {
    public native av_alias16 u16(short var1);

    private native /* synthetic */ void allocateArray(long var1);

    public av_alias16(long a) {
        super((Pointer)null);
        av_alias16 a2;
        a2.allocateArray(a);
    }

    public av_alias16 getPointer(long a) {
        av_alias16 a2;
        return (av_alias16)new av_alias16(a2).offsetAddress(a);
    }

    @Cast(value={"uint16_t"})
    public native short u16();

    public native av_alias16 u8(int var1, byte var2);

    public av_alias16() {
        super((Pointer)null);
        av_alias16 a;
        a.allocate();
    }

    @Cast(value={"uint8_t"})
    public native byte u8(int var1);

    public av_alias16(Pointer pointer) {
        av_alias16 a = pointer;
        av_alias16 a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    @MemberGetter
    @Cast(value={"uint8_t*"})
    public native BytePointer u8();

    private native /* synthetic */ void allocate();

    public av_alias16 position(long a) {
        av_alias16 a2;
        return (av_alias16)super.position(a);
    }
}
