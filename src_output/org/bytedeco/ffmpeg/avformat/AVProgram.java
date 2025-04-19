/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVProgram
extends Pointer {
    public AVProgram() {
        super((Pointer)null);
        AVProgram a;
        a.allocate();
    }

    public AVProgram(Pointer pointer) {
        AVProgram a = pointer;
        AVProgram a2 = this;
        super((Pointer)a);
    }

    public native AVProgram stream_index(IntPointer var1);

    public native AVDictionary metadata();

    public AVProgram(long a) {
        super((Pointer)null);
        AVProgram a2;
        a2.allocateArray(a);
    }

    public native AVProgram pts_wrap_reference(long var1);

    public native int id();

    public native int program_num();

    public AVProgram getPointer(long a) {
        AVProgram a2;
        return (AVProgram)new AVProgram(a2).offsetAddress(a);
    }

    @Cast(value={"unsigned int"})
    public native int nb_stream_indexes();

    public native int pmt_pid();

    @Cast(value={"int64_t"})
    public native long start_time();

    @Cast(value={"AVDiscard"})
    public native int discard();

    public native AVProgram id(int var1);

    public native AVProgram metadata(AVDictionary var1);

    public native int flags();

    public native int pts_wrap_behavior();

    public native AVProgram nb_stream_indexes(int var1);

    @Cast(value={"int64_t"})
    public native long pts_wrap_reference();

    static {
        Loader.load();
    }

    public native AVProgram start_time(long var1);

    private native /* synthetic */ void allocate();

    public native AVProgram pcr_pid(int var1);

    @Cast(value={"unsigned int*"})
    public native IntPointer stream_index();

    public AVProgram position(long a) {
        AVProgram a2;
        return (AVProgram)super.position(a);
    }

    public native AVProgram pmt_pid(int var1);

    public native AVProgram program_num(int var1);

    public native AVProgram pmt_version(int var1);

    public native AVProgram end_time(long var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVProgram flags(int var1);

    @Cast(value={"int64_t"})
    public native long end_time();

    public native AVProgram pts_wrap_behavior(int var1);

    public native int pcr_pid();

    public native AVProgram discard(int var1);

    public native int pmt_version();
}
