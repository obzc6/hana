/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avcodec.AVCodecParameters;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avcodec.AVPacketSideData;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVStream
extends Pointer {
    public static final int AVSTREAM_EVENT_FLAG_NEW_PACKETS = 2;
    public static final int AVSTREAM_EVENT_FLAG_METADATA_UPDATED = 1;

    public native int disposition();

    public native AVStream nb_side_data(int var1);

    @Deprecated
    public native AVPacketSideData side_data();

    public native AVStream avg_frame_rate(AVRational var1);

    private native /* synthetic */ void allocate();

    public native AVStream priv_data(Pointer var1);

    @Cast(value={"int64_t"})
    public native long nb_frames();

    @ByRef
    public native AVPacket attached_pic();

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"int64_t"})
    public native long duration();

    public native int pts_wrap_bits();

    @Cast(value={"int64_t"})
    public native long start_time();

    public native Pointer priv_data();

    public native int event_flags();

    public native AVStream start_time(long var1);

    public native AVStream nb_frames(long var1);

    public native AVCodecParameters codecpar();

    public native AVStream id(int var1);

    public native int index();

    public native AVStream duration(long var1);

    public native AVStream time_base(AVRational var1);

    public native AVStream codecpar(AVCodecParameters var1);

    public AVStream position(long a) {
        AVStream a2;
        return (AVStream)super.position(a);
    }

    public AVStream(long a) {
        super((Pointer)null);
        AVStream a2;
        a2.allocateArray(a);
    }

    public native AVStream discard(int var1);

    public native AVStream attached_pic(AVPacket var1);

    public native AVStream side_data(AVPacketSideData var1);

    public native AVStream event_flags(int var1);

    public AVStream(Pointer pointer) {
        AVStream a = pointer;
        AVStream a2 = this;
        super((Pointer)a);
    }

    public native AVDictionary metadata();

    public native AVStream index(int var1);

    @ByRef
    public native AVRational sample_aspect_ratio();

    @Deprecated
    public native int nb_side_data();

    @ByRef
    public native AVRational r_frame_rate();

    public native AVStream disposition(int var1);

    public native AVStream r_frame_rate(AVRational var1);

    public native AVStream av_class(AVClass var1);

    public native AVStream sample_aspect_ratio(AVRational var1);

    public AVStream() {
        super((Pointer)null);
        AVStream a;
        a.allocate();
    }

    public AVStream getPointer(long a) {
        AVStream a2;
        return (AVStream)new AVStream(a2).offsetAddress(a);
    }

    @Cast(value={"AVDiscard"})
    public native int discard();

    public native int id();

    @Const
    public native AVClass av_class();

    public native AVStream pts_wrap_bits(int var1);

    public native AVStream metadata(AVDictionary var1);

    @ByRef
    public native AVRational time_base();

    @ByRef
    public native AVRational avg_frame_rate();
}
