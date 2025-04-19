/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecParser;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVCodecParserContext
extends Pointer {
    public static final int PARSER_FLAG_ONCE = 2;
    public static final int AV_PARSER_PTS_NB = 4;
    public static final int PARSER_FLAG_FETCHED_OFFSET = 4;
    public static final int PARSER_FLAG_USE_CODEC_TS = 4096;
    public static final int PARSER_FLAG_COMPLETE_FRAMES = 1;

    public native int duration();

    public native Pointer priv_data();

    public native AVCodecParserContext dts_ref_dts_delta(int var1);

    public native int format();

    public native AVCodecParserContext next_frame_offset(long var1);

    public native int repeat_pict();

    public native int width();

    @Cast(value={"int64_t"})
    public native long pts();

    @MemberGetter
    @Cast(value={"int64_t*"})
    public native LongPointer cur_frame_pos();

    public native AVCodecParserContext format(int var1);

    public native AVCodecParserContext cur_frame_dts(int var1, long var2);

    public AVCodecParserContext() {
        super((Pointer)null);
        AVCodecParserContext a;
        a.allocate();
    }

    public native AVCodecParserContext cur_frame_start_index(int var1);

    public native int cur_frame_start_index();

    public native AVCodecParserContext repeat_pict(int var1);

    public native AVCodecParserContext field_order(int var1);

    public native int height();

    @Cast(value={"int64_t"})
    public native long dts();

    public native AVCodecParserContext pict_type(int var1);

    public native AVCodecParserContext cur_frame_end(int var1, long var2);

    public native int dts_sync_point();

    public native AVCodecParserContext last_dts(long var1);

    public native AVCodecParserContext picture_structure(int var1);

    @Cast(value={"int64_t"})
    public native long next_frame_offset();

    public native AVCodecParserContext dts(long var1);

    public native AVCodecParserContext coded_height(int var1);

    public native int coded_width();

    public native int pict_type();

    public native AVCodecParserContext pts_dts_delta(int var1);

    public AVCodecParserContext(long a) {
        super((Pointer)null);
        AVCodecParserContext a2;
        a2.allocateArray(a);
    }

    public native AVCodecParserContext priv_data(Pointer var1);

    public native int coded_height();

    public native AVCodecParserContext offset(long var1);

    public native AVCodecParserContext last_pts(long var1);

    public AVCodecParserContext position(long a) {
        AVCodecParserContext a2;
        return (AVCodecParserContext)super.position(a);
    }

    @Cast(value={"int64_t"})
    public native long last_pos();

    public native AVCodecParserContext width(int var1);

    private native /* synthetic */ void allocate();

    @Cast(value={"int64_t"})
    public native long cur_frame_offset(int var1);

    public native AVCodecParserContext flags(int var1);

    @Cast(value={"int64_t"})
    public native long cur_offset();

    @Cast(value={"int64_t"})
    public native long frame_offset();

    @MemberGetter
    @Cast(value={"int64_t*"})
    public native LongPointer cur_frame_dts();

    public native AVCodecParserContext last_pos(long var1);

    public native AVCodecParserContext duration(int var1);

    @Cast(value={"AVFieldOrder"})
    public native int field_order();

    @MemberGetter
    @Cast(value={"int64_t*"})
    public native LongPointer cur_frame_pts();

    public native AVCodecParserContext pts(long var1);

    @Cast(value={"int64_t"})
    public native long pos();

    public native AVCodecParserContext cur_offset(long var1);

    @MemberGetter
    @Cast(value={"int64_t*"})
    public native LongPointer cur_frame_end();

    public native AVCodecParserContext frame_offset(long var1);

    @MemberGetter
    @Cast(value={"int64_t*"})
    public native LongPointer cur_frame_offset();

    public native AVCodecParserContext key_frame(int var1);

    public native int output_picture_number();

    public native int fetch_timestamp();

    public native int flags();

    @Cast(value={"int64_t"})
    public native long cur_frame_end(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"int64_t"})
    public native long last_pts();

    public native int pts_dts_delta();

    @Cast(value={"int64_t"})
    public native long cur_frame_dts(int var1);

    public native AVCodecParserContext cur_frame_offset(int var1, long var2);

    public native AVCodecParserContext output_picture_number(int var1);

    public AVCodecParserContext(Pointer pointer) {
        AVCodecParserContext a = pointer;
        AVCodecParserContext a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"AVPictureStructure"})
    public native int picture_structure();

    public native AVCodecParserContext dts_sync_point(int var1);

    @Cast(value={"int64_t"})
    public native long last_dts();

    public native AVCodecParserContext parser(AVCodecParser var1);

    static {
        Loader.load();
    }

    @Cast(value={"int64_t"})
    public native long offset();

    public native int dts_ref_dts_delta();

    public native AVCodecParserContext coded_width(int var1);

    public native AVCodecParserContext fetch_timestamp(int var1);

    @Const
    public native AVCodecParser parser();

    public native AVCodecParserContext cur_frame_pos(int var1, long var2);

    public native int key_frame();

    public native AVCodecParserContext cur_frame_pts(int var1, long var2);

    public AVCodecParserContext getPointer(long a) {
        AVCodecParserContext a2;
        return (AVCodecParserContext)new AVCodecParserContext(a2).offsetAddress(a);
    }

    @Cast(value={"int64_t"})
    public native long cur_frame_pts(int var1);

    @Cast(value={"int64_t"})
    public native long cur_frame_pos(int var1);

    public native AVCodecParserContext pos(long var1);

    public native AVCodecParserContext height(int var1);
}
