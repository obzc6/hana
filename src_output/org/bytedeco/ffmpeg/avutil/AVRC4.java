/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVRC4
extends Pointer {
    static {
        Loader.load();
    }

    public AVRC4() {
        super((Pointer)null);
        AVRC4 a;
        a.allocate();
    }

    public native AVRC4 y(int var1);

    public AVRC4 position(long a) {
        AVRC4 a2;
        return (AVRC4)super.position(a);
    }

    public native AVRC4 x(int var1);

    private native /* synthetic */ void allocate();

    public native int y();

    public native AVRC4 state(int var1, byte var2);

    public native int x();

    public AVRC4 getPointer(long a) {
        AVRC4 a2;
        return (AVRC4)new AVRC4(a2).offsetAddress(a);
    }

    @Cast(value={"uint8_t"})
    public native byte state(int var1);

    public AVRC4(long a) {
        super((Pointer)null);
        AVRC4 a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVRC4(Pointer pointer) {
        AVRC4 a = pointer;
        AVRC4 a2 = this;
        super((Pointer)a);
    }

    @MemberGetter
    @Cast(value={"uint8_t*"})
    public native BytePointer state();
}
