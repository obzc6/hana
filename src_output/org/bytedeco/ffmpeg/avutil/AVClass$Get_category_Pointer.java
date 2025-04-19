/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVClass.Get_category_Pointer
extends FunctionPointer {
    public AVClass.Get_category_Pointer(Pointer pointer) {
        AVClass.Get_category_Pointer a = pointer;
        AVClass.Get_category_Pointer a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"AVClassCategory"})
    public native int call(Pointer var1);

    protected AVClass.Get_category_Pointer() {
        AVClass.Get_category_Pointer a;
        AVClass.Get_category_Pointer get_category_Pointer = a;
        get_category_Pointer.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
