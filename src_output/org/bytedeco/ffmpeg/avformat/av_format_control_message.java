/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class av_format_control_message
extends FunctionPointer {
    static {
        Loader.load();
    }

    protected av_format_control_message() {
        av_format_control_message a;
        av_format_control_message av_format_control_message2 = a;
        av_format_control_message2.allocate();
    }

    public native int call(AVFormatContext var1, int var2, Pointer var3, @Cast(value={"size_t"}) long var4);

    public av_format_control_message(Pointer pointer) {
        av_format_control_message a = pointer;
        av_format_control_message a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();
}
