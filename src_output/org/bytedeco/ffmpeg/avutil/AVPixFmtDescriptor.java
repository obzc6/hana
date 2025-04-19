/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVComponentDescriptor;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVPixFmtDescriptor
extends Pointer {
    public native AVPixFmtDescriptor flags(long var1);

    @Cast(value={"uint64_t"})
    public native long flags();

    @Cast(value={"uint8_t"})
    public native byte log2_chroma_w();

    static {
        Loader.load();
    }

    public AVPixFmtDescriptor(long a) {
        super((Pointer)null);
        AVPixFmtDescriptor a2;
        a2.allocateArray(a);
    }

    @ByRef
    public native AVComponentDescriptor comp(int var1);

    public native AVPixFmtDescriptor alias(BytePointer var1);

    public native AVPixFmtDescriptor nb_components(byte var1);

    @Cast(value={"uint8_t"})
    public native byte log2_chroma_h();

    @MemberGetter
    public native AVComponentDescriptor comp();

    public native AVPixFmtDescriptor name(BytePointer var1);

    @Cast(value={"uint8_t"})
    public native byte nb_components();

    public native AVPixFmtDescriptor log2_chroma_w(byte var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"const char*"})
    public native BytePointer name();

    private native /* synthetic */ void allocate();

    public AVPixFmtDescriptor getPointer(long a) {
        AVPixFmtDescriptor a2;
        return (AVPixFmtDescriptor)new AVPixFmtDescriptor(a2).offsetAddress(a);
    }

    public native AVPixFmtDescriptor comp(int var1, AVComponentDescriptor var2);

    public AVPixFmtDescriptor position(long a) {
        AVPixFmtDescriptor a2;
        return (AVPixFmtDescriptor)super.position(a);
    }

    @Cast(value={"const char*"})
    public native BytePointer alias();

    public native AVPixFmtDescriptor log2_chroma_h(byte var1);

    public AVPixFmtDescriptor(Pointer pointer) {
        AVPixFmtDescriptor a = pointer;
        AVPixFmtDescriptor a2 = this;
        super((Pointer)a);
    }

    public AVPixFmtDescriptor() {
        super((Pointer)null);
        AVPixFmtDescriptor a;
        a.allocate();
    }
}
