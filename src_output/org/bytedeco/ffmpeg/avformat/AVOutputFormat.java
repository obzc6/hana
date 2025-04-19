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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVCodecTag;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVOutputFormat
extends Pointer {
    static {
        Loader.load();
    }

    @Cast(value={"const char*"})
    public native BytePointer mime_type();

    public AVOutputFormat(Pointer pointer) {
        AVOutputFormat a = pointer;
        AVOutputFormat a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    @Cast(value={"const char*"})
    public native BytePointer long_name();

    public native AVOutputFormat long_name(BytePointer var1);

    public native AVOutputFormat priv_class(AVClass var1);

    public native AVOutputFormat audio_codec(int var1);

    public native int flags();

    @Cast(value={"AVCodecID"})
    public native int audio_codec();

    @Cast(value={"AVCodecID"})
    public native int video_codec();

    public native AVOutputFormat flags(int var1);

    public AVOutputFormat getPointer(long a) {
        AVOutputFormat a2;
        return (AVOutputFormat)new AVOutputFormat(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Const
    public native AVClass priv_class();

    public native AVOutputFormat extensions(BytePointer var1);

    public AVOutputFormat position(long a) {
        AVOutputFormat a2;
        return (AVOutputFormat)super.position(a);
    }

    public native AVOutputFormat name(BytePointer var1);

    @MemberGetter
    @Cast(value={"const AVCodecTag*const*"})
    public native PointerPointer codec_tag();

    @MemberGetter
    @Const
    public native AVCodecTag codec_tag(int var1);

    public AVOutputFormat(long a) {
        super((Pointer)null);
        AVOutputFormat a2;
        a2.allocateArray(a);
    }

    @Cast(value={"AVCodecID"})
    public native int subtitle_codec();

    public native AVOutputFormat subtitle_codec(int var1);

    @Cast(value={"const char*"})
    public native BytePointer name();

    public AVOutputFormat() {
        super((Pointer)null);
        AVOutputFormat a;
        a.allocate();
    }

    public native AVOutputFormat video_codec(int var1);

    public native AVOutputFormat mime_type(BytePointer var1);

    @Cast(value={"const char*"})
    public native BytePointer extensions();
}
