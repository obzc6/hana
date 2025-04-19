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

import org.bytedeco.ffmpeg.avutil.AVBuffer;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVBufferRef
extends Pointer {
    private native /* synthetic */ void allocate();

    public native AVBuffer buffer();

    private native /* synthetic */ void allocateArray(long var1);

    public AVBufferRef(Pointer pointer) {
        AVBufferRef a = pointer;
        AVBufferRef a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    public native AVBufferRef size(long var1);

    public AVBufferRef() {
        super((Pointer)null);
        AVBufferRef a;
        a.allocate();
    }

    public native AVBufferRef buffer(AVBuffer var1);

    public AVBufferRef position(long a) {
        AVBufferRef a2;
        return (AVBufferRef)super.position(a);
    }

    public native AVBufferRef data(BytePointer var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer data();

    public AVBufferRef(long a) {
        super((Pointer)null);
        AVBufferRef a2;
        a2.allocateArray(a);
    }

    @Cast(value={"size_t"})
    public native long size();

    public AVBufferRef getPointer(long a) {
        AVBufferRef a2;
        return (AVBufferRef)new AVBufferRef(a2).offsetAddress(a);
    }
}
