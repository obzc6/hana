/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVOption
extends Pointer {
    public static final int AV_OPT_FLAG_AUDIO_PARAM = 8;
    public static final int AV_OPT_FLAG_ENCODING_PARAM = 1;
    public static final int AV_OPT_FLAG_CHILD_CONSTS = 262144;
    public static final int AV_OPT_FLAG_VIDEO_PARAM = 16;
    public static final int AV_OPT_FLAG_RUNTIME_PARAM = 32768;
    public static final int AV_OPT_FLAG_DEPRECATED = 131072;
    public static final int AV_OPT_FLAG_EXPORT = 64;
    public static final int AV_OPT_FLAG_BSF_PARAM = 256;
    public static final int AV_OPT_FLAG_DECODING_PARAM = 2;
    public static final int AV_OPT_FLAG_FILTERING_PARAM = 65536;
    public static final int AV_OPT_FLAG_READONLY = 128;
    public static final int AV_OPT_FLAG_SUBTITLE_PARAM = 32;

    public native AVOption default_val_q(AVRational var1);

    @Name(value={"default_val.str"})
    @Cast(value={"const char*"})
    public native BytePointer default_val_str();

    public native AVOption type(int var1);

    @Name(value={"default_val.q"})
    @ByRef
    public native AVRational default_val_q();

    @Name(value={"default_val.i64"})
    @Cast(value={"int64_t"})
    public native long default_val_i64();

    public native AVOption offset(int var1);

    public AVOption() {
        super((Pointer)null);
        AVOption a;
        a.allocate();
    }

    public native AVOption help(BytePointer var1);

    public native int offset();

    public native AVOption default_val_dbl(double var1);

    @Name(value={"default_val.dbl"})
    public native double default_val_dbl();

    public AVOption getPointer(long a) {
        AVOption a2;
        return (AVOption)new AVOption(a2).offsetAddress(a);
    }

    public native AVOption default_val_str(BytePointer var1);

    public native AVOption default_val_i64(long var1);

    public native AVOption max(double var1);

    public native double max();

    public native AVOption name(BytePointer var1);

    public native AVOption min(double var1);

    public native AVOption flags(int var1);

    public AVOption(Pointer pointer) {
        AVOption a = pointer;
        AVOption a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native AVOption unit(BytePointer var1);

    public AVOption(long a) {
        super((Pointer)null);
        AVOption a2;
        a2.allocateArray(a);
    }

    public AVOption position(long a) {
        AVOption a2;
        return (AVOption)super.position(a);
    }

    public native double min();

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"const char*"})
    public native BytePointer help();

    @Cast(value={"AVOptionType"})
    public native int type();

    static {
        Loader.load();
    }

    public native int flags();

    @Cast(value={"const char*"})
    public native BytePointer unit();

    @Cast(value={"const char*"})
    public native BytePointer name();
}
