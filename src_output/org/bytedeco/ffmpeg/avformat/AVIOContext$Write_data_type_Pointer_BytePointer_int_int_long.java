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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long
extends FunctionPointer {
    public AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long(Pointer pointer) {
        AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long a = pointer;
        AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3, @Cast(value={"AVIODataMarkerType"}) int var4, @Cast(value={"int64_t"}) long var5);

    protected AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long() {
        AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long a;
        AVIOContext.Write_data_type_Pointer_BytePointer_int_int_long write_data_type_Pointer_BytePointer_int_int_long = a;
        write_data_type_Pointer_BytePointer_int_int_long.allocate();
    }
}
