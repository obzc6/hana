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
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVHWAccel
extends Pointer {
    @Cast(value={"AVPixelFormat"})
    public native int pix_fmt();

    public native AVHWAccel id(int var1);

    public AVHWAccel position(long a) {
        AVHWAccel a2;
        return (AVHWAccel)super.position(a);
    }

    public native AVHWAccel name(BytePointer var1);

    public native AVHWAccel pix_fmt(int var1);

    public native AVHWAccel capabilities(int var1);

    public native AVHWAccel type(int var1);

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"AVMediaType"})
    public native int type();

    static {
        Loader.load();
    }

    @Cast(value={"const char*"})
    public native BytePointer name();

    public AVHWAccel(Pointer pointer) {
        AVHWAccel a = pointer;
        AVHWAccel a2 = this;
        super((Pointer)a);
    }

    public AVHWAccel(long a) {
        super((Pointer)null);
        AVHWAccel a2;
        a2.allocateArray(a);
    }

    public AVHWAccel() {
        super((Pointer)null);
        AVHWAccel a;
        a.allocate();
    }

    public AVHWAccel getPointer(long a) {
        AVHWAccel a2;
        return (AVHWAccel)new AVHWAccel(a2).offsetAddress(a);
    }

    public native int capabilities();

    @Cast(value={"AVCodecID"})
    public native int id();
}
