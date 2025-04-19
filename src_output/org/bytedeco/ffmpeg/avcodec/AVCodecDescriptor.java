/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVProfile;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVCodecDescriptor
extends Pointer {
    @MemberGetter
    @Cast(value={"const char*"})
    public native BytePointer mime_types(int var1);

    public AVCodecDescriptor position(long a) {
        AVCodecDescriptor a2;
        return (AVCodecDescriptor)super.position(a);
    }

    @Cast(value={"const char*"})
    public native BytePointer name();

    public AVCodecDescriptor() {
        super((Pointer)null);
        AVCodecDescriptor a;
        a.allocate();
    }

    @Cast(value={"AVMediaType"})
    public native int type();

    private native /* synthetic */ void allocate();

    public AVCodecDescriptor(long a) {
        super((Pointer)null);
        AVCodecDescriptor a2;
        a2.allocateArray(a);
    }

    public native AVCodecDescriptor profiles(AVProfile var1);

    @MemberGetter
    @Cast(value={"const char*const*"})
    public native PointerPointer mime_types();

    public AVCodecDescriptor getPointer(long a) {
        AVCodecDescriptor a2;
        return (AVCodecDescriptor)new AVCodecDescriptor(a2).offsetAddress(a);
    }

    public native AVCodecDescriptor name(BytePointer var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVCodecDescriptor long_name(BytePointer var1);

    @Const
    public native AVProfile profiles();

    public AVCodecDescriptor(Pointer pointer) {
        AVCodecDescriptor a = pointer;
        AVCodecDescriptor a2 = this;
        super((Pointer)a);
    }

    public native int props();

    static {
        Loader.load();
    }

    public native AVCodecDescriptor id(int var1);

    public native AVCodecDescriptor props(int var1);

    @Cast(value={"const char*"})
    public native BytePointer long_name();

    @Cast(value={"AVCodecID"})
    public native int id();

    public native AVCodecDescriptor type(int var1);
}
