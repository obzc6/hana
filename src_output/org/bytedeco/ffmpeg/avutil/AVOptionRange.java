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
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVOptionRange
extends Pointer {
    public native AVOptionRange str(BytePointer var1);

    public AVOptionRange(long a) {
        super((Pointer)null);
        AVOptionRange a2;
        a2.allocateArray(a);
    }

    public native double value_max();

    public native int is_range();

    public AVOptionRange position(long a) {
        AVOptionRange a2;
        return (AVOptionRange)super.position(a);
    }

    public AVOptionRange() {
        super((Pointer)null);
        AVOptionRange a;
        a.allocate();
    }

    public native AVOptionRange is_range(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVOptionRange component_min(double var1);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native double value_min();

    @Cast(value={"const char*"})
    public native BytePointer str();

    public AVOptionRange getPointer(long a) {
        AVOptionRange a2;
        return (AVOptionRange)new AVOptionRange(a2).offsetAddress(a);
    }

    public AVOptionRange(Pointer pointer) {
        AVOptionRange a = pointer;
        AVOptionRange a2 = this;
        super((Pointer)a);
    }

    public native AVOptionRange value_max(double var1);

    public native AVOptionRange component_max(double var1);

    public native double component_min();

    public native double component_max();

    public native AVOptionRange value_min(double var1);
}
