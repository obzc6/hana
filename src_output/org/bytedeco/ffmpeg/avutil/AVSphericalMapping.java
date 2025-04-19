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
public class AVSphericalMapping
extends Pointer {
    public native int pitch();

    public native int roll();

    @Cast(value={"uint32_t"})
    public native int bound_bottom();

    @Cast(value={"AVSphericalProjection"})
    public native int projection();

    public native AVSphericalMapping padding(int var1);

    public AVSphericalMapping() {
        super((Pointer)null);
        AVSphericalMapping a;
        a.allocate();
    }

    public native AVSphericalMapping bound_top(int var1);

    public native AVSphericalMapping bound_left(int var1);

    @Cast(value={"uint32_t"})
    public native int padding();

    public AVSphericalMapping(long a) {
        super((Pointer)null);
        AVSphericalMapping a2;
        a2.allocateArray(a);
    }

    public native AVSphericalMapping projection(int var1);

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVSphericalMapping roll(int var1);

    public AVSphericalMapping position(long a) {
        AVSphericalMapping a2;
        return (AVSphericalMapping)super.position(a);
    }

    @Cast(value={"uint32_t"})
    public native int bound_left();

    public native int yaw();

    public native AVSphericalMapping bound_right(int var1);

    public native AVSphericalMapping pitch(int var1);

    public native AVSphericalMapping yaw(int var1);

    public native AVSphericalMapping bound_bottom(int var1);

    public AVSphericalMapping(Pointer pointer) {
        AVSphericalMapping a = pointer;
        AVSphericalMapping a2 = this;
        super((Pointer)a);
    }

    public AVSphericalMapping getPointer(long a) {
        AVSphericalMapping a2;
        return (AVSphericalMapping)new AVSphericalMapping(a2).offsetAddress(a);
    }

    @Cast(value={"uint32_t"})
    public native int bound_top();

    @Cast(value={"uint32_t"})
    public native int bound_right();

    static {
        Loader.load();
    }
}
