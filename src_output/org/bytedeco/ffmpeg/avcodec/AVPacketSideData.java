/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVPacketSideData
extends Pointer {
    @Cast(value={"AVPacketSideDataType"})
    public native int type();

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    static {
        Loader.load();
    }

    public native AVPacketSideData size(long var1);

    public AVPacketSideData getPointer(long a) {
        AVPacketSideData a2;
        return (AVPacketSideData)new AVPacketSideData(a2).offsetAddress(a);
    }

    @Cast(value={"uint8_t*"})
    public native BytePointer data();

    public native AVPacketSideData data(BytePointer var1);

    public AVPacketSideData(Pointer pointer) {
        AVPacketSideData a = pointer;
        AVPacketSideData a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"size_t"})
    public native long size();

    public AVPacketSideData() {
        super((Pointer)null);
        AVPacketSideData a;
        a.allocate();
    }

    public native AVPacketSideData type(int var1);

    public AVPacketSideData(long a) {
        super((Pointer)null);
        AVPacketSideData a2;
        a2.allocateArray(a);
    }

    public AVPacketSideData position(long a) {
        AVPacketSideData a2;
        return (AVPacketSideData)super.position(a);
    }
}
