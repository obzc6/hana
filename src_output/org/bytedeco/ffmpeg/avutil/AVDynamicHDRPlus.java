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

import org.bytedeco.ffmpeg.avutil.AVHDRPlusColorTransformParams;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVDynamicHDRPlus
extends Pointer {
    public AVDynamicHDRPlus getPointer(long a) {
        AVDynamicHDRPlus a2;
        return (AVDynamicHDRPlus)new AVDynamicHDRPlus(a2).offsetAddress(a);
    }

    public AVDynamicHDRPlus(Pointer pointer) {
        AVDynamicHDRPlus a = pointer;
        AVDynamicHDRPlus a2 = this;
        super((Pointer)a);
    }

    public native AVDynamicHDRPlus targeted_system_display_actual_peak_luminance_flag(byte var1);

    public native AVDynamicHDRPlus num_cols_mastering_display_actual_peak_luminance(byte var1);

    public AVDynamicHDRPlus(long a) {
        super((Pointer)null);
        AVDynamicHDRPlus a2;
        a2.allocateArray(a);
    }

    public native AVDynamicHDRPlus num_windows(byte var1);

    public native AVDynamicHDRPlus params(int var1, AVHDRPlusColorTransformParams var2);

    public native AVDynamicHDRPlus application_version(byte var1);

    private native /* synthetic */ void allocate();

    @ByRef
    public native AVHDRPlusColorTransformParams params(int var1);

    @Cast(value={"uint8_t"})
    public native byte mastering_display_actual_peak_luminance_flag();

    public native AVDynamicHDRPlus mastering_display_actual_peak_luminance_flag(byte var1);

    @MemberGetter
    @Cast(value={"AVRational(* /*[25]*/ )[25]"})
    public native AVRational targeted_system_display_actual_peak_luminance();

    @Cast(value={"uint8_t"})
    public native byte num_windows();

    public native AVDynamicHDRPlus targeted_system_display_actual_peak_luminance(int var1, int var2, AVRational var3);

    @ByRef
    public native AVRational mastering_display_actual_peak_luminance(int var1, int var2);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVDynamicHDRPlus targeted_system_display_maximum_luminance(AVRational var1);

    @ByRef
    public native AVRational targeted_system_display_actual_peak_luminance(int var1, int var2);

    @Cast(value={"uint8_t"})
    public native byte num_rows_mastering_display_actual_peak_luminance();

    @ByRef
    public native AVRational targeted_system_display_maximum_luminance();

    @Cast(value={"uint8_t"})
    public native byte application_version();

    public AVDynamicHDRPlus() {
        super((Pointer)null);
        AVDynamicHDRPlus a;
        a.allocate();
    }

    @Cast(value={"uint8_t"})
    public native byte num_rows_targeted_system_display_actual_peak_luminance();

    @Cast(value={"uint8_t"})
    public native byte targeted_system_display_actual_peak_luminance_flag();

    public AVDynamicHDRPlus position(long a) {
        AVDynamicHDRPlus a2;
        return (AVDynamicHDRPlus)super.position(a);
    }

    @Cast(value={"uint8_t"})
    public native byte itu_t_t35_country_code();

    @Cast(value={"uint8_t"})
    public native byte num_cols_mastering_display_actual_peak_luminance();

    public native AVDynamicHDRPlus num_cols_targeted_system_display_actual_peak_luminance(byte var1);

    public native AVDynamicHDRPlus num_rows_targeted_system_display_actual_peak_luminance(byte var1);

    static {
        Loader.load();
    }

    public native AVDynamicHDRPlus mastering_display_actual_peak_luminance(int var1, int var2, AVRational var3);

    @MemberGetter
    @Cast(value={"AVRational(* /*[25]*/ )[25]"})
    public native AVRational mastering_display_actual_peak_luminance();

    public native AVDynamicHDRPlus num_rows_mastering_display_actual_peak_luminance(byte var1);

    public native AVDynamicHDRPlus itu_t_t35_country_code(byte var1);

    @MemberGetter
    public native AVHDRPlusColorTransformParams params();

    @Cast(value={"uint8_t"})
    public native byte num_cols_targeted_system_display_actual_peak_luminance();
}
