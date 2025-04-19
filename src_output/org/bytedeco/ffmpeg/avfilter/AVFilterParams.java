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

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.AVFilterPadParams;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterParams
extends Pointer {
    public native AVFilterContext filter();

    public AVFilterParams(long a) {
        super((Pointer)null);
        AVFilterParams a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocate();

    public AVFilterParams position(long a) {
        AVFilterParams a2;
        return (AVFilterParams)super.position(a);
    }

    @Cast(value={"AVFilterPadParams**"})
    public native PointerPointer inputs();

    @Cast(value={"char*"})
    public native BytePointer filter_name();

    public native AVFilterParams filter_name(BytePointer var1);

    public native AVFilterParams nb_outputs(int var1);

    public native AVFilterParams outputs(int var1, AVFilterPadParams var2);

    public native AVFilterPadParams inputs(int var1);

    public AVFilterParams getPointer(long a) {
        AVFilterParams a2;
        return (AVFilterParams)new AVFilterParams(a2).offsetAddress(a);
    }

    public AVFilterParams(Pointer pointer) {
        AVFilterParams a = pointer;
        AVFilterParams a2 = this;
        super((Pointer)a);
    }

    public native AVFilterParams opts(AVDictionary var1);

    @Cast(value={"unsigned"})
    public native int nb_inputs();

    @Cast(value={"unsigned"})
    public native int nb_outputs();

    public native AVDictionary opts();

    public native AVFilterParams outputs(PointerPointer var1);

    public native AVFilterParams inputs(PointerPointer var1);

    @Cast(value={"char*"})
    public native BytePointer instance_name();

    public native AVFilterPadParams outputs(int var1);

    @Cast(value={"AVFilterPadParams**"})
    public native PointerPointer outputs();

    public AVFilterParams() {
        super((Pointer)null);
        AVFilterParams a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public native AVFilterParams instance_name(BytePointer var1);

    public native AVFilterParams filter(AVFilterContext var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVFilterParams inputs(int var1, AVFilterPadParams var2);

    public native AVFilterParams nb_inputs(int var1);
}
