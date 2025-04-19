/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.AVFilterPad;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilter
extends Pointer {
    public native AVFilter formats_pix_fmt(int var1);

    @Cast(value={"uint8_t"})
    public native byte formats_state();

    private native /* synthetic */ void allocate();

    public native Preinit_AVFilterContext preinit();

    public AVFilter(long a) {
        super((Pointer)null);
        AVFilter a2;
        a2.allocateArray(a);
    }

    public native int priv_size();

    public native AVFilter inputs(AVFilterPad var1);

    public native AVFilter nb_outputs(byte var1);

    @Cast(value={"const char*"})
    public native BytePointer description();

    public AVFilter() {
        super((Pointer)null);
        AVFilter a;
        a.allocate();
    }

    public native Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command();

    public native AVFilter priv_class(AVClass var1);

    @Const
    public native AVFilterPad outputs();

    @Cast(value={"uint8_t"})
    public native byte nb_outputs();

    public native AVFilter activate(Activate_AVFilterContext var1);

    @Name(value={"formats.pixels_list"})
    @Cast(value={"const AVPixelFormat*"})
    public native IntPointer formats_pixels_list();

    @Name(value={"formats.samples_list"})
    @Cast(value={"const AVSampleFormat*"})
    public native IntPointer formats_samples_list();

    public native int flags_internal();

    public native AVFilter flags_internal(int var1);

    public AVFilter position(long a) {
        AVFilter a2;
        return (AVFilter)super.position(a);
    }

    public AVFilter(Pointer pointer) {
        AVFilter a = pointer;
        AVFilter a2 = this;
        super((Pointer)a);
    }

    public native AVFilter nb_inputs(byte var1);

    public native AVFilter formats_sample_fmt(int var1);

    public native int flags();

    public native AVFilter formats_query_func(Query_func_AVFilterContext var1);

    @Name(value={"formats.query_func"})
    public native Query_func_AVFilterContext formats_query_func();

    public AVFilter getPointer(long a) {
        AVFilter a2;
        return (AVFilter)new AVFilter(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public native AVFilter init(Init_AVFilterContext var1);

    public native AVFilter flags(int var1);

    @Const
    public native AVFilterPad inputs();

    public native AVFilter process_command(Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int var1);

    public native AVFilter name(BytePointer var1);

    public native Uninit_AVFilterContext uninit();

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"const char*"})
    public native BytePointer name();

    @Name(value={"formats.pix_fmt"})
    @Cast(value={"AVPixelFormat"})
    public native int formats_pix_fmt();

    public native Activate_AVFilterContext activate();

    public native AVFilter formats_samples_list(IntPointer var1);

    public native AVFilter priv_size(int var1);

    public native AVFilter formats_pixels_list(IntPointer var1);

    @Name(value={"formats.sample_fmt"})
    @Cast(value={"AVSampleFormat"})
    public native int formats_sample_fmt();

    @Const
    public native AVClass priv_class();

    public native AVFilter formats_state(byte var1);

    public native AVFilter uninit(Uninit_AVFilterContext var1);

    public native AVFilter preinit(Preinit_AVFilterContext var1);

    @Cast(value={"uint8_t"})
    public native byte nb_inputs();

    public native AVFilter outputs(AVFilterPad var1);

    public native Init_AVFilterContext init();

    public native AVFilter description(BytePointer var1);

    public static class Activate_AVFilterContext
    extends FunctionPointer {
        public Activate_AVFilterContext(Pointer pointer) {
            Activate_AVFilterContext a = pointer;
            Activate_AVFilterContext a2 = this;
            super((Pointer)a);
        }

        public native int call(AVFilterContext var1);

        protected Activate_AVFilterContext() {
            Activate_AVFilterContext a;
            Activate_AVFilterContext activate_AVFilterContext = a;
            activate_AVFilterContext.allocate();
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }
    }

    public static class Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int
    extends FunctionPointer {
        static {
            Loader.load();
        }

        public native int call(AVFilterContext var1, @Cast(value={"const char*"}) BytePointer var2, @Cast(value={"const char*"}) BytePointer var3, @Cast(value={"char*"}) BytePointer var4, int var5, int var6);

        public Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int(Pointer pointer) {
            Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a = pointer;
            Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a2 = this;
            super((Pointer)a);
        }

        protected Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int() {
            Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a;
            Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int = a;
            process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int.allocate();
        }

        private native /* synthetic */ void allocate();
    }

    public static class Query_func_AVFilterContext
    extends FunctionPointer {
        public Query_func_AVFilterContext(Pointer pointer) {
            Query_func_AVFilterContext a = pointer;
            Query_func_AVFilterContext a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }

        protected Query_func_AVFilterContext() {
            Query_func_AVFilterContext a;
            Query_func_AVFilterContext query_func_AVFilterContext = a;
            query_func_AVFilterContext.allocate();
        }

        public native int call(AVFilterContext var1);
    }

    public static class Uninit_AVFilterContext
    extends FunctionPointer {
        protected Uninit_AVFilterContext() {
            Uninit_AVFilterContext a;
            Uninit_AVFilterContext uninit_AVFilterContext = a;
            uninit_AVFilterContext.allocate();
        }

        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        public Uninit_AVFilterContext(Pointer pointer) {
            Uninit_AVFilterContext a = pointer;
            Uninit_AVFilterContext a2 = this;
            super((Pointer)a);
        }

        public native void call(AVFilterContext var1);
    }

    public static class Init_AVFilterContext
    extends FunctionPointer {
        protected Init_AVFilterContext() {
            Init_AVFilterContext a;
            Init_AVFilterContext init_AVFilterContext = a;
            init_AVFilterContext.allocate();
        }

        private native /* synthetic */ void allocate();

        public Init_AVFilterContext(Pointer pointer) {
            Init_AVFilterContext a = pointer;
            Init_AVFilterContext a2 = this;
            super((Pointer)a);
        }

        public native int call(AVFilterContext var1);

        static {
            Loader.load();
        }
    }

    public static class Preinit_AVFilterContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        public Preinit_AVFilterContext(Pointer pointer) {
            Preinit_AVFilterContext a = pointer;
            Preinit_AVFilterContext a2 = this;
            super((Pointer)a);
        }

        private native /* synthetic */ void allocate();

        public native int call(AVFilterContext var1);

        protected Preinit_AVFilterContext() {
            Preinit_AVFilterContext a;
            Preinit_AVFilterContext preinit_AVFilterContext = a;
            preinit_AVFilterContext.allocate();
        }
    }

}
