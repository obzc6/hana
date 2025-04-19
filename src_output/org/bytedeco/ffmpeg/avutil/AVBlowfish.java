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
public class AVBlowfish
extends Pointer {
    public native AVBlowfish p(int var1, int var2);

    @Cast(value={"uint32_t"})
    public native int p(int var1);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    @MemberGetter
    @Cast(value={"uint32_t(* /*[4]*/ )[256]"})
    public native IntPointer s();

    @MemberGetter
    @Cast(value={"uint32_t*"})
    public native IntPointer p();

    public AVBlowfish position(long a) {
        AVBlowfish a2;
        return (AVBlowfish)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVBlowfish(long a) {
        super((Pointer)null);
        AVBlowfish a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint32_t"})
    public native int s(int var1, int var2);

    public AVBlowfish() {
        super((Pointer)null);
        AVBlowfish a;
        a.allocate();
    }

    public native AVBlowfish s(int var1, int var2, int var3);

    public AVBlowfish getPointer(long a) {
        AVBlowfish a2;
        return (AVBlowfish)new AVBlowfish(a2).offsetAddress(a);
    }

    public AVBlowfish(Pointer pointer) {
        AVBlowfish a = pointer;
        AVBlowfish a2 = this;
        super((Pointer)a);
    }
}
