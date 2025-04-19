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
public class unaligned_16
extends Pointer {
    @Cast(value={"uint16_t"})
    public native short l();

    public unaligned_16 position(long a) {
        unaligned_16 a2;
        return (unaligned_16)super.position(a);
    }

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    public unaligned_16() {
        super((Pointer)null);
        unaligned_16 a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public unaligned_16 getPointer(long a) {
        unaligned_16 a2;
        return (unaligned_16)new unaligned_16(a2).offsetAddress(a);
    }

    public native unaligned_16 l(short var1);

    public unaligned_16(Pointer pointer) {
        unaligned_16 a = pointer;
        unaligned_16 a2 = this;
        super((Pointer)a);
    }

    public unaligned_16(long a) {
        super((Pointer)null);
        unaligned_16 a2;
        a2.allocateArray(a);
    }
}
