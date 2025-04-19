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
public class AVReplayGain
extends Pointer {
    public native AVReplayGain track_gain(int var1);

    public AVReplayGain(Pointer pointer) {
        AVReplayGain a = pointer;
        AVReplayGain a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"uint32_t"})
    public native int album_peak();

    public AVReplayGain() {
        super((Pointer)null);
        AVReplayGain a;
        a.allocate();
    }

    public native AVReplayGain album_peak(int var1);

    public AVReplayGain position(long a) {
        AVReplayGain a2;
        return (AVReplayGain)super.position(a);
    }

    private native /* synthetic */ void allocate();

    public native AVReplayGain album_gain(int var1);

    public native int album_gain();

    private native /* synthetic */ void allocateArray(long var1);

    public AVReplayGain(long a) {
        super((Pointer)null);
        AVReplayGain a2;
        a2.allocateArray(a);
    }

    public AVReplayGain getPointer(long a) {
        AVReplayGain a2;
        return (AVReplayGain)new AVReplayGain(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public native AVReplayGain track_peak(int var1);

    public native int track_gain();

    @Cast(value={"uint32_t"})
    public native int track_peak();
}
