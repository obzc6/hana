/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    protected AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int() {
        AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int a;
        AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges_PointerPointer_Pointer_BytePointer_int = a;
        query_ranges_PointerPointer_Pointer_BytePointer_int.allocate();
    }

    public AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int(Pointer pointer) {
        AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int a = pointer;
        AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    public native int call(@Cast(value={"AVOptionRanges**"}) PointerPointer var1, Pointer var2, @Cast(value={"const char*"}) BytePointer var3, int var4);
}
