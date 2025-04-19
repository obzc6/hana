/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVXTEA
extends Pointer {
    @Cast(value={"uint32_t"})
    public native int key(int var1);

    @MemberGetter
    @Cast(value={"uint32_t*"})
    public native IntPointer key();

    public AVXTEA(long a) {
        super((Pointer)null);
        AVXTEA a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    public AVXTEA position(long a) {
        AVXTEA a2;
        return (AVXTEA)super.position(a);
    }

    public AVXTEA(Pointer pointer) {
        AVXTEA a = pointer;
        AVXTEA a2 = this;
        super((Pointer)a);
    }

    public AVXTEA getPointer(long a) {
        AVXTEA a2;
        return (AVXTEA)new AVXTEA(a2).offsetAddress(a);
    }

    public AVXTEA() {
        super((Pointer)null);
        AVXTEA a;
        a.allocate();
    }

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public native AVXTEA key(int var1, int var2);
}
