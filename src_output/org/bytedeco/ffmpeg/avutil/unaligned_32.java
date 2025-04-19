/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class unaligned_32
extends Pointer {
    public unaligned_32(Pointer pointer) {
        unaligned_32 a = pointer;
        unaligned_32 a2 = this;
        super((Pointer)a);
    }

    public unaligned_32 getPointer(long a) {
        unaligned_32 a2;
        return (unaligned_32)new unaligned_32(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native unaligned_32 l(int var1);

    public unaligned_32() {
        super((Pointer)null);
        unaligned_32 a;
        a.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public unaligned_32(long a) {
        super((Pointer)null);
        unaligned_32 a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint32_t"})
    public native int l();

    public unaligned_32 position(long a) {
        unaligned_32 a2;
        return (unaligned_32)super.position(a);
    }
}
