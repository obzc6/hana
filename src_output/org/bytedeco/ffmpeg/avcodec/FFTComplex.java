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
public class FFTComplex
extends Pointer {
    public native FFTComplex re(float var1);

    public FFTComplex(long a) {
        super((Pointer)null);
        FFTComplex a2;
        a2.allocateArray(a);
    }

    @Cast(value={"FFTSample"})
    public native float im();

    public FFTComplex(Pointer pointer) {
        FFTComplex a = pointer;
        FFTComplex a2 = this;
        super((Pointer)a);
    }

    public FFTComplex position(long a) {
        FFTComplex a2;
        return (FFTComplex)super.position(a);
    }

    @Cast(value={"FFTSample"})
    public native float re();

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public FFTComplex getPointer(long a) {
        FFTComplex a2;
        return (FFTComplex)new FFTComplex(a2).offsetAddress(a);
    }

    public FFTComplex() {
        super((Pointer)null);
        FFTComplex a;
        a.allocate();
    }

    public native FFTComplex im(float var1);

    static {
        Loader.load();
    }
}
