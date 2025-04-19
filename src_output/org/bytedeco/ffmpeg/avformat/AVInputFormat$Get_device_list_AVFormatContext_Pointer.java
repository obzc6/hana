/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVInputFormat.Get_device_list_AVFormatContext_Pointer
extends FunctionPointer {
    public AVInputFormat.Get_device_list_AVFormatContext_Pointer(Pointer pointer) {
        AVInputFormat.Get_device_list_AVFormatContext_Pointer a = pointer;
        AVInputFormat.Get_device_list_AVFormatContext_Pointer a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected AVInputFormat.Get_device_list_AVFormatContext_Pointer() {
        AVInputFormat.Get_device_list_AVFormatContext_Pointer a;
        AVInputFormat.Get_device_list_AVFormatContext_Pointer get_device_list_AVFormatContext_Pointer = a;
        get_device_list_AVFormatContext_Pointer.allocate();
    }

    public native int call(AVFormatContext var1, @Cast(value={"AVDeviceInfoList*"}) Pointer var2);
}
