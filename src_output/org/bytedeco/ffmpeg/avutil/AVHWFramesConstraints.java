/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVHWFramesConstraints
extends Pointer {
    public native AVHWFramesConstraints max_width(int var1);

    public native AVHWFramesConstraints max_height(int var1);

    public AVHWFramesConstraints position(long a) {
        AVHWFramesConstraints a2;
        return (AVHWFramesConstraints)super.position(a);
    }

    public AVHWFramesConstraints() {
        super((Pointer)null);
        AVHWFramesConstraints a;
        a.allocate();
    }

    public native AVHWFramesConstraints valid_sw_formats(IntPointer var1);

    public native int min_width();

    public native int max_width();

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"AVPixelFormat*"})
    public native IntPointer valid_sw_formats();

    public native int max_height();

    public native AVHWFramesConstraints min_width(int var1);

    public native int min_height();

    public native AVHWFramesConstraints valid_hw_formats(IntPointer var1);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public AVHWFramesConstraints(long a) {
        super((Pointer)null);
        AVHWFramesConstraints a2;
        a2.allocateArray(a);
    }

    public AVHWFramesConstraints getPointer(long a) {
        AVHWFramesConstraints a2;
        return (AVHWFramesConstraints)new AVHWFramesConstraints(a2).offsetAddress(a);
    }

    public AVHWFramesConstraints(Pointer pointer) {
        AVHWFramesConstraints a = pointer;
        AVHWFramesConstraints a2 = this;
        super((Pointer)a);
    }

    public native AVHWFramesConstraints min_height(int var1);

    @Cast(value={"AVPixelFormat*"})
    public native IntPointer valid_hw_formats();
}
