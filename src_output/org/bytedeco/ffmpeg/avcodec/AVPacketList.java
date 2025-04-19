/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVPacketList
extends Pointer {
    public AVPacketList() {
        super((Pointer)null);
        AVPacketList a;
        a.allocate();
    }

    public AVPacketList getPointer(long a) {
        AVPacketList a2;
        return (AVPacketList)new AVPacketList(a2).offsetAddress(a);
    }

    @ByRef
    public native AVPacket pkt();

    public AVPacketList(long a) {
        super((Pointer)null);
        AVPacketList a2;
        a2.allocateArray(a);
    }

    public native AVPacketList next(AVPacketList var1);

    public AVPacketList position(long a) {
        AVPacketList a2;
        return (AVPacketList)super.position(a);
    }

    public native AVPacketList pkt(AVPacket var1);

    private native /* synthetic */ void allocate();

    public native AVPacketList next();

    public AVPacketList(Pointer pointer) {
        AVPacketList a = pointer;
        AVPacketList a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    static {
        Loader.load();
    }
}
