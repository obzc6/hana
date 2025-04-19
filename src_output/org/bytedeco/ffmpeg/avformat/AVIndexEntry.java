/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.NoOffset
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.NoOffset;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVIndexEntry
extends Pointer {
    public static final int AVINDEX_KEYFRAME = 1;
    public static final int AVINDEX_DISCARD_FRAME = 2;

    @NoOffset
    public native int size();

    public AVIndexEntry() {
        super((Pointer)null);
        AVIndexEntry a;
        a.allocate();
    }

    public AVIndexEntry(long a) {
        super((Pointer)null);
        AVIndexEntry a2;
        a2.allocateArray(a);
    }

    public AVIndexEntry getPointer(long a) {
        AVIndexEntry a2;
        return (AVIndexEntry)new AVIndexEntry(a2).offsetAddress(a);
    }

    @Cast(value={"int64_t"})
    public native long timestamp();

    public native AVIndexEntry pos(long var1);

    public AVIndexEntry position(long a) {
        AVIndexEntry a2;
        return (AVIndexEntry)super.position(a);
    }

    public native AVIndexEntry size(int var1);

    public native AVIndexEntry min_distance(int var1);

    public native AVIndexEntry flags(int var1);

    @NoOffset
    public native int flags();

    public native AVIndexEntry timestamp(long var1);

    public AVIndexEntry(Pointer pointer) {
        AVIndexEntry a = pointer;
        AVIndexEntry a2 = this;
        super((Pointer)a);
    }

    public native int min_distance();

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    @Cast(value={"int64_t"})
    public native long pos();

    private native /* synthetic */ void allocateArray(long var1);
}
