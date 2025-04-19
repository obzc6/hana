/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterParams;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterChain
extends Pointer {
    public AVFilterChain(Pointer pointer) {
        AVFilterChain a = pointer;
        AVFilterChain a2 = this;
        super((Pointer)a);
    }

    public native AVFilterParams filters(int var1);

    public native AVFilterChain filters(PointerPointer var1);

    public AVFilterChain getPointer(long a) {
        AVFilterChain a2;
        return (AVFilterChain)new AVFilterChain(a2).offsetAddress(a);
    }

    @Cast(value={"AVFilterParams**"})
    public native PointerPointer filters();

    public AVFilterChain(long a) {
        super((Pointer)null);
        AVFilterChain a2;
        a2.allocateArray(a);
    }

    public AVFilterChain() {
        super((Pointer)null);
        AVFilterChain a;
        a.allocate();
    }

    public AVFilterChain position(long a) {
        AVFilterChain a2;
        return (AVFilterChain)super.position(a);
    }

    public native AVFilterChain filters(int var1, AVFilterParams var2);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native AVFilterChain nb_filters(long var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"size_t"})
    public native long nb_filters();
}
