/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVIOContext
extends Pointer {
    public AVIOContext(long a) {
        super((Pointer)null);
        AVIOContext a2;
        a2.allocateArray(a);
    }

    public native AVIOContext seek(Seek_Pointer_long_int var1);

    public native AVIOContext read_seek(Read_seek_Pointer_int_long_int var1);

    public native Update_checksum_long_BytePointer_int update_checksum();

    @Cast(value={"unsigned char*"})
    public native BytePointer checksum_ptr();

    @Cast(value={"int64_t"})
    public native long pos();

    public native AVIOContext seekable(int var1);

    @Cast(value={"unsigned long"})
    public native long checksum();

    @Cast(value={"unsigned char*"})
    public native BytePointer buf_ptr_max();

    public AVIOContext getPointer(long a) {
        AVIOContext a2;
        return (AVIOContext)new AVIOContext(a2).offsetAddress(a);
    }

    public native int error();

    public native AVIOContext write_data_type(Write_data_type_Pointer_BytePointer_int_int_long var1);

    public native AVIOContext checksum_ptr(BytePointer var1);

    public native Seek_Pointer_long_int seek();

    public native AVIOContext buf_ptr(BytePointer var1);

    public native int seekable();

    public native Write_packet_Pointer_BytePointer_int write_packet();

    @Cast(value={"unsigned char*"})
    public native BytePointer buf_end();

    public native Write_data_type_Pointer_BytePointer_int_int_long write_data_type();

    public native int max_packet_size();

    public AVIOContext(Pointer pointer) {
        AVIOContext a = pointer;
        AVIOContext a2 = this;
        super((Pointer)a);
    }

    public native int buffer_size();

    @Cast(value={"int64_t"})
    public native long bytes_written();

    public native int write_flag();

    public native AVIOContext pos(long var1);

    public native Read_seek_Pointer_int_long_int read_seek();

    private native /* synthetic */ void allocate();

    public native AVIOContext update_checksum(Update_checksum_long_BytePointer_int var1);

    public AVIOContext position(long a) {
        AVIOContext a2;
        return (AVIOContext)super.position(a);
    }

    public native AVIOContext max_packet_size(int var1);

    public native int min_packet_size();

    public native AVIOContext write_flag(int var1);

    public native AVIOContext min_packet_size(int var1);

    public native AVIOContext protocol_whitelist(BytePointer var1);

    static {
        Loader.load();
    }

    @Cast(value={"unsigned char*"})
    public native BytePointer buffer();

    public native Read_pause_Pointer_int read_pause();

    public native AVIOContext bytes_written(long var1);

    public native AVIOContext read_packet(Read_packet_Pointer_BytePointer_int var1);

    public native AVIOContext opaque(Pointer var1);

    public native AVIOContext protocol_blacklist(BytePointer var1);

    @Cast(value={"const char*"})
    public native BytePointer protocol_blacklist();

    public AVIOContext() {
        super((Pointer)null);
        AVIOContext a;
        a.allocate();
    }

    public native Pointer opaque();

    public native AVIOContext buf_end(BytePointer var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native int direct();

    public native AVIOContext buffer_size(int var1);

    public native AVIOContext buf_ptr_max(BytePointer var1);

    public native AVIOContext eof_reached(int var1);

    public native AVIOContext ignore_boundary_point(int var1);

    public native int ignore_boundary_point();

    public native AVIOContext buffer(BytePointer var1);

    @Cast(value={"unsigned char*"})
    public native BytePointer buf_ptr();

    public native AVIOContext av_class(AVClass var1);

    @Cast(value={"int64_t"})
    public native long bytes_read();

    public native Read_packet_Pointer_BytePointer_int read_packet();

    @Cast(value={"const char*"})
    public native BytePointer protocol_whitelist();

    public native AVIOContext error(int var1);

    public native AVIOContext direct(int var1);

    @Const
    public native AVClass av_class();

    public native AVIOContext bytes_read(long var1);

    public native AVIOContext read_pause(Read_pause_Pointer_int var1);

    public native AVIOContext write_packet(Write_packet_Pointer_BytePointer_int var1);

    public native AVIOContext checksum(long var1);

    public native int eof_reached();

    public static class Write_data_type_Pointer_BytePointer_int_int_long
    extends FunctionPointer {
        public Write_data_type_Pointer_BytePointer_int_int_long(Pointer pointer) {
            Write_data_type_Pointer_BytePointer_int_int_long a = pointer;
            Write_data_type_Pointer_BytePointer_int_int_long a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3, @Cast(value={"AVIODataMarkerType"}) int var4, @Cast(value={"int64_t"}) long var5);

        protected Write_data_type_Pointer_BytePointer_int_int_long() {
            Write_data_type_Pointer_BytePointer_int_int_long a;
            Write_data_type_Pointer_BytePointer_int_int_long write_data_type_Pointer_BytePointer_int_int_long = a;
            write_data_type_Pointer_BytePointer_int_int_long.allocate();
        }
    }

    public static class Read_seek_Pointer_int_long_int
    extends FunctionPointer {
        protected Read_seek_Pointer_int_long_int() {
            Read_seek_Pointer_int_long_int a;
            Read_seek_Pointer_int_long_int read_seek_Pointer_int_long_int = a;
            read_seek_Pointer_int_long_int.allocate();
        }

        @Cast(value={"int64_t"})
        public native long call(Pointer var1, int var2, @Cast(value={"int64_t"}) long var3, int var5);

        public Read_seek_Pointer_int_long_int(Pointer pointer) {
            Read_seek_Pointer_int_long_int a = pointer;
            Read_seek_Pointer_int_long_int a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }
    }

    public static class Read_pause_Pointer_int
    extends FunctionPointer {
        protected Read_pause_Pointer_int() {
            Read_pause_Pointer_int a;
            Read_pause_Pointer_int read_pause_Pointer_int = a;
            read_pause_Pointer_int.allocate();
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        public native int call(Pointer var1, int var2);

        public Read_pause_Pointer_int(Pointer pointer) {
            Read_pause_Pointer_int a = pointer;
            Read_pause_Pointer_int a2 = this;
            super((Pointer)a);
        }
    }

    public static class Update_checksum_long_BytePointer_int
    extends FunctionPointer {
        @Cast(value={"unsigned long"})
        public native long call(@Cast(value={"unsigned long"}) long var1, @Cast(value={"const uint8_t*"}) BytePointer var3, @Cast(value={"unsigned int"}) int var4);

        protected Update_checksum_long_BytePointer_int() {
            Update_checksum_long_BytePointer_int a;
            Update_checksum_long_BytePointer_int update_checksum_long_BytePointer_int = a;
            update_checksum_long_BytePointer_int.allocate();
        }

        private native /* synthetic */ void allocate();

        public Update_checksum_long_BytePointer_int(Pointer pointer) {
            Update_checksum_long_BytePointer_int a = pointer;
            Update_checksum_long_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        static {
            Loader.load();
        }
    }

    public static class Seek_Pointer_long_int
    extends FunctionPointer {
        public Seek_Pointer_long_int(Pointer pointer) {
            Seek_Pointer_long_int a = pointer;
            Seek_Pointer_long_int a2 = this;
            super((Pointer)a);
        }

        protected Seek_Pointer_long_int() {
            Seek_Pointer_long_int a;
            Seek_Pointer_long_int seek_Pointer_long_int = a;
            seek_Pointer_long_int.allocate();
        }

        @Cast(value={"int64_t"})
        public native long call(Pointer var1, @Cast(value={"int64_t"}) long var2, int var4);

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }
    }

    public static class Write_packet_Pointer_BytePointer_int
    extends FunctionPointer {
        protected Write_packet_Pointer_BytePointer_int() {
            Write_packet_Pointer_BytePointer_int a;
            Write_packet_Pointer_BytePointer_int write_packet_Pointer_BytePointer_int = a;
            write_packet_Pointer_BytePointer_int.allocate();
        }

        private native /* synthetic */ void allocate();

        public Write_packet_Pointer_BytePointer_int(Pointer pointer) {
            Write_packet_Pointer_BytePointer_int a = pointer;
            Write_packet_Pointer_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        static {
            Loader.load();
        }

        public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3);
    }

    public static class Read_packet_Pointer_BytePointer_int
    extends FunctionPointer {
        private native /* synthetic */ void allocate();

        public Read_packet_Pointer_BytePointer_int(Pointer pointer) {
            Read_packet_Pointer_BytePointer_int a = pointer;
            Read_packet_Pointer_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        protected Read_packet_Pointer_BytePointer_int() {
            Read_packet_Pointer_BytePointer_int a;
            Read_packet_Pointer_BytePointer_int read_packet_Pointer_BytePointer_int = a;
            read_packet_Pointer_BytePointer_int.allocate();
        }

        static {
            Loader.load();
        }

        public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3);
    }

}
