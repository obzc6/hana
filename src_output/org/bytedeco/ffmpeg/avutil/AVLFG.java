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
public class AVLFG
extends Pointer {
    public AVLFG(long a) {
        super((Pointer)null);
        AVLFG a2;
        a2.allocateArray(a);
    }

    public native int index();

    static {
        Loader.load();
    }

    public AVLFG(Pointer pointer) {
        AVLFG a = pointer;
        AVLFG a2 = this;
        super((Pointer)a);
    }

    public AVLFG getPointer(long a) {
        AVLFG a2;
        return (AVLFG)new AVLFG(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocate();

    @Cast(value={"unsigned int"})
    public native int state(int var1);

    public native AVLFG state(int var1, int var2);

    public AVLFG position(long a) {
        AVLFG a2;
        return (AVLFG)super.position(a);
    }

    public AVLFG() {
        super((Pointer)null);
        AVLFG a;
        a.allocate();
    }

    public native AVLFG index(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    @MemberGetter
    @Cast(value={"unsigned int*"})
    public native IntPointer state();
}
