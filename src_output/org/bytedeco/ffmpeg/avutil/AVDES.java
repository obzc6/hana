/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVDES
extends Pointer {
    public AVDES position(long a) {
        AVDES a2;
        return (AVDES)super.position(a);
    }

    @MemberGetter
    @Cast(value={"uint64_t(* /*[3]*/ )[16]"})
    public native LongPointer round_keys();

    public native AVDES round_keys(int var1, int var2, long var3);

    public AVDES getPointer(long a) {
        AVDES a2;
        return (AVDES)new AVDES(a2).offsetAddress(a);
    }

    @Cast(value={"uint64_t"})
    public native long round_keys(int var1, int var2);

    static {
        Loader.load();
    }

    public AVDES(Pointer pointer) {
        AVDES a = pointer;
        AVDES a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    private native /* synthetic */ void allocateArray(long var1);

    public AVDES() {
        super((Pointer)null);
        AVDES a;
        a.allocate();
    }

    public native AVDES triple_des(int var1);

    public AVDES(long a) {
        super((Pointer)null);
        AVDES a2;
        a2.allocateArray(a);
    }

    public native int triple_des();
}
