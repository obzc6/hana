/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVChannelCustom;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVChannelLayout
extends Pointer {
    public AVChannelLayout getPointer(long a) {
        AVChannelLayout a2;
        return (AVChannelLayout)new AVChannelLayout(a2).offsetAddress(a);
    }

    @Cast(value={"AVChannelOrder"})
    public native int order();

    public AVChannelLayout position(long a) {
        AVChannelLayout a2;
        return (AVChannelLayout)super.position(a);
    }

    public AVChannelLayout() {
        super((Pointer)null);
        AVChannelLayout a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    @Name(value={"u.map"})
    public native AVChannelCustom u_map();

    public native Pointer opaque();

    public native int nb_channels();

    public native AVChannelLayout u_map(AVChannelCustom var1);

    @Name(value={"u.mask"})
    @Cast(value={"uint64_t"})
    public native long u_mask();

    private native /* synthetic */ void allocateArray(long var1);

    public AVChannelLayout(Pointer pointer) {
        AVChannelLayout a = pointer;
        AVChannelLayout a2 = this;
        super((Pointer)a);
    }

    public native AVChannelLayout nb_channels(int var1);

    public native AVChannelLayout opaque(Pointer var1);

    public native AVChannelLayout u_mask(long var1);

    public native AVChannelLayout order(int var1);

    private native /* synthetic */ void allocate();

    public AVChannelLayout(long a) {
        super((Pointer)null);
        AVChannelLayout a2;
        a2.allocateArray(a);
    }
}
