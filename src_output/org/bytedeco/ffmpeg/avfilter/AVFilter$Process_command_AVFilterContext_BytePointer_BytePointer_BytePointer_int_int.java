/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilter;
import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int
extends FunctionPointer {
    static {
        Loader.load();
    }

    public native int call(AVFilterContext var1, @Cast(value={"const char*"}) BytePointer var2, @Cast(value={"const char*"}) BytePointer var3, @Cast(value={"char*"}) BytePointer var4, int var5, int var6);

    public AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int(Pointer pointer) {
        AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a = pointer;
        AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a2 = this;
        super((Pointer)a);
    }

    protected AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int() {
        AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int a;
        AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int = a;
        process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int.allocate();
    }

    private native /* synthetic */ void allocate();
}
