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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVChapter
extends Pointer {
    public native AVChapter end(long var1);

    public native AVChapter time_base(AVRational var1);

    public AVChapter(long a) {
        super((Pointer)null);
        AVChapter a2;
        a2.allocateArray(a);
    }

    public native AVChapter metadata(AVDictionary var1);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    @Cast(value={"int64_t"})
    public native long id();

    @ByRef
    public native AVRational time_base();

    public native AVChapter id(long var1);

    @Cast(value={"int64_t"})
    public native long start();

    public AVChapter() {
        super((Pointer)null);
        AVChapter a;
        a.allocate();
    }

    public AVChapter getPointer(long a) {
        AVChapter a2;
        return (AVChapter)new AVChapter(a2).offsetAddress(a);
    }

    public AVChapter(Pointer pointer) {
        AVChapter a = pointer;
        AVChapter a2 = this;
        super((Pointer)a);
    }

    public AVChapter position(long a) {
        AVChapter a2;
        return (AVChapter)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVChapter start(long var1);

    public native AVDictionary metadata();

    @Cast(value={"int64_t"})
    public native long end();
}
