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
public class AVRegionOfInterest
extends Pointer {
    public native AVRegionOfInterest qoffset(AVRational var1);

    public native int left();

    private native /* synthetic */ void allocate();

    public AVRegionOfInterest() {
        super((Pointer)null);
        AVRegionOfInterest a;
        a.allocate();
    }

    public native AVRegionOfInterest bottom(int var1);

    public native AVRegionOfInterest self_size(int var1);

    public native int bottom();

    public native AVRegionOfInterest left(int var1);

    @Cast(value={"uint32_t"})
    public native int self_size();

    @ByRef
    public native AVRational qoffset();

    public native int top();

    public AVRegionOfInterest getPointer(long a) {
        AVRegionOfInterest a2;
        return (AVRegionOfInterest)new AVRegionOfInterest(a2).offsetAddress(a);
    }

    public native int right();

    public AVRegionOfInterest(long a) {
        super((Pointer)null);
        AVRegionOfInterest a2;
        a2.allocateArray(a);
    }

    public AVRegionOfInterest(Pointer pointer) {
        AVRegionOfInterest a = pointer;
        AVRegionOfInterest a2 = this;
        super((Pointer)a);
    }

    public native AVRegionOfInterest right(int var1);

    public AVRegionOfInterest position(long a) {
        AVRegionOfInterest a2;
        return (AVRegionOfInterest)super.position(a);
    }

    public native AVRegionOfInterest top(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    static {
        Loader.load();
    }
}
