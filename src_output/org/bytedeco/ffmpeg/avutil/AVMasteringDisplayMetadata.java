/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVMasteringDisplayMetadata
extends Pointer {
    public native AVMasteringDisplayMetadata display_primaries(int var1, int var2, AVRational var3);

    public AVMasteringDisplayMetadata(Pointer pointer) {
        AVMasteringDisplayMetadata a = pointer;
        AVMasteringDisplayMetadata a2 = this;
        super((Pointer)a);
    }

    public AVMasteringDisplayMetadata getPointer(long a) {
        AVMasteringDisplayMetadata a2;
        return (AVMasteringDisplayMetadata)new AVMasteringDisplayMetadata(a2).offsetAddress(a);
    }

    @MemberGetter
    public native AVRational white_point();

    public native AVMasteringDisplayMetadata has_luminance(int var1);

    public native AVMasteringDisplayMetadata has_primaries(int var1);

    public AVMasteringDisplayMetadata() {
        super((Pointer)null);
        AVMasteringDisplayMetadata a;
        a.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    @ByRef
    public native AVRational max_luminance();

    @ByRef
    public native AVRational min_luminance();

    public AVMasteringDisplayMetadata(long a) {
        super((Pointer)null);
        AVMasteringDisplayMetadata a2;
        a2.allocateArray(a);
    }

    public native AVMasteringDisplayMetadata white_point(int var1, AVRational var2);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVMasteringDisplayMetadata max_luminance(AVRational var1);

    public AVMasteringDisplayMetadata position(long a) {
        AVMasteringDisplayMetadata a2;
        return (AVMasteringDisplayMetadata)super.position(a);
    }

    @MemberGetter
    @Cast(value={"AVRational(* /*[3]*/ )[2]"})
    public native AVRational display_primaries();

    @ByRef
    public native AVRational display_primaries(int var1, int var2);

    public native int has_primaries();

    public native AVMasteringDisplayMetadata min_luminance(AVRational var1);

    @ByRef
    public native AVRational white_point(int var1);

    public native int has_luminance();
}
