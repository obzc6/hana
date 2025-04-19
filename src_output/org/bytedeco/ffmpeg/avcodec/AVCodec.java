/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVProfile;
import org.bytedeco.ffmpeg.avutil.AVChannelLayout;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVCodec
extends Pointer {
    public native AVCodec long_name(BytePointer var1);

    @Const
    public native AVRational supported_framerates();

    public native AVCodec priv_class(AVClass var1);

    @Cast(value={"AVMediaType"})
    public native int type();

    public native AVCodec wrapper_name(BytePointer var1);

    @Cast(value={"const AVPixelFormat*"})
    public native IntPointer pix_fmts();

    public native AVCodec type(int var1);

    static {
        Loader.load();
    }

    public native AVCodec supported_samplerates(IntPointer var1);

    @Const
    public native AVChannelLayout ch_layouts();

    public native AVCodec capabilities(int var1);

    public native AVCodec supported_framerates(AVRational var1);

    public native int capabilities();

    @Cast(value={"const char*"})
    public native BytePointer name();

    public AVCodec getPointer(long a) {
        AVCodec a2;
        return (AVCodec)new AVCodec(a2).offsetAddress(a);
    }

    public native AVCodec channel_layouts(LongPointer var1);

    @Cast(value={"const char*"})
    public native BytePointer long_name();

    public AVCodec(long a) {
        super((Pointer)null);
        AVCodec a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocate();

    public native AVCodec sample_fmts(IntPointer var1);

    @Cast(value={"uint8_t"})
    public native byte max_lowres();

    public AVCodec() {
        super((Pointer)null);
        AVCodec a;
        a.allocate();
    }

    @Const
    public native AVProfile profiles();

    @Cast(value={"const uint64_t*"})
    @Deprecated
    public native LongPointer channel_layouts();

    public native AVCodec name(BytePointer var1);

    @Cast(value={"AVCodecID"})
    public native int id();

    public native AVCodec profiles(AVProfile var1);

    public AVCodec position(long a) {
        AVCodec a2;
        return (AVCodec)super.position(a);
    }

    public native AVCodec ch_layouts(AVChannelLayout var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"const char*"})
    public native BytePointer wrapper_name();

    public native AVCodec id(int var1);

    @Const
    public native IntPointer supported_samplerates();

    @Const
    public native AVClass priv_class();

    public AVCodec(Pointer pointer) {
        AVCodec a = pointer;
        AVCodec a2 = this;
        super((Pointer)a);
    }

    public native AVCodec pix_fmts(IntPointer var1);

    public native AVCodec max_lowres(byte var1);

    @Cast(value={"const AVSampleFormat*"})
    public native IntPointer sample_fmts();
}
