/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVBitStreamFilter;
import org.bytedeco.ffmpeg.avcodec.AVCodecParameters;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVBSFContext
extends Pointer {
    public native AVBSFContext par_in(AVCodecParameters var1);

    public AVBSFContext(long a) {
        super((Pointer)null);
        AVBSFContext a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    @ByRef
    public native AVRational time_base_out();

    public native AVCodecParameters par_out();

    @ByRef
    public native AVRational time_base_in();

    public native AVCodecParameters par_in();

    @Const
    public native AVBitStreamFilter filter();

    public AVBSFContext(Pointer pointer) {
        AVBSFContext a = pointer;
        AVBSFContext a2 = this;
        super((Pointer)a);
    }

    public AVBSFContext getPointer(long a) {
        AVBSFContext a2;
        return (AVBSFContext)new AVBSFContext(a2).offsetAddress(a);
    }

    public native AVBSFContext time_base_in(AVRational var1);

    public native AVBSFContext par_out(AVCodecParameters var1);

    public native AVBSFContext filter(AVBitStreamFilter var1);

    public AVBSFContext position(long a) {
        AVBSFContext a2;
        return (AVBSFContext)super.position(a);
    }

    public native AVBSFContext time_base_out(AVRational var1);

    private native /* synthetic */ void allocateArray(long var1);

    public AVBSFContext() {
        super((Pointer)null);
        AVBSFContext a;
        a.allocate();
    }

    @Const
    public native AVClass av_class();

    public native AVBSFContext av_class(AVClass var1);

    private native /* synthetic */ void allocate();

    public native AVBSFContext priv_data(Pointer var1);

    public native Pointer priv_data();
}
