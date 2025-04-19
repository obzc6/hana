/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVMotionVector
extends Pointer {
    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    @Cast(value={"uint8_t"})
    public native byte w();

    public native int source();

    public native AVMotionVector flags(long var1);

    public native AVMotionVector src_x(short var1);

    public native AVMotionVector motion_scale(short var1);

    public native AVMotionVector dst_x(short var1);

    public AVMotionVector(Pointer pointer) {
        AVMotionVector a = pointer;
        AVMotionVector a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"uint8_t"})
    public native byte h();

    public native short dst_y();

    @Cast(value={"uint64_t"})
    public native long flags();

    public AVMotionVector() {
        super((Pointer)null);
        AVMotionVector a;
        a.allocate();
    }

    public native AVMotionVector source(int var1);

    public AVMotionVector(long a) {
        super((Pointer)null);
        AVMotionVector a2;
        a2.allocateArray(a);
    }

    public native AVMotionVector w(byte var1);

    public AVMotionVector position(long a) {
        AVMotionVector a2;
        return (AVMotionVector)super.position(a);
    }

    public native AVMotionVector src_y(short var1);

    public native short dst_x();

    public native short src_y();

    public AVMotionVector getPointer(long a) {
        AVMotionVector a2;
        return (AVMotionVector)new AVMotionVector(a2).offsetAddress(a);
    }

    public native AVMotionVector dst_y(short var1);

    public native int motion_x();

    public native AVMotionVector h(byte var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVMotionVector motion_x(int var1);

    public native int motion_y();

    public native short src_x();

    @Cast(value={"uint16_t"})
    public native short motion_scale();

    public native AVMotionVector motion_y(int var1);
}
