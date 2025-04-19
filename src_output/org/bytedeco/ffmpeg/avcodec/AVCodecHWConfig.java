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
public class AVCodecHWConfig
extends Pointer {
    public AVCodecHWConfig(Pointer pointer) {
        AVCodecHWConfig a = pointer;
        AVCodecHWConfig a2 = this;
        super((Pointer)a);
    }

    public native AVCodecHWConfig pix_fmt(int var1);

    @Cast(value={"AVPixelFormat"})
    public native int pix_fmt();

    public native int methods();

    static {
        Loader.load();
    }

    public AVCodecHWConfig(long a) {
        super((Pointer)null);
        AVCodecHWConfig a2;
        a2.allocateArray(a);
    }

    public native AVCodecHWConfig device_type(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public AVCodecHWConfig getPointer(long a) {
        AVCodecHWConfig a2;
        return (AVCodecHWConfig)new AVCodecHWConfig(a2).offsetAddress(a);
    }

    @Cast(value={"AVHWDeviceType"})
    public native int device_type();

    public AVCodecHWConfig() {
        super((Pointer)null);
        AVCodecHWConfig a;
        a.allocate();
    }

    public AVCodecHWConfig position(long a) {
        AVCodecHWConfig a2;
        return (AVCodecHWConfig)super.position(a);
    }

    public native AVCodecHWConfig methods(int var1);
}
