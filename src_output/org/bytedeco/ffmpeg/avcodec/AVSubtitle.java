/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVSubtitleRect;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVSubtitle
extends Pointer {
    @Cast(value={"int64_t"})
    public native long pts();

    public native AVSubtitle start_display_time(int var1);

    public AVSubtitle(long a) {
        super((Pointer)null);
        AVSubtitle a2;
        a2.allocateArray(a);
    }

    public native AVSubtitle format(short var1);

    @Cast(value={"uint32_t"})
    public native int start_display_time();

    static {
        Loader.load();
    }

    public native AVSubtitleRect rects(int var1);

    @Cast(value={"unsigned"})
    public native int num_rects();

    public AVSubtitle getPointer(long a) {
        AVSubtitle a2;
        return (AVSubtitle)new AVSubtitle(a2).offsetAddress(a);
    }

    public AVSubtitle(Pointer pointer) {
        AVSubtitle a = pointer;
        AVSubtitle a2 = this;
        super((Pointer)a);
    }

    public AVSubtitle position(long a) {
        AVSubtitle a2;
        return (AVSubtitle)super.position(a);
    }

    public native AVSubtitle rects(int var1, AVSubtitleRect var2);

    @Cast(value={"uint32_t"})
    public native int end_display_time();

    @Cast(value={"AVSubtitleRect**"})
    public native PointerPointer rects();

    private native /* synthetic */ void allocate();

    public native AVSubtitle rects(PointerPointer var1);

    public native AVSubtitle end_display_time(int var1);

    public native AVSubtitle pts(long var1);

    public AVSubtitle() {
        super((Pointer)null);
        AVSubtitle a;
        a.allocate();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVSubtitle num_rects(int var1);

    @Cast(value={"uint16_t"})
    public native short format();
}
