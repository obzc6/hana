/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVBitStreamFilter
extends Pointer {
    public native AVBitStreamFilter codec_ids(IntPointer var1);

    public AVBitStreamFilter(long a) {
        super((Pointer)null);
        AVBitStreamFilter a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    public AVBitStreamFilter(Pointer pointer) {
        AVBitStreamFilter a = pointer;
        AVBitStreamFilter a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"const AVCodecID*"})
    public native IntPointer codec_ids();

    @Const
    public native AVClass priv_class();

    public AVBitStreamFilter position(long a) {
        AVBitStreamFilter a2;
        return (AVBitStreamFilter)super.position(a);
    }

    @Cast(value={"const char*"})
    public native BytePointer name();

    public AVBitStreamFilter getPointer(long a) {
        AVBitStreamFilter a2;
        return (AVBitStreamFilter)new AVBitStreamFilter(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocate();

    public native AVBitStreamFilter name(BytePointer var1);

    public native AVBitStreamFilter priv_class(AVClass var1);

    public AVBitStreamFilter() {
        super((Pointer)null);
        AVBitStreamFilter a;
        a.allocate();
    }
}
