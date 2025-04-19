/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVChannelLayout;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVBufferSrcParameters
extends Pointer {
    public native int width();

    public native AVBufferSrcParameters time_base(AVRational var1);

    public AVBufferSrcParameters(Pointer pointer) {
        AVBufferSrcParameters a = pointer;
        AVBufferSrcParameters a2 = this;
        super((Pointer)a);
    }

    @ByRef
    public native AVRational sample_aspect_ratio();

    public AVBufferSrcParameters getPointer(long a) {
        AVBufferSrcParameters a2;
        return (AVBufferSrcParameters)new AVBufferSrcParameters(a2).offsetAddress(a);
    }

    public native AVBufferSrcParameters sample_aspect_ratio(AVRational var1);

    @Cast(value={"uint64_t"})
    @Deprecated
    public native long channel_layout();

    public AVBufferSrcParameters position(long a) {
        AVBufferSrcParameters a2;
        return (AVBufferSrcParameters)super.position(a);
    }

    public native int height();

    static {
        Loader.load();
    }

    public native int format();

    @ByRef
    public native AVRational time_base();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVBufferSrcParameters ch_layout(AVChannelLayout var1);

    public native AVBufferSrcParameters frame_rate(AVRational var1);

    private native /* synthetic */ void allocate();

    public native AVBufferSrcParameters width(int var1);

    public native AVBufferSrcParameters sample_rate(int var1);

    public native AVBufferSrcParameters hw_frames_ctx(AVBufferRef var1);

    public AVBufferSrcParameters(long a) {
        super((Pointer)null);
        AVBufferSrcParameters a2;
        a2.allocateArray(a);
    }

    @ByRef
    public native AVChannelLayout ch_layout();

    public native AVBufferSrcParameters channel_layout(long var1);

    public native AVBufferSrcParameters format(int var1);

    @ByRef
    public native AVRational frame_rate();

    public AVBufferSrcParameters() {
        super((Pointer)null);
        AVBufferSrcParameters a;
        a.allocate();
    }

    public native int sample_rate();

    public native AVBufferRef hw_frames_ctx();

    public native AVBufferSrcParameters height(int var1);
}
