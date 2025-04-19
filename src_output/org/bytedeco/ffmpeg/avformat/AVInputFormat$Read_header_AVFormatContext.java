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

public static class AVInputFormat.Read_header_AVFormatContext
extends FunctionPointer {
    public AVInputFormat.Read_header_AVFormatContext(Pointer pointer) {
        AVInputFormat.Read_header_AVFormatContext a = pointer;
        AVInputFormat.Read_header_AVFormatContext a2 = this;
        super((Pointer)a);
    }

    protected AVInputFormat.Read_header_AVFormatContext() {
        AVInputFormat.Read_header_AVFormatContext a;
        AVInputFormat.Read_header_AVFormatContext read_header_AVFormatContext = a;
        read_header_AVFormatContext.allocate();
    }

    private native /* synthetic */ void allocate();

    public native int call(AVFormatContext var1);

    static {
        Loader.load();
    }
}
