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
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVClass.Item_name_Pointer
extends FunctionPointer {
    @Cast(value={"const char*"})
    public native BytePointer call(Pointer var1);

    public AVClass.Item_name_Pointer(Pointer pointer) {
        AVClass.Item_name_Pointer a = pointer;
        AVClass.Item_name_Pointer a2 = this;
        super((Pointer)a);
    }

    protected AVClass.Item_name_Pointer() {
        AVClass.Item_name_Pointer a;
        AVClass.Item_name_Pointer item_name_Pointer = a;
        item_name_Pointer.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();
}
