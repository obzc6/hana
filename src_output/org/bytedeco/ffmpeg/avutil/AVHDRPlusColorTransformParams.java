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

import org.bytedeco.ffmpeg.avutil.AVHDRPlusPercentile;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVHDRPlusColorTransformParams
extends Pointer {
    public native AVHDRPlusColorTransformParams overlap_process_option(int var1);

    public native AVHDRPlusColorTransformParams knee_point_x(AVRational var1);

    public AVHDRPlusColorTransformParams getPointer(long a) {
        AVHDRPlusColorTransformParams a2;
        return (AVHDRPlusColorTransformParams)new AVHDRPlusColorTransformParams(a2).offsetAddress(a);
    }

    @Cast(value={"uint8_t"})
    public native byte color_saturation_mapping_flag();

    @MemberGetter
    public native AVHDRPlusPercentile distribution_maxrgb();

    public native AVHDRPlusColorTransformParams num_bezier_curve_anchors(byte var1);

    @ByRef
    public native AVRational knee_point_x();

    public native AVHDRPlusColorTransformParams window_upper_left_corner_y(AVRational var1);

    @ByRef
    public native AVRational average_maxrgb();

    public native AVHDRPlusColorTransformParams average_maxrgb(AVRational var1);

    public native AVHDRPlusColorTransformParams distribution_maxrgb(int var1, AVHDRPlusPercentile var2);

    @Cast(value={"uint8_t"})
    public native byte num_distribution_maxrgb_percentiles();

    public native AVHDRPlusColorTransformParams center_of_ellipse_x(short var1);

    public native AVHDRPlusColorTransformParams maxscl(int var1, AVRational var2);

    public native AVHDRPlusColorTransformParams tone_mapping_flag(byte var1);

    public AVHDRPlusColorTransformParams() {
        super((Pointer)null);
        AVHDRPlusColorTransformParams a;
        a.allocate();
    }

    @MemberGetter
    public native AVRational maxscl();

    public native AVHDRPlusColorTransformParams color_saturation_mapping_flag(byte var1);

    @ByRef
    public native AVHDRPlusPercentile distribution_maxrgb(int var1);

    public native AVHDRPlusColorTransformParams semimajor_axis_internal_ellipse(short var1);

    @ByRef
    public native AVRational knee_point_y();

    public native AVHDRPlusColorTransformParams window_lower_right_corner_x(AVRational var1);

    public native AVHDRPlusColorTransformParams center_of_ellipse_y(short var1);

    static {
        Loader.load();
    }

    @Cast(value={"uint8_t"})
    public native byte tone_mapping_flag();

    public native AVHDRPlusColorTransformParams knee_point_y(AVRational var1);

    public native AVHDRPlusColorTransformParams semimajor_axis_external_ellipse(short var1);

    public AVHDRPlusColorTransformParams(Pointer pointer) {
        AVHDRPlusColorTransformParams a = pointer;
        AVHDRPlusColorTransformParams a2 = this;
        super((Pointer)a);
    }

    public native AVHDRPlusColorTransformParams bezier_curve_anchors(int var1, AVRational var2);

    @Cast(value={"AVHDRPlusOverlapProcessOption"})
    public native int overlap_process_option();

    @ByRef
    public native AVRational maxscl(int var1);

    @ByRef
    public native AVRational window_lower_right_corner_x();

    @ByRef
    public native AVRational window_lower_right_corner_y();

    @Cast(value={"uint16_t"})
    public native short semimajor_axis_external_ellipse();

    public AVHDRPlusColorTransformParams(long a) {
        super((Pointer)null);
        AVHDRPlusColorTransformParams a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint16_t"})
    public native short center_of_ellipse_x();

    @ByRef
    public native AVRational window_upper_left_corner_x();

    public native AVHDRPlusColorTransformParams window_upper_left_corner_x(AVRational var1);

    @Cast(value={"uint16_t"})
    public native short semiminor_axis_external_ellipse();

    @Cast(value={"uint8_t"})
    public native byte num_bezier_curve_anchors();

    public native AVHDRPlusColorTransformParams num_distribution_maxrgb_percentiles(byte var1);

    public native AVHDRPlusColorTransformParams color_saturation_weight(AVRational var1);

    @ByRef
    public native AVRational bezier_curve_anchors(int var1);

    @MemberGetter
    public native AVRational bezier_curve_anchors();

    @ByRef
    public native AVRational color_saturation_weight();

    @Cast(value={"uint16_t"})
    public native short semimajor_axis_internal_ellipse();

    public native AVHDRPlusColorTransformParams fraction_bright_pixels(AVRational var1);

    public native AVHDRPlusColorTransformParams rotation_angle(byte var1);

    @ByRef
    public native AVRational window_upper_left_corner_y();

    private native /* synthetic */ void allocate();

    public native AVHDRPlusColorTransformParams window_lower_right_corner_y(AVRational var1);

    public AVHDRPlusColorTransformParams position(long a) {
        AVHDRPlusColorTransformParams a2;
        return (AVHDRPlusColorTransformParams)super.position(a);
    }

    @Cast(value={"uint16_t"})
    public native short center_of_ellipse_y();

    private native /* synthetic */ void allocateArray(long var1);

    @ByRef
    public native AVRational fraction_bright_pixels();

    @Cast(value={"uint8_t"})
    public native byte rotation_angle();

    public native AVHDRPlusColorTransformParams semiminor_axis_external_ellipse(short var1);
}
