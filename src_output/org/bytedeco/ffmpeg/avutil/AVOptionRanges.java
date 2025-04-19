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
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVOptionRange;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVOptionRanges
extends Pointer {
    public native AVOptionRanges nb_components(int var1);

    public native int nb_ranges();

    private native /* synthetic */ void allocateArray(long var1);

    static {
        Loader.load();
    }

    public AVOptionRanges(Pointer pointer) {
        AVOptionRanges a = pointer;
        AVOptionRanges a2 = this;
        super((Pointer)a);
    }

    public native AVOptionRange range(int var1);

    public AVOptionRanges getPointer(long a) {
        AVOptionRanges a2;
        return (AVOptionRanges)new AVOptionRanges(a2).offsetAddress(a);
    }

    public native AVOptionRanges range(PointerPointer var1);

    private native /* synthetic */ void allocate();

    public native AVOptionRanges nb_ranges(int var1);

    public AVOptionRanges(long a) {
        super((Pointer)null);
        AVOptionRanges a2;
        a2.allocateArray(a);
    }

    @Cast(value={"AVOptionRange**"})
    public native PointerPointer range();

    public AVOptionRanges() {
        super((Pointer)null);
        AVOptionRanges a;
        a.allocate();
    }

    public native AVOptionRanges range(int var1, AVOptionRange var2);

    public native int nb_components();

    public AVOptionRanges position(long a) {
        AVOptionRanges a2;
        return (AVOptionRanges)super.position(a);
    }
}
