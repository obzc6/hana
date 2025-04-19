/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.DoublePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilter;
import org.bytedeco.ffmpeg.avfilter.AVFilterGraph;
import org.bytedeco.ffmpeg.avfilter.AVFilterInternal;
import org.bytedeco.ffmpeg.avfilter.AVFilterLink;
import org.bytedeco.ffmpeg.avfilter.AVFilterPad;
import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterContext
extends Pointer {
    public native AVFilterContext inputs(PointerPointer var1);

    public native AVFilterContext hw_device_ctx(AVBufferRef var1);

    public native AVFilterGraph graph();

    public native AVFilterContext av_class(AVClass var1);

    public native Pointer enable();

    public native AVFilterContext filter(AVFilter var1);

    static {
        Loader.load();
    }

    public native AVFilterContext inputs(int var1, AVFilterLink var2);

    @Cast(value={"unsigned"})
    public native int ready();

    @Cast(value={"unsigned"})
    public native int nb_outputs();

    public native AVFilterContext enable_str(BytePointer var1);

    public AVFilterContext(long a) {
        super((Pointer)null);
        AVFilterContext a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Const
    public native AVClass av_class();

    public native AVFilterContext thread_type(int var1);

    public native AVFilterContext name(BytePointer var1);

    public native AVFilterContext nb_outputs(int var1);

    @Cast(value={"AVFilterLink**"})
    public native PointerPointer outputs();

    public native int extra_hw_frames();

    public native AVFilterContext nb_inputs(int var1);

    @Const
    public native AVFilter filter();

    public native AVFilterInternal internal();

    public native AVFilterContext internal(AVFilterInternal var1);

    public native AVFilterContext is_disabled(int var1);

    public native AVFilterContext extra_hw_frames(int var1);

    private native /* synthetic */ void allocate();

    public AVFilterContext getPointer(long a) {
        AVFilterContext a2;
        return (AVFilterContext)new AVFilterContext(a2).offsetAddress(a);
    }

    public native DoublePointer var_values();

    public native AVFilterPad input_pads();

    public native AVFilterContext outputs(int var1, AVFilterLink var2);

    public native AVFilterContext enable(Pointer var1);

    @Cast(value={"AVFilterCommand*"})
    public native Pointer command_queue();

    public native AVFilterContext var_values(DoublePointer var1);

    public native AVFilterContext ready(int var1);

    public native Pointer priv();

    @Cast(value={"unsigned"})
    public native int nb_inputs();

    public native AVFilterContext priv(Pointer var1);

    public native AVFilterContext nb_threads(int var1);

    public native AVFilterContext input_pads(AVFilterPad var1);

    public native AVFilterContext output_pads(AVFilterPad var1);

    public native int nb_threads();

    public native AVFilterLink inputs(int var1);

    public native AVFilterPad output_pads();

    public native int thread_type();

    public native AVBufferRef hw_device_ctx();

    public native AVFilterContext graph(AVFilterGraph var1);

    public native AVFilterContext outputs(PointerPointer var1);

    public native AVFilterContext command_queue(Pointer var1);

    public native int is_disabled();

    public AVFilterContext() {
        super((Pointer)null);
        AVFilterContext a;
        a.allocate();
    }

    public AVFilterContext(Pointer pointer) {
        AVFilterContext a = pointer;
        AVFilterContext a2 = this;
        super((Pointer)a);
    }

    public native AVFilterLink outputs(int var1);

    @Cast(value={"char*"})
    public native BytePointer name();

    public AVFilterContext position(long a) {
        AVFilterContext a2;
        return (AVFilterContext)super.position(a);
    }

    @Cast(value={"char*"})
    public native BytePointer enable_str();

    @Cast(value={"AVFilterLink**"})
    public native PointerPointer inputs();
}
