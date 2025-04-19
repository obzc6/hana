/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class RcOverride
extends Pointer {
    public RcOverride(long a) {
        super((Pointer)null);
        RcOverride a2;
        a2.allocateArray(a);
    }

    public native RcOverride qscale(int var1);

    public RcOverride(Pointer pointer) {
        RcOverride a = pointer;
        RcOverride a2 = this;
        super((Pointer)a);
    }

    public native RcOverride end_frame(int var1);

    public native int qscale();

    public RcOverride position(long a) {
        RcOverride a2;
        return (RcOverride)super.position(a);
    }

    public native RcOverride quality_factor(float var1);

    public native float quality_factor();

    public native RcOverride start_frame(int var1);

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    public native int start_frame();

    public RcOverride getPointer(long a) {
        RcOverride a2;
        return (RcOverride)new RcOverride(a2).offsetAddress(a);
    }

    public native int end_frame();

    public RcOverride() {
        super((Pointer)null);
        RcOverride a;
        a.allocate();
    }

    static {
        Loader.load();
    }
}
