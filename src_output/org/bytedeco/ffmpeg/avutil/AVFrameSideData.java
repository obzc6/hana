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
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVFrameSideData
extends Pointer {
    public native AVFrameSideData size(long var1);

    public AVFrameSideData() {
        super((Pointer)null);
        AVFrameSideData a;
        a.allocate();
    }

    public native AVFrameSideData data(BytePointer var1);

    public AVFrameSideData(Pointer pointer) {
        AVFrameSideData a = pointer;
        AVFrameSideData a2 = this;
        super((Pointer)a);
    }

    public AVFrameSideData(long a) {
        super((Pointer)null);
        AVFrameSideData a2;
        a2.allocateArray(a);
    }

    public native AVFrameSideData type(int var1);

    @Cast(value={"size_t"})
    public native long size();

    public native AVFrameSideData buf(AVBufferRef var1);

    public AVFrameSideData position(long a) {
        AVFrameSideData a2;
        return (AVFrameSideData)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer data();

    private native /* synthetic */ void allocate();

    public native AVFrameSideData metadata(AVDictionary var1);

    public native AVBufferRef buf();

    static {
        Loader.load();
    }

    @Cast(value={"AVFrameSideDataType"})
    public native int type();

    public AVFrameSideData getPointer(long a) {
        AVFrameSideData a2;
        return (AVFrameSideData)new AVFrameSideData(a2).offsetAddress(a);
    }

    public native AVDictionary metadata();
}
