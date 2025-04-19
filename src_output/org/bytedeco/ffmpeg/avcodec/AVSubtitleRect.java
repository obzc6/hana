/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVSubtitleRect
extends Pointer {
    public native int flags();

    @Cast(value={"uint8_t*"})
    public native BytePointer data(int var1);

    public native int y();

    static {
        Loader.load();
    }

    public native int h();

    public native AVSubtitleRect y(int var1);

    public native AVSubtitleRect text(BytePointer var1);

    @Cast(value={"char*"})
    public native BytePointer ass();

    public native AVSubtitleRect w(int var1);

    public AVSubtitleRect getPointer(long a) {
        AVSubtitleRect a2;
        return (AVSubtitleRect)new AVSubtitleRect(a2).offsetAddress(a);
    }

    public native int linesize(int var1);

    public native int w();

    @MemberGetter
    @Cast(value={"uint8_t**"})
    public native PointerPointer data();

    public native AVSubtitleRect linesize(int var1, int var2);

    private native /* synthetic */ void allocate();

    public native int nb_colors();

    public native AVSubtitleRect type(int var1);

    public AVSubtitleRect() {
        super((Pointer)null);
        AVSubtitleRect a;
        a.allocate();
    }

    @Cast(value={"char*"})
    public native BytePointer text();

    public native int x();

    public AVSubtitleRect(long a) {
        super((Pointer)null);
        AVSubtitleRect a2;
        a2.allocateArray(a);
    }

    @MemberGetter
    public native IntPointer linesize();

    public native AVSubtitleRect nb_colors(int var1);

    public AVSubtitleRect(Pointer pointer) {
        AVSubtitleRect a = pointer;
        AVSubtitleRect a2 = this;
        super((Pointer)a);
    }

    public native AVSubtitleRect h(int var1);

    public AVSubtitleRect position(long a) {
        AVSubtitleRect a2;
        return (AVSubtitleRect)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVSubtitleRect data(int var1, BytePointer var2);

    @Cast(value={"AVSubtitleType"})
    public native int type();

    public native AVSubtitleRect flags(int var1);

    public native AVSubtitleRect x(int var1);

    public native AVSubtitleRect ass(BytePointer var1);
}
