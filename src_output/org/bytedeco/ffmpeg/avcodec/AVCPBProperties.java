/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVCPBProperties
extends Pointer {
    public native AVCPBProperties buffer_size(long var1);

    @Cast(value={"int64_t"})
    public native long avg_bitrate();

    public AVCPBProperties(Pointer pointer) {
        AVCPBProperties a = pointer;
        AVCPBProperties a2 = this;
        super((Pointer)a);
    }

    public native AVCPBProperties avg_bitrate(long var1);

    @Cast(value={"int64_t"})
    public native long buffer_size();

    static {
        Loader.load();
    }

    public native AVCPBProperties min_bitrate(long var1);

    public AVCPBProperties position(long a) {
        AVCPBProperties a2;
        return (AVCPBProperties)super.position(a);
    }

    @Cast(value={"int64_t"})
    public native long max_bitrate();

    @Cast(value={"int64_t"})
    public native long min_bitrate();

    public AVCPBProperties getPointer(long a) {
        AVCPBProperties a2;
        return (AVCPBProperties)new AVCPBProperties(a2).offsetAddress(a);
    }

    @Cast(value={"uint64_t"})
    public native long vbv_delay();

    public AVCPBProperties(long a) {
        super((Pointer)null);
        AVCPBProperties a2;
        a2.allocateArray(a);
    }

    public AVCPBProperties() {
        super((Pointer)null);
        AVCPBProperties a;
        a.allocate();
    }

    public native AVCPBProperties vbv_delay(long var1);

    public native AVCPBProperties max_bitrate(long var1);

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);
}
