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
public class AVChannelCustom
extends Pointer {
    static {
        Loader.load();
    }

    public AVChannelCustom(Pointer pointer) {
        AVChannelCustom a = pointer;
        AVChannelCustom a2 = this;
        super((Pointer)a);
    }

    @MemberGetter
    @Cast(value={"char*"})
    public native BytePointer name();

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    @Cast(value={"AVChannel"})
    public native int id();

    public AVChannelCustom() {
        super((Pointer)null);
        AVChannelCustom a;
        a.allocate();
    }

    public AVChannelCustom getPointer(long a) {
        AVChannelCustom a2;
        return (AVChannelCustom)new AVChannelCustom(a2).offsetAddress(a);
    }

    @Cast(value={"char"})
    public native byte name(int var1);

    public native AVChannelCustom name(int var1, byte var2);

    public native AVChannelCustom opaque(Pointer var1);

    public AVChannelCustom position(long a) {
        AVChannelCustom a2;
        return (AVChannelCustom)super.position(a);
    }

    public AVChannelCustom(long a) {
        super((Pointer)null);
        AVChannelCustom a2;
        a2.allocateArray(a);
    }

    public native Pointer opaque();

    public native AVChannelCustom id(int var1);
}
