/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterFormats;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterFormatsConfig
extends Pointer {
    public AVFilterFormatsConfig(Pointer pointer) {
        AVFilterFormatsConfig a = pointer;
        AVFilterFormatsConfig a2 = this;
        super((Pointer)a);
    }

    public AVFilterFormatsConfig() {
        super((Pointer)null);
        AVFilterFormatsConfig a;
        a.allocate();
    }

    public AVFilterFormatsConfig getPointer(long a) {
        AVFilterFormatsConfig a2;
        return (AVFilterFormatsConfig)new AVFilterFormatsConfig(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"AVFilterChannelLayouts*"})
    public native Pointer channel_layouts();

    static {
        Loader.load();
    }

    public native AVFilterFormats formats();

    public AVFilterFormatsConfig(long a) {
        super((Pointer)null);
        AVFilterFormatsConfig a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocate();

    public native AVFilterFormatsConfig formats(AVFilterFormats var1);

    public AVFilterFormatsConfig position(long a) {
        AVFilterFormatsConfig a2;
        return (AVFilterFormatsConfig)super.position(a);
    }

    public native AVFilterFormats samplerates();

    public native AVFilterFormatsConfig samplerates(AVFilterFormats var1);

    public native AVFilterFormatsConfig channel_layouts(Pointer var1);
}
