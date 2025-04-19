/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVInputFormat.Read_play_AVFormatContext
extends FunctionPointer {
    static {
        Loader.load();
    }

    protected AVInputFormat.Read_play_AVFormatContext() {
        AVInputFormat.Read_play_AVFormatContext a;
        AVInputFormat.Read_play_AVFormatContext read_play_AVFormatContext = a;
        read_play_AVFormatContext.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVInputFormat.Read_play_AVFormatContext(Pointer pointer) {
        AVInputFormat.Read_play_AVFormatContext a = pointer;
        AVInputFormat.Read_play_AVFormatContext a2 = this;
        super((Pointer)a);
    }

    public native int call(AVFormatContext var1);
}
