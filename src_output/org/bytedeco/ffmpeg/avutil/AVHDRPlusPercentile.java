/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVHDRPlusPercentile
extends Pointer {
    public AVHDRPlusPercentile getPointer(long a) {
        AVHDRPlusPercentile a2;
        return (AVHDRPlusPercentile)new AVHDRPlusPercentile(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVHDRPlusPercentile(long a) {
        super((Pointer)null);
        AVHDRPlusPercentile a2;
        a2.allocateArray(a);
    }

    public native AVHDRPlusPercentile percentile(AVRational var1);

    public native AVHDRPlusPercentile percentage(byte var1);

    static {
        Loader.load();
    }

    public AVHDRPlusPercentile(Pointer pointer) {
        AVHDRPlusPercentile a = pointer;
        AVHDRPlusPercentile a2 = this;
        super((Pointer)a);
    }

    public AVHDRPlusPercentile position(long a) {
        AVHDRPlusPercentile a2;
        return (AVHDRPlusPercentile)super.position(a);
    }

    private native /* synthetic */ void allocate();

    @Cast(value={"uint8_t"})
    public native byte percentage();

    public AVHDRPlusPercentile() {
        super((Pointer)null);
        AVHDRPlusPercentile a;
        a.allocate();
    }

    @ByRef
    public native AVRational percentile();
}
