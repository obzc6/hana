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
public class AVDownmixInfo
extends Pointer {
    public AVDownmixInfo(Pointer pointer) {
        AVDownmixInfo a = pointer;
        AVDownmixInfo a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public AVDownmixInfo(long a) {
        super((Pointer)null);
        AVDownmixInfo a2;
        a2.allocateArray(a);
    }

    public native AVDownmixInfo lfe_mix_level(double var1);

    public native double surround_mix_level();

    public native AVDownmixInfo center_mix_level_ltrt(double var1);

    public native AVDownmixInfo center_mix_level(double var1);

    public AVDownmixInfo getPointer(long a) {
        AVDownmixInfo a2;
        return (AVDownmixInfo)new AVDownmixInfo(a2).offsetAddress(a);
    }

    public native double center_mix_level();

    public AVDownmixInfo position(long a) {
        AVDownmixInfo a2;
        return (AVDownmixInfo)super.position(a);
    }

    public native AVDownmixInfo surround_mix_level_ltrt(double var1);

    public AVDownmixInfo() {
        super((Pointer)null);
        AVDownmixInfo a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public native double surround_mix_level_ltrt();

    public native double lfe_mix_level();

    public native double center_mix_level_ltrt();

    @Cast(value={"AVDownmixType"})
    public native int preferred_downmix_type();

    private native /* synthetic */ void allocateArray(long var1);

    public native AVDownmixInfo preferred_downmix_type(int var1);

    public native AVDownmixInfo surround_mix_level(double var1);
}
