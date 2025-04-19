/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avformat.AVCodecTag;
import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVProbeData;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVInputFormat
extends Pointer {
    static {
        Loader.load();
    }

    public native int flags();

    @Cast(value={"const char*"})
    public native BytePointer extensions();

    public native AVInputFormat read_header(Read_header_AVFormatContext var1);

    public native Get_device_list_AVFormatContext_Pointer get_device_list();

    private native /* synthetic */ void allocate();

    public AVInputFormat(Pointer pointer) {
        AVInputFormat a = pointer;
        AVInputFormat a2 = this;
        super((Pointer)a);
    }

    public native int flags_internal();

    public native Read_pause_AVFormatContext read_pause();

    public native AVInputFormat read_pause(Read_pause_AVFormatContext var1);

    public native AVInputFormat flags_internal(int var1);

    public AVInputFormat position(long a) {
        AVInputFormat a2;
        return (AVInputFormat)super.position(a);
    }

    public native Read_probe_AVProbeData read_probe();

    public native AVInputFormat read_probe(Read_probe_AVProbeData var1);

    public native AVInputFormat long_name(BytePointer var1);

    @Const
    public native AVClass priv_class();

    public native AVInputFormat priv_data_size(int var1);

    public AVInputFormat getPointer(long a) {
        AVInputFormat a2;
        return (AVInputFormat)new AVInputFormat(a2).offsetAddress(a);
    }

    public AVInputFormat(long a) {
        super((Pointer)null);
        AVInputFormat a2;
        a2.allocateArray(a);
    }

    @Cast(value={"const char*"})
    public native BytePointer name();

    public native Read_seek_AVFormatContext_int_long_int read_seek();

    public native AVInputFormat name(BytePointer var1);

    public native AVInputFormat read_packet(Read_packet_AVFormatContext_AVPacket var1);

    @Cast(value={"const char*"})
    public native BytePointer long_name();

    public native AVInputFormat flags(int var1);

    public native AVInputFormat priv_class(AVClass var1);

    public native Read_seek2_AVFormatContext_int_long_long_long_int read_seek2();

    public native AVInputFormat extensions(BytePointer var1);

    public native int priv_data_size();

    @Cast(value={"const char*"})
    public native BytePointer mime_type();

    public native AVInputFormat raw_codec_id(int var1);

    public native Read_play_AVFormatContext read_play();

    @MemberGetter
    @Const
    public native AVCodecTag codec_tag(int var1);

    @MemberGetter
    @Cast(value={"const AVCodecTag*const*"})
    public native PointerPointer codec_tag();

    public native AVInputFormat read_seek(Read_seek_AVFormatContext_int_long_int var1);

    public native int raw_codec_id();

    public native AVInputFormat read_play(Read_play_AVFormatContext var1);

    public native AVInputFormat mime_type(BytePointer var1);

    public AVInputFormat() {
        super((Pointer)null);
        AVInputFormat a;
        a.allocate();
    }

    public native AVInputFormat read_close(Read_close_AVFormatContext var1);

    public native AVInputFormat read_timestamp(Read_timestamp_AVFormatContext_int_LongPointer_long var1);

    public native AVInputFormat get_device_list(Get_device_list_AVFormatContext_Pointer var1);

    public native Read_header_AVFormatContext read_header();

    public native AVInputFormat read_seek2(Read_seek2_AVFormatContext_int_long_long_long_int var1);

    public native Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp();

    private native /* synthetic */ void allocateArray(long var1);

    public native Read_close_AVFormatContext read_close();

    public native Read_packet_AVFormatContext_AVPacket read_packet();

    public static class Get_device_list_AVFormatContext_Pointer
    extends FunctionPointer {
        public Get_device_list_AVFormatContext_Pointer(Pointer pointer) {
            Get_device_list_AVFormatContext_Pointer a = pointer;
            Get_device_list_AVFormatContext_Pointer a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        protected Get_device_list_AVFormatContext_Pointer() {
            Get_device_list_AVFormatContext_Pointer a;
            Get_device_list_AVFormatContext_Pointer get_device_list_AVFormatContext_Pointer = a;
            get_device_list_AVFormatContext_Pointer.allocate();
        }

        public native int call(AVFormatContext var1, @Cast(value={"AVDeviceInfoList*"}) Pointer var2);
    }

    public static class Read_seek2_AVFormatContext_int_long_long_long_int
    extends FunctionPointer {
        static {
            Loader.load();
        }

        protected Read_seek2_AVFormatContext_int_long_long_long_int() {
            Read_seek2_AVFormatContext_int_long_long_long_int a;
            Read_seek2_AVFormatContext_int_long_long_long_int read_seek2_AVFormatContext_int_long_long_long_int = a;
            read_seek2_AVFormatContext_int_long_long_long_int.allocate();
        }

        private native /* synthetic */ void allocate();

        public native int call(AVFormatContext var1, int var2, @Cast(value={"int64_t"}) long var3, @Cast(value={"int64_t"}) long var5, @Cast(value={"int64_t"}) long var7, int var9);

        public Read_seek2_AVFormatContext_int_long_long_long_int(Pointer pointer) {
            Read_seek2_AVFormatContext_int_long_long_long_int a = pointer;
            Read_seek2_AVFormatContext_int_long_long_long_int a2 = this;
            super((Pointer)a);
        }
    }

    public static class Read_pause_AVFormatContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        protected Read_pause_AVFormatContext() {
            Read_pause_AVFormatContext a;
            Read_pause_AVFormatContext read_pause_AVFormatContext = a;
            read_pause_AVFormatContext.allocate();
        }

        public Read_pause_AVFormatContext(Pointer pointer) {
            Read_pause_AVFormatContext a = pointer;
            Read_pause_AVFormatContext a2 = this;
            super((Pointer)a);
        }

        public native int call(AVFormatContext var1);

        private native /* synthetic */ void allocate();
    }

    public static class Read_play_AVFormatContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        protected Read_play_AVFormatContext() {
            Read_play_AVFormatContext a;
            Read_play_AVFormatContext read_play_AVFormatContext = a;
            read_play_AVFormatContext.allocate();
        }

        private native /* synthetic */ void allocate();

        public Read_play_AVFormatContext(Pointer pointer) {
            Read_play_AVFormatContext a = pointer;
            Read_play_AVFormatContext a2 = this;
            super((Pointer)a);
        }

        public native int call(AVFormatContext var1);
    }

    public static class Read_timestamp_AVFormatContext_int_LongPointer_long
    extends FunctionPointer {
        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        @Cast(value={"int64_t"})
        public native long call(AVFormatContext var1, int var2, @Cast(value={"int64_t*"}) LongPointer var3, @Cast(value={"int64_t"}) long var4);

        protected Read_timestamp_AVFormatContext_int_LongPointer_long() {
            Read_timestamp_AVFormatContext_int_LongPointer_long a;
            Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp_AVFormatContext_int_LongPointer_long = a;
            read_timestamp_AVFormatContext_int_LongPointer_long.allocate();
        }

        public Read_timestamp_AVFormatContext_int_LongPointer_long(Pointer pointer) {
            Read_timestamp_AVFormatContext_int_LongPointer_long a = pointer;
            Read_timestamp_AVFormatContext_int_LongPointer_long a2 = this;
            super((Pointer)a);
        }
    }

    public static class Read_seek_AVFormatContext_int_long_int
    extends FunctionPointer {
        public native int call(AVFormatContext var1, int var2, @Cast(value={"int64_t"}) long var3, int var5);

        private native /* synthetic */ void allocate();

        protected Read_seek_AVFormatContext_int_long_int() {
            Read_seek_AVFormatContext_int_long_int a;
            Read_seek_AVFormatContext_int_long_int read_seek_AVFormatContext_int_long_int = a;
            read_seek_AVFormatContext_int_long_int.allocate();
        }

        static {
            Loader.load();
        }

        public Read_seek_AVFormatContext_int_long_int(Pointer pointer) {
            Read_seek_AVFormatContext_int_long_int a = pointer;
            Read_seek_AVFormatContext_int_long_int a2 = this;
            super((Pointer)a);
        }
    }

    public static class Read_close_AVFormatContext
    extends FunctionPointer {
        public Read_close_AVFormatContext(Pointer pointer) {
            Read_close_AVFormatContext a = pointer;
            Read_close_AVFormatContext a2 = this;
            super((Pointer)a);
        }

        protected Read_close_AVFormatContext() {
            Read_close_AVFormatContext a;
            Read_close_AVFormatContext read_close_AVFormatContext = a;
            read_close_AVFormatContext.allocate();
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        public native int call(AVFormatContext var1);
    }

    public static class Read_packet_AVFormatContext_AVPacket
    extends FunctionPointer {
        static {
            Loader.load();
        }

        public Read_packet_AVFormatContext_AVPacket(Pointer pointer) {
            Read_packet_AVFormatContext_AVPacket a = pointer;
            Read_packet_AVFormatContext_AVPacket a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        public native int call(AVFormatContext var1, AVPacket var2);

        protected Read_packet_AVFormatContext_AVPacket() {
            Read_packet_AVFormatContext_AVPacket a;
            Read_packet_AVFormatContext_AVPacket read_packet_AVFormatContext_AVPacket = a;
            read_packet_AVFormatContext_AVPacket.allocate();
        }
    }

    public static class Read_header_AVFormatContext
    extends FunctionPointer {
        public Read_header_AVFormatContext(Pointer pointer) {
            Read_header_AVFormatContext a = pointer;
            Read_header_AVFormatContext a2 = this;
            super((Pointer)a);
        }

        protected Read_header_AVFormatContext() {
            Read_header_AVFormatContext a;
            Read_header_AVFormatContext read_header_AVFormatContext = a;
            read_header_AVFormatContext.allocate();
        }

        private native /* synthetic */ void allocate();

        public native int call(AVFormatContext var1);

        static {
            Loader.load();
        }
    }

    public static class Read_probe_AVProbeData
    extends FunctionPointer {
        protected Read_probe_AVProbeData() {
            Read_probe_AVProbeData a;
            Read_probe_AVProbeData read_probe_AVProbeData = a;
            read_probe_AVProbeData.allocate();
        }

        public Read_probe_AVProbeData(Pointer pointer) {
            Read_probe_AVProbeData a = pointer;
            Read_probe_AVProbeData a2 = this;
            super((Pointer)a);
        }

        public native int call(@Const AVProbeData var1);

        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();
    }

}
