/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVPacketSideData;
import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVPacket
extends Pointer {
    public native AVBufferRef opaque_ref();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVPacket buf(AVBufferRef var1);

    public native AVPacket opaque(Pointer var1);

    public native int side_data_elems();

    public AVPacket getPointer(long a) {
        AVPacket a2;
        return (AVPacket)new AVPacket(a2).offsetAddress(a);
    }

    public native AVPacketSideData side_data();

    @Cast(value={"uint8_t*"})
    public native BytePointer data();

    public AVPacket position(long a) {
        AVPacket a2;
        return (AVPacket)super.position(a);
    }

    public native AVPacket flags(int var1);

    public AVPacket() {
        super((Pointer)null);
        AVPacket a;
        a.allocate();
    }

    public native AVPacket side_data_elems(int var1);

    @Cast(value={"int64_t"})
    public native long duration();

    public native int flags();

    private native /* synthetic */ void allocate();

    public native int size();

    @ByRef
    public native AVRational time_base();

    static {
        Loader.load();
    }

    public native AVPacket time_base(AVRational var1);

    public native AVPacket duration(long var1);

    public AVPacket(long a) {
        super((Pointer)null);
        AVPacket a2;
        a2.allocateArray(a);
    }

    public native AVPacket opaque_ref(AVBufferRef var1);

    public native AVBufferRef buf();

    public AVPacket(Pointer pointer) {
        AVPacket a = pointer;
        AVPacket a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"int64_t"})
    public native long pos();

    public native int stream_index();

    public native AVPacket pts(long var1);

    public native Pointer opaque();

    public native AVPacket size(int var1);

    public native AVPacket stream_index(int var1);

    public native AVPacket pos(long var1);

    public native AVPacket data(BytePointer var1);

    @Cast(value={"int64_t"})
    public native long pts();

    @Cast(value={"int64_t"})
    public native long dts();

    public native AVPacket dts(long var1);

    public native AVPacket side_data(AVPacketSideData var1);
}
