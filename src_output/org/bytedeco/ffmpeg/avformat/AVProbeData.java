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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVProbeData
extends Pointer {
    public native AVProbeData filename(BytePointer var1);

    public native AVProbeData buf(BytePointer var1);

    @Cast(value={"const char*"})
    public native BytePointer mime_type();

    public native AVProbeData mime_type(BytePointer var1);

    public native int buf_size();

    public AVProbeData(Pointer pointer) {
        AVProbeData a = pointer;
        AVProbeData a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"const char*"})
    public native BytePointer filename();

    public AVProbeData(long a) {
        super((Pointer)null);
        AVProbeData a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    public native AVProbeData buf_size(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public AVProbeData getPointer(long a) {
        AVProbeData a2;
        return (AVProbeData)new AVProbeData(a2).offsetAddress(a);
    }

    @Cast(value={"unsigned char*"})
    public native BytePointer buf();

    public AVProbeData() {
        super((Pointer)null);
        AVProbeData a;
        a.allocate();
    }

    public AVProbeData position(long a) {
        AVProbeData a2;
        return (AVProbeData)super.position(a);
    }

    private native /* synthetic */ void allocate();
}
