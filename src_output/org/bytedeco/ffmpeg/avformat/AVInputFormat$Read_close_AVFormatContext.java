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

public static class AVInputFormat.Read_close_AVFormatContext
extends FunctionPointer {
    public AVInputFormat.Read_close_AVFormatContext(Pointer pointer) {
        AVInputFormat.Read_close_AVFormatContext a = pointer;
        AVInputFormat.Read_close_AVFormatContext a2 = this;
        super((Pointer)a);
    }

    protected AVInputFormat.Read_close_AVFormatContext() {
        AVInputFormat.Read_close_AVFormatContext a;
        AVInputFormat.Read_close_AVFormatContext read_close_AVFormatContext = a;
        read_close_AVFormatContext.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int call(AVFormatContext var1);
}
