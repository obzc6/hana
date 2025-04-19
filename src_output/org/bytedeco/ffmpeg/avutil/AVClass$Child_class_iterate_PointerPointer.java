/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;

public static class AVClass.Child_class_iterate_PointerPointer
extends FunctionPointer {
    static {
        Loader.load();
    }

    protected AVClass.Child_class_iterate_PointerPointer() {
        AVClass.Child_class_iterate_PointerPointer a;
        AVClass.Child_class_iterate_PointerPointer child_class_iterate_PointerPointer = a;
        child_class_iterate_PointerPointer.allocate();
    }

    @Const
    public native AVClass call(@Cast(value={"void**"}) PointerPointer var1);

    private native /* synthetic */ void allocate();

    public AVClass.Child_class_iterate_PointerPointer(Pointer pointer) {
        AVClass.Child_class_iterate_PointerPointer a = pointer;
        AVClass.Child_class_iterate_PointerPointer a2 = this;
        super((Pointer)a);
    }
}
