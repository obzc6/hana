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
public class unaligned_64
extends Pointer {
    public native unaligned_64 l(long var1);

    static {
        Loader.load();
    }

    public unaligned_64(long a) {
        super((Pointer)null);
        unaligned_64 a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public unaligned_64() {
        super((Pointer)null);
        unaligned_64 a;
        a.allocate();
    }

    public unaligned_64 getPointer(long a) {
        unaligned_64 a2;
        return (unaligned_64)new unaligned_64(a2).offsetAddress(a);
    }

    @Cast(value={"uint64_t"})
    public native long l();

    private native /* synthetic */ void allocate();

    public unaligned_64 position(long a) {
        unaligned_64 a2;
        return (unaligned_64)super.position(a);
    }

    public unaligned_64(Pointer pointer) {
        unaligned_64 a = pointer;
        unaligned_64 a2 = this;
        super((Pointer)a);
    }
}
