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
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.AVFilterFormatsConfig;
import org.bytedeco.ffmpeg.avfilter.AVFilterGraph;
import org.bytedeco.ffmpeg.avfilter.AVFilterPad;
import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVChannelLayout;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterLink
extends Pointer {
    public static final int AVLINK_INIT = 2;
    public static final int AVLINK_STARTINIT = 1;
    public static final int AVLINK_UNINIT = 0;

    public native AVFilterLink reserved(int var1, byte var2);

    @ByRef
    public native AVChannelLayout ch_layout();

    public native AVFilterLink frame_count_out(long var1);

    public native AVFilterLink hw_frames_ctx(AVBufferRef var1);

    public native AVFilterPad srcpad();

    public native AVFilterLink outcfg(AVFilterFormatsConfig var1);

    public native AVFilterLink max_samples(int var1);

    public AVFilterLink() {
        super((Pointer)null);
        AVFilterLink a;
        a.allocate();
    }

    public native AVFilterLink src(AVFilterContext var1);

    public native Pointer frame_pool();

    @MemberGetter
    @Cast(value={"char*"})
    public native BytePointer reserved();

    public native AVFilterLink frame_rate(AVRational var1);

    public native AVFilterLink sample_rate(int var1);

    @Cast(value={"char"})
    public native byte reserved(int var1);

    public native AVFilterLink dstpad(AVFilterPad var1);

    @ByRef
    public native AVRational time_base();

    @ByRef
    public native AVRational frame_rate();

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int age_index();

    public native int w();

    public native AVFilterContext dst();

    public native AVFilterContext src();

    @Cast(value={"int64_t"})
    public native long sample_count_in();

    public native AVFilterLink format(int var1);

    public native AVFilterLink srcpad(AVFilterPad var1);

    public native AVFilterLink dst(AVFilterContext var1);

    public native AVFilterLink sample_count_out(long var1);

    public native AVFilterPad dstpad();

    public native AVFilterLink min_samples(int var1);

    public native AVFilterLink channel_layout(long var1);

    public native AVFilterLink ch_layout(AVChannelLayout var1);

    @ByRef
    public native AVFilterFormatsConfig outcfg();

    public AVFilterLink getPointer(long a) {
        AVFilterLink a2;
        return (AVFilterLink)new AVFilterLink(a2).offsetAddress(a);
    }

    public native AVFilterLink incfg(AVFilterFormatsConfig var1);

    public AVFilterLink(long a) {
        super((Pointer)null);
        AVFilterLink a2;
        a2.allocateArray(a);
    }

    public native AVFilterLink time_base(AVRational var1);

    @Cast(value={"int64_t"})
    public native long sample_count_out();

    public native int min_samples();

    public native int max_samples();

    public native int h();

    @Cast(value={"int64_t"})
    public native long current_pts_us();

    public native int sample_rate();

    public AVFilterLink(Pointer pointer) {
        AVFilterLink a = pointer;
        AVFilterLink a2 = this;
        super((Pointer)a);
    }

    public native int frame_wanted_out();

    public native int format();

    public native AVFilterLink w(int var1);

    public native AVFilterLink frame_count_in(long var1);

    @Cast(value={"AVMediaType"})
    public native int type();

    public native AVFilterLink current_pts_us(long var1);

    public native AVFilterLink frame_wanted_out(int var1);

    public native AVFilterLink h(int var1);

    @Cast(value={"int64_t"})
    public native long frame_count_out();

    @ByRef
    public native AVRational sample_aspect_ratio();

    @Cast(value={"int64_t"})
    public native long current_pts();

    public native AVFilterLink current_pts(long var1);

    public native AVFilterLink sample_aspect_ratio(AVRational var1);

    @Cast(value={"uint64_t"})
    @Deprecated
    public native long channel_layout();

    public native AVFilterLink type(int var1);

    public native AVFilterLink graph(AVFilterGraph var1);

    public native AVBufferRef hw_frames_ctx();

    public native AVFilterLink age_index(int var1);

    public native AVFilterLink sample_count_in(long var1);

    @Cast(value={"int64_t"})
    public native long frame_count_in();

    @ByRef
    public native AVFilterFormatsConfig incfg();

    public AVFilterLink position(long a) {
        AVFilterLink a2;
        return (AVFilterLink)super.position(a);
    }

    public native AVFilterGraph graph();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVFilterLink frame_pool(Pointer var1);
}
