/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVChannelLayout;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.avutil.AVFrameSideData;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVFrame
extends Pointer {
    public static final int FF_DECODE_ERROR_CONCEALMENT_ACTIVE = 4;
    public static final int AV_FRAME_FLAG_DISCARD = 4;
    public static final int AV_FRAME_FLAG_KEY = 2;
    public static final int FF_DECODE_ERROR_INVALID_BITSTREAM = 1;
    public static final int FF_DECODE_ERROR_MISSING_REFERENCE = 2;
    public static final int FF_DECODE_ERROR_DECODE_SLICES = 8;
    public static final int AV_FRAME_FLAG_INTERLACED = 8;
    public static final int AV_FRAME_FLAG_CORRUPT = 1;
    public static final int AV_NUM_DATA_POINTERS = 8;
    public static final int AV_FRAME_FLAG_TOP_FIELD_FIRST = 16;

    @Cast(value={"int64_t"})
    public native long best_effort_timestamp();

    public native AVFrame top_field_first(int var1);

    public native int decode_error_flags();

    public native AVFrame crop_bottom(long var1);

    public native AVFrame extended_buf(PointerPointer var1);

    @Cast(value={"int64_t"})
    public native long pkt_dts();

    @Cast(value={"AVColorTransferCharacteristic"})
    public native int color_trc();

    @Cast(value={"uint8_t**"})
    public native PointerPointer extended_data();

    public native AVFrame colorspace(int var1);

    public native AVFrame opaque(Pointer var1);

    @Cast(value={"int64_t"})
    public native long pts();

    public native AVFrame private_ref(AVBufferRef var1);

    public native AVFrame pkt_dts(long var1);

    public AVFrame(long a) {
        super((Pointer)null);
        AVFrame a2;
        a2.allocateArray(a);
    }

    public native AVFrame format(int var1);

    public AVFrame position(long a) {
        AVFrame a2;
        return (AVFrame)super.position(a);
    }

    public native AVFrame extended_data(PointerPointer var1);

    public native AVBufferRef buf(int var1);

    @Deprecated
    public native int display_picture_number();

    public native AVFrame crop_top(long var1);

    @Cast(value={"size_t"})
    public native long crop_right();

    public native int linesize(int var1);

    public native AVFrame opaque_ref(AVBufferRef var1);

    @Deprecated
    public native int key_frame();

    public native AVFrame time_base(AVRational var1);

    public native AVFrame channel_layout(long var1);

    public native AVFrame color_range(int var1);

    public native AVFrame sample_aspect_ratio(AVRational var1);

    @MemberGetter
    @Cast(value={"uint8_t**"})
    public native PointerPointer data();

    @Deprecated
    public native int top_field_first();

    public native AVFrame repeat_pict(int var1);

    @ByRef
    public native AVChannelLayout ch_layout();

    public native int width();

    public native AVFrame reordered_opaque(long var1);

    public native AVFrame pkt_size(int var1);

    public native AVFrame best_effort_timestamp(long var1);

    public native int nb_side_data();

    public native AVFrameSideData side_data(int var1);

    @Deprecated
    public native int interlaced_frame();

    public native AVFrame crop_left(long var1);

    public native int sample_rate();

    public native AVFrame nb_extended_buf(int var1);

    public native AVFrame pts(long var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer extended_data(int var1);

    public native AVFrame side_data(PointerPointer var1);

    @ByRef
    public native AVRational time_base();

    public native AVFrame quality(int var1);

    static {
        Loader.load();
    }

    public native AVFrame palette_has_changed(int var1);

    public native AVFrame chroma_location(int var1);

    public native AVFrame pkt_duration(long var1);

    public native AVFrame width(int var1);

    public native int nb_samples();

    private native /* synthetic */ void allocateArray(long var1);

    public native Pointer opaque();

    public native AVFrame color_trc(int var1);

    public native AVFrame nb_samples(int var1);

    @Deprecated
    public native int palette_has_changed();

    public native AVFrame key_frame(int var1);

    public native AVFrame data(int var1, BytePointer var2);

    public native AVFrame nb_side_data(int var1);

    @Cast(value={"AVBufferRef**"})
    public native PointerPointer extended_buf();

    @Cast(value={"int64_t"})
    @Deprecated
    public native long pkt_pos();

    public native AVBufferRef extended_buf(int var1);

    @ByRef
    public native AVRational sample_aspect_ratio();

    public native AVFrame extended_data(int var1, BytePointer var2);

    @Cast(value={"uint8_t*"})
    public native BytePointer data(int var1);

    public native int height();

    public native AVFrame decode_error_flags(int var1);

    @Cast(value={"AVChromaLocation"})
    public native int chroma_location();

    public native AVFrame sample_rate(int var1);

    public native AVDictionary metadata();

    @Cast(value={"size_t"})
    public native long crop_bottom();

    public native AVFrame hw_frames_ctx(AVBufferRef var1);

    public native AVFrame coded_picture_number(int var1);

    @Cast(value={"AVColorRange"})
    public native int color_range();

    public native AVFrame metadata(AVDictionary var1);

    public native AVFrame color_primaries(int var1);

    public AVFrame() {
        super((Pointer)null);
        AVFrame a;
        a.allocate();
    }

    @Cast(value={"AVColorPrimaries"})
    public native int color_primaries();

    public native AVBufferRef opaque_ref();

    public native AVFrame channels(int var1);

    @Cast(value={"AVFrameSideData**"})
    public native PointerPointer side_data();

    public native AVFrame linesize(int var1, int var2);

    @Deprecated
    public native int channels();

    public native AVFrame pkt_pos(long var1);

    @Cast(value={"int64_t"})
    @Deprecated
    public native long pkt_duration();

    public native int nb_extended_buf();

    @MemberGetter
    @Cast(value={"AVBufferRef**"})
    public native PointerPointer buf();

    public native AVFrame ch_layout(AVChannelLayout var1);

    public native int format();

    @Deprecated
    public native int coded_picture_number();

    @Deprecated
    public native int pkt_size();

    @Cast(value={"AVPictureType"})
    public native int pict_type();

    public native AVFrame flags(int var1);

    public native AVFrame extended_buf(int var1, AVBufferRef var2);

    @Cast(value={"size_t"})
    public native long crop_left();

    @MemberGetter
    public native IntPointer linesize();

    public native int repeat_pict();

    public AVFrame(Pointer pointer) {
        AVFrame a = pointer;
        AVFrame a2 = this;
        super((Pointer)a);
    }

    public native AVBufferRef private_ref();

    private native /* synthetic */ void allocate();

    public native AVFrame buf(int var1, AVBufferRef var2);

    public native AVBufferRef hw_frames_ctx();

    public native AVFrame duration(long var1);

    public native int flags();

    @Cast(value={"int64_t"})
    @Deprecated
    public native long reordered_opaque();

    public native AVFrame display_picture_number(int var1);

    @Cast(value={"size_t"})
    public native long crop_top();

    @Cast(value={"int64_t"})
    public native long duration();

    public native AVFrame side_data(int var1, AVFrameSideData var2);

    public native int quality();

    public AVFrame getPointer(long a) {
        AVFrame a2;
        return (AVFrame)new AVFrame(a2).offsetAddress(a);
    }

    @Cast(value={"AVColorSpace"})
    public native int colorspace();

    public native AVFrame interlaced_frame(int var1);

    public native AVFrame height(int var1);

    @Cast(value={"uint64_t"})
    @Deprecated
    public native long channel_layout();

    public native AVFrame crop_right(long var1);

    public native AVFrame pict_type(int var1);
}
