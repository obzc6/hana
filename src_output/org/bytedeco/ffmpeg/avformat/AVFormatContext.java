/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avformat.AVChapter;
import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.ffmpeg.avformat.AVIOInterruptCB;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.ffmpeg.avformat.AVOutputFormat;
import org.bytedeco.ffmpeg.avformat.AVProgram;
import org.bytedeco.ffmpeg.avformat.AVStream;
import org.bytedeco.ffmpeg.avformat.av_format_control_message;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVFormatContext
extends Pointer {
    public static final int FF_FDEBUG_TS = 1;
    public static final int AVFMT_FLAG_CUSTOM_IO = 128;
    public static final int AVFMT_FLAG_SORT_DTS = 65536;
    public static final int AVFMT_EVENT_FLAG_METADATA_UPDATED = 1;
    public static final int AVFMT_FLAG_GENPTS = 1;
    public static final int AVFMT_AVOID_NEG_TS_MAKE_ZERO = 2;
    public static final int AVFMT_AVOID_NEG_TS_DISABLED = 0;
    public static final int AVFMT_FLAG_NOPARSE = 32;
    public static final int AVFMT_FLAG_SHORTEST = 1048576;
    public static final int AVFMT_FLAG_IGNIDX = 2;
    public static final int AVFMT_FLAG_BITEXACT = 1024;
    public static final int AVFMT_FLAG_FAST_SEEK = 524288;
    public static final int AVFMT_AVOID_NEG_TS_MAKE_NON_NEGATIVE = 1;
    public static final int AVFMT_FLAG_NOFILLIN = 16;
    public static final int AVFMT_AVOID_NEG_TS_AUTO = -1;
    public static final int AVFMT_FLAG_IGNDTS = 8;
    public static final int AVFMT_FLAG_FLUSH_PACKETS = 512;
    public static final int AVFMT_FLAG_DISCARD_CORRUPT = 256;
    public static final int AVFMT_FLAG_AUTO_BSF = 2097152;
    public static final int AVFMT_FLAG_NOBUFFER = 64;
    public static final int AVFMT_FLAG_NONBLOCK = 4;

    public native int probe_score();

    public native AVFormatContext data_codec_id(int var1);

    public native AVFormatContext start_time_realtime(long var1);

    public native int max_chunk_duration();

    public native int seek2any();

    @Cast(value={"int64_t"})
    public native long probesize();

    public native int max_delay();

    static {
        Loader.load();
    }

    public native AVFormatContext io_close2(Io_close2_AVFormatContext_AVIOContext var1);

    public native AVFormatContext av_class(AVClass var1);

    public native int debug();

    public native AVFormatContext streams(int var1, AVStream var2);

    public native AVFormatContext seek2any(int var1);

    public native AVFormatContext url(BytePointer var1);

    public native AVFormatContext control_message_cb(av_format_control_message var1);

    public native AVFormatContext codec_whitelist(BytePointer var1);

    @Const
    public native AVCodec data_codec();

    public native AVProgram programs(int var1);

    public native AVFormatContext oformat(AVOutputFormat var1);

    public native AVFormatContext audio_codec_id(int var1);

    @Cast(value={"unsigned int"})
    public native int packet_size();

    public native AVFormatContext format_whitelist(BytePointer var1);

    @Cast(value={"AVStream**"})
    public native PointerPointer streams();

    public native int flush_packets();

    public native AVFormatContext skip_estimate_duration_from_pts(int var1);

    @Cast(value={"int64_t"})
    public native long output_ts_offset();

    @Const
    public native AVCodec audio_codec();

    public native int error_recognition();

    @Const
    public native AVCodec subtitle_codec();

    public native AVFormatContext priv_data(Pointer var1);

    public native AVFormatContext output_ts_offset(long var1);

    @Cast(value={"unsigned int"})
    public native int nb_chapters();

    public native AVFormatContext probesize(long var1);

    @Cast(value={"AVDurationEstimationMethod"})
    public native int duration_estimation_method();

    public native AVFormatContext protocol_blacklist(BytePointer var1);

    public native AVFormatContext event_flags(int var1);

    public native AVFormatContext subtitle_codec_id(int var1);

    public native AVFormatContext video_codec(AVCodec var1);

    public native AVFormatContext subtitle_codec(AVCodec var1);

    public native int use_wallclock_as_timestamps();

    public native AVFormatContext audio_preload(int var1);

    @Cast(value={"const uint8_t*"})
    public native BytePointer key();

    public native AVFormatContext duration(long var1);

    @Const
    public native AVClass av_class();

    public AVFormatContext getPointer(long a) {
        AVFormatContext a2;
        return (AVFormatContext)new AVFormatContext(a2).offsetAddress(a);
    }

    public native AVFormatContext key(BytePointer var1);

    @Cast(value={"int64_t"})
    public native long start_time();

    public native AVFormatContext max_picture_buffer(int var1);

    public native AVFormatContext chapters(PointerPointer var1);

    public native AVFormatContext data_codec(AVCodec var1);

    public native AVFormatContext probe_score(int var1);

    public native AVFormatContext nb_chapters(int var1);

    @Const
    public native AVCodec video_codec();

    public native int avoid_negative_ts();

    public native AVFormatContext max_delay(int var1);

    public native AVFormatContext io_repositioned(int var1);

    public native int max_ts_probe();

    @Cast(value={"int64_t"})
    public native long max_analyze_duration();

    @Cast(value={"int64_t"})
    public native long duration();

    public native AVFormatContext flush_packets(int var1);

    @Cast(value={"char*"})
    public native BytePointer protocol_whitelist();

    public native int max_probe_packets();

    public native AVFormatContext error_recognition(int var1);

    public native AVFormatContext max_streams(int var1);

    @Cast(value={"AVCodecID"})
    public native int audio_codec_id();

    @Cast(value={"uint8_t*"})
    public native BytePointer dump_separator();

    public native AVFormatContext programs(PointerPointer var1);

    @Cast(value={"unsigned int"})
    public native int max_picture_buffer();

    public native AVFormatContext io_open(Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer var1);

    public native AVFormatContext dump_separator(BytePointer var1);

    @Cast(value={"char*"})
    public native BytePointer url();

    public native AVFormatContext avoid_negative_ts(int var1);

    public native int metadata_header_padding();

    public native AVFormatContext packet_size(int var1);

    public native AVFormatContext video_codec_id(int var1);

    public native AVFormatContext max_analyze_duration(long var1);

    @ByRef
    public native AVIOInterruptCB interrupt_callback();

    public native AVFormatContext opaque(Pointer var1);

    public native int max_chunk_size();

    public native AVFormatContext duration_estimation_method(int var1);

    public native AVFormatContext interrupt_callback(AVIOInterruptCB var1);

    public native AVFormatContext flags(int var1);

    @Const
    public native AVOutputFormat oformat();

    public native AVFormatContext metadata_header_padding(int var1);

    public native AVFormatContext max_chunk_duration(int var1);

    @Cast(value={"unsigned int"})
    public native int nb_programs();

    public native AVFormatContext start_time(long var1);

    public native AVFormatContext avio_flags(int var1);

    public native AVFormatContext programs(int var1, AVProgram var2);

    public native AVFormatContext streams(PointerPointer var1);

    public native int format_probesize();

    @Cast(value={"char*"})
    public native BytePointer codec_whitelist();

    @Cast(value={"AVChapter**"})
    public native PointerPointer chapters();

    @Cast(value={"unsigned int"})
    public native int correct_ts_overflow();

    public native AVFormatContext chapters(int var1, AVChapter var2);

    public AVFormatContext(Pointer pointer) {
        AVFormatContext a = pointer;
        AVFormatContext a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"char*"})
    public native BytePointer format_whitelist();

    public native AVFormatContext io_close(Io_close_AVFormatContext_AVIOContext var1);

    public native AVFormatContext max_chunk_size(int var1);

    public native AVFormatContext max_probe_packets(int var1);

    public native AVFormatContext keylen(int var1);

    public native AVFormatContext skip_initial_bytes(long var1);

    public AVFormatContext() {
        super((Pointer)null);
        AVFormatContext a;
        a.allocate();
    }

    public native int event_flags();

    @Cast(value={"AVProgram**"})
    public native PointerPointer programs();

    public AVFormatContext position(long a) {
        AVFormatContext a2;
        return (AVFormatContext)super.position(a);
    }

    public native AVFormatContext ts_id(int var1);

    public native av_format_control_message control_message_cb();

    @Cast(value={"AVCodecID"})
    public native int data_codec_id();

    public native AVFormatContext fps_probe_size(int var1);

    public native AVFormatContext protocol_whitelist(BytePointer var1);

    @Cast(value={"unsigned int"})
    public native int max_index_size();

    public native AVFormatContext metadata(AVDictionary var1);

    public native int keylen();

    public native int skip_estimate_duration_from_pts();

    @Cast(value={"int64_t"})
    public native long max_interleave_delta();

    public native Pointer opaque();

    @Cast(value={"unsigned int"})
    public native int nb_streams();

    public native AVFormatContext debug(int var1);

    public native AVFormatContext iformat(AVInputFormat var1);

    @Const
    public native AVInputFormat iformat();

    public native AVFormatContext max_ts_probe(int var1);

    public native Io_close2_AVFormatContext_AVIOContext io_close2();

    @Cast(value={"char*"})
    public native BytePointer protocol_blacklist();

    public native AVFormatContext use_wallclock_as_timestamps(int var1);

    @Cast(value={"int64_t"})
    public native long start_time_realtime();

    public native AVFormatContext strict_std_compliance(int var1);

    public native AVFormatContext bit_rate(long var1);

    public native AVDictionary metadata();

    public native AVFormatContext format_probesize(int var1);

    public native AVFormatContext ctx_flags(int var1);

    public native Io_close_AVFormatContext_AVIOContext io_close();

    public native AVFormatContext pb(AVIOContext var1);

    public native int avio_flags();

    public native AVChapter chapters(int var1);

    public native int max_streams();

    public native int fps_probe_size();

    public native int io_repositioned();

    @Cast(value={"AVCodecID"})
    public native int subtitle_codec_id();

    private native /* synthetic */ void allocateArray(long var1);

    public native Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer io_open();

    public native AVFormatContext nb_programs(int var1);

    public native int flags();

    public native int strict_std_compliance();

    public native int ctx_flags();

    public native AVFormatContext max_interleave_delta(long var1);

    public native int ts_id();

    public native AVFormatContext max_index_size(int var1);

    public native AVFormatContext nb_streams(int var1);

    @Cast(value={"int64_t"})
    public native long skip_initial_bytes();

    @Cast(value={"int64_t"})
    public native long bit_rate();

    public native AVStream streams(int var1);

    public native AVIOContext pb();

    private native /* synthetic */ void allocate();

    public AVFormatContext(long a) {
        super((Pointer)null);
        AVFormatContext a2;
        a2.allocateArray(a);
    }

    @Cast(value={"AVCodecID"})
    public native int video_codec_id();

    public native AVFormatContext audio_codec(AVCodec var1);

    public native int audio_preload();

    public native Pointer priv_data();

    public native AVFormatContext correct_ts_overflow(int var1);

    public static class Io_close2_AVFormatContext_AVIOContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        public native int call(AVFormatContext var1, AVIOContext var2);

        public Io_close2_AVFormatContext_AVIOContext(Pointer pointer) {
            Io_close2_AVFormatContext_AVIOContext a = pointer;
            Io_close2_AVFormatContext_AVIOContext a2 = this;
            super((Pointer)a);
        }

        protected Io_close2_AVFormatContext_AVIOContext() {
            Io_close2_AVFormatContext_AVIOContext a;
            Io_close2_AVFormatContext_AVIOContext io_close2_AVFormatContext_AVIOContext = a;
            io_close2_AVFormatContext_AVIOContext.allocate();
        }
    }

    public static class Io_close_AVFormatContext_AVIOContext
    extends FunctionPointer {
        @Deprecated
        public native void call(AVFormatContext var1, AVIOContext var2);

        protected Io_close_AVFormatContext_AVIOContext() {
            Io_close_AVFormatContext_AVIOContext a;
            Io_close_AVFormatContext_AVIOContext io_close_AVFormatContext_AVIOContext = a;
            io_close_AVFormatContext_AVIOContext.allocate();
        }

        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        public Io_close_AVFormatContext_AVIOContext(Pointer pointer) {
            Io_close_AVFormatContext_AVIOContext a = pointer;
            Io_close_AVFormatContext_AVIOContext a2 = this;
            super((Pointer)a);
        }
    }

    public static class Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer
    extends FunctionPointer {
        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        protected Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer() {
            Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a;
            Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer = a;
            io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer.allocate();
        }

        public Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer(Pointer pointer) {
            Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a = pointer;
            Io_open_AVFormatContext_PointerPointer_BytePointer_int_PointerPointer a2 = this;
            super((Pointer)a);
        }

        public native int call(AVFormatContext var1, @Cast(value={"AVIOContext**"}) PointerPointer var2, @Cast(value={"const char*"}) BytePointer var3, int var4, @Cast(value={"AVDictionary**"}) PointerPointer var5);
    }

}
