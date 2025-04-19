/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Const
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.ffmpeg.avformat.AVProbeData;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Const;

public static class AVInputFormat.Read_probe_AVProbeData
extends FunctionPointer {
    protected AVInputFormat.Read_probe_AVProbeData() {
        AVInputFormat.Read_probe_AVProbeData a;
        AVInputFormat.Read_probe_AVProbeData read_probe_AVProbeData = a;
        read_probe_AVProbeData.allocate();
    }

    public AVInputFormat.Read_probe_AVProbeData(Pointer pointer) {
        AVInputFormat.Read_probe_AVProbeData a = pointer;
        AVInputFormat.Read_probe_AVProbeData a2 = this;
        super((Pointer)a);
    }

    public native int call(@Const AVProbeData var1);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();
}
