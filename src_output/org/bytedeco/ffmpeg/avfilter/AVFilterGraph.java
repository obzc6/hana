/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.AVFilterGraphInternal;
import org.bytedeco.ffmpeg.avfilter.AVFilterLink;
import org.bytedeco.ffmpeg.avfilter.avfilter_execute_func;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterGraph
extends Pointer {
    public native int nb_threads();

    @Cast(value={"AVFilterLink**"})
    public native PointerPointer sink_links();

    public AVFilterGraph(Pointer pointer) {
        AVFilterGraph a = pointer;
        AVFilterGraph a2 = this;
        super((Pointer)a);
    }

    public native AVFilterGraph disable_auto_convert(int var1);

    public AVFilterGraph getPointer(long a) {
        AVFilterGraph a2;
        return (AVFilterGraph)new AVFilterGraph(a2).offsetAddress(a);
    }

    public native AVFilterLink sink_links(int var1);

    public native AVFilterGraph sink_links(int var1, AVFilterLink var2);

    public AVFilterGraph() {
        super((Pointer)null);
        AVFilterGraph a;
        a.allocate();
    }

    public native int thread_type();

    public native AVFilterGraphInternal internal();

    public native AVFilterGraph av_class(AVClass var1);

    public AVFilterGraph(long a) {
        super((Pointer)null);
        AVFilterGraph a2;
        a2.allocateArray(a);
    }

    public native avfilter_execute_func execute();

    @Cast(value={"char*"})
    public native BytePointer aresample_swr_opts();

    public native AVFilterGraph execute(avfilter_execute_func var1);

    public native AVFilterGraph filters(PointerPointer var1);

    public native AVFilterGraph sink_links_count(int var1);

    public native Pointer opaque();

    public native AVFilterGraph nb_threads(int var1);

    public native int sink_links_count();

    public native AVFilterGraph scale_sws_opts(BytePointer var1);

    private native /* synthetic */ void allocate();

    public native AVFilterGraph filters(int var1, AVFilterContext var2);

    public AVFilterGraph position(long a) {
        AVFilterGraph a2;
        return (AVFilterGraph)super.position(a);
    }

    public native AVFilterGraph internal(AVFilterGraphInternal var1);

    static {
        Loader.load();
    }

    @Const
    public native AVClass av_class();

    public native AVFilterGraph sink_links(PointerPointer var1);

    @Cast(value={"char*"})
    public native BytePointer scale_sws_opts();

    @Cast(value={"unsigned"})
    public native int disable_auto_convert();

    public native AVFilterGraph thread_type(int var1);

    @Cast(value={"unsigned"})
    public native int nb_filters();

    public native AVFilterGraph nb_filters(int var1);

    public native AVFilterGraph aresample_swr_opts(BytePointer var1);

    public native AVFilterContext filters(int var1);

    @Cast(value={"AVFilterContext**"})
    public native PointerPointer filters();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVFilterGraph opaque(Pointer var1);
}
