/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterInOut
extends Pointer {
    public native AVFilterInOut pad_idx(int var1);

    public native AVFilterInOut name(BytePointer var1);

    private native /* synthetic */ void allocate();

    public native AVFilterInOut filter_ctx(AVFilterContext var1);

    public AVFilterInOut(long a) {
        super((Pointer)null);
        AVFilterInOut a2;
        a2.allocateArray(a);
    }

    public AVFilterInOut position(long a) {
        AVFilterInOut a2;
        return (AVFilterInOut)super.position(a);
    }

    static {
        Loader.load();
    }

    @Cast(value={"char*"})
    public native BytePointer name();

    public native int pad_idx();

    public AVFilterInOut() {
        super((Pointer)null);
        AVFilterInOut a;
        a.allocate();
    }

    public AVFilterInOut getPointer(long a) {
        AVFilterInOut a2;
        return (AVFilterInOut)new AVFilterInOut(a2).offsetAddress(a);
    }

    public native AVFilterInOut next();

    public AVFilterInOut(Pointer pointer) {
        AVFilterInOut a = pointer;
        AVFilterInOut a2 = this;
        super((Pointer)a);
    }

    public native AVFilterInOut next(AVFilterInOut var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVFilterContext filter_ctx();
}
