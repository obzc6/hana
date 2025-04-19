/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.ShortPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVPanScan
extends Pointer {
    static {
        Loader.load();
    }

    public native int id();

    public AVPanScan(long a) {
        super((Pointer)null);
        AVPanScan a2;
        a2.allocateArray(a);
    }

    @Name(value={"position"})
    public native short _position(int var1, int var2);

    public native int width();

    private native /* synthetic */ void allocateArray(long var1);

    @MemberGetter
    @Cast(value={"int16_t(* /*[3]*/ )[2]"})
    @Name(value={"position"})
    public native ShortPointer _position();

    public AVPanScan position(long a) {
        AVPanScan a2;
        return (AVPanScan)super.position(a);
    }

    public native AVPanScan _position(int var1, int var2, short var3);

    public AVPanScan(Pointer pointer) {
        AVPanScan a = pointer;
        AVPanScan a2 = this;
        super((Pointer)a);
    }

    public native int height();

    public native AVPanScan height(int var1);

    public native AVPanScan id(int var1);

    public AVPanScan getPointer(long a) {
        AVPanScan a2;
        return (AVPanScan)new AVPanScan(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocate();

    public native AVPanScan width(int var1);

    public AVPanScan() {
        super((Pointer)null);
        AVPanScan a;
        a.allocate();
    }
}
