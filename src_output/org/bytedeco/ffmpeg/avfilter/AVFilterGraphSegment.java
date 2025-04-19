/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterChain;
import org.bytedeco.ffmpeg.avfilter.AVFilterGraph;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterGraphSegment
extends Pointer {
    @Cast(value={"AVFilterChain**"})
    public native PointerPointer chains();

    public AVFilterGraphSegment position(long a) {
        AVFilterGraphSegment a2;
        return (AVFilterGraphSegment)super.position(a);
    }

    @Cast(value={"char*"})
    public native BytePointer scale_sws_opts();

    public native AVFilterGraph graph();

    private native /* synthetic */ void allocate();

    public AVFilterGraphSegment getPointer(long a) {
        AVFilterGraphSegment a2;
        return (AVFilterGraphSegment)new AVFilterGraphSegment(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public native AVFilterGraphSegment scale_sws_opts(BytePointer var1);

    public AVFilterGraphSegment() {
        super((Pointer)null);
        AVFilterGraphSegment a;
        a.allocate();
    }

    @Cast(value={"size_t"})
    public native long nb_chains();

    public native AVFilterGraphSegment nb_chains(long var1);

    public native AVFilterGraphSegment graph(AVFilterGraph var1);

    public native AVFilterGraphSegment chains(PointerPointer var1);

    public native AVFilterGraphSegment chains(int var1, AVFilterChain var2);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVFilterChain chains(int var1);

    public AVFilterGraphSegment(long a) {
        super((Pointer)null);
        AVFilterGraphSegment a2;
        a2.allocateArray(a);
    }

    public AVFilterGraphSegment(Pointer pointer) {
        AVFilterGraphSegment a = pointer;
        AVFilterGraphSegment a2 = this;
        super((Pointer)a);
    }
}
