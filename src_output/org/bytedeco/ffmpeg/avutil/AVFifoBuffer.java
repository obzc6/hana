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

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVFifoBuffer
extends Pointer {
    static {
        Loader.load();
    }

    @Cast(value={"uint32_t"})
    public native int rndx();

    public AVFifoBuffer(Pointer pointer) {
        AVFifoBuffer a = pointer;
        AVFifoBuffer a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"uint8_t*"})
    public native BytePointer rptr();

    @Cast(value={"uint32_t"})
    public native int wndx();

    public native AVFifoBuffer wptr(BytePointer var1);

    public AVFifoBuffer() {
        super((Pointer)null);
        AVFifoBuffer a;
        a.allocate();
    }

    public native AVFifoBuffer rptr(BytePointer var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer end();

    public native AVFifoBuffer rndx(int var1);

    public AVFifoBuffer position(long a) {
        AVFifoBuffer a2;
        return (AVFifoBuffer)super.position(a);
    }

    public AVFifoBuffer getPointer(long a) {
        AVFifoBuffer a2;
        return (AVFifoBuffer)new AVFifoBuffer(a2).offsetAddress(a);
    }

    @Cast(value={"uint8_t*"})
    public native BytePointer buffer();

    @Cast(value={"uint8_t*"})
    public native BytePointer wptr();

    private native /* synthetic */ void allocate();

    public AVFifoBuffer(long a) {
        super((Pointer)null);
        AVFifoBuffer a2;
        a2.allocateArray(a);
    }

    public native AVFifoBuffer buffer(BytePointer var1);

    public native AVFifoBuffer end(BytePointer var1);

    public native AVFifoBuffer wndx(int var1);

    private native /* synthetic */ void allocateArray(long var1);
}
